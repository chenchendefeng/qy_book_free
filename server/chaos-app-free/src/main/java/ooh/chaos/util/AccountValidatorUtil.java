package ooh.chaos.util;

import java.util.regex.Pattern;

/**
 * 账户校验工具类
 * @author ZHI ZUN BAO
 * @since 2018/12/26
 */
public class AccountValidatorUtil {

    /**
     * 正则表达式：验证手机号
     */
    public static final String REGEX_MOBILE = "(1)\\d{10}$";


    /**
     * 校验手机号
     *
     * @param mobile
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isMobile(String mobile) {
        return Pattern.matches(REGEX_MOBILE, mobile);
    }

    public static void main(String[] args) {
        String mobile = "12326545661";
        boolean isMobile = AccountValidatorUtil.isMobile(mobile);
        System.out.println(isMobile);
    }
}
