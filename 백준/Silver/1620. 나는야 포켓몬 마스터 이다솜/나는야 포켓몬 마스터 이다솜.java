import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;


public class Main{
  public static void main(String[] args) throws IOException {
    // 입력 받기
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    
    // 해시맵 두 개 만들기
    HashMap<String, Integer> poke = new HashMap<>();
    HashMap<Integer, String> mon = new HashMap<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      String name = st.nextToken();
      poke.put(name, i+1);
      mon.put(i+1, name);
    }
    
    // 해시맵 돌면서 이름이면 도감번호, 도감번호면 이름 출력
    for (int j = 0; j < M; j++) {
      st = new StringTokenizer(br.readLine());
      String input = st.nextToken();
      try {
        int num = Integer.parseInt(input);
        String name = mon.get(num);
        System.out.println(name);
      } catch (NumberFormatException e) {
        String name = input;
        int num = poke.get(name);
        System.out.println(num);
      }
    }
  }
}
