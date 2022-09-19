package com.knoldus.interfaces;

import com.knoldus.dto.Item;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.Data;
import com.netflix.client.util.Resources;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.*;

@FeignClient("ITEMCATALOG")
public interface ItemClient {
    @GetMapping("/items")
    CollectionModel<Item> readData();
}
