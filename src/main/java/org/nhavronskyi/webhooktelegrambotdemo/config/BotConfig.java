package org.nhavronskyi.webhooktelegrambotdemo.config;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.nhavronskyi.webhooktelegrambotdemo.props.TelegramProps;
import org.nhavronskyi.webhooktelegrambotdemo.service.Bot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
@RequiredArgsConstructor
public class BotConfig {

    private final TelegramProps props;

    @Bean
    public SetWebhook setWebhook() {
        return SetWebhook.builder()
                .url(props.webhook())
                .build();
    }

    @SneakyThrows
    @Bean
    public Bot myTelegramBot(SetWebhook setWebhook) {
        Bot bot = new Bot(setWebhook, props);
        TelegramBotsApi tba = new TelegramBotsApi(DefaultBotSession.class);
        tba.registerBot(bot, setWebhook);
        return bot;
    }
}
