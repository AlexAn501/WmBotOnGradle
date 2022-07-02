package ru.worldmac.wmbot.comand.commands;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.worldmac.wmbot.comand.Command;
import ru.worldmac.wmbot.service.SendMessageService;

/**
 * List {@link Command}.
 */

public class ListCommand implements Command {

    private final SendMessageService sendMessageService;

    private final static String LIST_MESSAGE = "Список всех продуктов.";

    public ListCommand(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        sendMessageService.sandMessage(chatId, LIST_MESSAGE);
    }
}
