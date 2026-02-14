import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main{
    
    static int N, M, V;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {

        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        // 그래프 만들기
        for(int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 입력
        for (int j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // 간선 정렬
        for (int k = 0; k < N + 1; k++) {
            Collections.sort(graph.get(k));
        }

        // visited 초기화
        visited = new boolean[N + 1];

        // dfs
        dfs(V);
        
        // visited 초기화
        visited = new boolean[N + 1];

        // 한 줄 띄기
        System.out.println("");
        
        // bfs
        Queue<Integer> q = new ArrayDeque<>();
        q.add(V);
        visited[V] = true;
        while (!q.isEmpty()) {
            // 큐에서 하나 꺼내기
            int curr = q.poll();
            // 현재 노드 출력
            System.out.print(curr + " ");
            // 인접 노드 큐에 넣기
            for (int next: graph.get(curr)) {
                // 방문했던 곳이면 컨티뉴
                if (visited[next]) continue;
                // 방문 안 했던 곳이면 방문처리 후 큐에 넣기
                visited[next] = true;
                q.add(next);
            }
        }

    }

    static void dfs(int node) {
        // 현재 노드 출력
        System.out.print(node + " ");
        visited[node] = true;
        
        for (int next: graph.get(node)) {
            // 방문했던 곳이면 컨티뉴
            if (visited[next]) continue;
            // 방문 안 했던 곳이면 재귀 호출
            dfs(next);
        }
    }
  }