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
public class ExampleController {

    @GetMapping("/example")
    public String example() throws IOException {
        return "example";
    }

}
