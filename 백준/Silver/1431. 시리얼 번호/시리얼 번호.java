import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
    private static class Number implements Comparable<Number> {
        String str;
        int numSum = 0;

        Number(String str) {
            this.str = str;
            
            for (int i=0; i<str.length(); i++) {
                char at = str.charAt(i);
                numSum += Character.isDigit(at) ? Character.digit(at, 10) : 0;
            }
        }

        @Override
        public int compareTo(Number num) {
            int cLen = compareLength(num);
            if (cLen != 0) return cLen;

            int cSum = compareNumSum(num);
            if (cSum != 0) return cSum;

            return compareStr(num);
        }

        public int compareLength(Number num) {
            return Integer.compare(this.str.length(), num.str.length());
        }

        public int compareNumSum(Number num) {
            return Integer.compare(this.numSum, num.numSum);
        }

        public int compareStr(Number num) {
            return this.str.compareTo(num.str);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeSet<Number> numbers = new TreeSet<>();

        for (int i=0; i<n; i++) {
            numbers.add(new Number(br.readLine()));
        }

        StringBuilder sb = new StringBuilder();
        for (Number number : numbers) {
            sb.append(number.str).append("\n");
        }

        System.out.println(sb.toString());
    }
}