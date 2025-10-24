package racingcar.domain;

public class CarPosition {
    private int position;

    private CarPosition() {
        this.position = 0;
    }

    public static CarPosition generate() {
        return new CarPosition();
    }

    public void go() {
        position++;
    }

    public int getPosition() {
        return position;
    }
}
