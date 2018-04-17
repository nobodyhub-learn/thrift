package com.nobodyhub.learn.thrift.spring;

import com.nobodyhub.learn.thrift.spring.service.TCalculatiorService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Servlet;

/**
 * @author Ryan
 */
@EnableAutoConfiguration
@Configuration
@ComponentScan
public class CalculatorApplication {
    public static void main(String[] args) {
        SpringApplication.run(CalculatorApplication.class, args);
    }

    @Bean
    public TProtocolFactory tProtocolFactory() {
        return new TBinaryProtocol.Factory();
    }

    @Bean
    public Servlet calculator(TProtocolFactory tProtocolFactory, CalculatorServiceHandler handler) {
        return new TServlet(new TCalculatiorService.Processor<>(handler), tProtocolFactory);
    }
}
