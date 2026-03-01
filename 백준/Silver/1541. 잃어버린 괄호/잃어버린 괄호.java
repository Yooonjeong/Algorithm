import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splited = br.readLine().split("\\-");

        int sum = 0;
        for (int i=0; i<splited.length; i++) {
            String[] nums = splited[i].split("\\+");

            int inSum = 0;
            for (String num : nums) {
                inSum += Integer.parseInt(num);
            }
            
            sum += (i == 0) ? inSum : -inSum;
        }

        System.out.println(sum);        
    }
}