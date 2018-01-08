package com.github.example.cakefactory.services;

import com.github.example.cakefactory.dto.Cake;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CakeServiceTest {

    @Resource
    private CakeService cakeService;

    @Test
    public void defaultCakeIsChocolate() {

        //GIVEN

        //WHEN
        Cake cake = cakeService.getCake();

        //THEN
        assertEquals("chocolate", cake.getKind());
    }

    @Test
    public void orderedCakeIsProduced() {

        //GIVEN
        String kindOfPie = "raspberry";

        //WHEN
        Cake cake = cakeService.getCake(kindOfPie);

        //THEN
        assertEquals(kindOfPie, cake.getKind());
    }
}