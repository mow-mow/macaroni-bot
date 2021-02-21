package info.caprese.macaronibot.logic;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import info.caprese.macaronibot.model.TimeZone;
import lombok.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PastaRenponse {
    private String result;
    private String date;
    @JsonProperty("time_zone")
    private TimeZone timeZone;
    @JsonProperty("pasta_name")
    private String pastaName;
    private String description;
    private String comment;
    private String image;
    private String errorMsg;


}
