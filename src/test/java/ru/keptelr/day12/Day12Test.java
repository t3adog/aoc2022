package ru.keptelr.day12;

import junit.framework.TestCase;
import ru.keptelr.utils.InputParserUtil;

public class Day12Test extends TestCase {

    private Day12 day12 = new Day12();

    public void testPartOne() {
        assertEquals(31, day12.partOne(InputParserUtil.readFile("day12")), 0);
    }

    public void testPartTwo() {
        assertEquals(0, day12.partTwo(InputParserUtil.readFile("day12")), 0);
    }
}