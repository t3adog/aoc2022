package ru.keptelr.day02;

import lombok.Data;

@Data
public class Step implements Comparable<Step> {
    private Shape shape;
    private Integer score;

    public Step(String shape) {
        if (shape.equals("A") || shape.equals("X")) {
            this.shape = Shape.rock;
        }
        if (shape.equals("B") || shape.equals("Y")) {
            this.shape = Shape.paper;
        }
        if (shape.equals("C") || shape.equals("Z")) {
            this.shape = Shape.scissors;
        }
        this.score = calcScores(this.getShape());
    }

    public Step(Shape shape) {
        this.shape = shape;
        this.score = calcScores(this.shape);
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
        throw new RuntimeException("whats wrong with you?"); //whats wrong with me?
    }

    private int calcScores(Shape shape) {
        switch(shape) {
            case rock: return 1;
            case paper: return 2;
            case scissors: return 3;
        }
        throw new RuntimeException("whats wrong with you?"); //whats wrong with me?
    }

}
