package de.atruvia.backend.application;


import de.atruvia.service.BlacklistService;
import de.atruvia.service.internal.BlacklistServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BlacklistConfig {


    @Bean
    public BlacklistService createBlacklistService() {
        return new BlacklistServiceImpl();
    }
}
