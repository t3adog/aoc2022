package ru.keptelr.day12;

import java.util.Arrays;
import java.util.List;

public class Day12 {

    List<String> findPaths(char[][] map, int[] from, int[] to, List<String> foundPaths) {


        // TODO Написать тут рекурсивный метод, который будет возвращать все возможные следующие шаги, после чего
        // каждый из них в цикле проверять и так далее, пока не достигнем тупика либо финиша
        String path = "";
        int[] currentPoint = from;
        while (!Arrays.equals(currentPoint, to)) {

        }

        return foundPaths;
    }

    void findNextSteps(int[][]map, List<int[]> paths) {
        int y = currentPath[0];
        int x = currentPath[1];
        // up

        // down

        // left

        // right
    }

    public Integer partOne(List<String> input) {
        char[][] map = parseMap(input);
        int[] from = findPosition(map, 'S');
        int[] to = findPosition(map, 'E');

        return 0;
    }


    public Integer partTwo(List<String> input) {
        return 0;
    }

    private int[] findPosition(char[][] map, char position) {
        for (int y = 0; y < map.length; y++) {
            char[] line = map[y];
            for (int x = 0; x < line.length; x++) {
                if (map[y][x] == position) {
                    return new int[]{y, x};
                }
            }
        }
        throw new RuntimeException();
    }

    private char[][] parseMap(List<String> input) {
        char[][] map = new char[input.size()][input.get(0).length()];
        for (int y = 0; y < input.size(); y++) {
            char[] line = input.get(y).toCharArray();
            for (int x = 0; x < line.length; x++) {
                map[y][x] = line[x];
            }
        }
        return map;
    }
}
