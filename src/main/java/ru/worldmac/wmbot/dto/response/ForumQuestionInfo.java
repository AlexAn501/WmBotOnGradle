package ru.worldmac.wmbot.dto.response;

import lombok.Data;
import lombok.ToString;
import ru.worldmac.wmbot.dto.Language;
import ru.worldmac.wmbot.dto.LikesInfo;

@Data
@ToString
public class ForumQuestionInfo {

    private Integer commentsCount;
    private String content;
    private String createdTime;
    private String description;
    private Integer id;
    private String key;
    private Language language;
    private LikesInfo likesInfo;
    private Double rating;

}
