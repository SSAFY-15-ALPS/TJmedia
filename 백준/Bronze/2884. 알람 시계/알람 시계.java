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
		int H, M;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		if (M >= 45) System.out.println(H + " " + (M-45));
		else {
			if (H == 0) System.out.println("23 " + (M+15));
			else System.out.println(--H + " " + (M+15));
		}
	}
}