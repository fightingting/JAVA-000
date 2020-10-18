package com.citi.lm.modules.business.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author wangtingting
 * @date 2020-10-18 21:17
 * -------------------------------------------------------------------------
 * Modified Date  Modified By   Why & What's modified
 * -------------------------------------------------------------------------
 */
public class HelloClassLoader extends ClassLoader {

    public static void main(String[] args) {
        try {
            //Hello 实例
            Object helloClass = new HelloClassLoader().findClass("Hello").newInstance();
            Method helloMethod = helloClass.getClass().getMethod("hello");
            helloMethod.invoke(helloClass);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }  catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name){
        File file = new File("E:\\java_training\\Hello\\Hello.xlass");
        byte[] bytes = new byte[(int) file.length()];
        try {
            new FileInputStream(file).read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte)(255-bytes[i]);
        }
        return defineClass(name,bytes,0,bytes.length);
    }
}
