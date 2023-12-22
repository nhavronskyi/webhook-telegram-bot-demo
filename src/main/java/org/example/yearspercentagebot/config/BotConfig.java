package org.example.yearspercentagebot.config;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.example.yearspercentagebot.component.Bot;
import org.example.yearspercentagebot.props.TelegramProps;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
@RequiredArgsConstructor
public class BotConfig {

    private final TelegramProps props;

    @SneakyThrows
    @Bean
    public Bot myTelegramBot() {
        System.out.println(props.token());

        Bot bot = new Bot(props.token(), props);
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(bot, new SetWebhook(props.webhook()));
        return bot;
    }
}
