package org.example.yearspercentagebot.component;

import lombok.SneakyThrows;
import org.example.yearspercentagebot.props.TelegramProps;
import org.jvnet.hk2.annotations.Service;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class Bot extends TelegramWebhookBot {

    private final TelegramProps props;


    public Bot(String s, TelegramProps props) {
        super(s);
        this.props = props;
    }

    @Override
    public String getBotUsername() {
        return props.username();
    }

    @SneakyThrows
    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        System.out.println("hello");
        if (update.hasMessage() && update.getMessage().hasText()) {
            var chatId = update.getMessage().getChatId().toString();
            String text = update.getMessage().getText();

            SendMessage message = new SendMessage(chatId, "You said: " + text);

            execute(message);
        }
        return null;
    }

    @Override
    public String getBotPath() {
        return props.webhook();
    }
}
