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
