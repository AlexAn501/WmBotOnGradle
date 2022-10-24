package ru.worldmac.wmbot.comand.commands;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.worldmac.wmbot.comand.Command;
import ru.worldmac.wmbot.dto.enums.GroupTypeEnum;
import ru.worldmac.wmbot.dto.request.GroupRequestFilter;
import ru.worldmac.wmbot.dto.request.GroupsCountRequestFilter;
import ru.worldmac.wmbot.dto.response.GroupDiscussionInfo;
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
                .build();
        List<GroupDiscussionInfo> groupDiscussionByFilter = javaRushClient.getGroupDiscussionByFilter(args.populateQueries());

        GroupsCountRequestFilter countFilter = GroupsCountRequestFilter.builder()
                .type(GroupTypeEnum.TECH)
                .build();
        Integer groupCount = javaRushClient.getGroupCount(countFilter.populateQueries());

        GroupDiscussionInfo groupById = javaRushClient.getGroupById("26");

        sendMessageService.sendMessage(chatId, START_MESSAGE);
    }
}
