package ru.keptelr.day05;

import java.util.List;

import lombok.Data;

@Data
public class Instruction {

    private String from;
    private String to;
    private Integer count;

    public Instruction(String instruction) {
        List<String> insctructionElements = List.of(
                instruction.replaceAll("move ", "")
                        .replaceAll("from ", "")
                        .replaceAll("to ", "").split(" "));

        this.count = Integer.parseInt(insctructionElements.get(0));
        this.from = insctructionElements.get(1);
        this.to = insctructionElements.get(2);
    }

}
