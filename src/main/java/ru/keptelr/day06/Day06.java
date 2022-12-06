package ru.keptelr.day06;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day06 {

    private static final int OFFSET = 4;

    public int partOne(List<String> input) {
        char[] source = input.get(0).toCharArray();

        for (int i = 0; i < source.length; i++) {
            Set<Character> buffer = new HashSet<>();
            for (int z = 0; z < OFFSET; z++) {
                buffer.add(source[i + z]);
            }
            if (buffer.size() == OFFSET) {
                return i + OFFSET;
            }

        }
        return 0;
    }

    public int partTwo(List<String> input) {
        return 0;
    }

}
