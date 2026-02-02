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

        int cnt = 0;
        int streak = 0;
        for (int i = 0; i < N; i++) {
            cnt = 0;
            streak = 0;
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++){
                if (s.charAt(j) == 'O') {
                    streak += 1;
                    cnt += streak;
                }
                else streak = 0;
            }
            System.out.println(cnt);
        }
    }
  }
