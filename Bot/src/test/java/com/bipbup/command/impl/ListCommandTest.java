package com.bipbup.command.impl;

import com.bipbup.command.Command;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.bipbup.util.CommandTestUtils.createMockUpdate;
import static com.bipbup.util.ResponseMessages.DEFAULT_INCORRECT_COMMAND;
import static com.bipbup.util.ResponseMessages.LIST_COMMAND;
import static org.assertj.core.api.Assertions.assertThat;

class ListCommandTest {
    private static final String CORRECT_RESPONSE = """
        Tracked resources:
        *1*: https://github.com/bulatruslanovich
        *2*: https://stackoverflow.com/questions""";


    @Test
    @DisplayName("Correct /list command test")
    void handle_correctCommand() {
        //given
        Update mockUpdate = createMockUpdate(LIST_COMMAND);
        Command command = new ListCommand();

        // when
        SendMessage message = command.handle(mockUpdate);

        // then
        assertThat(message.getParameters()).containsEntry("text", CORRECT_RESPONSE);
    }

    @Test
    @DisplayName("Incorrect /list command test")
    void handle_incorrectCommand() {
        // given
        Update mockUpdate = createMockUpdate(LIST_COMMAND + "3");
        Command command = new ListCommand();

        // when
        SendMessage message = command.handle(mockUpdate);

        // then
        assertThat(message.getParameters()).containsEntry("text", DEFAULT_INCORRECT_COMMAND);
    }
}