package com.bipbup.command.impl;

import com.bipbup.command.Command;
import com.bipbup.sender.impl.CommandUtils;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Component;

import static com.bipbup.util.ResponseMessages.TRACK_INCORRECT_COMMAND;
import static com.bipbup.util.ResponseMessages.TRACK_INCORRECT_FORMAT;
import static com.bipbup.util.ResponseMessages.TRACK_SUCCESS;
import static com.bipbup.util.ResponseMessages.UNTRACK_COMMAND;
import static com.bipbup.util.ResponseMessages.UNTRACK_DESCRIPTION;
import static com.bipbup.util.ResponseMessages.UNTRACK_INCORRECT_COMMAND;
import static com.bipbup.util.ResponseMessages.UNTRACK_INCORRECT_FORMAT;
import static com.bipbup.util.ResponseMessages.UNTRACK_SUCCESS;

@Component
public class UntrackCommand implements Command {

    @Override
    public String command() {
        return UNTRACK_COMMAND;
    }

    @Override
    public String description() {
        return UNTRACK_DESCRIPTION;
    }

    @Override
    public SendMessage handle(Update update) {
        return CommandUtils.handleMessage(update,
                this, UNTRACK_SUCCESS,
                UNTRACK_INCORRECT_COMMAND, UNTRACK_INCORRECT_FORMAT);
    }
}
