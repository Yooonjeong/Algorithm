
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

   public static void main(String[] args) throws NumberFormatException, IOException {
      BigInteger a,b,c;
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      a = BigInteger.valueOf(Long.parseLong(st.nextToken()));
      b = BigInteger.valueOf(Long.parseLong(st.nextToken()));
      c = BigInteger.valueOf(Long.parseLong(st.nextToken()));
      
      System.out.println(a.modPow(b, c));
   }

}
