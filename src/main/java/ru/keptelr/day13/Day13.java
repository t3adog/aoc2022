package ru.keptelr.day13;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

public class Day13 {

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

    public Integer partOne(List<String> input) {
        List<Pair<Package, Package>> parsePackages = parsePackages(input);

        for (Pair<Package, Package> pair : parsePackages) {
            System.out.println("Левый " + pair.getLeft());
            System.out.println("Правый " + pair.getRight());
            System.out.println("~~~~~");
        }
        return 0;
    }

    public Integer partTwo(List<String> input) {
        return 0;
    }
}
