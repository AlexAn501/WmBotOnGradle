package ru.worldmac.wmbot.feign;

import feign.Headers;
import feign.RequestLine;
import ru.worldmac.wmbot.dto.GroupInfo;
import ru.worldmac.wmbot.dto.request.GroupRequestArgs;
import ru.worldmac.wmbot.dto.response.GroupDiscussionInfo;

import java.util.List;

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


//    =================================

//    "/api/1.0/rest/groups":
//    {"get":{"tags":["group-controller"],
//      "summary":"Get groups by filters","operationId":"getGroupsListUsingGET",
//      "consumes":["application/json;charset=UTF-8","*/*"],
//      "produces":["application/json","application/json;charset=UTF-8"],
//      "parameters":[
//          {"name":"query","in":"query","description":"query","required":false,"type":"string"},
//          {"name":"type","in":"query","description":"type","required":false,"type":"string","enum":["UNKNOWN","CITY","COMPANY","COLLEGE","TECH","SPECIAL","COUNTRY"]},
//          {"name":"userId","in":"query","description":"userId","required":false,"type":"integer","format":"int32"},
//          {"name":"order","in":"query","description":"order","required":false,"type":"string","enum":["UNKNOWN","NAME","MEMBERS","GROUP_ID"]},
//          {"name":"filter","in":"query","description":"filter","required":false,"type":"string","enum":["UNKNOWN","ALL","MY"]},
//          {"name":"includeDiscussion","in":"query","description":"includeDiscussion","required":false,"type":"boolean","default":false},
//          {"name":"offset","in":"query","description":"offset","required":false,"type":"integer","format":"int32"},
//          {"name":"limit","in":"query","description":"limit","required":false,"type":"integer","format":"int32"}],
//      "responses":{"200":{"description":"OK","schema":{"type":"array","items":{"$ref":"#/definitions/GroupDiscussionInfo"}}},
//                  "401":{"description":"Unauthorized"},
//                  "403":{"description":"Forbidden"},
//                  "404":{"description":"Not Found"}}}},

    /**
     * Get all the {@link GroupDiscussionInfo} filtered by provided {@link GroupRequestArgs}.
     *
     * @return the collection of the {@link GroupDiscussionInfo} objects.
     */

    @RequestLine("GET /groups/api/1.0/rest/groups")
    @Headers("Content-Type: application/json")
    List<GroupDiscussionInfo> getGroupDiscussionByFilter();


//    /**
//     * Get all the {@link GroupInfo} filtered by provided {@link GroupRequestArgs}.
//     *
//     * @param requestArgs provided {@link GroupRequestArgs}.
//     * @return the collection of the {@link GroupInfo} objects.
//     */
//    List<GroupInfo> getGroupList(GroupRequestArgs requestArgs);
//
//
//    /**
//     * Get count of groups filtered by provided {@link GroupRequestArgs}.
//     *
//     * @param countRequestArgs provided {@link GroupsCountRequestArgs}.
//     * @return the count of the groups.
//     */
//    Integer getGroupCount(GroupsCountRequestArgs countRequestArgs);
//
//    /**
//     * Get {@link GroupDiscussionInfo} by provided ID.
//     *
//     * @param id provided ID.
//     * @return {@link GroupDiscussionInfo} object.
//     */
//    GroupDiscussionInfo getGroupById(Integer id);


}
