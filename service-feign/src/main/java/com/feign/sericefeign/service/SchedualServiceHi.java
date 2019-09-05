package com.feign.sericefeign.service;

import com.feign.sericefeign.service.impl.SchedualServiceHiHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//,fallback = SchedualServiceHiHystric.class
@FeignClient(value = "service-hi")
public interface SchedualServiceHi {

    @RequestMapping(value = "/user/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

    @RequestMapping(value = "/user/insertUser",method = RequestMethod.GET)
    String insert(@RequestParam(value = "name") String name);
}