package com.sample.customannotationsample.service;

import com.sample.customannotationsample.common.annotation.ExecutableMethod;
import com.sample.customannotationsample.common.service.ExecutableMethodRegistry;
import jdk.jfr.Description;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestService {

    private final ExecutableMethodRegistry executableMethodRegistry;

    @ExecutableMethod(methodName = "customAnnotationTest")
    @Description("Custom Annotation Test")
    @Scheduled(cron = "15 19 * * * *")
    public void customAnnotationTest() {
        log.info("customAnnotationTest Start!!!");
        if(executableMethodRegistry.isMethodExecutable("customAnnotationTest")) {
            log.info("customAnnotationTest is executable");
        } else {
            log.info("customAnnotationTest is not executable");
        }
    }
}
