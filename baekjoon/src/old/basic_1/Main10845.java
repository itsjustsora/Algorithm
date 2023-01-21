package old.basic_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10845 {

    private static int[] que = new int[10001];
    private static int first = 0;
    private static int last = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            switch (command) {
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(pop()).append("\n");
                    break;
                case "size":
                    sb.append(size()).append("\n");
                    break;
                case "empty":
                    sb.append(empty()).append("\n");
                    break;
                case "front":
                    sb.append(front()).append("\n");
                    break;
                case "back":
                    sb.append(back()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }

    public static void push(int num) {
        que[last] = num;
        last++;
    }

    public static int pop() {
        if(size() == 0) {
            return -1;
        } else {
            int value = que[first];
            first++;
            return value;
        }
    }

    public static int size() {
        return last - first;
    }

    public static int empty() {
        if(size() == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int front() {
        if(size() == 0) {
            return -1;
        } else {
            return que[first];
        }
    }

    public static int back() {
        if(size() == 0) {
            return -1;
        } else {
            return que[last - 1];
        }
    }
}
