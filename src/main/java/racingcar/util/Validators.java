package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 요구사항:
 * - 들여쓰기 depth ≤ 2
 * - 3항 연산자 금지
 * - 메서드는 한 가지 일만 수행
 * - 외부 라이브러리 사용 금지 (standard library만 사용)
 */
public final class Validators {

    private Validators() { }

    /**
     * 이름 문자열을 쉼표(,)로 분리해 트림하고 검증한다.
     * - 공백/빈 입력 금지
     * - 연속 구분자(,,) 금지
     * - 각 이름 길이 1~5자
     * - 위반 시 IllegalArgumentException
     */
    public static List<String> parseNames(String line) {
        if (line == null) {
            throw new IllegalArgumentException("이름 입력이 null입니다.");
        }

        String trimmed = line.trim();
        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException("이름을 최소 1개 이상 입력해야 합니다.");
        }
        if (trimmed.contains(",,")) {
            throw new IllegalArgumentException("빈 이름은 허용되지 않습니다.");
        }

        List<String> names = Arrays.stream(trimmed.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        if (names.isEmpty()) {
            throw new IllegalArgumentException("이름을 최소 1개 이상 입력해야 합니다.");
        }
        for (String name : names) {
            if (name.isEmpty()) {
                throw new IllegalArgumentException("빈 이름은 허용되지 않습니다.");
            }
            int len = name.length();
            if (len < 1 || len > 5) {
                throw new IllegalArgumentException("자동차 이름은 1~5자여야 합니다.");
            }
        }
        return names;
    }

    /**
     * 시도 횟수 문자열을 정수로 파싱하고 1 이상을 강제한다.
     * - 정수 아님/0 이하 → IllegalArgumentException
     */
    public static int parseTryCount(String line) {
        if (line == null) {
            throw new IllegalArgumentException("시도 횟수 입력이 null입니다.");
        }
        String trimmed = line.trim();
        int n;
        try {
            n = Integer.parseInt(trimmed);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 정수로 입력해야 합니다.");
        }
        if (n <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 정수여야 합니다.");
        }
        return n;
    }
}
