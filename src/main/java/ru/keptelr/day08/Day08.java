package ru.keptelr.day08;

import java.util.ArrayList;
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
        int[][] forest = parseForest(input);

        List<Integer> scenicScores = new ArrayList<>();

        for (int y = 0; y < forest.length; y++) {
            for (int x = 0; x < forest.length; x++) {
                int sceneScore =
                        getTreesCountFromDown(forest, y, x)
                                * getTreesCountFromTheRight(forest, y, x)
                                * getTreesCountFromTheLeft(forest, y, x)
                                * getTreesCountFromTop(forest, y, x);
                scenicScores.add(sceneScore);
            }
        }

        return scenicScores.stream().mapToInt(Integer::intValue).max().orElse(0);
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

    private int getTreesCountFromTop(int[][] forest, int yPoint, int xPoint) {
        int treeSize = forest[yPoint][xPoint];
        int count = 0;
        for (int y = yPoint - 1; y > -1; y--) {
            count++;
            if (treeSize <= forest[y][xPoint]) {
                break;
            }
        }
        return count;
    }

    private int getTreesCountFromDown(int[][] forest, int yPoint, int xPoint) {
        int treeSize = forest[yPoint][xPoint];
        int count = 0;
        for (int y = yPoint + 1; y < forest.length; y++) {
            count++;
            if (treeSize <= forest[y][xPoint]) {
                break;
            }
        }
        return count;
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

    private int getTreesCountFromTheRight(int[][] forest, int yPoint, int xPoint) {
        int treeSize = forest[yPoint][xPoint];
        int count = 0;
        for (int x = xPoint + 1; x < forest[yPoint].length; x++) {
            count++;
            if (treeSize <= forest[yPoint][x]) {
                break;
            }
        }
        return count;
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

    private int getTreesCountFromTheLeft(int[][] forest, int yPoint, int xPoint) {
        int count = 0;
        int treeSize = forest[yPoint][xPoint];
        for (int x = xPoint - 1; x > -1; x--) {
            count++;
            if (treeSize <= forest[yPoint][x]) {
                break;
            }
        }
        return count;
    }

}
