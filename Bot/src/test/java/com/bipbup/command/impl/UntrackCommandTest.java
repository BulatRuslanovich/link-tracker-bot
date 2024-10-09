package com.bipbup.command.impl;

import com.bipbup.command.Command;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.bipbup.util.CommandTestUtils.createMockUpdate;
import static com.bipbup.util.ResponseMessages.DUMMY_GITHUB;
import static com.bipbup.util.ResponseMessages.UNTRACK_COMMAND;
import static com.bipbup.util.ResponseMessages.UNTRACK_INCORRECT_FORMAT;
import static com.bipbup.util.ResponseMessages.UNTRACK_SUCCESS;
import static org.assertj.core.api.Assertions.assertThat;

class UntrackCommandTest {

    @Test
    @DisplayName("Correct /untrack command test")
    void handle_correctCommand() {
        //given
        Update mockUpdate = createMockUpdate(UNTRACK_COMMAND + " " + DUMMY_GITHUB);
        Command command = new UntrackCommand();

        // when
        SendMessage message = command.handle(mockUpdate);

        // then
        assertThat(message.getParameters()).containsEntry("text", UNTRACK_SUCCESS);
    }

    @Test
    @DisplayName("Incorrect /untrack command test")
    void handle_incorrectCommand() {
        // given
        Update mockUpdate = createMockUpdate(UNTRACK_COMMAND + "3");
        Command command = new UntrackCommand();

        // when
        SendMessage message = command.handle(mockUpdate);

        // then
        assertThat(message.getParameters()).containsEntry("text", UNTRACK_INCORRECT_FORMAT);
    }
}