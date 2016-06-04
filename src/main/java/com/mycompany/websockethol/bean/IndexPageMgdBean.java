/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.websockethol.bean;

import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Topic;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author matsumotoshigeharu
 */
@Named(value = "indexPageMgdBean")
@RequestScoped
public class IndexPageMgdBean {
    
    @Inject
    @JMSConnectionFactory("jms/topicCon")
    JMSContext context;
    
    @Resource(mappedName="jms/inforegtopic")
    Topic topic;
    
    @Getter @Setter
    private String message;
    
    public String pushSendButton(){
        //System.out.println(getMessage());
        context.createProducer().send(topic, getMessage());
        return "";
    }
}
