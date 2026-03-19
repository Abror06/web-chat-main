package com.akhrullo.webchat.message.event;

import com.akhrullo.webchat.message.Message;
import com.akhrullo.webchat.notification.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class MessageSentEventListener {
    private final NotificationService notificationService;
    @Async
    @EventListener
    public void onMessageSent(MessageSentEvent event) {
        Message message = event.getMessage();
        notificationService.notifyReceiver(message);
    }
}
