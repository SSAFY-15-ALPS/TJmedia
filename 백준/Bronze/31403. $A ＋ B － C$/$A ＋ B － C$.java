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
		int A, B, C;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		B = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		
		System.out.println(A + B - C);
		int logB = (int)Math.log10(B);
		int jariB = (int)Math.pow(10, logB+1);
		System.out.println((A*jariB) + B - C);
		
	}
}