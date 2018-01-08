package com.github.example.cakefactory.controller;

import com.github.example.cakefactory.dto.Cake;
import com.github.example.cakefactory.services.CakeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CakeControllerTest {

    @Resource
    private CakeController cakeController;

    @MockBean
    private CakeService cakeService;

    @Test
    public void getCake() {

        //GIVEN
        Cake expectedCake = mock(Cake.class);
        when(cakeService.getCake()).thenReturn(expectedCake);

        //WHEN
        Cake cake = cakeController.getCake();

        //THEN
        Assert.assertEquals(expectedCake, cake);
    }
}