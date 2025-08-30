import java.time.LocalDate;
import java.time.ZoneId;

public class Main {

    public static void main(String[] args) {
        LocalDate utcDate = LocalDate.now(ZoneId.of("UTC"));

        System.out.println(utcDate.getYear());
        System.out.printf("%02d%n", utcDate.getMonthValue());
        System.out.printf("%02d%n", utcDate.getDayOfMonth());
    }
}