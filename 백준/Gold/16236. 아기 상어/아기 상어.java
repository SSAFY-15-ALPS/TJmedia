import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main{
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {

        // 입력 받기
        int N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        // 상어 시작 위치
        int[] start = new int[2];
        // 먹은 물고기 개수
        int eat = 0;
        // 현재 상어 사이즈
        int sharkSize = 2;
        // 걸린 시간
        int time = 0;
        // 먹을 수 있는 물고기
        ArrayList<int[]> canGo = new ArrayList<>();
        // 크기 별 fish 배열 [ {}, {[0, 0], [1, 2]}, {}..., {[1, 0]} ]
        ArrayList<int[]>[] fish = new ArrayList[7];
        for (int i = 0; i < 7; i++) {
            fish[i] = new ArrayList<>();
        }
        // map
        int[][] map = new int[N][N];

        // 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int f = Integer.parseInt(st.nextToken());
                map[i][j] = f;
                if (f == 9) {
                    start = new int[] {i, j};
                    map[i][j] = 0;
                }
                else if (f == 1) {
                    canGo.add(new int[] {i, j});
                    fish[f].add(new int[] {i, j});
                }
                else fish[f].add(new int[] {i, j});
            }
        }

        while (!canGo.isEmpty()) {
            // canGo에 있는 모든 값에 대해 bfs로 거리 구하기
            canGo.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            // 최소 거리 담을 배열 dist[]
            int[] dist = new int[canGo.size()];
            for (int d = 0; d < canGo.size(); d++) {
                dist[d] = Integer.MAX_VALUE;
            }
            for (int i = 0; i < canGo.size(); i++) {
                int[] curr = new int[3];
                curr[0] = start[0];
                curr[1] = start[1];
                curr[2] = 0; // 거리
                // 방문처리
                boolean[][] visited =  new boolean[N][N];
                // bfs 시작
                Deque<int[]> q = new LinkedList<>();
                q.offer(curr);
                while (!q.isEmpty()) {
                    // 하나 꺼내기
                    int[] location = q.poll();

                    // 먹어야하는 물고기 칸 도착했으면 dist 배열에 거리 업데이트
                    if (location[0] == canGo.get(i)[0] && location[1] == canGo.get(i)[1])
                        dist[i] = location[2];

                    // 방향
                    int[] dx = new int[] {1, -1, 0, 0};
                    int[] dy = new int[] {0, 0, 1, -1};
                    // 네 방향 탐색
                    for (int k = 0; k < 4; k++) {
                        int nx = location[0] + dx[k];
                        int ny = location[1] + dy[k];
                        // 이동
                        if (nx >= 0 && nx < N && ny >= 0 && ny < N &&
                                map[nx][ny] <= sharkSize && !visited[nx][ny]) {
                            visited[nx][ny] = true;
                            q.add(new int[] {nx, ny, location[2] + 1});
                        }
                    }
                }
            }
            // 먹을 수 있는 물고기 중 가장 가까운 물고기로 감
            int minDist = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int min = 0; min < dist.length; min++) {
                if (minDist > dist[min]) {
                    minDist = dist[min];
                    minIndex = min;
                    }
            }
            if (minDist == Integer.MAX_VALUE) break;

            // 물고기 먹음
            start = canGo.get(minIndex);
            canGo.remove(minIndex);
            // 시간 증가
            time += minDist;

            // 테스트 호출 (테스트 할 때는 canGo.remove(minIndex);를 아래로
             // System.out.println(Arrays.toString(canGo.get(minIndex)) + ": " + time);

            // 먹은 물고기 수 증가
            eat++;
            // 상어 사이즈 증가
            if (eat >= sharkSize && sharkSize < 7) {
                eat = 0;
                sharkSize++;
                canGo.addAll(fish[sharkSize - 1]);
            }
        }

        // 정답 출력
        System.out.println(time);

    }
}