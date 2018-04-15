package com.mpeti.circuitbreakerdemo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Cat {
    private Integer id;
    private Integer age;
    private String name;

    public Cat(){
        super();
    }
}

