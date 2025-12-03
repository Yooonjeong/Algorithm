import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (char c : s.toCharArray()) {
            left.push(c);
        }

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "L":
                    if (!left.isEmpty()) right.push(left.pop());
                    break;
                case "D":
                    if (!right.isEmpty()) left.push(right.pop());
                    break;
                case "B":
                    if (!left.isEmpty()) left.pop();
                    break;
                case "P":
                    char ch = st.nextToken().charAt(0);
                    left.push(ch);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : left) sb.append(c);
        while (!right.isEmpty()) sb.append(right.pop());
        System.out.println(sb);
    }
}
