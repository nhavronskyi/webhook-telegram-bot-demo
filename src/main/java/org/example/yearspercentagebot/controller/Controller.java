package org.example.yearspercentagebot.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.example.yearspercentagebot.component.Bot;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final Bot bot;

    @PostMapping("update")
    @SneakyThrows
    public BotApiMethod<?> onWebhookUpdateReceived(@RequestBody Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            var chatId = update.getMessage().getChatId().toString();
            bot.execute(new SendMessage(chatId, "You said: " + update.getMessage().getText()));
        }
        return new SendMessage();
    }
}
