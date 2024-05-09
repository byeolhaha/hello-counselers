package com.hellomeritz.global;

import com.hellomeritz.chat.controller.dto.request.*;
import com.hellomeritz.chat.controller.dto.response.ChatRoomUserInfoResponse;
import com.hellomeritz.chat.domain.ChatMessage;
import com.hellomeritz.chat.domain.ChatMessageType;
import com.hellomeritz.chat.domain.ChatRoom;
import com.hellomeritz.chat.domain.ChatRoomPassword;
import com.hellomeritz.chat.global.SourceLanguage;
import com.hellomeritz.chat.global.TargetLanguage;
import com.hellomeritz.chat.global.stt.SttProvider;
import com.hellomeritz.chat.repository.chatmessage.dto.ChatMessageGetRepositoryRequest;
import com.hellomeritz.chat.service.dto.param.*;
import com.hellomeritz.chat.service.dto.result.*;

import java.time.LocalDateTime;
import java.util.List;

public class ChatFixture {

    private static final long USER_ID = 1;
    private static final long FC_ID = 2;
    private static final String CHAT_MESSAGE_ID_MIN_VALUE = "";

    private ChatFixture() {
        throw new AssertionError("생성자를 통해서 인스턴스를 생성할 수 없습니다.");
    }

    public static ChatMessageTextParam chatMessageTextParamByFC() {
        return new ChatMessageTextParam(
            "안녕하세요 반가워요",
            FC_ID,
            true,
            1,
            TargetLanguage.findTargetLanguage("US"),
            SourceLanguage.findSourceLanguage("KOREAN")
        );
    }

    public static ChatMessage firstReadNotChatMessageByFC(Long chatRoomId) {
        return ChatMessage.of(
            "안녕하세요 반가워요",
            ChatMessageType.TEXT.name(),
            FC_ID,
            true,
            chatRoomId,
            false
        );
    }

    public static ChatMessage secondReadNotChatMessageByFC(Long chatRoomId) {
        return ChatMessage.of(
            "어떤 일로 문의주셨나요?",
            ChatMessageType.TEXT.name(),
            FC_ID,
            true,
            chatRoomId,
            false
        );
    }

    public static ChatMessage translatedChatMessageByFC() {
        return ChatMessage.of(
            "hello nice meet you",
            ChatMessageType.TRANSLATED_TEXT.name(),
            FC_ID,
            true,
            1L,
            true
        );
    }

    public static ChatMessage originChatMessageByUser() {
        return ChatMessage.of(
            "Hello my name is byeol",
            ChatMessageType.TEXT.name(),
            FC_ID,
            true,
            1L,
            true
        );
    }

    public static ChatMessage translatedChatMessageByUser() {
        return ChatMessage.of(
            "안녕하세요 저의 이름은 별입니다.",
            ChatMessageType.TRANSLATED_TEXT.name(),
            FC_ID,
            true,
            1L,
            true
        );
    }

    public static ChatMessageTextParam chatMessageTextParamByUser() {
        return new ChatMessageTextParam(
            "Hello my name is byeol",
            USER_ID,
            false,
            1,
            TargetLanguage.findTargetLanguage("US"),
            SourceLanguage.findSourceLanguage("KOREAN")
        );
    }

    public static ChatRoomCreateParam chatRoomCreateParam() {
        return new ChatRoomCreateParam(
            1L,
            1L
        );
    }

    public static ChatMessageGetParam chatMessageGetParam() {
        return new ChatMessageGetParam(
            FC_ID,
            CHAT_MESSAGE_ID_MIN_VALUE,
            1,
            true
        );
    }

    public static ChatMessageGetResults chatMessageGetResults() {
        return new ChatMessageGetResults(
            List.of(
                new ChatMessageGetResults.ChatMessageGetResult(
                    "66172f7ab156dc2cf99c4b2c",
                    "안녕하세요 반갑습니다.",
                    LocalDateTime.of(2024, 3, 1, 11, 20).toString(),
                    true,
                    true
                ),
                new ChatMessageGetResults.ChatMessageGetResult(
                    "66172f7ab156dc2cf99c4b2d",
                    "hello nice meet you",
                    LocalDateTime.of(2024, 3, 1, 11, 21).toString(),
                    true,
                    true
                ),
                new ChatMessageGetResults.ChatMessageGetResult(
                    "66172f7ab156dc2cf99c4b2e",
                    "hello my name is byeol",
                    LocalDateTime.of(2024, 3, 1, 11, 22).toString(),
                    false,
                    true
                ),
                new ChatMessageGetResults.ChatMessageGetResult(
                    "66172f7ab156dc2cf99c4b2f",
                    "안녕하세요 제 이름은 별입니다.",
                    LocalDateTime.of(2024, 3, 1, 11, 23).toString(),
                    true,
                    true
                )
            ),
            "66172f7ab156dc2cf99c4b2c",
            true
        );
    }

