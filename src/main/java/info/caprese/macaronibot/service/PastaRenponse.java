package info.caprese.macaronibot.service;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PastaRenponse {
    private String result;
    private String date;
    @JsonProperty("pasta_name")
    private String pastaName;
    private String description;
    private String comment;
    private String errorMsg;
}
