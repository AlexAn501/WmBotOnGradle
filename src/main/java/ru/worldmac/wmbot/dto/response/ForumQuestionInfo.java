package ru.worldmac.wmbot.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import ru.worldmac.wmbot.dto.enums.LanguageEnum;
import ru.worldmac.wmbot.dto.LikesInfo;

/**
 * Forum Question Info DTO class.
 */
@Data
@ToString
public class ForumQuestionInfo {

    private Integer commentsCount;
    private String content;
    private String createdTime;
    private String description;
    private Integer id;
    private String key;
    @JsonProperty("Language")
    private LanguageEnum languageEnum;
    private LikesInfo likesInfo;
    private Double rating;

}
