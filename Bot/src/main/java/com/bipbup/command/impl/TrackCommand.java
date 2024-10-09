package com.bipbup.command.impl;

import com.bipbup.command.Command;
import com.bipbup.sender.impl.CommandUtils;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Component;

import static com.bipbup.util.ResponseMessages.TRACK_COMMAND;
import static com.bipbup.util.ResponseMessages.TRACK_DESCRIPTION;
import static com.bipbup.util.ResponseMessages.TRACK_INCORRECT_COMMAND;
import static com.bipbup.util.ResponseMessages.TRACK_INCORRECT_FORMAT;
import static com.bipbup.util.ResponseMessages.TRACK_SUCCESS;

@Component
public class TrackCommand implements Command {

    @Override
    public String command() {
        return TRACK_COMMAND;
    }

    @Override
    public String description() {
        return TRACK_DESCRIPTION;
    }

    @Override
    public SendMessage handle(Update update) {
        return CommandUtils.handleMessage(update,
                this, TRACK_SUCCESS,
                TRACK_INCORRECT_COMMAND, TRACK_INCORRECT_FORMAT);
    }
}
