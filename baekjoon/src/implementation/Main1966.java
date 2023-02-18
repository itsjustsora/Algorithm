package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1966 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());	// 테스트케이스의 수
		Queue<Document> queue = new LinkedList();

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());	// 문서의 개수
			int M = Integer.parseInt(st.nextToken());	// 몇 번째로 인쇄되었는지 궁금한 문서가 현재 몇 번째에 있는지

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				queue.add(new Document(j, Integer.parseInt(st.nextToken())));
			}

			int cnt = 1;

			while (!queue.isEmpty()) {
				Document current = queue.poll();
				boolean flag = true;

				Iterator itr = queue.iterator();
				while (itr.hasNext()) {
					Document value = (Document) itr.next();
					if (current.priority < value.priority) {
						flag = false;
						break;
					}
				}

				if (!flag) {
					queue.add(current);
				} else {
					if (current.num == M) {
						System.out.println(cnt);
					} else {
						cnt++;
					}
				}
			}
		}
	}
}

class Document {
	int num;
	int priority;

	public Document(int num, int priority) {
		this.num = num;
		this.priority = priority;
	}
}
