package com.example.demo;

import com.example.MyAppService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcController {

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    private MyAppService myAppService;

    @GetMapping("/dc")
    public String dc() {
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }

    @GetMapping("/hello")
    public String hello() {
        System.out.println("---->hello");
        return "hello";
    }

    @GetMapping("/hello2")
    public String hello(String name) {
        return myAppService.sayHello(name);
    }
}
