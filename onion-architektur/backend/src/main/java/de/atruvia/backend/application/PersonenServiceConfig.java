package de.atruvia.backend.application;


import de.atruvia.service.BlacklistService;
import de.atruvia.service.PersonenService;
import de.atruvia.service.internal.PersonenServiceImpl;
import de.atruvia.service.repository.PersonenRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonenServiceConfig {


    @Bean
    public PersonenService createPersonenService(final PersonenRepository repo, final BlacklistService blacklistService) {
        return new PersonenServiceImpl(repo,blacklistService);
    }
}
