import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i=0; i<n; i++) {
            String word = br.readLine();
            cnt += isGoodWord(word);
        }

        System.out.println(cnt);
    }

    private static int isGoodWord(String word) {

        int len = word.length();
        if (len % 2 == 1) return 0;

        Deque<Character> stack = new ArrayDeque<>();
        
        for (int i=0; i<len; i++) {
            char at = word.charAt(i);

            if (!stack.isEmpty() && stack.peekLast() == at) {
                stack.pollLast();
            }
            else {
                stack.addLast(at);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}