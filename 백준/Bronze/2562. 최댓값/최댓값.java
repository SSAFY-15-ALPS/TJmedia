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
    int N = 9;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int max = 0, index = 0;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int num = Integer.parseInt(st.nextToken());
      if (num > max) {
        max = num;
        index = i + 1;
      } 
    }
    System.out.println(max);
    System.out.println(index);
  }
}
