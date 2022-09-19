package com.knoldus.controller;

import com.knoldus.dto.Item;
import com.knoldus.interfaces.ItemClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;


@RestController
public class JatinController {
    private final ItemClient itemClient;
    public JatinController(ItemClient itemClient){
        this.itemClient = itemClient;
    }
    @GetMapping("/neha")
    public Collection<Item> goodItems() {
        return itemClient.readData()
                .getContent()
                .stream()
                .filter(this::isGreat)
                .collect(Collectors.toList());
    }
    private boolean isGreat(Item item) {
        return !item.getName().equals("Nike") &&
                !item.getName().equals("Adidas") &&
                !item.getName().equals("Reebok");
    }
}
