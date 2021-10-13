package com.dyx;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyDemo1 {
    public static void main(String[] args) {

        //不用代理，执行方法
        String buy2 = new Lenovo().sale(5200);
        System.out.println(buy2);


/*
        //动态代理 实现和普通调用一摸一样
        final Lenovo lenovo = new Lenovo();
        Sale proxy_lenovo = (Sale) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(),
                lenovo.getClass().getInterfaces(),
                new InvocationHandler() {

                    //通过代理对象调用的所有方法，都会触发该方法执行
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        Object obj = method.invoke(lenovo, args);
                        return obj;
                    }
                });


        String buy1 = proxy_lenovo.sale(6400);
        System.out.println(buy1);
*/


        //动态代理 增强某一个方法
        final Lenovo lenovo = new Lenovo();
        Sale proxy_lenovo = (Sale) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(),
                lenovo.getClass().getInterfaces(),
                new InvocationHandler() {

                    //通过代理对象调用的所有方法，都会触发该方法执行
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        // 只增强 sale 方法
                        if(method.getName().equals("sale")){
                            double money = (double)args[0];
                            Object obj = method.invoke(lenovo, money*0.85);
                            return obj;
                        }else{
                            Object obj = method.invoke(lenovo, args);
                            return obj;
                        }
                    }
                });


        String buy1 = proxy_lenovo.sale(5200);
        System.out.println(buy1);



    }
}
