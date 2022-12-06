package ru.keptelr.day06;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day06 {

    private static final int PACKET_OFFSET = 4;
    private static final int MESSAGE_OFFSET = 14;

    public int partOne(List<String> input) {
        char[] source = input.get(0).toCharArray();

        for (int i = 0; i < source.length; i++) {
            Set<Character> buffer = new HashSet<>();
            for (int z = 0; z < PACKET_OFFSET; z++) {
                buffer.add(source[i + z]);
            }
            if (buffer.size() == PACKET_OFFSET) {
                return i + PACKET_OFFSET;
            }

        }
        throw new RuntimeException("Packet not found");
    }

    public int partTwo(List<String> input) {
        char[] source = input.get(0).toCharArray();

        for (int i = 0; i < source.length; i++) {
            Set<Character> buffer = new HashSet<>();
            for (int z = 0; z < MESSAGE_OFFSET; z++) {
                buffer.add(source[i + z]);
            }
            if (buffer.size() == MESSAGE_OFFSET) {
                return i + MESSAGE_OFFSET;
            }

        }
        throw new RuntimeException("Message not found");
    }

}
