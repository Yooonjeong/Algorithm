
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int h,w;
		h = Integer.parseInt(br.readLine());
		w = Integer.parseInt(br.readLine());
		double a = Math.min(h, w);
		System.out.printf("%.0f", a/2*100);
	}
}
