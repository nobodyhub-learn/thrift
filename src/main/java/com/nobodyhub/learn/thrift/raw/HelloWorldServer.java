package com.nobodyhub.learn.thrift.raw;

import com.nobodyhub.learn.thrift.raw.handler.HelloWorldHandler;
import com.nobodyhub.learn.thrift.raw.service.HelloWorldService;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * @author Ryan
 */
public class HelloWorldServer {
    public static HelloWorldHandler handler;
    public static HelloWorldService.Processor<HelloWorldHandler> processor;

    public static void main(String[] args) {
        try{
            handler = new HelloWorldHandler();
            processor = new HelloWorldService.Processor<HelloWorldHandler>(handler);
            TServerTransport serverTransport = new TServerSocket(9090);
            TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));
            System.out.println("Starting the simple server...");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
