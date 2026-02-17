import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main{
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {

        // 입력 받기
        int N, M;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 배열 안에 어레이리스트
        ArrayList<Integer>[] pc = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            pc[i] = new ArrayList<>();
        }
        // pc 배열 채우기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int pc1 = Integer.parseInt(st.nextToken());
            int pc2 = Integer.parseInt(st.nextToken());
            pc[pc2].add(pc1);
        }

        // 정답 배열
        int[] answer = new int[N + 1];

        // 모든 칸에 대해서 bfs 돌기
        for (int j = 1; j < N + 1; j++) {
            // 방문처리 배열
            boolean[] visited = new boolean[N + 1];
            // 큐
            Deque<Integer> q = new ArrayDeque<>();
            // 해킹 가능한 컴퓨터 수
            int cnt = 1;

            // 현재 노드 큐에 넣고 방문처리
            q.add(j);
            visited[j] = true;
            
            // bfs 시작
            while (!q.isEmpty()) {
                // 현재 노드 큐에서 뽑기
                int curr = q.poll();

                // pc배열에서 자신을 신뢰하는 컴퓨터 큐에 넣기
                for (int cmpt: pc[curr]) {
                    if (!visited[cmpt]) {
                        cnt++;
                        q.add(cmpt);
                        visited[cmpt] = true;
                    }
                }
            }
            // 정답 배열에 컴퓨터 몇 개 해킹 가능한지 기록
            answer[j] = cnt;
        }

        int max = 0;
        for (int i = 1; i < N + 1; i++) {
            if (answer[i] > max) max = answer[i];
        }
    

        for (int j = 1; j < N + 1; j++) {
            if (answer[j] == max) System.out.print(j + " ");
        }
        
    }
  }