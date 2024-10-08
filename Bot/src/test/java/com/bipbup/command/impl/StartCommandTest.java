package com.bipbup.command.impl;

import com.bipbup.command.Command;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.bipbup.util.CommandTestUtils.createMockUpdate;
import static com.bipbup.util.ResponseMessages.*;
import static org.assertj.core.api.Assertions.assertThat;

class StartCommandTest {
    private static final String CORRECT_RESPONSE = """
    Hello, User!
    *LinkTrackerBot* - Your ultimate helper in tracking changes!
    Just type */track {*_link_*}* and the bot will make your life easier!
    For a full list of commands, type */help*.""";


    @Test
    @DisplayName("Correct /start command test")
    void handle_correctCommand() {
        //given
        Update mockUpdate = createMockUpdate(START_COMMAND);
        Command command = new StartCommand();

        // when
        SendMessage message = command.handle(mockUpdate);

        // then
        assertThat(message.getParameters()).containsEntry("text", CORRECT_RESPONSE);
    }

    @Test
    @DisplayName("Incorrect /start command test")
    void handle_incorrectCommand() {
        // given
        Update mockUpdate = createMockUpdate(START_COMMAND + "3");
        Command command = new StartCommand();

        // when
        SendMessage message = command.handle(mockUpdate);

        // then
        assertThat(message.getParameters()).containsEntry("text", DEFAULT_INCORRECT_COMMAND);
    }
}