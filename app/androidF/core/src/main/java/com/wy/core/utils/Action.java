package com.wy.core.utils;


public interface Action<T> {
    void call(T data);
}