package com.sample.customannotationsample.service;

import com.sample.customannotationsample.common.annotation.ExecutableMethod;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestService {

    @ExecutableMethod(methodName = "customAnnotationTest")
    @Scheduled(cron = "15 19 * * * *")
    public void customAnnotationTest() {
        log.info("customAnnotationTest Start!!!");
    }
}
