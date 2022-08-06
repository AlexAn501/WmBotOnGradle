package ru.worldmac.wmbot.comand.commands;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.worldmac.wmbot.comand.Command;
import ru.worldmac.wmbot.service.SendMessageService;

/**
 * No {@link Command}.
 */

public class NoCommand implements Command {

    private final SendMessageService sendMessageService;

    public final static String NO_MESSAGE = "Я поддерживаю команды начинающиеся со слеша (/).\n"
        + "Чтобы посмотреть все команды введите /help";

    public NoCommand(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        sendMessageService.sendMessage(chatId, NO_MESSAGE);
    }
}
