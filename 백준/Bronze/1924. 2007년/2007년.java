
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[] month = {31,28,31,30,31,30,31,31,30,31,30,31};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int rst=0;
		
		for(int i=1; i<x; i++) {
			rst += month[i-1];
		}
		rst += y;
		String answer="";
		switch(rst%7) {
		case 0:
			answer = "SUN";
			break;
		case 1:
			answer = "MON";
			break;
		case 2:
			answer = "TUE";
			break;
		case 3:
			answer = "WED";
			break;
		case 4:
			answer = "THU";
			break;
		case 5:
			answer = "FRI";
			break;
		case 6:
			answer = "SAT";
			break;
		}
		System.out.println(answer);
	}

}
