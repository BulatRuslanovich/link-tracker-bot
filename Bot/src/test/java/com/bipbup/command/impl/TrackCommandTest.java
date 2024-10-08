package com.bipbup.command.impl;

import com.bipbup.command.Command;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.bipbup.util.CommandTestUtils.createMockUpdate;
import static com.bipbup.util.ResponseMessages.*;
import static org.assertj.core.api.Assertions.assertThat;

class TrackCommandTest {

    @Test
    @DisplayName("Correct /track command test")
    void handle_correctCommand() {
        //given
        Update mockUpdate = createMockUpdate(TRACK_COMMAND + " " + DUMMY_GITHUB);
        Command command = new TrackCommand();

        // when
        SendMessage message = command.handle(mockUpdate);

        // then
        assertThat(message.getParameters()).containsEntry("text", TRACK_SUCCESS);
    }

    @Test
    @DisplayName("Incorrect /track command test")
    void handle_incorrectCommand() {
        // given
        Update mockUpdate = createMockUpdate(TRACK_COMMAND + "3");
        Command command = new TrackCommand();

        // when
        SendMessage message = command.handle(mockUpdate);

        // then
        assertThat(message.getParameters()).containsEntry("text", TRACK_INCORRECT_FORMAT);
    }
}