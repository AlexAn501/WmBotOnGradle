package ru.worldmac.wmbot.comand.commands;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.worldmac.wmbot.comand.Command;
import ru.worldmac.wmbot.dto.enums.GroupTypeEnum;
import ru.worldmac.wmbot.dto.enums.PostTypeEnum;
import ru.worldmac.wmbot.dto.request.GroupRequestFilter;
import ru.worldmac.wmbot.dto.request.GroupsCountRequestFilter;
import ru.worldmac.wmbot.dto.request.PostCountRequestFilter;
import ru.worldmac.wmbot.dto.request.PostsRequestFilter;
import ru.worldmac.wmbot.dto.response.GroupDiscussionInfo;
import ru.worldmac.wmbot.dto.response.PostInfo;
import ru.worldmac.wmbot.entity.TelegramUser;
import ru.worldmac.wmbot.feign.JavaRushClient;
import ru.worldmac.wmbot.service.SendMessageService;
import ru.worldmac.wmbot.service.TelegramUserService;

import java.util.List;

/**
 * Start {@link Command}.
 */
public class StartCommand implements Command {

    private final SendMessageService sendMessageService;
    private final TelegramUserService telegramUserService;
    private final JavaRushClient javaRushClient;

    public final static String START_MESSAGE = "Привет, я бот WorldMac. Я помогу тебе в поиске техники";

    public StartCommand(SendMessageService sendMessageService, TelegramUserService telegramUserService,
                        JavaRushClient javaRushClient) {
        this.sendMessageService = sendMessageService;
        this.telegramUserService = telegramUserService;
        this.javaRushClient = javaRushClient;
    }

    @Override
    public void execute(Update update) {
        String chatId = update.getMessage().getChatId().toString();

        telegramUserService.findByChatId(chatId).ifPresentOrElse(
                user -> {
                    user.setActive(true);
                    telegramUserService.save(user);
                },
                () -> {
                    TelegramUser telegramUser = new TelegramUser();
                    telegramUser.setActive(true);
                    telegramUser.setChatId(chatId);
                    telegramUserService.save(telegramUser);
                }
        );

        GroupRequestFilter args = GroupRequestFilter.builder()
                .type(GroupTypeEnum.TECH)
                .limit(2)
                .build();
        List<GroupDiscussionInfo> groupDiscussionByFilter = javaRushClient.getGroupDiscussionByFilter(args.populateQueries());

        GroupsCountRequestFilter countFilter = GroupsCountRequestFilter.builder()
                .type(GroupTypeEnum.TECH)
                .build();
        Integer groupCount = javaRushClient.getGroupCount(countFilter.populateQueries());

        GroupDiscussionInfo groupById = javaRushClient.getGroupById("26");

        PostsRequestFilter postFilter = PostsRequestFilter.builder()
                .offset(3)
                .limit(3)
                .build();
        List<PostInfo> postsByFilter = javaRushClient.getPostsByFilter(postFilter.populateQueries());

        PostInfo postById = javaRushClient.getPostById("2");

        PostCountRequestFilter postCountFilter = PostCountRequestFilter.builder()
                .type(PostTypeEnum.INNER_LINK)
                .build();
        Integer postCount = javaRushClient.getPostCount(postCountFilter.populateQueries());


        sendMessageService.sendMessage(chatId, START_MESSAGE);
    }
}
