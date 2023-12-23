package org.nhavronskyi.webhooktelegrambotdemo.service;

import lombok.SneakyThrows;
import org.nhavronskyi.webhooktelegrambotdemo.props.TelegramProps;
import org.jvnet.hk2.annotations.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.starter.SpringWebhookBot;

@Service
public class Bot extends SpringWebhookBot {

    private final TelegramProps props;


    public Bot(SetWebhook setWebhook, TelegramProps props) {
        super(setWebhook, props.token());
        this.props = props;
    }


    @SneakyThrows
    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        return new SendMessage();
    }


    // default path is "callout" but we need the "callout/update" to run our main logic
    @Override
    public String getBotPath() {
        return "update";
    }

    @Override
    public String getBotUsername() {
        return props.username();
    }
}
