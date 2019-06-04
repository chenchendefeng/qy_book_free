package com.only.tech.ywapi.service.handler;

import com.only.tech.constant.TaduConstants;
import com.only.tech.dto.tadu.TaduCode;
import com.only.tech.dto.tadu.TaduResultDto;
import lombok.extern.slf4j.Slf4j;
import ooh.chaos.util.UrlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZHI ZUN BAO
 * @since 2019/4/12
 */
@Slf4j
@Service
public class TaduHandler {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 所有书籍id
     * @param lastUpdateTime
     * @return
     */
    public TaduResultDto bookList(Long lastUpdateTime) {

        try {
            //获取公用参数
            Map<String, Object> paramsMap = getBaseParamsMap();
            paramsMap.put("lastUpdateTime",lastUpdateTime);


            String url = UrlUtil.paramsUrlForGet(TaduConstants.BOOK_LIST,paramsMap);

            TaduResultDto resultDto = restTemplate.getForObject(url, TaduResultDto.class);
//            log.info("所有书籍结果：",resultDto);
            return resultDto;
        } catch (RestClientException e) {
            log.error("查询所有书籍错误 lastUpdateTime:[{}]",lastUpdateTime);
            log.error("查询所有书籍 错误: ",e);
        }

        return build();

    }


    /**
     * 书籍信息
     * @param bookId
     * @return
     */
    public TaduResultDto bookInfo(Long bookId) {

        try {
            //获取公用参数
            Map<String, Object> paramsMap = getBaseParamsMap();
            paramsMap.put("bookId",bookId);

            String url = UrlUtil.paramsUrlForGet(TaduConstants.BOOK_INFO,paramsMap);

            TaduResultDto resultDto = restTemplate.getForObject(url, TaduResultDto.class);
//            log.info("书籍信息：",resultDto);
            return resultDto;
        } catch (RestClientException e) {
            log.error("查询书籍信息错误 bookId:[{}]",bookId);
            log.error("查询书籍信息错误：",e);
        }
        return build();

    }


    /**
     * 书籍结构
     * @param bookId
     * @return
     */
    public TaduResultDto bookStructure(Long bookId) {

        try {
            //获取公用参数
            Map<String, Object> paramsMap = getBaseParamsMap();
            paramsMap.put("bookId",bookId);

            String url = UrlUtil.paramsUrlForGet(TaduConstants.BOOK_STRUCTURE,paramsMap);

            TaduResultDto resultDto = restTemplate.getForObject(url, TaduResultDto.class);
//            log.info("书籍结构：",resultDto);
            return resultDto;
        } catch (RestClientException e) {
            log.error("书籍结构错误 bookId:[{}]",bookId);
            log.error("查询书籍所有章节错误：",e);
        }
        return build();

    }

    /**
     * 章节信息
     * @param bookId
     * @param volumeId
     * @param chapterId
     * @return
     */
    public TaduResultDto chapterInfo(Long bookId, Long volumeId, Long chapterId) {

        try {
            //获取公用参数
            Map<String, Object> paramsMap = getBaseParamsMap();
            paramsMap.put("bookId",bookId);
            paramsMap.put("volumeId",volumeId);
            paramsMap.put("chapterId",chapterId);

            String url = UrlUtil.paramsUrlForGet(TaduConstants.CHAPTER_INFO,paramsMap);

            TaduResultDto resultDto = restTemplate.getForObject(url, TaduResultDto.class);

//            log.info("章节信息：",resultDto);
            return resultDto;
        } catch (RestClientException e) {
            log.error("查询章节信息错误：bookId:[{}],volumeId:[{}],chapterId:[{}]",bookId,volumeId,chapterId);
            log.error("查询章节信息错误：",e);
        }
        return build();
    }



    private TaduResultDto build() {
        TaduResultDto resultDto = new TaduResultDto();
        resultDto.setCode(TaduCode.FAIL);
        resultDto.setMsg(TaduCode.DEFAULT_MESSAGE);
        return resultDto;
    }


    private Map<String, Object> getBaseParamsMap() {
        Map<String,Object> paramsMap = new HashMap<>();
        paramsMap.put("identity", TaduConstants.IDENTITY);
        return paramsMap;
    }



}
