package com.hamster.test;

import org.springframework.aop.framework.Advised;
import org.springframework.aop.support.AopUtils;

public class Utils {

    private Utils() {
    }

    public static final <T> T unwrapProxy(Object bean, Class<T> _class) throws Exception {
        /*
         * If the given object is a proxy, set the return value as the object
         * being proxied, otherwise return the given object.
         */
        if (!AopUtils.isAopProxy(bean) || !(bean instanceof Advised)) {
            return (T) bean;
        }
        Advised advised = (Advised) bean;
        return unwrapProxy(advised.getTargetSource().getTarget(), _class);
    }
}
