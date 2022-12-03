package ru.keptelr.day03;

import java.util.Set;

public class PriorityCounter {

    public int getPriority(Set<Character> duplicates) {
        if (duplicates.size() != 1) {
            throw new RuntimeException("whats wrong with you?"); // whats wring with me?
        }
        char input = duplicates.iterator().next();
        int priority = 0;
        if (Character.isUpperCase(input)) {
            priority = priority + 26;
        }
        return priority + getPosition(input);
    }

    private int getPosition(char input) {
        return (String.valueOf(input).toLowerCase().codePointAt(0)) - 'a' + 1;
    }

}
