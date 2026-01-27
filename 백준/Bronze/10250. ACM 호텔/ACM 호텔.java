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
		int T, H, W, N;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			// 층, 번호 계산
			int floor, num;
			if (N % H == 0) {
				floor = H;
				num = N / H;
			}
			else {
				floor = N % H;
				num = (N / H) + 1;
			}
			
			// 방 구하기
			String room = "";
			if (num < 10)
				room = String.valueOf(floor) + "0" + String.valueOf(num);
			else 
				room = String.valueOf(floor) + String.valueOf(num);
				
			System.out.println(room); 
		}
	}
}