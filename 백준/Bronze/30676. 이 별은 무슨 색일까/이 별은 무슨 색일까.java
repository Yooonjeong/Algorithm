import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());

        System.out.println(
            l >= 620 ? "Red" :
            l >= 590 ? "Orange" :
            l >= 570 ? "Yellow" :
            l >= 495 ? "Green" :
            l >= 450 ? "Blue" :
            l >= 425 ? "Indigo" :
            "Violet"
        );
    }
}