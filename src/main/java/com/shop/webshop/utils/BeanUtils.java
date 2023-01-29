package com.shop.webshop.utils;

import java.util.*;

/**
 * 对象转换类
 */
public class BeanUtils {

    public static <T, E> void copyProperties(T source, E target, String[] ignoreParams) {
        copy(source, target, ignoreParams);
    }

    public static <T, E> void copyProperties(T source, E target) {
        copy(source, target, null);
    }

    public static <T, E> E copyProperties(T source, Class<E> type) {
        if (source == null) {
            return null;
        }
        E target;
        try {
            target = type.newInstance();
            copyProperties(source, target, null);
            return target;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T, E> E copyProperties(T source, Class<E> type, String[] ignoreParams) {
        E target;
        try {
            target = type.newInstance();
            copyProperties(source, target, ignoreParams);
            return target;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static <T, E> E copy(T source, E target, String[] ignoreParams) {
        if (source == null || target == null) {
            return null;
        }
        org.springframework.beans.BeanUtils.copyProperties(source, target, ignoreParams);
        return target;
    }

//    public static <T, E> List<E> copyList(List<T> source, Class<E> type) {
//        if (source == null || type == null) {
//            return null;
//        }
//        List<E> result = new ArrayList<E>();
//        E temp = null;
//        for (T o : source) {
//            temp = BeanUtils.copyProperties(o, type);
//            result.add(temp);
//        }
//        return result;
//    }

    public static <T, E> List<E> copyList(Collection<T> source, Class<E> type) {
        if (source == null || type == null) {
            return null;
        }
        List<E> result = new ArrayList<E>();
        E temp = null;
        for (T o : source) {
            temp = BeanUtils.copyProperties(o, type);
            result.add(temp);
        }
        return result;
    }

    public static <T, E> List<E> copyList(List<T> source, Class<E> type, String[] ignoreParams) {
        if (source == null || type == null) {
            return null;
        }
        List<E> result = new ArrayList<E>();
        E temp = null;
        for (T o : source) {
            temp = BeanUtils.copyProperties(o, type, ignoreParams);
            result.add(temp);
        }
        return result;
    }


}





