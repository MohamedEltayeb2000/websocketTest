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


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.util.CollectionUtils;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.server.HandshakeFailureException;
import org.springframework.web.socket.server.HandshakeHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.util.List;
import java.util.Map;
import java.util.Optional;



@Slf4j
@RequiredArgsConstructor
public class OcppWebSocketHandshakeHandler implements HandshakeHandler {

    private final DefaultHandshakeHandler delegate;
  

    public WebSocketHandler getDummyWebSocketHandler() {
        return new TextWebSocketHandler();
    }

    @Override
    public boolean doHandshake(ServerHttpRequest request, ServerHttpResponse response,
                               WebSocketHandler wsHandler, Map<String, Object> attributes) throws HandshakeFailureException {

     log.info("Do handshake");

        // -------------------------------------------------------------------------
        // 2. Route according to the selected protocol
        // -------------------------------------------------------------------------

        List<String> requestedProtocols = new WebSocketHttpHeaders(request.getHeaders()).getSecWebSocketProtocol();

//        if (CollectionUtils.isEmpty(requestedProtocols)) {
//            log.error("No protocol (OCPP version) is specified.");
//            response.setStatusCode(HttpStatus.BAD_REQUEST);
//            return false;
//        }

        AbstractWebSocketEndpoint endpoint = new AbstractWebSocketEndpoint();
       

//        if (endpoint == null) {
//            log.error("None of the requested protocols '{}' is supported", requestedProtocols);
//            response.setStatusCode(HttpStatus.NOT_FOUND);
//            return false;
//        }

        
        return delegate.doHandshake(request, response, endpoint, attributes);
    }


}
