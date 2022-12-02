package ru.keptelr.day02;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ru.keptelr.utils.InputParserUtil;

public class Day02Test {
    @Test
    public void testPartOne() {
        List<String> input = InputParserUtil.readFile("day02");
        Day02 day02 = new Day02();
        Assert.assertEquals(15, day02.partOne(input));
    }

    @Test
    public void testPartTwo() {
        List<String> input = InputParserUtil.readFile("day02");
        Day02 day02 = new Day02();
        Assert.assertEquals(0L, day02.partTwo(input), 0);
    }
}
