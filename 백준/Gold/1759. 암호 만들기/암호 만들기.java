import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static char[] alphabet;
    public static void main(String[] args) throws IOException {

        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 알파벳 입력 받기
        alphabet = new char[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            alphabet[i] = st.nextToken().charAt(0);
        }

        // 정렬
        Arrays.sort(alphabet);

        // 예시 출력
//        System.out.println(Arrays.toString(alphabet));

        // 백트래킹 돌려서 가능한 조합 찾기
        StringBuilder sb = new StringBuilder();
        dfs(sb, 0, 0, 0);
    }

    public static void dfs(StringBuilder sb, int i, int vCnt, int depth) {
        // N개 모두 채움
        if (depth == N) {
            if (vCnt > 0 && N - vCnt >= 2) {
                System.out.println(sb);
                return;
            }
            return;
        }

        for (; i < M; i++) {
            // 방문 안했던 곳이면
            if (alphabet[i] != '0') {
                // 모음이면 모음 개수 +1
                int nextVcnt = vCnt;
                if (alphabet[i] == 'a' || alphabet[i] == 'e' || alphabet[i] == 'i' || alphabet[i] == 'o' || alphabet[i] == 'u') {
                    nextVcnt++;
                }
                
                // sb에 현재 알파벳
                sb.append(alphabet[i]);
                
                // 다음거 호출
                dfs(sb, i + 1, nextVcnt, depth + 1);

                // 백트래킹
                sb.deleteCharAt(sb.length() - 1);

            }
        }
    }
}