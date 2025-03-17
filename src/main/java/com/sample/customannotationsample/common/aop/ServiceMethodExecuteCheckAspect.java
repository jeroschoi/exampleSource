package com.sample.customannotationsample.common.aop;

import com.sample.customannotationsample.common.annotation.ExecutableMethod;
import com.sample.customannotationsample.common.service.ExecutableMethodRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
@Slf4j
public class ServiceMethodExecuteCheckAspect {
    private final ExecutableMethodRegistry executableMethodRegistry;

    @Before("@annotation(executableMethod)")
    public void checkExecution(ExecutableMethod executableMethod) throws Throwable {
        String methodName = executableMethod.methodName();
        Boolean isExecutable = executableMethodRegistry.isMethodExecutable(methodName);
        if (!Boolean.TRUE.equals(isExecutable)) {
            throw new IllegalAccessException("Method [" +  methodName + " ] is not executable at this time.");
        }else{
            log.info("Method [{}] is executable at this time.", methodName);
        }
    }
}
