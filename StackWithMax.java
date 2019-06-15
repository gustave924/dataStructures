import java.util.*;
import java.io.*;

class StackWithMax {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public void solve() throws IOException {
        FastScanner scanner = new FastScanner();
        int queries = scanner.nextInt();
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> maxStack = new Stack<>();

        for (int qi = 0; qi < queries; ++qi) {
            String operation = scanner.next();
            if ("push".equals(operation)) {
                int value = scanner.nextInt();
                stack.push(value);
                if (maxStack.isEmpty()){
                    maxStack.push(value);
                }else if(maxStack.peek() <= value){
                    maxStack.push(value);
                }
            } else if ("pop".equals(operation)) {
                if(maxStack.peek().intValue() == stack.peek().intValue()){
                    maxStack.pop();
                }
                stack.pop();
            } else if ("max".equals(operation)) {
                if (!maxStack.isEmpty())
                    System.out.println(maxStack.peek());
                else
                    System.out.println("Stack is empty");
            }
        }
    }

    static public void main(String[] args) throws IOException {
        new StackWithMax().solve();
    }
}
