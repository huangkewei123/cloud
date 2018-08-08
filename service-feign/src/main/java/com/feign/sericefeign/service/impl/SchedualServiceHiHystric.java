package com.feign.sericefeign.service.impl;

import com.feign.sericefeign.service.SchedualServiceHi;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry, you are fail,"+name;
    }

    public String insert(String name) {
        return "sorry, you are fail,insert"+name;
    }
}