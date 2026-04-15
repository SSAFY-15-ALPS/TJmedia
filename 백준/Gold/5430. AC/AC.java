import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        // 입력 받기
        int T;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        
        outer:
        for (int t = 0; t < T; t++) {
            // RD 입력
            String p = br.readLine();
            
            // 배열 길이 입력
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            // 배열 입력
            Deque<Integer> arr = new ArrayDeque<>();
            String s = br.readLine();
            s = s.replace("[", "");
            s = s.replace("]", "");
            String[] str = s.split(",");
            for (int i = 0; i < n; i++) {
                arr.offer(Integer.parseInt(str[i]));
            }

            // 앞을 지울지 뒤를 지울지
            boolean front = true;
            
            // p 함수 수행
            for (int i = 0; i < p.length(); i++) {
                // R일 때
                if (p.charAt(i) == 'R') {
                    if (front) front = false;
                    else front = true;
                }
                // D일 때
                else {
                    if (arr.size() == 0) {
                        System.out.println("error");
                        continue outer;
                    }
                    if (front) arr.pollFirst();
                    else arr.pollLast();
                }
            }

            // 정답 출력
            System.out.print("[");
            int len = arr.size();
            if (front) {
                for (int i = 0; i < len; i++) {
                    System.out.print(arr.pollFirst());
                    if (i != len - 1) System.out.print(",");
                }
            }
            else {
                for (int i = len - 1; i >= 0; i--) {
                    System.out.print(arr.pollLast());
                    if (i != 0) System.out.print(",");
                }
            }
            System.out.println("]");
        }
    }
}