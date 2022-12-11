package ru.keptelr.day11;

import junit.framework.TestCase;
import org.junit.Assert;
import ru.keptelr.utils.InputParserUtil;

import java.math.BigInteger;

public class Day11Test extends TestCase {
    Day11 day11 = new Day11();
    public void testPartOne() {
        Assert.assertEquals(new BigInteger("10605"), day11.partOne(InputParserUtil.readFile("day11")));
    }

    public void testPartTwo() {
        Assert.assertEquals(new BigInteger("2713310158"), day11.partTwo(InputParserUtil.readFile("day11")));
    }
}