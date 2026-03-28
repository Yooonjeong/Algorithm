import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());

            String a = st.nextToken();
            String b = st.nextToken();

            long mult = Long.parseLong(a) * Long.parseLong(b);

            if (wrongMult(a, b) == mult) {
                sb.append("1").append("\n");
            }
            else {
                sb.append("0").append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    private static long wrongMult(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();

        StringBuilder sum = new StringBuilder();
        int i=0;
        for (i=0; i<Math.min(aLen, bLen); i++) {
            int aAt = Character.getNumericValue(a.charAt(aLen-i-1));
            int bAt = Character.getNumericValue(b.charAt(bLen-i-1));

            sum.insert(0, aAt * bAt);
        }

        if (aLen > bLen) {
            while (aLen-i>0) {
                sum.insert(0, Character.getNumericValue(a.charAt(aLen-i-1)));
                i++;
            }
        }
        else if (bLen > aLen) {
            while (bLen-i>0) {
                sum.insert(0, Character.getNumericValue(b.charAt(bLen-i-1)));
                i++;
            }
        }

        return Long.parseLong(sum.toString());
    }
}