package info.caprese.macaronibot.logic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

@Service
@Slf4j
public class ChiyomiLogic {

    @Autowired
    private Twitter twitter;

    public void tweet(String text) {
        log.info("【ツイート開始】");
        log.info("ツイート内容："+ text);

        try {
            Status status = twitter.updateStatus(text);
            log.info("Successfully updated the status to [" + status.getText() + "].");
            log.info("つぶやきに成功しました");
        } catch (TwitterException e) {
            log.error("つぶやきに失敗しました", e);
        }
        log.info("【ツイート終了】");
    }
}
