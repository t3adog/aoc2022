package ru.keptelr.day13;

import com.google.gson.Gson;
import org.apache.commons.lang3.tuple.Pair;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Day13 {

    public List<Pair<List<Object>, List<Object>>> parsePackages(List<String> input) {
        Gson parser = new Gson();
        var result = new ArrayList<Pair<List<Object>, List<Object>>>();

        for (int i = 0; i < input.size(); i = i + 3) {
            if (input.get(i).startsWith("[") && input.get(i + 1).startsWith("[")) {
                result.add(
                        Pair.of(
                                parser.fromJson(input.get(i), List.class),
                                parser.fromJson(input.get(i + 1), List.class)
                        )
                );
            } else {
                throw new RuntimeException("");
            }
        }
        return result;
    }

    public Integer partOne(List<String> input) {
        var packages = parsePackages(input);

        List<Integer> validIndicies = new ArrayList<>();
        for (int i = 0; i < packages.size(); i++) {
            var pkg = packages.get(i);
            if (isValidPkg(pkg)) {
                validIndicies.add(i + 1);
            }

        }
        //System.out.println(validIndicies); // 6235
        return validIndicies.stream().mapToInt(Integer::intValue).sum();
    }

    public boolean isValidPkg(Pair<List<Object>, List<Object>> pkg) {
        var left = pkg.getLeft();
        var right = pkg.getRight();
        try {
            for (int i = 0; i < left.size(); i++) {
                var leftValue = left.get(i);
                var rightValue = right.get(i);

                if (leftValue instanceof Double && rightValue instanceof Double) {
                    Double leftDouble = (Double) leftValue;
                    Double rightDouble = (Double) rightValue;
                    if (rightDouble < leftDouble) {
                        return false;
                    }
                    if (left.size() != right.size() && right.size() < (i + 2)) {
                        if (rightDouble.equals(leftDouble)) {
                            return false;
                        }
                        if (rightDouble > leftDouble) {
                            return true;
                        }
                    }
                } else if (leftValue instanceof ArrayList && rightValue instanceof ArrayList) {
                    var leftList = (ArrayList) leftValue;
                    var rightList = (ArrayList) rightValue;
                    var res = isValidPkg(Pair.of(leftList, rightList));
                    if (!res) {
                        return res;
                    }
                } else if (leftValue instanceof ArrayList && rightValue instanceof Double) {
                    var leftList = (ArrayList) leftValue;
                    var rightList = List.of(rightValue);
                    var res = isValidPkg(Pair.of(leftList, rightList));
                    if (!res) {
                        return res;
                    }
                } else if (leftValue instanceof Double && rightValue instanceof ArrayList) {
                    var leftList = List.of(leftValue);
                    var rightList = (ArrayList) rightValue;
                    var res = isValidPkg(Pair.of(leftList, rightList));
                    if (!res) {
                        return res;
                    }
                }
            }
        } catch (IndexOutOfBoundsException ex) {
            return false;
            //return isValidPkg(Pair.of(List.of(left.get(left.size() -1)), List.of(right.get(right.size() - 1))));
        }

        return true;
    }

    public Integer partTwo(List<String> input) {
        return 0;
    }
}
