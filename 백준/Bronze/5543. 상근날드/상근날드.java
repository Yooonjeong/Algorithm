
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arr[] = new int[5];
		int minb=Integer.MAX_VALUE, mind=Integer.MAX_VALUE;
		for(int i=0; i<3; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(minb>arr[i]) {
				minb = arr[i];
			}
		}
		for(int i=3; i<5; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(mind>arr[i]) {
				mind = arr[i];
			}
		}
		System.out.println(minb+mind-50);
	}

}
