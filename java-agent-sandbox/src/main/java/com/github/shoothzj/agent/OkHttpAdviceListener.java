package com.github.shoothzj.agent;

import com.alibaba.jvm.sandbox.api.listener.ext.Advice;
import com.alibaba.jvm.sandbox.api.listener.ext.AdviceListener;

/**
 * @author hezhangjian
 */
public class OkHttpAdviceListener extends AdviceListener {

    public OkHttpAdviceListener() {
        System.out.println("Listener init");
    }

    @Override
    protected void before(Advice advice) throws Throwable {
        super.before(advice);
        System.out.println("okhttp3 before");
    }

    @Override
    protected void afterReturning(Advice advice) throws Throwable {
        super.afterReturning(advice);
        System.out.println("okhttp3 after returning");
    }

    @Override
    protected void after(Advice advice) throws Throwable {
        super.after(advice);
        System.out.println("okhttp3 after");
    }

    @Override
    protected void afterThrowing(Advice advice) throws Throwable {
        super.afterThrowing(advice);
        System.out.println("okhttp3 after throwing");
    }
}
