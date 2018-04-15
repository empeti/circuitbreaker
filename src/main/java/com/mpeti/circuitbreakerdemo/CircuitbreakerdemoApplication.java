package com.mpeti.circuitbreakerdemo;

import com.mpeti.circuitbreakerdemo.domain.Cat;
import com.mpeti.circuitbreakerdemo.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
@EnableCircuitBreaker
@EnableFeignClients
public class CircuitbreakerdemoApplication {
    @Autowired
    CatService catService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(CircuitbreakerdemoApplication.class, args);
        CircuitbreakerdemoApplication app = context.getBean(CircuitbreakerdemoApplication.class);
        System.out.println(app.getCats());
    }

    protected List<Cat> getCats() {
        return catService.getCats();
    }

}
