package ru.worldmac.wmbot.comand.commands;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.worldmac.wmbot.comand.Command;
import ru.worldmac.wmbot.service.SendMessageService;
import ru.worldmac.wmbot.service.TelegramUserService;

/**
 * Statistics {@link Command}.
 */
public class StatCommand implements Command {

    private final SendMessageService sendMessageService;
    private final TelegramUserService telegramUserService;

    public final static String STAT_MESSAGE = "WMBot использует %s человек.";

    public StatCommand(SendMessageService sendMessageService, TelegramUserService telegramUserService) {
        this.sendMessageService = sendMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        int sizeActiveUser = telegramUserService.retrieveAllActiveUsers().size();

        sendMessageService.sendMessage(chatId,
                String.format(STAT_MESSAGE, sizeActiveUser));
    }
}
