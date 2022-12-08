package ru.keptelr.day08;

import java.util.List;

public class Day08 {

    public Integer partOne(List<String> input) {

        int[][] forest = parseForest(input);

        int visibleTreeCount = (forest.length * 4) - 4;

        for (int y = 1; y < forest.length - 1; y++) {
            for (int x = 1; x < forest.length - 1; x++) {
                if (isTreeVisibleFromTheTop(forest, y, x)
                        || isTreeVisibleFromTheDown(forest, y, x)
                        || isTreeVisibleFromTheRight(forest, y, x)
                        || isTreeVisibleFromTheLeft(forest, y, x)) {
                    visibleTreeCount++;
                }
            }
        }

        return visibleTreeCount;
    }

    public int partTwo(List<String> input) {
        return 0;
    }

    private int[][] parseForest(List<String> input) {
        int[][] forest = new int[input.size()][input.get(0).length()];

        for (int y = 0; y < input.size(); y++) {
            char[] numbers = input.get(y).toCharArray();
            for (int x = 0; x < numbers.length; x++) {
                forest[y][x] = Character.getNumericValue(numbers[x]);
            }
        }
        return forest;
    }

    private boolean isTreeVisibleFromTheTop(int[][] forest, int yPoint, int xPoint) {
        int treeSize = forest[yPoint][xPoint];
        for (int y = yPoint - 1; y > -1; y--) {
            if (treeSize <= forest[y][xPoint]) {
                return false;
            }
        }
        return true;
    }

    private boolean isTreeVisibleFromTheDown(int[][] forest, int yPoint, int xPoint) {
        int treeSize = forest[yPoint][xPoint];
        for (int y = yPoint + 1; y < forest.length; y++) {
            if (treeSize <= forest[y][xPoint]) {
                return false;
            }
        }
        return true;
    }

    private boolean isTreeVisibleFromTheRight(int[][] forest, int yPoint, int xPoint) {
        int treeSize = forest[yPoint][xPoint];
        for (int x = xPoint + 1; x < forest[yPoint].length; x++) {
            if (treeSize <= forest[yPoint][x]) {
                return false;
            }
        }
        return true;
    }

    private boolean isTreeVisibleFromTheLeft(int[][] forest, int yPoint, int xPoint) {
        int treeSize = forest[yPoint][xPoint];
        for (int x = xPoint - 1; x > -1; x--) {
            if (treeSize <= forest[yPoint][x]) {
                return false;
            }
        }
        return true;
    }

}
