package com.abhi.messageproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/message-produce")
public class MessageProduceController {

    private static final String URL="http://192.168.56.1:8765/messaging-server-config/message-config/produce";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public void sendMessage(){

        Map<String, String> uriVariable = new HashMap<>();
        System.out.println(URL);
        uriVariable.put("topicName", "test");
        System.out.println(uriVariable);
        restTemplate.getForObject(URL, Object.class);
        System.out.println("Send successfully");
    }

   /* @GetMapping
    public String testConfig(){
        return "Ok tested";
    }*/

}
