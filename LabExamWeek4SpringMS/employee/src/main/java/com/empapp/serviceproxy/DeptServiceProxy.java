package com.empapp.serviceproxy;

import com.empapp.dto.Department;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Service
@FeignClient(name = "departments")
public interface DeptServiceProxy {

    @GetMapping("departments/{name}")
    @CircuitBreaker(name = "cb", fallbackMethod = "DeptFallBack")
    public Department getByName(@PathVariable String name);

    default Department DeptFallBack(String name ,Throwable throwable){
        return new Department(0,null,"Not Found");
    }
}
