package com.hellomeritz.chat.service.dto.param;

import com.hellomeritz.chat.domain.ChatMessage;
import com.hellomeritz.chat.domain.ChatMessageType;
import com.hellomeritz.chat.global.client.TranslationRequest;

import java.util.Locale;

public record ChatMessageTextParam(
    String contents,
    long userId,
    boolean isFC,
    long chatRoomId,
    String targetLang,
    String sourceLang
) {
    public ChatMessage toChatMessage() {
        return ChatMessage.of(
            contents,
            ChatMessageType.TEXT.name(),
            userId,
            isFC,
            chatRoomId
        );
    }

    public ChatMessage toChatMessage(String translatedContents) {
        return ChatMessage.of(
            translatedContents,
            ChatMessageType.TRANSLATED_TEXT.name(),
            userId,
            isFC,
            chatRoomId
        );
    }

    public TranslationRequest toTranslationRequest() {
        return new TranslationRequest(
            contents,
            targetLang,
            sourceLang
        );
    }
}
