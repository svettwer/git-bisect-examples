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
    public void defaultCakeIsVanilla() {

        //GIVEN

        //WHEN
        Cake cake = cakeService.getCake();

        //THEN
        assertEquals("vanilla", cake.getKind());
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