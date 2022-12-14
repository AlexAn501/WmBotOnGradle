package ru.worldmac.wmbot.comand.enums;


/**
 * Enumeration for Command's.
 */

public enum CommandName {
    START("/start"),
    STOP("/stop"),
    LIST("/list"),
    HELP("/help"),
    STAT("/stat"),
    NO("nocommand");

    CommandName(String commandName) {
        this.commandName = commandName;
    }

    private final String commandName;

    public String getCommandName() {
        return commandName;
    }
}
