package com.github.example.cakefactory.controller;

import com.github.example.cakefactory.dto.Cake;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/cake")
public class CakeController {

    @RequestMapping(method = RequestMethod.GET)
    public Cake getCake(){
        return new Cake("chocolate");
    }
}
