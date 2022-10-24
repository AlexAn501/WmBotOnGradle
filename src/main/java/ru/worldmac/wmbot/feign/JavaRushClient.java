package ru.worldmac.wmbot.feign;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import ru.worldmac.wmbot.dto.request.GroupRequestFilter;
import ru.worldmac.wmbot.dto.request.GroupsCountRequestFilter;
import ru.worldmac.wmbot.dto.request.PostCountRequestFilter;
import ru.worldmac.wmbot.dto.request.PostsRequestFilter;
import ru.worldmac.wmbot.dto.response.GroupDiscussionInfo;
import ru.worldmac.wmbot.dto.response.PostInfo;

import java.util.List;
import java.util.Map;

/**
 * Client for Javarush Open API corresponds to Groups.
 */
public interface JavaRushClient {

    /**
     * Get all the {@link GroupDiscussionInfo} filtered by provided {@link GroupRequestFilter}.
     *
     * @param args provided {@link GroupRequestFilter}
     * @return the collection of the {@link GroupDiscussionInfo} objects.
     * <p>
     * <p>
     * OK (status code 200) <p>
     * Unauthorized (status code 401) <p>
     * Forbidden (status code 403) <p>
     * Not Found (status code 404) <p>
     */

    @RequestLine("GET /groups")
    @Headers("Content-Type: application/json")
    List<GroupDiscussionInfo> getGroupDiscussionByFilter(@QueryMap Map<String, Object> args);

    /**
     * Get count of groups filtered by provided {@link GroupsCountRequestFilter}.
     *
     * @param countRequestArgs provided {@link GroupsCountRequestFilter}.
     * @return the count of the groups.
     * <p>
     * <p>
     * OK (status code 200) <p>
     * or Unauthorized (status code 401) <p>
     * or Forbidden (status code 403) <p>
     * or Not Found (status code 404) <p>
     */

    @RequestLine("GET /groups/count")
    @Headers("Content-Type: application/json")
    Integer getGroupCount(@QueryMap Map<String, Object> countRequestArgs);

    /**
     * Get {@link GroupDiscussionInfo} by provided ID.
     *
     * @param id provided ID.
     * @return {@link GroupDiscussionInfo} object.
     * <p>
     * <p>
     * OK (status code 200)<p>
     * or Unauthorized (status code 401)<p>
     * or Forbidden (status code 403)<p>
     * or Not Found (status code 404)<p>
     */

    @RequestLine("GET /groups/group{id}")
    @Headers("Content-Type: application/json")
    GroupDiscussionInfo getGroupById(@Param String id);

    /**
     * Get all the {@link PostInfo} filtered by provided {@link PostsRequestFilter}.
     *
     * @param args provided {@link PostsRequestFilter}
     * @return the collection of the {@link PostInfo} objects.
     * <p>
     * <p>
     * OK (status code 200)<p>
     * Unauthorized (status code 401)<p>
     * Forbidden (status code 403)<p>
     * Not Found (status code 404)<p>
     */

    @RequestLine("GET /posts")
    @Headers("Content-Type: application/json")
    List<PostInfo> getPostsByFilter(@QueryMap Map<String, Object> args);

    /**
     * Get count of post filtered by provided {@link PostCountRequestFilter}.
     *
     * @param args provided {@link PostCountRequestFilter}.
     * @return the count of the post.
     * <p>
     * <p>
     * OK (status code 200) <p>
     * or Unauthorized (status code 401) <p>
     * or Forbidden (status code 403) <p>
     * or Not Found (status code 404) <p>
     */

    @RequestLine("GET /posts/count")
    @Headers("Content-Type: application/json")
    Integer getPostCount(@QueryMap Map<String, Object> args);

    /**
     * Get {@link PostInfo} by provided ID.
     *
     * @param id provided ID.
     * @return {@link PostInfo} object.
     * <p>
     * <p>
     * OK (status code 200)<p>
     * or Unauthorized (status code 401)<p>
     * or Forbidden (status code 403)<p>
     * or Not Found (status code 404)<p>
     */

    @RequestLine("GET /posts/post{id}")
    @Headers("Content-Type: application/json")
    PostInfo getPostById(@Param String id);
}
