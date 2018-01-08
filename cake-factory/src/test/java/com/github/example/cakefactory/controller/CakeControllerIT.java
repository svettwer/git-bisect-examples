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

import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.dsl.junit.JUnit4CitrusTestDesigner;
import com.consol.citrus.http.client.HttpClient;
import com.consol.citrus.message.MessageType;
import com.github.example.cakefactory.config.EndpointConfig;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = { EndpointConfig.class })
public class CakeControllerIT extends JUnit4CitrusTestDesigner{

    @Autowired
    private HttpClient cakeFactoryClient;

    @Test
    @CitrusTest
    public void ensureDefaultCakeIsChocolate(){

        http()
                .client(cakeFactoryClient)
                .send()
                .get("/cake");
        http()
                .client(cakeFactoryClient)
                .receive()
                .response(HttpStatus.OK)
                .messageType(MessageType.JSON)
                .payload("{\"kind\": \"chocolate\"}");
    }

    @Test
    @CitrusTest
    public void ensureOrderedCakeIsDelivered(){

        http()
                .client(cakeFactoryClient)
                .send()
                .get("/cake/strawberry");
        http()
                .client(cakeFactoryClient)
                .receive()
                .response(HttpStatus.OK)
                .messageType(MessageType.JSON)
                .payload("{\"kind\": \"strawberry\"}");
    }
}
