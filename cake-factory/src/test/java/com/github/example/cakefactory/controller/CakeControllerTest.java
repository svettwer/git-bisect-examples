/*
MIT License

Copyright (c) 2018 Sven Hettwer

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */

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
import static org.mockito.Mockito.verify;
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
        verify(cakeService).getCake();
        Assert.assertEquals(expectedCake, cake);
    }

    @Test
    public void getSpecificCake() {

        //GIVEN
        String orderedCake = "strawberry";
        Cake expectedCake = mock(Cake.class);
        when(cakeService.getCake(orderedCake)).thenReturn(expectedCake);

        //WHEN
        Cake cake = cakeController.getCake(orderedCake);

        //THEN
        verify(cakeService).getCake(orderedCake);
        Assert.assertEquals(expectedCake, cake);
    }
}