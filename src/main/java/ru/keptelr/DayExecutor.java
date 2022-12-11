package ru.keptelr;

import ru.keptelr.day01.Day01;
import ru.keptelr.day02.Day02;
import ru.keptelr.day03.Day03;
import ru.keptelr.day04.Day04;
import ru.keptelr.day05.Day05;
import ru.keptelr.day06.Day06;
import ru.keptelr.day07.Day07;
import ru.keptelr.day08.Day08;
import ru.keptelr.day09.Day09;
import ru.keptelr.day10.Day10;
import ru.keptelr.day11.Day11;
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

        Day06 day06 = new Day06();
        System.out.println("Day06 Part01: " + day06.partOne(InputParserUtil.readFile("day06")));
        System.out.println("Day06 Part02: " + day06.partTwo(InputParserUtil.readFile("day06")));

        Day07 day07 = new Day07();
        System.out.println("Day07 Part01: " + day07.partOne(InputParserUtil.readFile("day07")));
        System.out.println("Day07 Part02: " + day07.partTwo(InputParserUtil.readFile("day07")));

        Day08 day08 = new Day08();
        System.out.println("Day08 Part01: " + day08.partOne(InputParserUtil.readFile("day08")));
        System.out.println("Day08 Part02: " + day08.partTwo(InputParserUtil.readFile("day08")));

        Day09 day09 = new Day09();
        System.out.println("Day09 Part01: " + day09.partOne(InputParserUtil.readFile("day09")));
        System.out.println("Day09 Part02: " + day09.partTwo(InputParserUtil.readFile("day09")));

        Day10 day10 = new Day10();
        System.out.println("Day10 Part01: " + day10.partOne(InputParserUtil.readFile("day10")));
        System.out.println("Day10 Part02: ");
        day10.partTwo(InputParserUtil.readFile("day10"));

        Day11 day11 = new Day11();
        System.out.println("Day11 Part01: " + day11.partOne(InputParserUtil.readFile("day11")));
        System.out.println("Day11 Part02: " + day11.partTwo(InputParserUtil.readFile("day11")));
    }

}
