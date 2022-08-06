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

    public final static String HELP_MESSAGE = String.format("<b>✨ Доступные команды ✨</b>\n\n"
            + "<b>Начать\\закончить работу с ботом</b>\n"
            + "%s - начать работу со мной \n"
            + "%s - приостановить работу со мной\n"
            + "%s - получить список всех продуктов\n"
            + "%s - получить помощь в работе со мной\n",
        CommandName.START, CommandName.STOP, CommandName.LIST, CommandName.HELP);

    public HelpCommand(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        sendMessageService.sendMessage(chatId, HELP_MESSAGE);
    }
}
