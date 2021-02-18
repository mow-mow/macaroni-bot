package info.caprese.macaronibot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MacaroniService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${app.macaroni-url}")
    String url;

    public PastaRenponse call() {
        return restTemplate.getForObject(url, PastaRenponse.class);
    }
}
