package ru.keptelr;

import ru.keptelr.day01.Day01;
import ru.keptelr.day02.Day02;
import ru.keptelr.day03.Day03;
import ru.keptelr.day04.Day04;
import ru.keptelr.day05.Day05;
import ru.keptelr.utils.InputParserUtil;

public class DayExecutor {

    public static void main(String[] args) {
        Day01 day01 = new Day01();
        System.out.println("Day01 Part01: " + day01.partOne(InputParserUtil.readFile("day01")));
        System.out.println("Day01 Part02: " + day01.partTwo(InputParserUtil.readFile("day01")));

        Day02 day02 = new Day02();
        System.out.println("Day02 Part01: " + day02.partOne(InputParserUtil.readFile("day02")));
        System.out.println("Day02 Part02: " + day02.partTwo(InputParserUtil.readFile("day02")));

        Day03 day03 = new Day03();
        System.out.println("Day03 Part01: " + day03.partOne(InputParserUtil.readFile("day03")));
        System.out.println("Day03 Part02: " + day03.partTwo(InputParserUtil.readFile("day03")));

        Day04 day04 = new Day04();
        System.out.println("Day04 Part01: " + day04.partOne(InputParserUtil.readFile("day04")));
        System.out.println("Day04 Part02: " + day04.partTwo(InputParserUtil.readFile("day04")));

        Day05 day05 = new Day05();
        System.out.println("Day05 Part01: " + day05.partOne(InputParserUtil.readFile("day05")));
        System.out.println("Day05 Part02: " + day05.partTwo(InputParserUtil.readFile("day05")));
    }

}
