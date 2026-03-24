import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int[][] map;
    static int n, t;
    public static void main(String[] args) throws IOException {

        // 입력 받기
        int T;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for (int tc = 1; tc <= T; tc++) {
            // 노드, 간선, 목적지 후보 개수
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            // 스타트, 필수 경로
            st = new StringTokenizer(br.readLine());
            int s =  Integer.parseInt(st.nextToken());
            int g =  Integer.parseInt(st.nextToken());
            int h =  Integer.parseInt(st.nextToken());

            // 간선 정보
            map = new int[n + 1][n + 1];
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int dist = Integer.parseInt(st.nextToken());
                // 인접 행렬
                map[x][y] = dist;
                map[y][x] = dist;
            }

            // 목적지 입력 받기
            boolean[] target = new boolean[n + 1];
            int[] targets = new int[t];
            for (int j = 0; j < t; j++) {
                st = new StringTokenizer(br.readLine());
                int node = Integer.parseInt(st.nextToken());
                // 방문 안 한 목적지는 true로 초기화
                target[node] = true;
                targets[j] = node;
            }


            // 다익스트라로 각 노드까지의 최소 거리 구하기
            boolean[] sTarget = target.clone();
            int[][] sDist = new int[n + 1][2];
            dijkstra(s, sDist, sTarget, 1);

            // g, h에서 시작하는 다익스트라
            boolean[] gTarget = target.clone();
            gTarget[h] = true;
            int[][] gDist = new int[n + 1][2];
            dijkstra(g, gDist, gTarget, 0);

            boolean[] hTarget = target.clone();
            hTarget[g] = true;
            int[][] hDist = new int[n + 1][2];
            dijkstra(h, hDist, hTarget, 0);

            // 예시 출력
//            System.out.println("sDist: " + Arrays.deepToString(sDist));
//            System.out.println("gDist: " + Arrays.deepToString(gDist));
//            System.out.println("hDist: " + Arrays.deepToString(hDist));

            Arrays.sort(targets);

            for (int i : targets) {
                if (sDist[i][1] == sDist[g][1] + map[g][h] + hDist[i][1] ||
                        sDist[i][1] == sDist[h][1] + map[h][g] + gDist[i][1] ) {
                    System.out.print(i + " ");
                }
            }
            System.out.println("");
        }
    }

    // 다익스트라 구현
    public static void dijkstra(int start, int[][] dist, boolean[] target, int cnt) {
        // 방문 처리
        boolean[] visited = new boolean[n + 1];

        // 우선순위 큐
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        // 시작 지점 넣기
        pq.offer(new int[]{start, 0});

        // target 다 채울 때까지
        while (cnt <= t && !pq.isEmpty()) {

            // 예시 출력
//            System.out.println(start + ". pq: " + Arrays.toString(pq.peek()));

            int[] curr = pq.poll();
            // 방문 했던 곳이면 컨티뉴
            if (visited[curr[0]]) continue;

            // 방문 처리
            visited[curr[0]] = true;

            // 방문 안 했던 target이면 방문 처리하고 cnt++
            if (target[curr[0]]) {
                target[curr[0]] = false;
                cnt++;
            }

            // 값 채우기
            dist[curr[0]][0] = curr[0];
            dist[curr[0]][1] = curr[1];

            for (int i = 1; i <= n; i++) {
                if (map[curr[0]][i] != 0) {
                    pq.offer(new int[] {i, map[curr[0]][i] + curr[1]});
                }
            }
        }
    }
}