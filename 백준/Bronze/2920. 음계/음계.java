import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.HashMap;
import java.util.LinkedList;

public class Main 
{
	public static void main(String[] args) throws IOException {
	
		// 입력 받기
		int[] note = new int[8];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		// 증감 검사
		boolean isAsc = true, isDesc = true;
		for (int i = 0; i < 8; i++) {
			note[i] = Integer.parseInt(st.nextToken());
			if (i > 0 && note[i] != note[i - 1] + 1) isAsc = false;
			if (i > 0 && note[i] != note[i - 1] - 1) isDesc = false;
		}
		// 정답 출력
		if (isAsc) System.out.println("ascending");
		else if (isDesc) System.out.println("descending");
		else System.out.println("mixed");
	}
}