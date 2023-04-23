package com.farm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @name: DataController
 * @author: sutton
 * @date: 2023-04-23 17:16
 * @description: DataController
 */
@RequestMapping("/api/v1/data")
@RestController
public class DataController {

    @RequestMapping("/getHello")
    public String getHello () {
        return "hello";
    }
}
