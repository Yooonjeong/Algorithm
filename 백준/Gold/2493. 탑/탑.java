
import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<int[]> stack = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            int height = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty() && stack.peek()[1] < height){
                stack.pop();
            }

            if(stack.isEmpty()) sb.append("0 ");
            else {
                sb.append(stack.peek()[0]).append(" ");
            }
            stack.push(new int[]{i+1, height});
        }
        
        System.out.println(sb.toString());
    }
}