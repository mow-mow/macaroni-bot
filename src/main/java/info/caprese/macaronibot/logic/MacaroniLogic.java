package info.caprese.macaronibot.logic;

import info.caprese.macaronibot.service.PastaRenponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class MacaroniLogic {

    @Autowired
    RestTemplate restTemplate;

    @Value("${app.macaroni-url}")
    String url;

    public PastaRenponse call() {
        log.info("パスタ情報取得【開始】");
        PastaRenponse result = restTemplate.getForObject(url, PastaRenponse.class);
        log.info("パスタ取得情報" + result.toString());
        log.info("パスタ情報取得【終了】");
        return result;
    }
}
