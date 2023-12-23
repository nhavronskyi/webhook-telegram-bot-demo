package org.nhavronskyi.webhooktelegrambotdemo;

import org.nhavronskyi.webhooktelegrambotdemo.props.TelegramProps;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(TelegramProps.class)
public class WebhookTelegramBotDemo {

    public static void main(String[] args) {
        SpringApplication.run(WebhookTelegramBotDemo.class, args);
    }

}
