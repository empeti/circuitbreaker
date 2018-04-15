package com.mpeti.circuitbreakerdemo.client;

import com.mpeti.circuitbreakerdemo.domain.Cat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CatResource {
    @RequestMapping(value = "/cat", method = RequestMethod.GET)
    public List<Cat> getCats();

    @RequestMapping(value = "/cat/{id}", method = RequestMethod.GET)
    public Cat getCat(@RequestParam("id") Integer id);
}
