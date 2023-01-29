package com.shop.webshop.utils;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @AUTHOR: OSWALDO HERNANDEZ
 */
public class NullUtils {

    /**
     *
     * @param obj
     * @return true
     */
    public static boolean isEmpty(Object obj) {

        if (obj == null) {
            return true;
        }
        if (obj instanceof String) {
            return "".equals(((String) obj).trim());
        }
        if (obj instanceof Collection) {
            Collection coll = (Collection) obj;
            return coll.size() == 0;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            return map.size() == 0;
        }
        if (obj.getClass().isArray()) {
            return Array.getLength(obj) == 0;
        } else {
            return false;
        }
    }

    /**
     *
     * @param source
     * @return
     */
    public static boolean isEmpty(String source) {
        return (source == null || source.trim().isEmpty() || "".equals(source));
    }

    /**
     *
     * @param source
     * @return
     */
    public static boolean isNotEmpty(String source) {
        return (source != null && !source.trim().isEmpty());
    }

    /**
     * Null
     *
     * @param source
     * @return
     */
    public static boolean isEmpty(String[] source) {
        return (source == null || source.length == 0);
    }

    /**
     *
     * @param source
     * @return
     */
    public static boolean isNotEmpty(String[] source) {
        return (source != null && source.length > 0);
    }

    /**
     *
     * @param source
     * @return
     */
    public static boolean isEmpty(List<Object> source) {
        return (source == null || source.size() == 0);
    }

    /**
     *
     * @param source
     * @return
     */
    public static boolean isNotEmpty(List<Object> source) {
        return (source != null && source.size() > 0);
    }

    /**
     * Null
     *
     * @param source
     * @return
     */
    public static boolean isNotNull(Object source) {
        return source != null;
    }

    /**
     * Null
     *
     * @param source
     * @return
     */
    public static boolean isNull(Object source) {
        return source == null;
    }


}

