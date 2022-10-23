package ru.worldmac.wmbot.dto;

import lombok.Data;
import lombok.ToString;
import ru.worldmac.wmbot.dto.enums.GroupTypeEnum;
import ru.worldmac.wmbot.dto.enums.VisibilityStatusEnum;

/**
 * Group Info DTO class.
 */
@Data
@ToString
public class GroupInfo {

    private String avatarUrl;
    private String createTime;
    private String description;
    private Integer id;
    private String key;
    private Integer levelToEditor;
    private MeGroupInfo meGroupInfo;
    private String pictureUrl;
    private String title;
    private GroupTypeEnum type;
    private Integer usersCount;
    private VisibilityStatusEnum status;

}
