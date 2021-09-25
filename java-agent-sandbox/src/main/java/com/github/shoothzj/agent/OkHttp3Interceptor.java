package com.github.shoothzj.agent;

import com.alibaba.jvm.sandbox.api.Information;
import com.alibaba.jvm.sandbox.api.LoadCompleted;
import com.alibaba.jvm.sandbox.api.Module;
import com.alibaba.jvm.sandbox.api.listener.ext.EventWatchBuilder;
import com.alibaba.jvm.sandbox.api.resource.ModuleEventWatcher;
import org.kohsuke.MetaInfServices;

import javax.annotation.Resource;

/**
 * @author hezhangjian
 */
@MetaInfServices(Module.class)
@Information(id = "okhttp3", version = "0.0.1", author = "shoothzj@gmail.com", isActiveOnLoad = true)
public class OkHttp3Interceptor implements Module, LoadCompleted {

    @Resource
    private ModuleEventWatcher moduleEventWatcher;

    public OkHttp3Interceptor() {
        System.out.println("init okhttp3 interceptor");
    }

    @Override
    public void loadCompleted() {
        System.out.println("okhttp3 module load completed");
        try {
            new EventWatchBuilder(moduleEventWatcher)
                    .onClass("okhttp3.internal.connection.RealCall")
                    .includeSubClasses()
                    .onBehavior("execute")
                    .onWatch(new OkHttpAdviceListener());
        } catch (Exception e) {
            System.err.println("error");
            System.err.println(e);
        }
        System.out.println("listener init over");
    }
}
