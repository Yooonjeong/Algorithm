import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String in = br.readLine();

        Deque<Character> stack = new ArrayDeque<>();
        char prev = '-';
        int cnt = 0;
        for (int i=0; i<in.length(); i++) {
            char at = in.charAt(i);
            if (at == '(') {
                stack.add(at);
            }
            else if (at == ')') {
                if (prev == '(') {
                    stack.poll();
                    cnt += stack.size();
                }
                else {
                    stack.poll();
                    cnt++;
                }
            }
            prev = at;
        }

        System.out.println(cnt);
    }
}