package ru.keptelr.day01;

import lombok.Data;

@Data
public class Elve {

    public Elve() {
        this.calories = 0L;
    }

    private Long calories;
}
