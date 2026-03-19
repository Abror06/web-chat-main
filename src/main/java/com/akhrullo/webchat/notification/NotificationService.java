package com.akhrullo.webchat.notification;

import com.akhrullo.webchat.exception.WebChatApiException;
import com.akhrullo.webchat.message.Message;
import com.akhrullo.webchat.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {
//    private final EmailService emailService;
    public void notifyReceiver(Message message) {
        User receiver = message.getChat().getUsers().stream()
                .filter(user -> !user.equals(message.getSender()))
                .findFirst()
                .orElseThrow(WebChatApiException::receiverNotFound);

//        emailService.sendNotification(receiver.getEmail(), "New Message", "You have received a new message from " + message.getSender().getFirstname());
    }
}
