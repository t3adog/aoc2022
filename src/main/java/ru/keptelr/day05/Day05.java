package ru.keptelr.day05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class Day05 {

    private List<Instruction> parseInstructions(List<String> input) {
        List<Instruction> instructions = new ArrayList<>();
        for (String line : input) {
            if (!line.startsWith("move")) {
                continue;
            }
            instructions.add(new Instruction(line));
        }
        return instructions;
    }

    private Map<String, List<String>> parseStacks(List<String> input) {
        Map<String, List<String>> stacks = new HashMap<>();
        for (String line : input) {
            if (line.startsWith(" 1")) {
                for (String number : line.split(" ")) {
                    if (StringUtils.isNotBlank(number)) {
                        stacks.put(number.trim(), new LinkedList<String>());
                    }
                }
                break;
            }
        }

        for (String line : input) {
            if (line.startsWith(" 1")) {
                break;
            }
            int crateStrSize = 4;
            int index = 0;
            List<String> crates = new ArrayList<>();
            while (index < line.length()) {
                String crate = line.substring(index, Math.min(index + crateStrSize, line.length()));
                crates.add(crate);
                index += crateStrSize;
            }

            for (int i = 0; i < crates.size(); i++) {
                String crate = crates.get(i).replaceAll("\\[", "").replaceAll("\\]", "").trim();
                if (StringUtils.isNotBlank(crate)) {
                    String key = String.valueOf(i + 1);
                    stacks.get(key).add(crate);
                }

            }
        }

        return stacks;
    }

    public String partOne(List<String> input) {
        Map<String, List<String>> stacks = parseStacks(input);
        List<Instruction> instructions = parseInstructions(input);

        for (Instruction instruction : instructions) {
            for (int i = 0; i < instruction.getCount(); i++) {
                stacks.get(instruction.getTo()).add(0, stacks.get(instruction.getFrom()).get(0));
                stacks.get(instruction.getFrom()).remove(0);
            }
        }
        String result = "";
        for (String key : stacks.keySet()) {
            result = result + stacks.get(key).get(0);
        }
        return result;
    }

    public String partTwo(List<String> input) {
        Map<String, List<String>> stacks = parseStacks(input);
        List<Instruction> instructions = parseInstructions(input);

        for (Instruction instruction : instructions) {
            List<String> cratesForMove = new ArrayList<>();
            for (int i = 0; i < instruction.getCount(); i++) {
                cratesForMove.add(0, stacks.get(instruction.getFrom()).get(0));
                stacks.get(instruction.getFrom()).remove(0);
            }

            for (String crate : cratesForMove) {
                stacks.get(instruction.getTo()).add(0, crate);
            }
        }
        String result = "";
        for (String key : stacks.keySet()) {
            result = result + stacks.get(key).get(0);
        }
        return result;
    }

}
