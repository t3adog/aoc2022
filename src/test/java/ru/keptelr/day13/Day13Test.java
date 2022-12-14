package ru.keptelr.day13;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import ru.keptelr.utils.InputParserUtil;

import java.util.List;

public class Day13Test extends TestCase {

    Day13 day13 = new Day13();

    @Test
    public void testPartOne() {
        Assert.assertEquals(13, day13.partOne(InputParserUtil.readFile("day13")), 0);
    }

    @Test
    public void testPackageValidation() {
        assertTrue(day13.isValidPkg(day13.parsePackages(List.of("[1,1,3,1,1]", "[1,1,5,1,1]")).get(0)));
        assertTrue(day13.isValidPkg(day13.parsePackages(List.of("[[1],[2,3,4]]", "[[1],4]")).get(0)));
        assertFalse(day13.isValidPkg(day13.parsePackages(List.of("[9]", "[[8,7,6]]")).get(0)));
        assertTrue(day13.isValidPkg(day13.parsePackages(List.of("[[4,4],4,4]", "[[4,4],4,4,4]")).get(0)));
        assertFalse(day13.isValidPkg(day13.parsePackages(List.of("[7,7,7,7]", "[7,7,7]")).get(0)));
        assertTrue(day13.isValidPkg(day13.parsePackages(List.of("[]", "[3]")).get(0)));
        assertFalse(day13.isValidPkg(day13.parsePackages(List.of("[[[]]]", "[[]]")).get(0)));
        assertFalse(day13.isValidPkg(day13.parsePackages(List.of("[1,[2,[3,[4,[5,6,7]]]],8,9]", "[1,[2,[3,[4,[5,6,0]]]],8,9]")).get(0)));
    }

    @Test
    public void testPartTwo() {
        Assert.assertEquals(0, day13.partTwo(InputParserUtil.readFile("day13")), 0);
    }
}