package ru.keptelr.day09;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

public class RopeImpl implements Rope {

    private Pair<Integer, Integer> currentPosition;
    private final List<Pair<Integer, Integer>> positionsHistory;

    public RopeImpl(Pair<Integer, Integer> startPosition) {
        this.currentPosition = startPosition;
        positionsHistory = new ArrayList<>();
        //positionsHistory.add(startPosition);
    }

    @Override
    public Pair<Integer, Integer> getCurrentPosition() {
        return this.currentPosition;
    }

    @Override
    public Pair<Integer, Integer> getPrevPosition() {
        return positionsHistory.get(positionsHistory.size() - 1);
    }

    @Override
    public void move(Pair<Integer, Integer> newPosition) {
        positionsHistory.add(currentPosition);
        this.currentPosition = newPosition;
    }

    @Override
    public List<Pair<Integer, Integer>> getPositionsHistory() {
        return this.positionsHistory;
    }
}
