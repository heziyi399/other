package com.hzyexample.other.service;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author hzy
 * @date 2021-12-08
 */
public class UserProxy {

    public static void nice() throws IOException {
        final Userimpl userimpl = new Userimpl();
        User targetproxy = (User) Proxy.newProxyInstance(UserProxy.class.getClassLoader(), new Class[]{User.class}, new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] myargs) throws Throwable {
                System.out.println("q我是前置");
                try {
                    return method.invoke(userimpl,myargs);
                } finally {
                    System.out.println("后置");
                }

            }
        });
targetproxy.getName("hzy");
buildProxy();
    }

    public static void buildProxy() throws IOException {
        byte[] bytes = ProxyGenerator.generateProxyClass("User$proxy",new Class[]{User.class});
        String fileName = System.getProperty("user.dir")+"\\target\\UserService$proxy.class";
        System.out.println(fileName);
        File file = new File(fileName);

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(bytes);
        fileOutputStream.flush();
        fileOutputStream.close();
    }

}
