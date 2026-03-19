package com.akhrullo.webchat.chat;

import com.akhrullo.webchat.chat.dto.ChatDto;
import com.akhrullo.webchat.user.dto.UserDto;

import java.util.List;


public interface ChatService {
    Chat findChatById(Long id);

    ChatDto createChat(Long partnerId);

    ChatDto getChatById(Long chatId);

    List<ChatDto>  getAllChats();

    List<UserDto> getChatUsers(Long chatId);
}
