package com.java4all.controller;

import com.java4all.component.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "mq")
public class RabbitmqController {

    @Autowired
    private Sender sender;

    @RequestMapping(value = "sendMsg",method = RequestMethod.GET)
    public String sendMsg(){
        List<String> list = Arrays.asList("重楼","天知道","哈哈","呵呵","啦啦啦");
        sender.send(list);
        return "Send.............";
    }
}
