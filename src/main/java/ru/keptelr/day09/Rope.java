package ru.keptelr.day09;

import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public interface Rope {

    Pair<Integer, Integer> getCurrentPosition();

    Pair<Integer, Integer> getPrevPosition();

    void move(Pair<Integer, Integer> newPosition);

    List<Pair<Integer, Integer>> getPositionsHistory();
}
