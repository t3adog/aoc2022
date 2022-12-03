package ru.keptelr.day03;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.Data;

@Data
public class Rucksack {

    private String firstCompartment;
    private String secondCompartment;

    public Rucksack(String content) {
        this.firstCompartment = content.substring(0, content.length() / 2);
        this.secondCompartment = content.substring(content.length() / 2);
    }

    public Set<Character> findDuplicates() {
        Set<Character> duplicates = new HashSet<>();
        for (Character character : firstCompartment.toCharArray()) {
            if (secondCompartment.indexOf(character) > -1) {
                duplicates.add(character);
            }
        }
        return duplicates;
    }

    public List<Character> getFullContent() {
        return (firstCompartment + secondCompartment).chars().mapToObj(c -> (char) c).collect(Collectors.toList());
    }

}
