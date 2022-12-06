package ru.keptelr.day06;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ru.keptelr.utils.InputParserUtil;

public class Day06Test {
    @Test
    public void testPartOne() {
        Day06 day06 = new Day06();
        Assert.assertEquals(7, day06.partOne(List.of("mjqjpqmgbljsphdztnvjfqwrcgsmlb")));
        Assert.assertEquals(5, day06.partOne(List.of("bvwbjplbgvbhsrlpgdmjqwftvncz")));
        Assert.assertEquals(6, day06.partOne(List.of("nppdvjthqldpwncqszvftbrmjlhg")));
        Assert.assertEquals(10, day06.partOne(List.of("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg")));
        Assert.assertEquals(11, day06.partOne(List.of("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw")));
    }

    @Test
    public void testPartTwo() {
        Day06 day06 = new Day06();
        // Assert.assertEquals(0, day06.partTwo(InputParserUtil.readFile("day06")));
    }
}
