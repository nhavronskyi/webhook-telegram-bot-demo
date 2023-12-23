package org.nhavronskyi.webhooktelegrambotdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.nhavronskyi.webhooktelegrambotdemo.service.Bot;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final Bot bot;

    @PostMapping("callback/update")
    @SneakyThrows
    public BotApiMethod<?> onWebhookUpdateReceived(@RequestBody Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            var chatId = update.getMessage().getChatId().toString();
            var message = SendMessage.builder()
                    .parseMode(ParseMode.HTML)
                    .chatId(chatId)
                    .text("You said: " + update.getMessage().getText())
                    .build();
            bot.execute(message);
        }
        return new SendMessage();
    }

    // method to check if ngrok is alive
    @GetMapping()
    public String test(HttpServletRequest request) {
        return "hello + " + request.getHeader("X-FORWARDED-FOR");
    }
}
