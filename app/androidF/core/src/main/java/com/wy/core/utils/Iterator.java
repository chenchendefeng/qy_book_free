package com.wy.core.utils;

import java.util.Collection;

/**
 * 迭代器
 */
public class Iterator {

    public static  <T> void foreach(Collection<T> list, Action<T> action) {
        if (list != null && list.size() > 0)
            for (T o : list) {
                action.call(o);
            }
    }
}
