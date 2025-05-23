package com.sample.customannotationsample.controller;

import com.sample.customannotationsample.common.service.ExecutableMethodRegistry;
import com.sample.customannotationsample.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class TestController {
    private final TestService testService;
    private final ExecutableMethodRegistry executableMethodRegistry;

    @RequestMapping("/test")
    public void test() {
        testService.customAnnotationTest();
    }

    @PutMapping("/{methodName}/status")
    public ResponseEntity<String> setMethodStatus(@PathVariable String methodName, @RequestParam boolean enable) {
        executableMethodRegistry.setMethodExecutable(methodName, enable);
        return ResponseEntity.ok(methodName + " method status set to " + (enable ? "enabled" : "disabled"));
    }

    @GetMapping("/{methodName}/status")
    public ResponseEntity<Boolean> getMethodStatus(@PathVariable String methodName) {
        boolean isExecutable = executableMethodRegistry.isMethodExecutable(methodName);
        return ResponseEntity.ok(isExecutable);
    }
}
