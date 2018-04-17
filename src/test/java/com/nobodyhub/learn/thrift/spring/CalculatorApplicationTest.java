package com.nobodyhub.learn.thrift.spring;

import com.nobodyhub.learn.thrift.spring.service.TCalculatiorService;
import com.nobodyhub.learn.thrift.spring.service.TOperation;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TTransport;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;


/**
 * @author Ryan
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
        classes = CalculatorApplication.class,
        properties = {"server.port=0"}
)
public class CalculatorApplicationTest {
    @Autowired
    protected TProtocolFactory tProtocolFactory;

    @Value("${server.port}")
    protected int port;

    protected TCalculatiorService.Client client;

    @Before
    public void setup() throws Exception {
        TTransport transport = new THttpClient("http://localhost:" + port + "/calculator/");
        TProtocol protocol = tProtocolFactory.getProtocol(transport);
        client = new TCalculatiorService.Client(protocol);
    }

    @Test
    public void testAdd() throws Exception {
        assertEquals(5, client.calculator(2, 3, TOperation.ADD));
    }
}