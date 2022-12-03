package ru.keptelr.day03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.Data;

@Data
public class Rucksack {

    private String firstCompartment;
    private String secondCompartment;

    public Rucksack(String content) {
        this.firstCompartment = content.substring(0, content.length()/2);
        this.secondCompartment = content.substring(content.length()/2);   
    }

    private Set<Character> findDuplicates() {
        Set<Character> duplicates = new HashSet();
        for (Character character : firstCompartment.toCharArray()) {
            if (secondCompartment.indexOf(character) > -1) {
                duplicates.add(character);
            } 
        }
        return duplicates;
    }

    private int getPosition(char input) {
        return (String.valueOf(input).toLowerCase().codePointAt(0))-'a'+1;
      }

    public int getPriority() {
        Set<Character> duplicates = findDuplicates();
        if (duplicates.size() != 1) {
            throw new RuntimeException("whats wrong with you?"); // whats wring with me?
        }
        char input = duplicates.iterator().next();
        int priority = 0;
        if (Character.isUpperCase(input)) {
            priority = priority + 26;
        }
        return priority + getPosition(input);
    }
    
}
