package racingcar.domain;

public class Position {

    private final int position;

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("위치는 0 이상이어야 합니다.");
        }
        this.position = position;
    }

    public Position advance(boolean isMoveable) {
        if (isMoveable) {
            return new Position(position + 1);
        }
        return this;
    }

    public int getPosition() {
        return position;
    }

}

