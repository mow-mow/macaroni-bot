package info.caprese.macaronibot.service;

import info.caprese.macaronibot.logic.ChiyomiLogic;
import info.caprese.macaronibot.logic.MacaroniLogic;
import info.caprese.macaronibot.logic.PastaRenponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Service
@Slf4j
public class MacaroniService {

    @Autowired
    MacaroniLogic macaroniLogic;
    @Autowired
    ChiyomiLogic chiyomiLogic;

    public void call() {

        PastaRenponse pasta=macaroniLogic.call();

        String text = generateTweetMessage(pasta);

        chiyomiLogic.tweet(text);
    }

    private String generateTweetMessage(PastaRenponse pasta) {
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
        return templateEngine.process("tweet.txt", context);
    }
}
