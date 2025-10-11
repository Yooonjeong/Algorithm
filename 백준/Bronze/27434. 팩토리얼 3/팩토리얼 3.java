import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if(n==0) {
            System.out.println(1);
            return;
        }
        System.out.println(fact(1, n));
    }
    private static BigInteger fact(int l, int r) {
        if (l > r) return BigInteger.ONE;
        if (l == r) return BigInteger.valueOf(l);
        int mid = (l+r)/2;
        return fact(l, mid).multiply(fact(mid+1, r));
    }
}
