package com.hellomeritz.chat.global.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TranslationText(
    String detected_source_language,
    String text
) {
}
