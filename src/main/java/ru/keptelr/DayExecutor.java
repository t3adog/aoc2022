package ru.keptelr;

import ru.keptelr.day01.Day01;
import ru.keptelr.day02.Day02;
import ru.keptelr.utils.InputParserUtil;

public class DayExecutor {

    public static void main(String[] args) {
        Day01 day01 = new Day01();
        System.out.println("Day01 Part01: " + day01.partOne(InputParserUtil.readFile("day01")));
        System.out.println("Day01 Part02: " + day01.partTwo(InputParserUtil.readFile("day01")));

        Day02 day02 = new Day02();
        System.out.println("Day02 Part01: " + day02.partOne(InputParserUtil.readFile("day02")));
        System.out.println("Day02 Part02: " + day02.partTwo(InputParserUtil.readFile("day02")));


        // Не 16028

    }
    
}
