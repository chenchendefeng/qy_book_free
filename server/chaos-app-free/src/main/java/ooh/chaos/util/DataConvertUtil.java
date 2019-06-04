package ooh.chaos.util;

import lombok.extern.slf4j.Slf4j;
import org.dom4j.*;

import java.util.*;

/**
 * 数据转换工具类
 * @author ZHI ZUN BAO
 * @since 2019/5/31
 */
@Slf4j
public class DataConvertUtil {


    /**
     * XML格式字符串转换为Map
     *
     * @param strXML XML字符串
     * @return XML数据转换后的Map
     * @throws Exception
     */
    public static Map<String, Object> xml2map(String strXML) {
        Document doc = null;
        try {
            doc = DocumentHelper.parseText(strXML);
        } catch (DocumentException e) {
            log.error("parse text error : " + e);
        }
        Element rootElement = doc.getRootElement();
        Map<String,Object> mapXml = new HashMap<>();
        element2Map(mapXml,rootElement);
//        log.info("Map >>> " + mapXml);
        return mapXml;
    }


    /**
     * 使用递归调用将多层级xml转为map
     * @param map
     * @param rootElement
     */
    public static void element2Map(Map<String, Object> map, Element rootElement) {

        //获得当前节点的子节点
        List<Element> elements = rootElement.elements();
        if (elements.size() == 0) {
            //没有子节点说明当前节点是叶子节点，直接取值
            map.put(rootElement.getName(),rootElement.getText());
        }else if (elements.size() == 1) {
            //只有一个子节点说明不用考虑list的情况，继续递归
            Map<String,Object> tempMap = new HashMap<String,Object>();
            element2Map(tempMap,elements.get(0));
            map.put(rootElement.getName(),tempMap);
        }else {
            //多个子节点的话就要考虑list的情况了，特别是当多个子节点有名称相同的字段时
            Map<String,Object> tempMap = new HashMap<String,Object>();
            for (Element element : elements) {
                tempMap.put(element.getName(),null);
            }
            Set<String> keySet = tempMap.keySet();
            for (String string : keySet) {
                Namespace namespace = elements.get(0).getNamespace();
                List<Element> sameElements = rootElement.elements(new QName(string,namespace));

                if (sameElements.size() == 1) {
                    //同名的数量等于于1直接递归
                    Element element = sameElements.get(0);
                    List<Element> childList = element.elements();
                    if (childList.size() >= 1){
                        List<Map<String,Object>> childMapList = new ArrayList<>();
                        for (Element childElement: childList) {
                            Map<String,Object> temChildMap = new HashMap<>();
                            element2Map(temChildMap,childElement);
                            childMapList.add(temChildMap);
                        }
                        map.put(element.getName(),childMapList);
                    }else {
                        element2Map(map,sameElements.get(0));
                    }

                }else if (sameElements.size() > 1){

                    //如果同名的数目大于1则表示要构建list
                    List<Map> list = new ArrayList<>();
                    Map<String,Object> sameTempMap = new HashMap<>();
                    for(Element element : sameElements){
                        element2Map(sameTempMap,element);
                        list.add(sameTempMap);
                    }
                    map.put(string,list);
                }
            }
        }
    }


}
