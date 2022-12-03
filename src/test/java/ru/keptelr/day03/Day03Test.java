package ru.keptelr.day03;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ru.keptelr.utils.InputParserUtil;

public class Day03Test {
    @Test
    public void testPartOne() {
        List<String> input = InputParserUtil.readFile("day03");
        Day03 day03 = new Day03();
        Assert.assertEquals(0, day03.partOne(input));
    }

    @Test
    public void testPartTwo() {
        List<String> input = InputParserUtil.readFile("day03");
        Day03 day03 = new Day03();
        Assert.assertEquals(0, day03.partTwo(input));
    }
}
