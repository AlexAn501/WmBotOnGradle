package ru.worldmac.wmbot.command.commands;

import ru.worldmac.wmbot.comand.Command;
import ru.worldmac.wmbot.comand.commands.StatCommand;
import ru.worldmac.wmbot.comand.enums.CommandName;

public class StatCommandTest extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return CommandName.START.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return String.format(StatCommand.STAT_MESSAGE, 0);
    }

    @Override
    Command getCommand() {
        return new StatCommand(sendMessageService, telegramUserService);
    }
}
