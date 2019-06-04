package com.only.tech.payment.common.utils;


import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	public static final String DEFAULT_FORMAT="yyyy-MM-dd HH:mm:ss";
	public static final String DEFAULT_FORMAT_YEAR_MONTH_DAY="yyyy-MM-dd";
	public static final String NO_SYMBLE_FORMAT="yyyyMMddHHmmss";
	public static final String NO_SYMBLE_FORMAT_MILL="yyyyMMddHHmmssS";
	/**
	 * 把当前时间转换成字符串
	 * @param format
	 * @return
	 */
	public static String getTimeStr(String format)
	{
		if(StringUtils.isEmpty(format))
		{
			format = DEFAULT_FORMAT;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		 Date d = new Date(); 
		return sdf.format(d);
	}
	
	 /**
     * 获取当前时间戳，单位秒
     * @return
     */
    public static long getCurrentTimestamp() {
        return System.currentTimeMillis()/1000;
    }

    /**
     * 获取当前时间戳，单位毫秒
     * @return
     */
    public static long getCurrentTimestampMs() {
        return System.currentTimeMillis();
    }
    /**
     * 获取当前时间之前或之后几小时 hour
     * @param hour
     * @return
     */
    public static String getTimeByHour(int hour, String format) {

        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + hour);
		if(StringUtils.isEmpty(format))
		{
			format = DEFAULT_FORMAT;
		}
        return new SimpleDateFormat(format).format(calendar.getTime());

    }

    /**
     * 获取当前时间之前或之后几分钟 minute
     * @param minute
     * @return
     */
    public static String getTimeByMinute(int minute, String format) {

        Calendar calendar = Calendar.getInstance();

        calendar.add(Calendar.MINUTE, minute);
		if(StringUtils.isEmpty(format))
		{
			format = DEFAULT_FORMAT;
		}
        return new SimpleDateFormat(format).format(calendar.getTime());
    }
    /**
     * 把时间戳转成date
     * @param seconds
     * @return
     */
    public static Date timeStamp2Date(String seconds)
    {
    	return new Date(Long.valueOf(seconds+"000"));
    }
    
    /**
     * 把时间字符串转为date
     * @param timeStr
     * @return
     * @throws ParseException 
     */
    public static Date timeStrToDate(String timeStr,String format) throws ParseException
    {
    	if(StringUtils.isEmpty(timeStr))
    	{
    		return new Date();
    	}
		if(StringUtils.isEmpty(format))
		{
			format = DEFAULT_FORMAT;
		}
    	SimpleDateFormat sDateFormat=new SimpleDateFormat(format); //加上时间
        return sDateFormat.parse(timeStr);
    }
    public static String getLastDayOfMonth(int year,int month)
	{
		Calendar cal = Calendar.getInstance();
		//设置年份
		cal.set(Calendar.YEAR,year);
		//设置月份
		cal.set(Calendar.MONTH, month-1);
		//获取某月最大天数
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		//设置日历中月份的最大天数
		cal.set(Calendar.DAY_OF_MONTH, lastDay);
		//格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String lastDayOfMonth = sdf.format(cal.getTime());
		
		return lastDayOfMonth;
	}
    public static void main(String[] args) throws ParseException {
    	String start = "2018-11";
		System.out.println(timeStrToDate(start, "yyyy-MM"));
		System.out.println(getLastDayOfMonth(2018, 11));
		
		System.out.println(isDateString("2018-11-20", null));
		System.out.println(isDateString("2018-11-31", null));
		System.out.println(isDateString("2018-13-20", null));
		System.out.println(isDateString("2018-11", null));
	}
   /**
      * 将短时间格式时间转换为字符串 yyyy-MM-dd
      * 
      * @param dateDate
      * @param k
      * @return
      */
   public static String dateToStr(Date dateDate,String format) {
	   if(dateDate == null)
	   {
		   dateDate = new Date();
	   }
		if(StringUtils.isEmpty(format))
		{
			format = DEFAULT_FORMAT;
		}
      SimpleDateFormat formatter = new SimpleDateFormat(format);
      String dateString = formatter.format(dateDate);
      return dateString;
   }
   /**
    * 
   * @Title: getPreDay
   * @Description: 获取距referenceDate日期之前几天的时间
   * @param @param referenceDate
   * @param @param day
   * @param @return    参数
   * @return Date    返回类型
   * @throws
   * @author xushunxing
   * @email 624412479@qq.com
   * @date 2017年8月9日
    */
   public static Date getPreDay(Date referenceDate,int day){
       Calendar calendar = Calendar.getInstance();
       calendar.setTime(referenceDate);
       calendar.add(Calendar.DATE, -day);
       return calendar.getTime();
   }
   /**
    * 获取上个月
    * @return
    */
   public static String getLastMonth() {
		LocalDate today = LocalDate.now();
		today = today.minusMonths(1);
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM");
		return formatters.format(today);
	}
   
   /**
    * 判断时间字符串是否合规
    * @param datevalue
    * @param dateFormat
    * @return
    */
   public static boolean isDateString(String datevalue, String dateFormat) {
       if (StringUtils.isEmpty(datevalue)) {
           return false;
       }
		if(StringUtils.isEmpty(dateFormat))
		{
			dateFormat = DEFAULT_FORMAT_YEAR_MONTH_DAY;
		}
       try {
           SimpleDateFormat fmt = new SimpleDateFormat(dateFormat);
           Date dd = fmt.parse(datevalue);
           if (datevalue.equals(fmt.format(dd))) {
               return true;
           } else {
               return false;
           }
       } catch (Exception e) {
           return false;
       }
   }

}
