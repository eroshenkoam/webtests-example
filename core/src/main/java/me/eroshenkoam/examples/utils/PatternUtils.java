package me.eroshenkoam.examples.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author eroshenkoam
 */
public class PatternUtils {

    private PatternUtils() {
    }

    public static String findFirstGroup(Pattern pattern, String where) {
        Matcher matcher = pattern.matcher(where);
        return matcher.find() ? matcher.group() : null;
    }

    public static List<String> findAllGroups(Pattern pattern, String where) {
        List<String> founded = new ArrayList<>();
        Matcher matcher = pattern.matcher(where);
        while (matcher.find()) {
            founded.add(matcher.group());
        }
        return founded;
    }
}
