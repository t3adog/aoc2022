package ru.keptelr.day08;

import junit.framework.TestCase;
import org.junit.Assert;
import ru.keptelr.utils.InputParserUtil;

public class Day08Test extends TestCase {

    public void testPartOne() {
        Day08 day08 = new Day08();
        Assert.assertEquals(0, day08.partOne(InputParserUtil.readFile("day08")), 0);
    }

    public void testPartTwo() {
        Day08 day08 = new Day08();
        Assert.assertEquals(0, day08.partTwo(InputParserUtil.readFile("day08")), 0);
    }
}