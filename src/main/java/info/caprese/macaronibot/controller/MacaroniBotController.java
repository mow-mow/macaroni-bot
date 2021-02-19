package info.caprese.macaronibot.controller;

import info.caprese.macaronibot.service.MacaroniService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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
