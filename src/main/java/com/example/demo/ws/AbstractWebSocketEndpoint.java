/*
 * SteVe - SteckdosenVerwaltung - https://github.com/steve-community/steve
 * Copyright (C) 2013-2023 SteVe Community Team
 * All Rights Reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.example.demo.ws;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.PongMessage;
import org.springframework.web.socket.SubProtocolCapable;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

@Slf4j
public  class AbstractWebSocketEndpoint extends ConcurrentWebSocketHandler implements SubProtocolCapable {

    @Autowired private ScheduledExecutorService service;

    @Autowired private ApplicationEventPublisher applicationEventPublisher;


    public void init() {
   
    }



    @Override
    public void onMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        if (message instanceof TextMessage) {
            handleTextMessage(session, (TextMessage) message);

        } else if (message instanceof PongMessage) {
            handlePongMessage(session);

        } else if (message instanceof BinaryMessage) {
            session.close(CloseStatus.NOT_ACCEPTABLE.withReason("Binary messages not supported"));

        } else {
            throw new IllegalStateException("Unexpected WebSocket message type: " + message);
        }
    }

    private void handleTextMessage(WebSocketSession session, TextMessage webSocketMessage) throws Exception {
    	log.info("on handel text message ???????");
    }

    private void handlePongMessage(WebSocketSession session) {
    	log.info("on handel pong message ???????");
    }

    @Override
    public void onOpen(WebSocketSession session) throws Exception {
    	log.info("open ???????");
             }
    

    @Override
    public void onClose(WebSocketSession session, CloseStatus closeStatus) throws Exception {
 log.info("close ???????");
    }	

    @Override
    public void onError(WebSocketSession session, Throwable throwable) throws Exception {
    	log.info("error ???????");
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }



	@Override
	public List<String> getSubProtocols() {
		// TODO Auto-generated method stub
		return null;
	}



    
}
