package com.mpeti.circuitbreakerdemo.service;

import com.mpeti.circuitbreakerdemo.client.CatClient;
import com.mpeti.circuitbreakerdemo.domain.Cat;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CatService {
    private CatClient catClient;

    @HystrixCommand(
        commandKey = "getCats",
        fallbackMethod = "getFallbackCats"
    )
    public List<Cat> getCats(){
        return catClient.getCats();
    }

    public List<Cat> getFallbackCats(){
        List<Cat> cats = new ArrayList<>();
        Cat cat1 = new Cat(1,2,"Daisy");
        Cat cat2 = new Cat(2, 3, "Whitey");
        Cat cat3 = new Cat(3, 4, "Mickey");
        Cat cat4 = new Cat(4, 5,"Mirrmurr");
        Cat cat5 = new Cat(5, 6, "Cili");

        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);
        cats.add(cat4);
        cats.add(cat5);

        return cats;
    }

    public Cat getCat(Integer id){
        return catClient.getCat(id);
    }
}
