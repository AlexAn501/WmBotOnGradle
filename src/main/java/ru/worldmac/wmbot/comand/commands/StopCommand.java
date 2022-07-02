package ru.worldmac.wmbot.comand.commands;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.worldmac.wmbot.comand.Command;
import ru.worldmac.wmbot.service.SendMessageService;

/**
 * Stop {@link Command}.
 */

public class StopCommand implements Command {

    private final SendMessageService sendMessageService;

    private final static String STOP_MESSAGE = "Пока";

    public StopCommand(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        sendMessageService.sandMessage(chatId, STOP_MESSAGE);
    }
}
