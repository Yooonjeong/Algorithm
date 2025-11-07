import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        long rem = 0;
        int mod = 20000303;
        for (int i=0; i<arr.length; i++) {
            rem = (rem*10+arr[i]-'0') % mod;
        }
        System.out.println(rem);
    }
}
