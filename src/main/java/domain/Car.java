package domain;

import java.util.Comparator;
import java.util.stream.IntStream;

public class Car {
    public static final int MAX_NAME_LEN = 5;
    public static final Comparator<Car> positionComparator = (o1, o2) -> o1.position - o2.position;

    private final String name;
    private int position;

    public Car(String name, int position) {
        if (name == null) {
            throw new IllegalArgumentException("name 이 null 입니다.");
        }
        if (name.length() == 0) {
            throw new IllegalArgumentException("name 이 빈문자열입니다.");
        }
        if (MAX_NAME_LEN < name.length()) {
            throw new IllegalArgumentException(
                    String.format("입력된 이름의 길이가 너무 깁니다. %d 자 이하로 입력해주세요. (in: %s)", MAX_NAME_LEN, name));
        }

        this.name = name;
        this.position = position;
    }

    public Car(String name) {
        this(name, 0);
    }

    public String getName() {
        return name;
    }

    public String getStatusString() {
        StringBuilder sb = new StringBuilder();

        sb.append(name);
        sb.append(" : ");

        for (int i = 0; i < position; i++) {
            sb.append("-");
        }

        return sb.toString();
    }

    public void move() {
        position++;
    }
}
