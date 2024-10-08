package com.bipbup.util;

import java.util.List;

public final class ResponseMessages {
    private ResponseMessages() {
    }

    public static final String DEFAULT_INCORRECT_COMMAND = "The command contains extra characters or arguments.";
    public static final String HELP_COMMAND = "/help";
    public static final String HELP_DESCRIPTION = "Displays a list of all available commands.";
    public static final String LIST_COMMAND = "/list";
    public static final String LIST_DESCRIPTION = "Displays a list of all tracked resources.";
    public static final String DUMMY_GITHUB = "https://github.com/bulatruslanovich";
    public static final String DUMMY_STACKOVERFLOW = "https://stackoverflow.com/questions";
    public static final String START_COMMAND = "/start";
    public static final String START_DESCRIPTION = "Starts the bot.";
    public static final String WELCOME_MESSAGE = """
    *LinkTrackerBot* - Your ultimate helper in tracking changes!
    Just type */track {*_link_*}* and the bot will make your life easier!
    For a full list of commands, type */help*.""";
    public static final String TRACK_COMMAND = "/track";
    public static final String TRACK_DESCRIPTION = "Adds a new resource to track.";
    public static final String TRACK_SUCCESS = "Resource successfully added to the tracking list.";
    public static final String TRACK_INCORRECT_COMMAND =
            "The command contains extra characters! Please use the format: */track* {resource to track}.";
    public static final String TRACK_INCORRECT_FORMAT = "Please use the format: */track* {resource to track}.";
    public static final String UNTRACK_COMMAND = "/untrack";
    public static final String UNTRACK_DESCRIPTION = "Removes a resource from the tracking list.";
    public static final String UNTRACK_SUCCESS = "Resource successfully removed from the tracking list.";
    public static final String UNTRACK_INCORRECT_COMMAND =
            "The command contains extra characters! Please use the format: */untrack* {resource to untrack}.";
    public static final String UNTRACK_INCORRECT_FORMAT = "Please use the format: */untrack* {resource to untrack}.";
    public static final String UNSUPPORTED_COMMAND =
            "Unsupported command. Please use */help* to view the available commands.";
    public static final List<String> DUMMY_LINKS = List.of(DUMMY_GITHUB, DUMMY_STACKOVERFLOW);
    public static final String LIST_TITLE = "Tracked resources:\n";
    public static final String WELCOME_TITLE = "Hello, %s!\n";

}
