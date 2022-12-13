package ru.keptelr.day12;

import org.apache.commons.lang3.Range;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class Day12 {

    private char[][] MAP;
    private static final Set<Point> UNXEPLORED = new HashSet<>();
    private static Point FINISH_POINT;
    private static Point START_POINT;

    public Integer partOne(List<String> input) {
        MAP = parseMap(input);

        FINISH_POINT = findPosition(MAP, 'E');
        START_POINT = findPosition(MAP, 'S');

        MAP[START_POINT.getY()][START_POINT.getX()] = 'a';
        MAP[FINISH_POINT.getY()][FINISH_POINT.getX()] = 'z';


        return findPaths(List.of(List.of(START_POINT))).stream().mapToInt(l -> l.size()).min().orElse(0) - 1;
    }


    public Integer partTwo(List<String> input) {
        return 0;
    }

    private List<List<Point>> findPaths(List<List<Point>> foundPaths) {

        List<List<Point>> newList = new ArrayList<>();

        for (List<Point> path : foundPaths) {
            Point lastPoint = path.get(path.size() - 1);
            if (FINISH_POINT.equals(lastPoint)) {
                return List.of(path);
            } else {
                for (Point point : findNextSteps(lastPoint, path)) {
                    List<Point> newPath = new ArrayList<>();
                    newPath.addAll(path);
                    newPath.add(point);
                    newList.add(newPath);
                }
            }
        }
        return findPaths(newList);
    }

    private List<Point> findNextSteps(Point currentPoint, List<Point> currentPath) {
        int x = currentPoint.getX();
        int y = currentPoint.getY();
        List<Point> foundPoints = new ArrayList<>();
        List<Point> pointsForCheck = List.of(
                new Point(x, y - 1), // up
                new Point(x, y + 1), // down
                new Point(x - 1, y), // left
                new Point(x + 1, y)  // right
        );

        for (Point newPoint : pointsForCheck) {
            if (Range.between(0, MAP.length - 1).contains(newPoint.getY())
                    && Range.between(0, MAP[0].length - 1).contains(newPoint.getX())) {
                if (UNXEPLORED.contains(newPoint) && !currentPath.contains(newPoint) && canGoHere(currentPoint, newPoint)) {
                    UNXEPLORED.remove(newPoint);
                    foundPoints.add(newPoint);
                }
            }
        }
        return foundPoints;
    }

    private Point findPosition(char[][] map, char position) {
        for (int y = 0; y < map.length; y++) {
            char[] line = map[y];
            for (int x = 0; x < line.length; x++) {
                if (map[y][x] == position) {
                    return new Point(x, y);
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
                UNXEPLORED.add(new Point(x, y));
            }
        }
        return map;
    }

    private boolean canGoHere(Point from, Point to) {
        return getCharAlphabetPosition(MAP[from.getY()][from.getX()]) + 1 >= getCharAlphabetPosition(MAP[to.getY()][to.getX()]);
    }

    private int getCharAlphabetPosition(char input) {
        return (String.valueOf(input).codePointAt(0)) - 'a' + 1;
    }
}
