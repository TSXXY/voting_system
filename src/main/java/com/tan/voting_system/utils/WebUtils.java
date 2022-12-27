package com.tan.voting_system.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * @author TanShan
 * @date 2022/12/27 21:03
 */
public class WebUtils {
    public static <T> T copy(Map map, T t) {
        try {
            BeanUtils.populate(t, map);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return t;
    }

    public static int parseInt(String s,int defaultValue){
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return defaultValue;
    }
}
