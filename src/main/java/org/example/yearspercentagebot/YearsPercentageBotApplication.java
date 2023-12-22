package org.example.yearspercentagebot;

import org.example.yearspercentagebot.props.TelegramProps;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(TelegramProps.class)
public class YearsPercentageBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(YearsPercentageBotApplication.class, args);
    }

}
