package ru.worldmac.wmbot.feign;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import ru.worldmac.wmbot.dto.request.GroupRequestArgs;
import ru.worldmac.wmbot.dto.request.GroupsCountRequestArgs;
import ru.worldmac.wmbot.dto.response.GroupDiscussionInfo;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Client for Javarush Open API corresponds to Groups.
 */
public interface JavaRushClient {

// :{"/api/1.0/rest/forum":{"get":{"tags":["forum-question-controller"],
// "summary":"Get forum questions by filters","operationId":"getForumQuestionsUsingGET",
// "consumes":["application/json;charset=UTF-8","*/*"],
// "produces":["application/json","application/json;charset=UTF-8"],
// "parameters":[{"name":"filter","in":"query","description":"filter","required":false,"type":"string",
//          "enum":["UNKNOWN","ALL","MY","FRIENDS"]},
//          {"name":"query","in":"query","description":"query","required":false,"type":"string"},
//          {"name":"status","in":"query","description":"status","required":false,"type":"string",
//                      "enum":["UNKNOWN","NEW","ACTIVE","SOLVED","ARCHIVE","DUPLICATE"]},
//          {"name":"order","in":"query","description":"order","required":false,"type":"string",
//                      "enum":["UNKNOWN","NEW","OLD","POPULAR","RELEVANCE"]},
//          {"name":"offset","in":"query","description":"offset","required":false,"type":"integer","format":"int32"},
//          {"name":"limit","in":"query","description":"limit","required":false,"type":"integer","format":"int32"}],
//          "responses":{"200":{"description":"OK","schema":{"type":"array","items":{"$ref":"#/definitions/ForumQuestionInfo"}}},
//          "401":{"description":"Unauthorized"},
//          "403":{"description":"Forbidden"},
//          "404":{"description":"Not Found"}}}},


    /**
     * Get all the {@link GroupDiscussionInfo} filtered by provided {@link GroupRequestArgs}.
     *
     * @param args  provided {@link GroupRequestArgs}
     * @return the collection of the {@link GroupDiscussionInfo} objects.
     *
     *  OK (status code 200)
     *  Unauthorized (status code 401)
     *  Forbidden (status code 403)
     *  Not Found (status code 404)
     */

    @RequestLine("GET /groups")
    @Headers("Content-Type: application/json")
    List<GroupDiscussionInfo> getGroupDiscussionByFilter(@QueryMap Map<String, Object> args);

    /**
     * Get count of groups filtered by provided {@link GroupRequestArgs}.
     *
     * @param countRequestArgs provided {@link GroupsCountRequestArgs}.
     * @return the count of the groups.
     *
     *  OK (status code 200)
     *  or Unauthorized (status code 401)
     *  or Forbidden (status code 403)
     *  or Not Found (status code 404)
     */
    @RequestLine("GET /groups/count")
    @Headers("Content-Type: application/json")
    Integer getGroupCount(@QueryMap Map<String,Object> countRequestArgs);

    /**
     * Get {@link GroupDiscussionInfo} by provided ID.
     * @param id provided ID.
     * @return {@link GroupDiscussionInfo} object.
     *
     *
     * OK (status code 200)
     * or Unauthorized (status code 401)
     * or Forbidden (status code 403)
     * or Not Found (status code 404)
     */
        @RequestLine("GET /groups/group{id}")
        @Headers("Content-Type: application/json")
    GroupDiscussionInfo getGroupById(@Param String id);
}
