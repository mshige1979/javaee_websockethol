/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.websockethol.webscoket;

import com.mycompany.websockethol.ejb.ClientManageSinglEJB;
import javax.ejb.EJB;
import javax.websocket.OnClose;
import javax.websocket.Session;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author matsumotoshigeharu
 */
@ServerEndpoint("/infotrans")
public class InfoTrainServerEndpoint {
    
    @EJB
    ClientManageSinglEJB clManager;
    
    @OnOpen
    public void initOpen(Session session){
        System.out.println("接続");
        clManager.addClient(session);
    }

    @OnClose
    public void closeWebSocket(Session session){
        System.out.println("切断");
        clManager.removeClient(session);
    }
    
}
