package com.only.tech.book.service.facade;

import com.only.tech.book.service.biz.BookInfoService;
import com.only.tech.book.service.biz.ChapterService;
import com.only.tech.book.service.biz.ReadProcessService;
import com.only.tech.entity.book.BookInfo;
import com.only.tech.entity.book.ReadProcess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/8
 */
@Slf4j
@Service
public class ReadProcessFacade {

    @Autowired
    private ReadProcessService readProcessService;

    @Autowired
    private BookInfoService bookInfoService;

    @Autowired
    private ChapterService chapterService;

    public boolean update(Long cuId, Long bid, Long cid, Integer readWords) {

        ReadProcess readProcess = readProcessService.getByCuidAndBid(cuId,bid);

        Date now = new Date();
        Float process = null;
        if (readProcess == null){
            readProcess = new ReadProcess();
            readProcess.setCuId(cuId);
            readProcess.setBid(bid);
            readProcess.setCid(cid);
            readProcess.setReadWords(readWords);
            readProcess.setCreateTime(now);
            readProcess.setUpdateTime(now);
            process = this.calcReadProcess(bid,cid,readWords);
            readProcess.setProcess(process);

            return readProcessService.save(readProcess);
        }
        readProcess.setCid(cid);
        readProcess.setReadWords(readWords);
        readProcess.setUpdateTime(now);
        process = this.calcReadProcess(bid,cid,readWords);
        readProcess.setProcess(process);
        return readProcessService.updateById(readProcess);

    }

    /**
     * 计算阅读进度百分比
     * @param bid
     * @param cid
     * @param readWords
     * @return
     */
    private Float calcReadProcess(Long bid, Long cid, Integer readWords){

        //获取书籍的总字数
        BookInfo bookInfo=this.bookInfoService.getOneByBid(bid);
        if(bookInfo == null){
            return -0.0f;
        }
        Integer totalWordCount=bookInfo.getTotalWordCount(); //总字数
        if(totalWordCount == 0){
            return -0.0f;
        }

        //获取当前阅读字数
        Integer readWordCount=this.chapterService.readWordCount(bid,cid);
        Integer curReadWordCount=readWordCount+readWords;

        //计算并存储
        BigDecimal totalWordCount_=new BigDecimal(totalWordCount);
        BigDecimal curReadWordCount_=new BigDecimal(curReadWordCount);
        BigDecimal process=curReadWordCount_.divide(totalWordCount_,4,BigDecimal.ROUND_HALF_EVEN).multiply(new BigDecimal(100));

        return process.floatValue();
    }




}
