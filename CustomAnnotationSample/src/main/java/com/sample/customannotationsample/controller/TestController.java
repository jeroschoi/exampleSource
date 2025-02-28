package com.sample.customannotationsample.controller;

import com.sample.customannotationsample.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TestController {
    private final TestService testService;

    @RequestMapping("/test")
    public void test() {
        testService.customAnnotationTest();
    }

}
