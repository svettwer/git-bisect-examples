package com.github.example.cakefactory.controller;

import com.github.example.cakefactory.dto.Cake;
import com.github.example.cakefactory.services.CakeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(path = "/cake")
public class CakeController {

    @Resource
    private CakeService cakeService;

    @RequestMapping(method = RequestMethod.GET)
    public Cake getCake(){
        return cakeService.getCake();
    }
}
