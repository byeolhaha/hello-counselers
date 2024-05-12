package com.hellomeritz.chat.controller.dto.request;

import com.hellomeritz.chat.domain.ChatRoomPassword;
import com.hellomeritz.chat.service.dto.param.ChatRoomCreateParam;
import com.hellomeritz.chat.service.dto.param.ChatRoomPasswordCreateParam;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;

public record ChatRoomPasswordCreateRequest(
        @NotBlank(message = "chatRoomPassword은 빈값일 수 없습니다.")
        String chatRoomPassword
) {

    public ChatRoomPasswordCreateParam toChatRoomPasswordCreateParam(Long chatRoomId) {
        return new ChatRoomPasswordCreateParam(
                ChatRoomPassword.of(chatRoomPassword),
                chatRoomId,
                LocalDateTime.now()
        );
    }
}
