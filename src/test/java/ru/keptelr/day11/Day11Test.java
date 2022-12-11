package ru.keptelr.day11;

import junit.framework.TestCase;
import org.junit.Assert;
import ru.keptelr.utils.InputParserUtil;

public class Day11Test extends TestCase {
    Day11 day11 = new Day11();
    public void testPartOne() {
        Assert.assertEquals(0, day11.partOne(InputParserUtil.readFile("day11")), 0);
    }

    public void testPartTwo() {
        Assert.assertEquals(0, day11.partTwo(InputParserUtil.readFile("day11")), 0);
    }
}