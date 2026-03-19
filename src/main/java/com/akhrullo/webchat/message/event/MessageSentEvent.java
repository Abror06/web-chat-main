package com.akhrullo.webchat.message.event;

import com.akhrullo.webchat.message.Message;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;


@Getter
public class MessageSentEvent extends ApplicationEvent {

    private final Message message;

    public MessageSentEvent(Object context, Message message) {
        super(context);
        this.message = message;
    }
}
