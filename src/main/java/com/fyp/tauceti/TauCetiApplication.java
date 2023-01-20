package com.fyp.tauceti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
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
}


