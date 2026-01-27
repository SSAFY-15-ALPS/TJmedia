import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main 
{
	public static void main(String[] args) throws IOException {
	
		// 입력 받기
		int num;
		Set<Integer> set = new HashSet<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
        // 나머지 개수 구하기
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			set.add(num % 42);
		}
		System.out.println(set.size());
	}
}