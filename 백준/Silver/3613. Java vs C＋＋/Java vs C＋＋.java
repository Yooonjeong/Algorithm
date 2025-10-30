import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine();

        // 예외 1: 빈 문자열
        if (in.isEmpty()) {
            System.out.println("Error!");
            return;
        }

        // 예외 2: 첫 글자가 대문자 or '_' 시작/끝
        if (Character.isUpperCase(in.charAt(0)) || in.charAt(0) == '_' || in.charAt(in.length() - 1) == '_') {
            System.out.println("Error!");
            return;
        }

        boolean hasUnderscore = in.contains("_");
        boolean hasUppercase = in.chars().anyMatch(Character::isUpperCase);

        // 둘 다 나오면 에러
        if (hasUnderscore && hasUppercase) {
            System.out.println("Error!");
            return;
        }

        // C++ → Java
        if (hasUnderscore) {
            if (in.contains("__")) { // 연속 언더바 금지
                System.out.println("Error!");
                return;
            }
            String[] parts = in.split("_");
            StringBuilder sb = new StringBuilder(parts[0]);
            for (int i = 1; i < parts.length; i++) {
                sb.append(Character.toUpperCase(parts[i].charAt(0)))
                  .append(parts[i].substring(1));
            }
            System.out.println(sb);
        }
        // Java → C++
        else if (hasUppercase) {
            StringBuilder sb = new StringBuilder();
            for (char c : in.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    sb.append('_').append(Character.toLowerCase(c));
                } else {
                    sb.append(c);
                }
            }
            System.out.println(sb);
        }
        // 이미 올바른 소문자 단어 하나라면 그대로 출력
        else {
            System.out.println(in);
        }
    }
}
