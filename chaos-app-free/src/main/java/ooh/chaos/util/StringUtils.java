package ooh.chaos.util;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Slf4j
public class StringUtils {
	/**
	 * 获取请求参数
	 * @param request
	 * @return
	 */
	 public static String servletToString(HttpServletRequest request){  
         String valueStr = "";  
         try {  
             StringBuffer sb = new StringBuffer();  
             InputStream is = request.getInputStream();  
             InputStreamReader isr = new InputStreamReader(is);  
             BufferedReader br = new BufferedReader(isr);  
             String s = "";  
             while ((s = br.readLine()) != null) {  
                 sb.append(s);  
             }  
             valueStr = sb.toString();  
         } catch (IOException e) {  
             e.printStackTrace();  
             valueStr = "";  
         }  
         return valueStr;  
   }  
	 
	 /**
	  * 获取请求参数
	  * @param request
	  * @return
	  */
	public static Map<String,String> servletToMap(HttpServletRequest request)
	{
		log.info("begin servletToMap");
		Map<String,String> params = new HashMap<String,String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
		    String name = (String) iter.next();
		    String[] values = (String[]) requestParams.get(name);
		    String valueStr = "";
		    for (int i = 0; i < values.length; i++) {
		        valueStr = (i == values.length - 1) ? valueStr + values[i]
		                    : valueStr + values[i] + ",";
		  	}
		    //乱码解决，这段代码在出现乱码时使用。
//			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		log.info("end servletToMap,params={}",params);
		return params;
	}
}
