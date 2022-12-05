package ru.keptelr.day05;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ru.keptelr.utils.InputParserUtil;

public class Day05Test {
    @Test
    public void testPartOne() {
        List<String> input = InputParserUtil.readFile("day05");
        Day05 day05 = new Day05();
        Assert.assertEquals("CMZ", day05.partOne(input));

    }

    @Test
    public void testPartTwo() {
        List<String> input = InputParserUtil.readFile("day05");
        Day05 day05 = new Day05();
        Assert.assertEquals("MCD", day05.partTwo(input));
    }
}
