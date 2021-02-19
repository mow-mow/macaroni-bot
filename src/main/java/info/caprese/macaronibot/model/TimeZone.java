package info.caprese.macaronibot.model;

import lombok.Getter;

@Getter
public enum TimeZone {
    MORNING("朝食"),
    DAYTIME("昼飯"),
    NIGHT("夕飯"),
    ;
    private String viewName;
    TimeZone(String viewName) {
        this.viewName = viewName;
    }
}
