package com.sda.oauth2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;
import java.util.List;

//@RestController
//@RequestMapping("/items")
public class ItemController {

    @GetMapping("/{id}")
    public Item findById(@PathVariable Long id) {
        return new Item(1, "test");
    }

    @GetMapping
    public List<Item> findAll() {
        return Arrays.asList(
                new Item(1, "test"),
                new Item(2, "test2"),
                new Item(3, "test3")
        );
    }

    @PostMapping
    public void create(@RequestBody Item item) {
        System.out.println("item created");
    }
}
