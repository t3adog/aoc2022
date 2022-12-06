package ru.keptelr.day06;

import org.junit.Assert;
import org.junit.Test;

import ru.keptelr.utils.InputParserUtil;

public class Day06Test {
    @Test
    public void testPartOne() {
        Day06 day06 = new Day06();
        Assert.assertEquals(0, day06.partOne(InputParserUtil.readFile("day06")));
    }

    @Test
    public void testPartTwo() {
        Day06 day06 = new Day06();
        Assert.assertEquals(0, day06.partTwo(InputParserUtil.readFile("day06")));
    }
}
