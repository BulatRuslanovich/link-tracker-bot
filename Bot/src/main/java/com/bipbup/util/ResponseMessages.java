package com.bipbup.util;

import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class ResponseMessages {
    public final String DEFAULT_INCORRECT_COMMAND = "The command contains extra characters or arguments.";
    public final String HELP_COMMAND = "/help";
    public final String HELP_DESCRIPTION = "Displays a list of all available commands.";
    public final String LIST_COMMAND = "/list";
    public final String LIST_DESCRIPTION = "Displays a list of all tracked resources.";
    public final String DUMMY_GITHUB = "https://github.com/bulatruslanovich";
    public final String DUMMY_STACKOVERFLOW = "https://stackoverflow.com/questions";
    public final String START_COMMAND = "/start";
    public final String START_DESCRIPTION = "Starts the bot.";
    public final String WELCOME_MESSAGE = """
    *ReminderBot* - Your ultimate helper in tracking changes!
    Just type */track {*_link_*}* and the bot will make your life easier!
    For a full list of commands, type */help*.""";
    public final String TRACK_COMMAND = "/track";
    public final String TRACK_DESCRIPTION = "Adds a new resource to track.";
    public final String TRACK_SUCCESS = "Resource successfully added to the tracking list.";
    public final String TRACK_INCORRECT_COMMAND =
            "The command contains extra characters! Please use the format: */track* {resource to track}.";
    public final String TRACK_INCORRECT_FORMAT = "Please use the format: */track* {resource to track}.";
    public final String UNTRACK_COMMAND = "/untrack";
    public final String UNTRACK_DESCRIPTION = "Removes a resource from the tracking list.";
    public final String UNTRACK_SUCCESS = "Resource successfully removed from the tracking list.";
    public final String UNTRACK_INCORRECT_COMMAND =
            "The command contains extra characters! Please use the format: */untrack* {resource to untrack}.";
    public final String UNTRACK_INCORRECT_FORMAT = "Please use the format: */untrack* {resource to untrack}.";
    public final String UNSUPPORTED_COMMAND =
            "Unsupported command. Please use */help* to view the available commands.";
    public final List<String> DUMMY_LINKS = List.of(DUMMY_GITHUB, DUMMY_STACKOVERFLOW);
    public final String LIST_TITLE = "Tracked resources:\n";
    public final String WELCOME_TITLE = "Hello, %s!\n";

}
