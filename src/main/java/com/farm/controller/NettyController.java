package com.farm.controller;

import com.farm.data.nio.server.NettyServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @name: NettyController
 * @author: sutton
 * @date: 2023-04-24 10:14
 * @description: NettyController
 */
@RestController
@RequestMapping(value = "/nettyserver", method = RequestMethod.GET)
public class NettyController {
    @Resource
    private NettyServer nettyServer;

    @RequestMapping("/localAddress")
    public String localAddress () {
        return "nettyServer localAddress " + nettyServer.getChannel().localAddress();
    }

    @RequestMapping("/isOpen")
    public String isOpen () {
        return "nettyServer isOpen " + nettyServer.getChannel().isOpen();
    }
}