    public static ChatMessageSttRequest chatAudioUploadRequest() {
        return new ChatMessageSttRequest(1L, true, "US");
    }

    public static ChatRoomCreateResult chatRoomCreateResult() {
        return new ChatRoomCreateResult(1L);
    }

    public static ChatRoomCreateRequest chatRoomCreateRequest() {
        return new ChatRoomCreateRequest(1L, 2L);
    }


    public static ChatMessageSttResult chatMessageSttResult() {
        return new ChatMessageSttResult(
            "Hello my name is byeol",
            LocalDateTime.now().toString(),
            SttProvider.WHISPER.name()
        );
    }


    public static ChatMessageTranslateResults chatMessageTranslateResult() {
        return new ChatMessageTranslateResults(
            List.of(
                new ChatMessageTranslateResults.ChatMessageTranslateResult
                    ("66172f7ab156dc2cf99c4b2c",
                        "hello my name is kim byeol",
                        false,
                        LocalDateTime.now()
                    ),
                new ChatMessageTranslateResults.ChatMessageTranslateResult(
                    "66172f7ab156dc2cf99c4b2d",
                    "안녕하세요 내 이름은 김별입니다",
                    false,
                    LocalDateTime.now()
                )
            )
        );
    }

    public static ChatMessageTranslateRequest chatMessageTranslateRequest() {
        return new ChatMessageTranslateRequest(
            "hello my name is kim byeol",
            1L,
            true,
            "KOREAN",
            "US"
        );
    }

    public static ChatRoom chatRoom() {
        return ChatRoom.of(
            1L,
            1L
        );
    }

    public static ChatRoomUserInfoResponse chatRoomUserInfoResponse() {
        return new ChatRoomUserInfoResponse(
            1L,
            1L
        );
    }

    public static ChatRoomUserInfoResult chatRoomUserInfoResult() {
        return new ChatRoomUserInfoResult(
            1L,
            1L
        );
    }

    public static ChatRoomPasswordCreateParam chatRoomPasswordCreateRequest(
        long chatRoomId
    ) {
        return new ChatRoomPasswordCreateParam(
            ChatRoomPassword.of("30303TWSA!!!"),
            chatRoomId,
            LocalDateTime.now()
        );
    }

    public static ChatRoomPasswordCheckParam chatRoomPasswordCheckRequest(
        long chatRoomId
    ) {
        return new ChatRoomPasswordCheckParam(
            chatRoomId,
            "30303TWSA!!!"
        );
    }

    public static ChatRoomPasswordCreateRequest chatRoomPasswordCreateRequest(
    ) {
        return new ChatRoomPasswordCreateRequest(
            "30303TWSA!!!",
            1L
        );
    }

    public static ChatRoomPasswordCheckRequest chatRoomPasswordCheckRequest(
    ) {
        return new ChatRoomPasswordCheckRequest(
            "30303TWSA!!!"
        );
    }

    public static ChatRoomEnterParam chatRoomEnterParamByForeigner(Long chatRoomId) {
        return new ChatRoomEnterParam(chatRoomId, false);
    }

    public static ChatMessageGetRepositoryRequest chatMessageGetRepositoryRequest(Long chatRoomId) {
        return new ChatMessageGetRepositoryRequest(
            CHAT_MESSAGE_ID_MIN_VALUE,
            chatRoomId,
            10
        );
    }

    public static ChatRoomEnterRequest chatRoomEnterRequest() {
        return new ChatRoomEnterRequest(true);
    }

    public static ChatRoomInfoParam chatRoomGetParamByForeigner() {
        return new ChatRoomInfoParam(1L, false);
    }

    public static ChatRoomInfoResults chatRoomInfoResults() {
        return new ChatRoomInfoResults(
            List.of(
                new ChatRoomInfoResult(
                    1L,
                    "안녕하세요",
                    LocalDateTime.now(),
                    3
                ),
                new ChatRoomInfoResult(
                    2L,
                    "자동차 보험 들고 싶어요",
                    LocalDateTime.now(),
                    4
                )
            ));
    }
}
