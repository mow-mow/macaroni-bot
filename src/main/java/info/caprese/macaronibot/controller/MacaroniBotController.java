package info.caprese.macaronibot.controller;

import info.caprese.macaronibot.service.MacaroniService;
import info.caprese.macaronibot.service.PastaRenponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;

import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

@Component
@Slf4j
class MacaroniBotController {

    @Autowired
    MacaroniService service;

    @Scheduled(cron = "${scheduler.cron}")
    public void tweet() {
        log.info("千代美つぶやき 【開始】");
        service.call();
        log.info("千代美つぶやき  [終了]");
    }
}
