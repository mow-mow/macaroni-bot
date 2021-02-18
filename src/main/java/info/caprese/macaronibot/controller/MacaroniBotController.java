package info.caprese.macaronibot.controller;

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
        log.info("パスタ情報取得【開始】");
        PastaRenponse pasta=service.call();


        log.info("パスタ取得情報" + pasta.toString());
        log.info("パスタ情報取得【終了】");

        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setTemplateMode(TemplateMode.TEXT);
        templateResolver.setCharacterEncoding("UTF-8");

        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        // ThymeleafのContextインスタンスを作成する
        Context context = new Context();
        // テンプレート内の変数に値を設定する
        context.setVariable("pasta", pasta);
        // テンプレートを処理する
        String text = templateEngine.process("tweet.txt", context);

        log.info("ツイート内容："+ text);

        try {
            Status status = twitter.updateStatus(text);
            log.info("Successfully updated the status to [" + status.getText() + "].");
        } catch (TwitterException e) {
            log.error("つぶやきに失敗しました", e);
            log.info("千代美つぶやき  [NG]");
        }

        log.info("千代美つぶやき  [OK]");
    }

    @Autowired
    private Twitter twitter;

    @Bean
    private Twitter twitter() {
        return new TwitterFactory().getInstance();
    }
}
