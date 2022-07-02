package ru.worldmac.wmbot.comand.commands;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.worldmac.wmbot.comand.Command;
import ru.worldmac.wmbot.comand.enums.CommandName;
import ru.worldmac.wmbot.service.SendMessageService;

/**
 * Help {@link Command}.
 */

public class HelpCommand implements Command {

    private final SendMessageService sendMessageService;

    private final static String HELP_MESSAGE = String.format(" Доступные команды \n\n"
            + "     Начать работу с ботом "
            + "%s - начать работу со мной \n"
            + "%s - приостановить работу со мной\n"
            + "%s - получить список всех продуктов\n"
            + "%s - получить помощь в работе со мной\n",
        CommandName.START, CommandName.START, CommandName.LIST, CommandName.HELP);

    public HelpCommand(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        sendMessageService.sandMessage(chatId, HELP_MESSAGE);
    }
}
