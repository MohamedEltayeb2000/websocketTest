package com.example.demo.config;



import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import com.example.demo.ws.OcppWebSocketHandshakeHandler;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@EnableWebSocket
@Configuration
@Slf4j
public class WebSocketConfiguration implements WebSocketConfigurer {


    public static final String PATH_INFIX = "/websocket/CentralSystemService/";
    public static final long PING_INTERVAL = TimeUnit.MINUTES.toMinutes(15);
    public static final Duration IDLE_TIMEOUT = Duration.ofHours(2);
    public static final int MAX_MSG_SIZE = 8_388_608; // 8 MB for max message size

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {

        OcppWebSocketHandshakeHandler handshakeHandler = new OcppWebSocketHandshakeHandler(
            new DefaultHandshakeHandler()

        );

        registry.addHandler(handshakeHandler.getDummyWebSocketHandler(), PATH_INFIX + "*")
                .setHandshakeHandler(handshakeHandler)
                .setAllowedOrigins("*");
    }
}
