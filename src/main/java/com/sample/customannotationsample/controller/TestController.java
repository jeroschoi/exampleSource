package com.sample.customannotationsample.controller;

import com.sample.customannotationsample.common.service.ExecutableMethodRegistry;
import com.sample.customannotationsample.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TestController {
    private final TestService testService;
    private final ExecutableMethodRegistry executableMethodRegistry;

    @RequestMapping("/test")
    public void test() {
        testService.customAnnotationTest();
    }

    @RequestMapping("/test/aop/false")
    public void testAopFalse() {
        executableMethodRegistry.setMethodExecutable( "customAnnotationTest", false);
    }

    @RequestMapping("/test/aop/true")
    public void testAopTrue() {
        executableMethodRegistry.setMethodExecutable( "customAnnotationTest", false);
    }
}
