
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

   public static void main(String[] args) throws IOException {
      int e,s,m;
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      e = Integer.parseInt(st.nextToken());
      s = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());
      int E=1,S=1,M=1,ans=1;
      while(true) {
         if(E==e&&S==s&&M==m) {
            System.out.println(ans);
            break;
         }
         if(E==15) {
            E=0;
         }
         if(S==28) {
            S=0;
         }
         if(M==19) {
            M=0;
         }
         E++; S++; M++;
         ans++;
      }
   }

}
