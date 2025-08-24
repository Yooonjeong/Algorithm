import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<in.length(); i++){
            char at = in.charAt(i);
            if(at == '('){
                stack.push(at);
            }
            else if(at == '*' || at == '/'){
                while(!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')){
                    sb.append(stack.pop());
                }
                stack.push(at);
            }
            else if(at == '+' || at == '-'){
                while(!stack.isEmpty() && stack.peek() != '('){
                    sb.append(stack.pop());
                }
                stack.push(at);
            }
            else if(at == ')'){
                while(!stack.isEmpty() && stack.peek() != '('){
                    sb.append(stack.pop());
                }
                stack.pop();
            }
            else{
                sb.append(at);
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
    }
}
