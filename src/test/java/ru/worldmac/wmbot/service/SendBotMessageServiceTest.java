package ru.worldmac.wmbot.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.worldmac.wmbot.bot.WmBot;

@DisplayName("Unit-level testing for SendMessageService")
public class SendBotMessageServiceTest {

    private SendMessageService sendMessageService;
    private WmBot wmBot;

    @BeforeEach
    public void init() {
        wmBot = Mockito.mock(WmBot.class);
        sendMessageService = new SendMessageServiceImpl(wmBot);
    }

    @Test
    public void shouldProperlySendMessage() throws TelegramApiException {
        //given
        String chatId = "test_chat_id";
        String message = "test_message";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);

        //when
        sendMessageService.sendMessage(chatId, message);

        //then
        Mockito.verify(wmBot).execute(sendMessage);
    }
}
