import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        LocalTime curTime = LocalTime.parse(br.readLine(), formatter);
        LocalTime startTime = LocalTime.parse(br.readLine(), formatter);

        int nowSec = curTime.toSecondOfDay();
        int startSec = startTime.toSecondOfDay();

        int diff = startSec - nowSec;
        if (diff < 0) diff += 24 * 3600;
        
        LocalTime result = LocalTime.ofSecondOfDay(diff);

        System.out.println(result.format(formatter));
    }
}
