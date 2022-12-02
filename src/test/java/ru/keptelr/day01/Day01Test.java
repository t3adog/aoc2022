package ru.keptelr.day01;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ru.keptelr.utils.InputParserUtil;

public class Day01Test {

    @Test
    public void testPartOne() {
        List<String> input = InputParserUtil.readFile("day01");
        Day01 day01 = new Day01();
        Assert.assertEquals(24000L, day01.partOne(input), 0);
    }

    @Test
    public void testPartTwo() {
        List<String> input = InputParserUtil.readFile("day01");
        Day01 day01 = new Day01();
        Assert.assertEquals(45000L, day01.partTwo(input), 0);
    }

}
