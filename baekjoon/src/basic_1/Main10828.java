package basic_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10828 {

    /**
     * 스택 구현하기
     * push X : 정수 X를 스택에 넣는 연산
     * pop : 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력. 값이 없으면 -1 반환
     * size : 스택에 들어있는 정수의 개수 출력
     * empty : 스택이 비어있으면 1, 아니면 0 출력
     * top : 스택의 가장 위에 있는 정수 출력. 값이 없으면 -1 반환
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        Stack stack = new Stack();

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(stack.pop()).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    sb.append(stack.empty()).append("\n");
                    break;
                case "top":
                    sb.append(stack.top()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }

    public static class Stack {
        static class Node {
            private Object data;
            private Node next;

            public Node(Object input) {
                this.data = input;
                this.next = null;
            }
        }

        private Node top;
        private int size = 0;

        public void push(Object item) {
            Node node = new Node(item);
            node.next = top;
            top = node;
            size++;
        }

        public Object pop() {
            if (top == null) {
                return -1;
            }
            Object item = top.data;
            top = top.next;
            size--;
            return item;
        }

        public Object size() {
            return size;
        }

        public Object empty() {
            if(top == null) return 1;
            return 0;
        }

        public Object top() {
            if(top == null) return -1;
            return top.data;
        }

    }
}

