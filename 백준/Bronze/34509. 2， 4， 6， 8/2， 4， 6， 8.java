public class Main {
    public static void main(String[] args) {
        for (int i = 10; i <= 99; i++) {
            String s = String.valueOf(i);
            
            if (s.contains("8")) continue;

            String reversedStr = new StringBuilder(s).reverse().toString();
            int reversed = Integer.parseInt(reversedStr);

            int sum = (s.charAt(0) - '0') + (s.charAt(1) - '0');

            if (reversed % 4 == 0 && sum % 6 == 0) {
                System.out.println(i);
                break;
            }
        }
    }
}