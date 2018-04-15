package com.mpeti.circuitbreakerdemo.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "cats", url="http://localhost:8080")
public interface CatClient extends CatResource{
}