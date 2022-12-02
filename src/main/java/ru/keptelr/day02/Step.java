package ru.keptelr.day02;

import lombok.Data;

@Data
public class Step implements Comparable<Step> {
    private Shape shape;
    private Integer score;

    public Step(String shape) {
        if (shape.equals("A") || shape.equals("X")) {
            this.shape = Shape.rock;
            this.score = 1;
        }
        if (shape.equals("B") || shape.equals("Y")) {
            this.shape = Shape.paper;
            this.score = 2;
        }
        if (shape.equals("C") || shape.equals("Z")) {
            this.shape = Shape.scissors;            
            this.score = 3;
        }
    }

    @Override
    public int compareTo(Step step) {
        if (this.getShape() == step.getShape()) {
            return 0;
        }
        if (this.getShape() == Shape.rock) {
          if (step.getShape() == Shape.scissors) {
            return 1;
          }
          if (step.getShape() == Shape.paper) {
            return -1;
          }
        }
        if (this.getShape() == Shape.scissors) {
            if (step.getShape() == Shape.rock) {
                return -1;
            }
            if (step.getShape() == Shape.paper) {
                return 1;
            }
        }
        if (this.getShape() == Shape.paper) {
            if (step.getShape() == Shape.rock) {
                return 1;
            }
            if (step.getShape() == Shape.scissors) {
                return -1;
            }
        }
        throw new RuntimeException("whats wrong with you?");
    }


}
