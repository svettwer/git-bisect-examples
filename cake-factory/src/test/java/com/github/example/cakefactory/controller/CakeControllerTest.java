package com.github.example.cakefactory.controller;

import com.github.example.cakefactory.dto.Cake;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CakeControllerTest {

    @Resource
    private CakeController cakeController;

    @Test
    public void getCake() {

        //GIVEN

        //WHEN
        Cake cake = cakeController.getCake();

        //THEN
        Assert.assertEquals("chocolate", cake.getKind());
    }
}