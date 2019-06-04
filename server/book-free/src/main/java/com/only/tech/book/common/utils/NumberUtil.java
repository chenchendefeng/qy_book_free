package com.only.tech.book.common.utils;

import java.math.BigDecimal;

public class NumberUtil {

    public static Integer toZeroIfNull(Integer num) {
        return num == null ? 0 : num;
    }

    public static BigDecimal toZeroIfNull(BigDecimal num) {
        return num == null ? new BigDecimal("0") : num;
    }

    public static Float toZeroIfNull(Float num) {
        return num == null ? 0F : num;
    }

    public static Long toZeroIfNull(Long num) {
        return num == null ? 0L : num;
    }

    public static Double toZeroIfNull(Double num) {
        return num == null ? 0D : num;
    }
}
