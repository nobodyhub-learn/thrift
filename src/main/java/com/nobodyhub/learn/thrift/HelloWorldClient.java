package com.nobodyhub.learn.thrift;

import com.nobodyhub.learn.thrift.service.HelloWorldService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * @author Ryan
 */
public class HelloWorldClient {
    public static void main(String[] args) {
        try (TTransport transport = new TSocket("127.0.0.1", 9090)) {
            transport.open();
            TProtocol protocal = new TBinaryProtocol(transport);
            HelloWorldService.Client client = new HelloWorldService.Client(protocal);

            String response = client.hello("Yan");
            System.out.println(String.format("Receive Response: %s",response));
        } catch(TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }
    }
}
