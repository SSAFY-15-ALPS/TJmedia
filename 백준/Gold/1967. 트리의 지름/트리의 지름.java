import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    // Edge 클래스
    static class Edge {
        int next;
        int weight;

        Edge(int next, int weight) {
            this.next = next;
            this.weight = weight;
        }
    }

    // 스택 현재 상황 클래스
    static class NodeInfo {
        int node;
        int dist;

        NodeInfo(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    // Edge 정보 담는 해시맵
    static HashMap<Integer, List<Edge>> tree = new HashMap<>();
    
    // 가장 먼 노드 번호랑 그때의 거리
    static int farNode;
    static int maxDist;

    public static void main(String[] args) throws IOException {

        // 입력 받기
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line = br.readLine();
        if (line == null) return;
        n = Integer.parseInt(line);

        // 노드 하나면 지름은 0
        if (n == 1) {
            System.out.println(0);
            return;
        }

        // 간선 입력 받기 (n-1개)
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            // 양방향 Edge 기록
            tree.putIfAbsent(p, new ArrayList<>());
            tree.get(p).add(new Edge(c, w));
            tree.putIfAbsent(c, new ArrayList<>());
            tree.get(c).add(new Edge(p, w));
        }

        // 1번노드에서 가장 먼 노드 찾기
        iterativeDfs(1, n);

        // 위에서 찾은 지름의 한쪽 끝에서 다시 탐색 시작
        iterativeDfs(farNode, n);

        // 정답 출력
        System.out.println(maxDist);
    }

    // ArrayDeque를 스택처럼 쓰는 반복문 dfs
    static void iterativeDfs(int startNode, int n) {
        Deque<NodeInfo> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        
        // 탐색 시작할 때마다 최대 거리 리셋
        maxDist = -1;

        // 시작점 세팅
        visited[startNode] = true;
        stack.push(new NodeInfo(startNode, 0));

        while (!stack.isEmpty()) {
            NodeInfo curr = stack.pop();
            int node = curr.node;
            int currentDist = curr.dist;

            // 지금 온 거리가 여태 본 것보다 멀면 갱신하고 노드 번호 기록
            if (currentDist > maxDist) {
                maxDist = currentDist;
                farNode = node;
            }

            List<Edge> neighbors = tree.get(node);
            if (neighbors == null) continue;

            for (Edge e : neighbors) {
                int next = e.next;
                int weight = e.weight;

                if (!visited[next]) {
                    visited[next] = true;
                    // 다음 노드랑 갱신된 거리 정보 스택에 넣기
                    stack.push(new NodeInfo(next, currentDist + weight));
                }
            }
        }
    }
}