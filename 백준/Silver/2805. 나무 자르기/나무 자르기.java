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
      int N, M;
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());

      // trees배열 넣기 & end값 찾기
      st = new StringTokenizer(br.readLine());
      int[] trees = new int[N];
      int start = 0, end = 0;
      for (int i = 0; i < N; i++) {
        trees[i] = Integer.parseInt(st.nextToken());
        if (trees[i] > end) 
          end = trees[i];
      }

      // 이분 탐색 돌기
      int mid = 0;
      int target = 0; 
      while (start <= end) {
        long answer = 0;
        // System.out.println(start + ", " + end);
        mid = (start + end) / 2;
        for (int tree : trees) {
          if (tree > mid)
            answer += tree - mid;       
        }
        if (answer >= M) {
          target = mid;
          start = mid + 1;
        }
        else 
          end = mid - 1;
      }
      System.out.println(target);
    }
}
