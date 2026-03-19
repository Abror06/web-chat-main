package com.akhrullo.webchat.message;

import com.akhrullo.webchat.message.dto.CreateMessageDto;
import com.akhrullo.webchat.message.dto.MessageDto;
import com.akhrullo.webchat.message.dto.MessageFileDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MessageService {
    MessageDto sendMessage(CreateMessageDto createMessageDto);

    Page<MessageDto> getMessagesByChat(Long chatId, Pageable pageable);

    void markMessagesAsRead(Long chatId);

    MessageDto getMessageById(Long messageId);

    MessageFileDto getAttachmentForMessage(Long messageId);
}
