import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<BigInteger> pq = new PriorityQueue<>();

        for (int i=0; i<n; i++) {
            String in = br.readLine();

            StringBuilder number = new StringBuilder();
            for (int j=0; j<in.length(); j++) {
                char at = in.charAt(j);
                if (at>='0' && at<='9') {
                        number.append(at);
                }
                else if(number.length()>0) {
                    pq.add(new BigInteger(number.toString()));
                    number.setLength(0);
                }
            }
            if (number.length()>0) {
                pq.add(new BigInteger(number.toString()));
            }
        }

        StringBuilder ans = new StringBuilder();
        while(!pq.isEmpty()) {
            ans.append(pq.poll()).append("\n");
        }
        System.out.println(ans.toString());
    }
}
