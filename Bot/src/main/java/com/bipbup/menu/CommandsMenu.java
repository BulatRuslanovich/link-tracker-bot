package com.bipbup.menu;

import com.bipbup.command.Command;
import com.pengrad.telegrambot.model.BotCommand;
import com.pengrad.telegrambot.request.SetMyCommands;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class CommandsMenu {

    private final List<Command> commands;

    public SetMyCommands getCommandsMenu() {
        var list = commands.stream().map(Command::toApiCommand).toList();

        return new SetMyCommands(list.toArray(new BotCommand[0]));
    }

}
