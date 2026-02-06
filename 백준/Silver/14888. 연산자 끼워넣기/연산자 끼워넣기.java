import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static char[] operator = {'+', '-', '*', '/'};
    private static int[] num;
    private static int n;
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;
    private static int[] operCnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        num = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        operCnt = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<4; i++) {
            operCnt[i] = Integer.parseInt(st.nextToken());
        }

        calcAll(0, num[0]);

        System.out.println(max+"\n"+min);
    }

    private static void calcAll(int idx, int sum) {
        if (idx == n-1) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for (int i=0; i<4; i++) {
            if (operCnt[i] <= 0) continue;

            char oper = operator[i];
            operCnt[i]--;
            calcAll(idx+1, calc(sum, num[idx+1], oper));
            operCnt[i]++;
        }
    }

    private static int calc(int a, int b, char operator) {
        switch(operator) {
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                int sign = a >= 0 ? 1 : -1;
                return sign * (Math.abs(a) / b);
            default:
                return a+b;
        }
    }
}