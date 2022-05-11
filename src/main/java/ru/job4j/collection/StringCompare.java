package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int i = 0;
        int rsl = 0;
        while (i < left.length() && i < right.length()) {
            rsl = Character.compare(left.charAt(i), right.charAt(i));
            i += 1;
            if (rsl != 0) {
                break;
            }
        }
        if (rsl == 0) {
            rsl = Integer.compare(left.length(), right.length());
        }
        return rsl;
    }
}
