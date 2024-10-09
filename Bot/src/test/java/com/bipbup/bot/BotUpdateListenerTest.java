package com.bipbup.bot;

import com.bipbup.command.impl.ListCommand;
import com.bipbup.command.impl.StartCommand;
import com.bipbup.command.impl.TrackCommand;
import com.bipbup.command.impl.UntrackCommand;
import com.bipbup.bot.sender.Sender;
import com.bipbup.bot.sender.impl.BotTextMessageSender;
import com.pengrad.telegrambot.model.Update;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.bipbup.util.CommandTestUtils.createMockUpdate;
import static com.bipbup.util.CommandTestUtils.createMockUpdateEditedMessage;
import static com.bipbup.util.ResponseMessages.START_COMMAND;
import static org.mockito.Mockito.*;

class BotUpdateListenerTest {

    private Update update;

    private BotUpdateListener listener;

    private Sender sender;

    @BeforeEach
    void initTest() {
        var commands = List.of(
                new ListCommand(),
                new StartCommand(),
                new TrackCommand(),
                new UntrackCommand()
        );

        sender = mock(BotTextMessageSender.class);

        listener = new BotUpdateListener(commands, sender);
    }

    @Test
    @DisplayName("process work with new message")
    void process_newMessage() {
        // given
        update = createMockUpdate(START_COMMAND);

        // when
        listener.process(List.of(update));

        // then
        verify(sender, times(1))
                .send(any());
    }

    @Test
    @DisplayName("process work with edited message")
    void process_editMessage() {
        // given
        update = createMockUpdateEditedMessage(START_COMMAND);

        // when
        listener.process(List.of(update));

        // then
        verify(sender, times(0))
                .send(any());
    }


}