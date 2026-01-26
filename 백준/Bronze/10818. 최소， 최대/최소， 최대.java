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

    st = new StringTokenizer(br.readLine());
    int max = -1000000, min = 1000000;
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());
      if (num > max) max = num;
      if (num < min) min = num;
    }
    System.out.print(min + " " + max);
  }
}