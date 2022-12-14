package ru.keptelr.day13;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Package {
    private List<Integer> numbers;

    private List<Package> packages;

    public static Package from(String input) {
        Package p = new Package();
        p.numbers = new ArrayList<>();
        p.packages = new ArrayList<>();

        char[] ch = input.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '[') {
                int to = findCloseIndex(ch, i);
                p.packages.add(from(input.substring(i + 1, to + 1).strip()));
                i = to + 1;
            } else if (ch[i] != ',' && ch[i] != ']') {
                p.numbers.add(Character.getNumericValue(ch[i]));
            }
        }
        return p;
    }

    private static int findCloseIndex(char[] ch, int from) {
        for (int i = from; i < ch.length; i++) {
            if (ch[i] == ']') {
                return i;
            }

        }
        throw new RuntimeException();
    }
}
