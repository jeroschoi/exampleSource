package com.sample.customannotationsample.common.service;

import com.sample.customannotationsample.common.annotation.ExecutableMethod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Slf4j
public class ExecutableMethodRegistry implements ApplicationListener<ContextRefreshedEvent> {

    private final ConcurrentHashMap<String, Boolean> enableMethodCheckMap = new ConcurrentHashMap<>();

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext context = event.getApplicationContext();
        Map<String, Object> beans = context.getBeansWithAnnotation(Service.class);

        for (Object bean : beans.values()) {
            Class<?> targetClass = AopProxyUtils.ultimateTargetClass(bean);
            Method[] methods = targetClass.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(ExecutableMethod.class)) {
                    ExecutableMethod executableFunction = method.getAnnotation(ExecutableMethod.class);
                    enableMethodCheckMap.put(executableFunction.methodName(), true);
                }
            }
        }
        log.info("enableMethod Data Setting Check : {}" , enableMethodCheckMap);
    }

    /**
     * method 사용가능여부 확인
     * @param methodName(String) Mehtod Name
     * @return Boolean ( true : 사용가능 , false : 사용불가 )
     */
    public Boolean isMethodExecutable(String methodName) {
        return enableMethodCheckMap.getOrDefault(methodName, true);
    }

    /**
     * method 사용가능여부 셋팅
     * @param methodName(String) Mehtod Name , enable(boolean) 사용가능여부
     */
    public void setMethodExecutable(String methodName , boolean enable) {
        enableMethodCheckMap.put(methodName, enable);
    }
}
