package com.bipbup.processor.impl;

import com.bipbup.command.impl.ListCommand;
import com.bipbup.command.impl.StartCommand;
import com.bipbup.command.impl.TrackCommand;
import com.bipbup.command.impl.UntrackCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.bipbup.util.CommandTestUtils.createMockUpdate;
import static com.bipbup.util.ResponseMessages.*;
import static org.assertj.core.api.Assertions.assertThat;

class BotTextMessageProcessorTest {

    @Test
    @DisplayName("Processor incorrect command test")
    void process_incorrectCommand() {
        // given
        var update = createMockUpdate(null);
        var commands = List.of(
                new ListCommand(),
                new StartCommand(),
                new TrackCommand(),
                new UntrackCommand()
        );

        var processor = new BotTextMessageProcessor(commands);

        // when
        var message = processor.process(update);

        // then
        assertThat(message.getParameters()).containsEntry("text", UNSUPPORTED_COMMAND);
    }

    @Test
    @DisplayName("Processor correct command test")
    void process_correctCommand() {
        // given
        var update = createMockUpdate(START_COMMAND);
        var commands = List.of(
                new ListCommand(),
                new StartCommand(),
                new TrackCommand(),
                new UntrackCommand()
        );

        var processor = new BotTextMessageProcessor(commands);

        // when
        var message = processor.process(update);

        // then
        assertThat(message.getParameters()).containsEntry("text", WELCOME_TITLE.formatted("User") + WELCOME_MESSAGE);
    }
}