package ru.worldmac.wmbot.dto.response;

import lombok.Data;
import ru.worldmac.wmbot.dto.AuthorInfo;
import ru.worldmac.wmbot.dto.LikesInfo;
import ru.worldmac.wmbot.dto.UserDiscussionInfo;
import ru.worldmac.wmbot.dto.enums.GroupTypeEnum;
import ru.worldmac.wmbot.dto.enums.LanguageEnum;
import ru.worldmac.wmbot.dto.enums.VisibilityStatusEnum;

/**
 * Post info DTO class.
 */
@Data
public class PostInfo {
    private AuthorInfo authorInfo;
    private Integer commentsCount;
    private String content;
    private Integer createdTime;
    private String description;
    private GroupInfo groupInfo;
    private Integer id;
    private String key;
    private LanguageEnum language;
    private LikesInfo likesInfo;
    private GroupInfo originalGroupInfo;
    private String pictureUrl;
    private Double rating;
    private Integer ratingCount;
    private String title;
    private GroupTypeEnum type;
    private Integer updatedTime;
    private UserDiscussionInfo userDiscussionInfo;
    private Integer views;
    private VisibilityStatusEnum visibilityStatus;
}
