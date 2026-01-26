import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {

      // 입력 받기
      int N;
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());

      // 숫자로 변환 후 total 계산
      String number = br.readLine();
      int total = 0;
      for (int i = 0; i < N; i++) {
        char c = number.charAt(i);
        total += c - '0';
      }
    System.out.println(total);
    }
  }
