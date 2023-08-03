package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 성적이_낮은_순서대로_학생_출력하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<Student> students = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split(" ");
			students.add(new Student(split[0], Integer.parseInt(split[1])));
		}

		Collections.sort(students);

		for (Student student : students) {
			System.out.print(student.name + " ");
		}
	}
}

class Student implements Comparable<Student> {
	String name;
	int score;

	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	@Override
	public int compareTo(Student o) {
		return this.score - o.score;
	}
}
