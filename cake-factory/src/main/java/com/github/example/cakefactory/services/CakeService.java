package com.github.example.cakefactory.services;

import com.github.example.cakefactory.dto.Cake;
import org.springframework.stereotype.Service;

@Service
public class CakeService {


    public Cake getCake() {
        return new Cake("vanilla");
    }


    public Cake getCake(String kind) {
        return new Cake(kind);
    }
}
