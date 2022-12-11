package ru.keptelr.day10;

import junit.framework.TestCase;
import org.junit.Assert;
import ru.keptelr.day09.Day09;
import ru.keptelr.utils.InputParserUtil;

public class Day10Test extends TestCase {

    public void testPartOne() {
        Day10 day10 = new Day10();
        Assert.assertEquals( 0, day10.partOne(InputParserUtil.readFile("day10")), 0);
    }

    public void testPartTwo() {
        Day10 day10 = new Day10();
        Assert.assertEquals( 0, day10.partTwo(InputParserUtil.readFile("day10")), 0);
    }
}