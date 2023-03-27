package com.fyp.tauceti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class TauCetiApplication {
    public static void main(String[] args) {
        SpringApplication.run(TauCetiApplication.class, args);
    }

//    private void insertFourSiteUsers(SiteUserRepository repository) {
//        repository.save(new SiteUser("Jim", "Holden", "jim@mail.com", "K12345678", LocalDateTime.now()));
//        repository.save(new SiteUser("Naomi", "Nagata", "naomi@email.org", "K87654321", LocalDateTime.now()));
//        repository.save(new SiteUser("Amos", "Burton", "aburton@webmail.mars", "K1122334455", LocalDateTime.now()));
//        repository.save(new SiteUser("Julie", "Mao", "julie.mao@mao.com", "K44332211", LocalDateTime.now()));
//    }

//    @Bean
//    public CommandLineRunner run(SiteUserRepository repository) {
//        return (args) -> {
//            insertFourSiteUsers(repository);
//            System.out.println(repository.findAll());
//        };
//    }

//    @Bean
//    public CommandLineRunner run(SiteUserRepository repository) {
//        return (args) -> {
//            insertFourSiteUsers(repository);
//            System.out.println(repository.findSiteUsersByLastNameContaining(" "));
//        };
//    }

//    @Bean
//    public CommandLineRunner run(SiteUserRepository siteUserRepository, GameRepository gameRepository) {
//        return (args) -> {
//            SiteUser siteUser = new SiteUser("Het", "Masteen", "tree@here", "k1", LocalDateTime.now());
//
//            siteUserRepository.save(siteUser);
//            siteUserRepository.save(new SiteUser("Jim", "Holden", "jim@mail.com", "K12345678", LocalDateTime.now()));
//            siteUserRepository.save(new SiteUser("Naomi", "Nagata", "naomi@email.org", "K87654321", LocalDateTime.now()));
//            siteUserRepository.save(new SiteUser("Amos", "Burton", "aburton@webmail.mars", "K1122334455", LocalDateTime.now()));
//            siteUserRepository.save(new SiteUser("Julie", "Mao", "julie.mao@mao.com", "K44332211", LocalDateTime.now()));
//            siteUserRepository.save(new SiteUser("Merri", "Mogridge", "merri@email.com", "K252252", LocalDateTime.now()));
//
//            gameRepository.save(new Game("Ouster Swarm", "Space Shooter", LocalDateTime.now(), siteUser));
//            gameRepository.save(new Game("Baltimore", "Crime", LocalDateTime.now(), siteUserRepository.getReferenceById(Long.valueOf(4))));
//
//        };
//    }
}


