package com.nobodyhub.learn.thrift.handler;

import com.nobodyhub.learn.thrift.service.HelloWorldService;
import org.apache.thrift.TException;

/**
 * @author Ryan
 */
public class HelloWorldHandler implements HelloWorldService.Iface {
    public String hello(String name) throws TException {
        System.out.println(String.format("Accepting Request: [Hello: %s]", name));
        return String.format("Hello %s!", name);
    }
}
