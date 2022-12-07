package ru.keptelr.day07;

import org.junit.Assert;
import org.junit.Test;
import ru.keptelr.utils.InputParserUtil;

public class Day07Test {
    @Test
    public void testPartOne() {
        Day07 day07 = new Day07();
        Assert.assertEquals(95437, day07.partOne(InputParserUtil.readFile("day07")), 0);
    }

    @Test
    public void testPartTwo() {
        Day07 day07 = new Day07();
        Assert.assertEquals(0, day07.partTwo(InputParserUtil.readFile("day07")));
    }
}
