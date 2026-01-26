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
    int T;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    st = new StringTokenizer(br.readLine());
    T = Integer.parseInt(st.nextToken());

    for (int i = 0; i < T; i++) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());

      String s = st.nextToken();
      for (int j = 0; j < s.length(); j++) {
        char c = s.charAt(j);
        for (int k = 0; k < n; k++) {
          System.out.print(c);
        }
      }
      System.out.println("");
    }
  }
}