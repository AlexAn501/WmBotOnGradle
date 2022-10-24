package ru.worldmac.wmbot.dto.request;

import ru.worldmac.wmbot.dto.enums.GroupTypeEnum;
import ru.worldmac.wmbot.dto.enums.PostTypeEnum;

public class PostCountRequestFilter {
    private String query;
    private PostTypeEnum type;
    private String groupKid;
    private GroupTypeEnum groupType;
    private Integer ownerId;
    private String filter;
}
