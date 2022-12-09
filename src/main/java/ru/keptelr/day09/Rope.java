package ru.keptelr.day09;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Data
public class Rope {

    private Point currentPosition;
    private final List<Point> positionsHistory;

    public Rope(Point point) {
        this.currentPosition = point;
        positionsHistory = new ArrayList<>();
    }

    public Point getPrevPosition() {
        return positionsHistory.get(positionsHistory.size() - 1);
    }

    public void move(Point newPosition) {
        positionsHistory.add(currentPosition);
        this.currentPosition = newPosition;
    }

    public void handleInstruction(Direction direction, int step) {
        switch (direction) {
            case up: {
                this.move(new Point(this.getCurrentPosition().getX(), this.getCurrentPosition().getY() + step));
                break;
            }
            case down: {
                this.move(new Point(this.getCurrentPosition().getX(), this.getCurrentPosition().getY() - step));
                break;
            }
            case left: {
                this.move(new Point(this.getCurrentPosition().getX() - step, this.getCurrentPosition().getY()));
                break;
            }
            case right: {
                this.move(new Point(this.getCurrentPosition().getX() + step, this.getCurrentPosition().getY()));
                break;
            }
        }
    }

    public int getUniqPositionCount() {
        this.positionsHistory.add(this.getCurrentPosition());
        return new HashSet<>(this.positionsHistory).size();

    }

    public boolean isNeighbor(Rope rope) {
        return Math.abs(this.currentPosition.getX() - rope.getCurrentPosition().getX()) <= 1
                && Math.abs(this.currentPosition.getY() - rope.currentPosition.getY()) <= 1;
    }
}
