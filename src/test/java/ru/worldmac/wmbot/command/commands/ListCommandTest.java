package ru.worldmac.wmbot.command.commands;

import org.junit.jupiter.api.DisplayName;
import ru.worldmac.wmbot.comand.Command;
import ru.worldmac.wmbot.comand.commands.ListCommand;
import ru.worldmac.wmbot.comand.enums.CommandName;

@DisplayName("Unit-level testing for ListCommand")
public class ListCommandTest extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return CommandName.LIST.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return ListCommand.LIST_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new ListCommand(sendMessageService);
    }
}