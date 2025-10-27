package racingcar.domain;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        String trimmed = name == null ? "" : name.trim();
        if (trimmed.length() < 1 || trimmed.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1~5자여야 합니다.");
        }
        this.name = trimmed;
        this.position = 0;
    }

    public void move(boolean canMove) {
        if (canMove) {
            position += 1;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
