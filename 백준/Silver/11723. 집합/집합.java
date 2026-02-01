import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {

        // 입력 받기
        int M;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(st.nextToken());

        Set<Integer> S = new HashSet<>();
        for (int i = 0; i < M; i++) {
            int num = 0;
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("all")) {
                S.clear();
                for (int k = 1; k <= 20; k++) S.add(k);
            }
            else if (command.equals("empty")) {
                S.clear();
            }
            else num = Integer.parseInt(st.nextToken());

            if (command.equals("add")) S.add(num);
            else if (command.equals("remove")) S.remove(num);
            else if (command.equals("check"))
                sb.append(S.contains(num) ? "1\n" : "0\n");
            else if (command.equals("toggle")) {
                if (S.contains(num)) S.remove(num);
                else S.add(num);
            }
        }
        System.out.print(sb);
    }
  }