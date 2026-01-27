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
		int num1, num2, num3;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		num1 = Integer.parseInt(st.nextToken());		
		st = new StringTokenizer(br.readLine());
		num2 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		num3 = Integer.parseInt(st.nextToken());

		int[] cnt = new int[10];
		int mlt = num1 * num2 * num3;
		while (mlt > 0) {
			int number = mlt % 10;
			cnt[number]++;
			mlt /= 10;
		}
		
		for (int num: cnt) {
			System.out.println(num);
		}
	}
}