package com.bipbup.command.impl;

import com.bipbup.command.Command;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.bipbup.util.CommandTestUtils.createMockUpdate;
import static com.bipbup.util.ResponseMessages.DEFAULT_INCORRECT_COMMAND;
import static com.bipbup.util.ResponseMessages.HELP_COMMAND;
import static org.assertj.core.api.Assertions.assertThat;

class HelpCommandTest {
    private static final String CORRECT_RESPONSE = """
        /help - Displays a list of all available commands.
        /list - Displays a list of all tracked resources.
        /start - Starts the bot.
        /track - Adds a new resource to track.
        /untrack - Removes a resource from the tracking list.
        """;


    @Test
    @DisplayName("Correct /help command test")
    void handle_correctCommand() {
        //given
        Update mockUpdate = createMockUpdate(HELP_COMMAND);
        List<Command> commandsList =
                List.of(
                        new ListCommand(),
                        new StartCommand(),
                        new TrackCommand(),
                        new UntrackCommand()
                );
        Command command = new HelpCommand(commandsList);

        // when
        SendMessage message = command.handle(mockUpdate);

        // then
        assertThat(message.getParameters()).containsEntry("text", CORRECT_RESPONSE);
    }

    @Test
    @DisplayName("Incorrect /help command test")
    void handle_incorrectCommand() {
        // given
        Update mockUpdate = createMockUpdate(HELP_COMMAND + "3");
        List<Command> commandsList =
                List.of(
                        new ListCommand(),
                        new StartCommand(),
                        new TrackCommand(),
                        new UntrackCommand()
                );
        Command command = new HelpCommand(commandsList);

        // when
        SendMessage message = command.handle(mockUpdate);

        // then
        assertThat(message.getParameters()).containsEntry("text", DEFAULT_INCORRECT_COMMAND);
    }
}