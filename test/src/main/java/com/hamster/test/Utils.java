package com.hamster.test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.springframework.aop.framework.Advised;
import org.springframework.aop.support.AopUtils;
import org.springframework.test.util.ReflectionTestUtils;

import com.google.common.base.Preconditions;

public class Utils {

    private Utils() {
    }

    public static <T> T unwrapProxy(Object bean, Class<T> _class) throws Exception {
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
    
    public static <T, K> T createMock(K object, Class<T> attrClass, String attrName){
        T attr = mock(attrClass);
        try {
            ReflectionTestUtils.setField(unwrapProxy(object, object.getClass()), attrName, attr);
        } catch (Exception e) {
            assertTrue(e.getMessage(), false);
        }
        return attr;
        
    }
    
    public static void invokeWithException(ExceptionCallback callback) {
        try {
            callback.invoke();
            assertTrue(false);
        } catch(Exception e) {
            assertTrue(callback.check(e));
        }
    }

    public static void invokeWithException(InvocationCallback callback) {
        invokeWithException(new SimpleExceptionCallback(callback));
    }
    
    public static interface ExceptionCallback {
        
        void invoke() throws Exception;
        
        boolean check(Exception e);
        
    }

    public static interface InvocationCallback {
        
        void invoke() throws Exception;

    }

    public static class SimpleExceptionCallback implements ExceptionCallback{

        private InvocationCallback callback;
        
        public SimpleExceptionCallback(InvocationCallback callback) {
            this.callback = Preconditions.checkNotNull(callback);
        }

        @Override
        public void invoke() throws Exception {
            callback.invoke();
        }

        @Override
        public boolean check(Exception e) {
            return true;
        }
        
    }
}
