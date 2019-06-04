/**
 * Copyright 2016 JustWayward Team
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.wy.core.utils;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Created by lfh on 2016/9/10.
 */
public class StringUtils {

    private static final int HOUR_OF_DAY = 24;
    private static final int DAY_OF_YESTERDAY = 2;
    private static final int TIME_UNIT = 60;

    //将时间转换成日期
    public static String dateConvert(long time, String pattern) {
        Date date = new Date(time);
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    //将日期转换成昨天、今天、明天
    public static String dateConvert(String source, String pattern) {
        DateFormat format = new SimpleDateFormat(pattern);
        Calendar calendar = Calendar.getInstance();
        try {
            Date date = format.parse(source);
            long curTime = calendar.getTimeInMillis();
            calendar.setTime(date);
            //将MISC 转换成 sec
            long difSec = Math.abs((curTime - date.getTime()) / 1000);
            long difMin = difSec / 60;
            long difHour = difMin / 60;
            long difDate = difHour / 60;
            int oldHour = calendar.get(Calendar.HOUR);
            //如果没有时间
            if (oldHour == 0) {
                //比日期:昨天今天和明天
                if (difDate == 0) {
                    return "今天";
                } else if (difDate < DAY_OF_YESTERDAY) {
                    return "昨天";
                } else {
                    DateFormat convertFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String value = convertFormat.format(date);
                    return value;
                }
            }

            if (difSec < TIME_UNIT) {
                return difSec + "秒前";
            } else if (difMin < TIME_UNIT) {
                return difMin + "分钟前";
            } else if (difHour < HOUR_OF_DAY) {
                return difHour + "小时前";
            } else if (difDate < DAY_OF_YESTERDAY) {
                return "昨天";
            } else {
                DateFormat convertFormat = new SimpleDateFormat("yyyy-MM-dd");
                String value = convertFormat.format(date);
                return value;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }




    public static boolean isNumber(String str) {
        if (str == null || str.length() < 1) {
            return false;
        }

        Pattern pattern = Pattern.compile("[0-9]*.[0-9]*");
        return pattern.matcher(str).matches();
    }

    /**
     * 将文本中的半角字符，转换成全角字符
     *
     * @param input
     * @return
     */
    public static String halfToFull(String input) {
        char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 32) //半角空格
            {
                c[i] = (char) 12288;
                continue;
            }
            //根据实际情况，过滤不需要转换的符号
            //if (c[i] == 46) //半角点号，不转换
            // continue;

            if (c[i] > 32 && c[i] < 127)    //其他符号都转换为全角
                c[i] = (char) (c[i] + 65248);
        }
        return new String(c);
    }


    /**
     * 格式化金额
     *
     * @param num   需要格式化的值
     * @param point 小数点位数
     * @return
     */
    public static String formartAmout(double num, int point) {
        String pattern = "#0.0";
        for (int i = 1; i < point; i++) {
            pattern += "0";
        }
        DecimalFormat format = new DecimalFormat(pattern);
        String value = format.format(num);
        return value;
    }



    public static String formartAmout(String num, int point) {
        return formartAmout(ConvertUtils.covertDouble(num), point);
    }


}
