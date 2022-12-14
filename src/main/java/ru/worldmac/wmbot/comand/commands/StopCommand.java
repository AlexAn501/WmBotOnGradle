package ru.worldmac.wmbot.comand.commands;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.worldmac.wmbot.comand.Command;
import ru.worldmac.wmbot.service.SendMessageService;
import ru.worldmac.wmbot.service.TelegramUserService;

/**
 * Stop {@link Command}.
 */

public class StopCommand implements Command {

    private final SendMessageService sendMessageService;
    private final TelegramUserService telegramUserService;

    public final static String STOP_MESSAGE = "Пока";

    public StopCommand(SendMessageService sendMessageService, TelegramUserService telegramUserService) {
        this.sendMessageService = sendMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        sendMessageService.sendMessage(chatId, STOP_MESSAGE);

        telegramUserService.findByChatId(chatId).ifPresent(
                user -> {
                    user.setActive(false);
                    telegramUserService.save(user);
                }
        );
    }
}
