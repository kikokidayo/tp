package seedu.address.logic.commands;

import seedu.address.model.Model;
import seedu.address.model.tag.Tag;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

/**
 * Outputs the currently used tags in the AddressBook
 */
public class ListTagsCommand extends Command {
    public static final String COMMAND_WORD = "taglist";

    public static final String MESSAGE_SUCCESS = "Listed tags currently in use: %1$s";

    @Override
    public CommandResult execute(Model model) {
        HashMap<Tag, Integer> tagMap = model.getActiveTags();
        Set<Tag> tags = tagMap.keySet();    //Getting the unique Tags
        String[] tagStrings = tags.stream().map(Tag::toString).toArray(String[]::new); //convert Set to Array
        Arrays.sort(tagStrings);    //Sort the tag strings in alphabetical order

        String resultString = String.join(", ", tagStrings);

        return new CommandResult(String.format(MESSAGE_SUCCESS, resultString));
    }
}
