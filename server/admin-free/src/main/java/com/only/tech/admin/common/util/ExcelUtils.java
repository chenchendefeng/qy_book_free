package com.only.tech.admin.common.util;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * excel工具类
 * @author  shutong
 * @since  2019/03/3
 */
public class ExcelUtils {

    // 去读Excel的方法readExcel，该方法的入口参数为一个File对象
    public static List readCellContent(MultipartFile file) {
        try {
            // 创建输入流，读取Excel
//            InputStream is = new FileInputStream(file.getAbsolutePath());
            InputStream is=file.getInputStream();
            // jxl提供的Workbook类
            Workbook wb = Workbook.getWorkbook(is);
            // Excel的页签数量
            int sheet_size = wb.getNumberOfSheets();
            for (int index = 0; index < sheet_size; index++) {
                List contentList=new ArrayList();
                // 每个页签创建一个Sheet对象
                Sheet sheet = wb.getSheet(index);
                // sheet.getRows()返回该页的总行数
                for (int i = 0; i < sheet.getRows(); i++) {

                    // sheet.getColumns()返回该页的总列数
                    for (int j = 0; j < sheet.getColumns(); j++) {
                        String cellinfo = sheet.getCell(j, i).getContents();
                        if(cellinfo.isEmpty()){
                            continue;
                        }
                        contentList.add(cellinfo);
                    }
                }
                return contentList;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
