package com.github.shoothzj.agent.test.controller;

import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author hezhangjian
 */
@Slf4j
@RestController
public class OkHttp3Controller {

    @GetMapping("/okhttp3")
    public String testOkHttp() throws IOException {
        OkHttpClient client = new OkHttpClient.Builder().build();
        Request request = new Request.Builder()
                .url("http://localhost:8080/example").build();
        okhttp3.Response execute = client.newCall(request).execute();
        return execute.body().string();
    }

}
