import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Long> stack = new Stack<>();

        long ans = 0;
        for (int i=0; i<n; i++) {
            long in = Long.parseLong(br.readLine());

            while(!stack.isEmpty() && stack.peek() <= in) {
                stack.pop();
            }

            ans += stack.size();

            stack.push(in);
        }

        System.out.println(ans);
    }
}
