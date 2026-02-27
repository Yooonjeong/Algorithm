import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String title = br.readLine();

        String[] keywords = {"social", "history", "language", "literacy"};

        for (String keyword : keywords) {
            if (title.contains(keyword)) {
                System.out.println("digital humanities");
                return;
            }
        }

        System.out.println("public bigdata");
    }
}