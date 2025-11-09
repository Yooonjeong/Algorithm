import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            char[] cmds = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            String arrStr = br.readLine();

            Deque<Integer> deque = new ArrayDeque<>();
            // 빈 배열이 아닐 경우에만 파싱
            if (n > 0) {
                String[] nums = arrStr.substring(1, arrStr.length() - 1).split(",");
                for (String num : nums) {
                    deque.add(Integer.parseInt(num));
                }
            }

            boolean dir = true; // true = 정방향, false = 역방향
            boolean error = false;

            for (char c : cmds) {
                if (c == 'R') {
                    dir = !dir;
                } else if (c == 'D') {
                    if (deque.isEmpty()) {
                        sb.append("error\n");
                        error = true;
                        break;
                    }
                    if (dir) deque.pollFirst();
                    else deque.pollLast();
                }
            }

            if (error) continue;

            sb.append("[");
            if (!deque.isEmpty()) {
                if (dir) {
                    while (!deque.isEmpty()) {
                        sb.append(deque.pollFirst());
                        if (!deque.isEmpty()) sb.append(",");
                    }
                } else {
                    while (!deque.isEmpty()) {
                        sb.append(deque.pollLast());
                        if (!deque.isEmpty()) sb.append(",");
                    }
                }
            }
            sb.append("]\n");
        }

        System.out.print(sb.toString());
    }
}
