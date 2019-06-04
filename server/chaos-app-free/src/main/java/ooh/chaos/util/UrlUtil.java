package ooh.chaos.util;

import java.util.Map;
import java.util.Set;

/**
 * @author ZHI ZUN BAO
 * @since 2019/4/26
 */
public class UrlUtil {

    /**
     * GET请求拼接参数
     * @param url
     * @param paramsMap
     * @return
     */
    public static String paramsUrlForGet(String url, Map<String, Object> paramsMap) {
        if (paramsMap == null || paramsMap.isEmpty()){
            return url;
        }

        StringBuffer sb = new StringBuffer();
        sb.append(url);
        sb.append("?");

        Set<String> keySet = paramsMap.keySet();
        int index = 0;
        for (String key: keySet) {
            Object value = paramsMap.get(key);
            if (index != 0){
                sb.append("&");
            }
            sb.append(key);
            sb.append("=");
            sb.append(value);
            index++;
        }
        return sb.toString();
    }
}
