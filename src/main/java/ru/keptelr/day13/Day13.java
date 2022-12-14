package ru.keptelr.day13;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day13 {

    public boolean isValidPackage(Pair<List<Integer>, List<Integer>> pkg) {
        List<Integer> left = pkg.getLeft();
        List<Integer> right = pkg.getRight();

        for (int i = 0; i < left.size(); i++) {
            try {
                if (left.get(i) > right.get(i)) {
                    return false;
                }
                if (left.get(i) < right.get(i)) {
                    return true;
                }
            } catch (Exception ex) {
                if (left.size() > right.size()) {
                    return false;
                }
            }
        }
        return true;
    }

    private List<Pair<Package, Package>> parsePackages(List<String> input) {
        List<Pair<Package, Package>> packages = new ArrayList<>();
        for (int i = 0; i < input.size(); i = i + 3) {
            if (input.get(i).startsWith("[") && input.get(i + 1).startsWith("[")) {
                String leftPackageStr = input.get(i).substring(1, input.get(i).length() - 1);
                String rightPackageStr = input.get(i+1).substring(1, input.get(i+1).length() - 1);
                packages.add(Pair.of(Package.from(leftPackageStr), Package.from(rightPackageStr)));
            } else {
                throw new RuntimeException("");
            }
        }
        return packages;
    }

    private List<Pair<List<Integer>, List<Integer>>> parse(List<String> input) {
        List<Pair<List<Integer>, List<Integer>>> packages = new ArrayList<>();
        for (int i = 0; i < input.size(); i = i + 3) {
            if (input.get(i).startsWith("[") && input.get(i + 1).startsWith("[")) {
               packages.add(
                       Pair.of(
                              parseNumbers(input.get(i)),
                              parseNumbers(input.get(i+1))
                       )
               );
            } else {
                throw new RuntimeException("");
            }
        }
        return packages;
    }

    private List<Integer> parseNumbers(String input) {
        input = input.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(",", "");

        List<Integer> result = new ArrayList<>();
        for (String sym : input.strip().split("")) {
            if (sym.equals("")) {
                continue;
            }
            result.add(Integer.parseInt(sym.strip()));
        }
        return result;
    }

    public Integer partOne(List<String> input) {
        List<Pair<List<Integer>, List<Integer>>> parsePackages = parse(input);

        int validCount = 0;
        for ( Pair<List<Integer>, List<Integer>> pair : parsePackages) {
           if (isValidPackage(pair)) {
               validCount++;
           }
        }
        return validCount;
    }

    public Integer partTwo(List<String> input) {
        return 0;
    }
}
