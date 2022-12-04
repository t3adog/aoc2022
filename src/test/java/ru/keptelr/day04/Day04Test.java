package ru.keptelr.day04;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ru.keptelr.utils.InputParserUtil;

public class Day04Test {
    @Test
    public void testPartOne() {
        List<String> input = InputParserUtil.readFile("day04");
        Day04 day04 = new Day04();
        Assert.assertEquals(2, day04.partOne(input));

    }

    @Test
    public void testPartTwo() {
        List<String> input = InputParserUtil.readFile("day04");
        Day04 day04 = new Day04();
        Assert.assertEquals(0, day04.partTwo(input));
    }
}
