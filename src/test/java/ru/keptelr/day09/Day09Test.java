package ru.keptelr.day09;

import junit.framework.TestCase;
import org.junit.Assert;
import ru.keptelr.day08.Day08;
import ru.keptelr.utils.InputParserUtil;

public class Day09Test extends TestCase {

    public void testPartOne() {
        Day09 day09 = new Day09();
        Assert.assertEquals(0, day09.partOne(InputParserUtil.readFile("day09")), 0);
    }

    public void testPartTwo() {
        Day09 day09 = new Day09();
        Assert.assertEquals(0, day09.partOne(InputParserUtil.readFile("day09")), 0);
    }
}