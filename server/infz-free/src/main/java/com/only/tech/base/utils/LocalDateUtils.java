package com.only.tech.base.utils;

import com.google.common.collect.ImmutableMap;
import org.springframework.util.StringUtils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class LocalDateUtils {
	public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final Map<String, String> DAY_OF_WEEK = ImmutableMap.<String, String>builder()  
			.put("MONDAY", "周一")  
			.put("TUESDAY", "周二")  
			.put("WEDNESDAY", "周三")  
			.put("THURSDAY", "周四")  
			.put("FRIDAY", "周五")  
		    .put("SATURDAY", "周六")  
		    .put("SUNDAY", "周日")  
		    .build();
	/**
	 * 定时任务需要使用，以逗号分隔的参数，如"2018-12-12,100",获取从2018-12-12开始的100天的日期格式
	 * @param param
	 * @return
	 */
	public static List<String> parseDateParam(String param) {
		List<String> resultStr = new ArrayList<>();
		String[] params = param.split(",");
		String endDateStr = params[0].trim();
		resultStr.add(endDateStr);
		if (params.length > 1) {
			String dayStr = params[1].trim();
			if (!StringUtils.isEmpty(dayStr)) {
				int days = Integer.parseInt(dayStr);
				LocalDate endDate = LocalDate.parse(endDateStr);
				for (int i = 1; i <= days; i++) {
					resultStr.add(endDate.plusDays(-i).toString());
				}
			}
		}
		return resultStr;
	}
	/**
	 * 获取当前日期是周几  
	 * 输入：2018-11-11  输出：周一
	 * @param dateStr
	 * @return
	 */
	public static String getDayOfWeek(String dateStr){
		return DAY_OF_WEEK.get(LocalDate.parse(dateStr).getDayOfWeek().toString());
	}
	
	/**
	 * 对yyyy-mm-dd类型的时间串 加减天数
	 * @param dateStr
	 * @param dayNum
	 * @return
	 */
	public static String getPlusDayStr(String dateStr,int dayNum){
		LocalDate endDate = null;
		if(dateStr == null){
			endDate = LocalDate.now();
		}else{
			endDate = LocalDate.parse(dateStr);
		}
		return endDate.plusDays(dayNum).toString();
	}
	/**
	 * 对yyyy-mm-dd类型的时间串 加减天数  单位是月
	 * @param dateStr
	 * @param monthNum
	 * @return
	 */
	public static String getPlusMonthStr(String dateStr,int monthNum){
		LocalDate endDate = LocalDate.parse(dateStr);
		return endDate.plusMonths(monthNum).toString();
	}
	 /**
     * Date转换为LocalDateTime
     * @param date
     */
    public static String date2LocalDateTime(Date date){
        Instant instant = date.toInstant();//An instantaneous point on the time-line.(时间线上的一个瞬时点。)
        ZoneId zoneId = ZoneId.systemDefault();//A time-zone ID, such as {@code Europe/Paris}.(时区)
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DEFAULT_FORMAT);//This class is immutable and thread-safe.@since 1.8
        return dateTimeFormatter.format(localDateTime);
    }
 
    /**
     * LocalDateTime转换为Date
     * @param localDateTime
     */
    public static Date localDateTime2Date(LocalDateTime localDateTime){
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);//Combines this date-time with a time-zone to create a  ZonedDateTime.
        return Date.from(zdt.toInstant());
    }
    
    /**
     * 某个时间串 大于等于当前
     * @param localDateStr
     * @return
     */
    public static boolean isAfterNow(String localDateStr){
    	LocalDate now = LocalDate.now();
    	LocalDate date = LocalDate.parse(localDateStr);
    	return date.isAfter(now) || date.equals(now);
    }
    
    /**
     * 某个时间串 小于当前
     * @param localDateStr
     * @return
     */
    public static boolean isBeforeNow(String localDateStr){
    	LocalDate now = LocalDate.now();
    	LocalDate date = LocalDate.parse(localDateStr);
    	return date.isBefore(now);
    }
    public static void main(String[] args) {
    	System.out.println(isBeforeNow("2019-1-23"));
		System.out.println(isBeforeNow("2019-1-24"));
		System.out.println(isBeforeNow("2019-1-25"));
	}
}
