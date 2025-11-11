package com.chat.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@EnableWebSocketMessageBroker
@Configuration
public class WebSocket implements WebSocketMessageBrokerConfigurer {
    @Override public void registerStompEndpoints(StompEndpointRegistry registry){
        registry.addEndpoint("/chat") .setAllowedOrigins("*") .withSockJS(); 
    }

    @Override public void configureMessageBroker(MessageBrokerRegistry registry){ // set message broker // whoever is subsribed to this "topic", they will get the message - sets up the message broker 
        registry.enableSimpleBroker("/topic"); // server -> client // expect message with /app/sendMessage 
        registry.setApplicationDestinationPrefixes("/app"); // client ->server 
    } 
}