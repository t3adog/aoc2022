package ru.keptelr.day13;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import ru.keptelr.utils.InputParserUtil;

public class Day13Test extends TestCase {

    @Test
    public void testParsing() {
        System.out.println(Package.from("[[1],[2,3,4]]"));
    }

    public void testPartOne() {
        Day13 day13 = new Day13();
        Assert.assertEquals(13, day13.partOne(InputParserUtil.readFile("day13")), 0);
    }

    public void testPartTwo() {
        Day13 day13 = new Day13();
        Assert.assertEquals(0, day13.partTwo(InputParserUtil.readFile("day13")), 0);
    }
}