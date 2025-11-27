import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        Stack<Integer> stack = new Stack();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i=n-1; i>=0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            ans[i] = stack.isEmpty() || stack.peek() <= arr[i] ? -1 : stack.peek();
            stack.push(arr[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++){
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
