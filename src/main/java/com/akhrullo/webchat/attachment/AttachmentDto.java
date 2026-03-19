package com.akhrullo.webchat.attachment;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AttachmentDto {
    private Long id;

    private String originalName;

    private String type;

    private String generatedName;

    private String path;

    private long size;

    private boolean isMedia;
}
