package com.akhrullo.webchat.message.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.core.io.Resource;

@Data
@Builder
public class MessageFileDto {

    private String contentType;

    private Resource resource;

    private String filename;
}
