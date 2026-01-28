import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 입력 받기
		int N, K;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// 예외(N > K)
		if (N > K) {
			System.out.println(N - K);
			return;
		} else if (N == K) {
			System.out.println(0);
			return;
		}
		
		// BFS 돌기
		LinkedList<Integer> queue = new LinkedList<>();
		HashMap<Integer, Integer> visited = new HashMap<>();
		queue.offer(N);
		visited.put(N, 0);
		while (!queue.isEmpty()) {
			N = queue.poll();
			if (K == N) {
				System.out.println(visited.get(N));
				break;
			}
			if (N-1 > -1 && N-1 < 100001 && visited.get(N-1) == null) {
				queue.offer(N-1);
				visited.put(N-1, visited.get(N) + 1);
			}
			if (N+1 > -1 && N+1 < 100001 && visited.get(N+1) == null) {
				queue.offer(N+1);
				visited.put(N+1, visited.get(N) + 1);
			}
			if (N*2 > -1 && N*2 < 100001 && visited.get(N*2) == null) {
				queue.offer(N*2);
				visited.put(N*2, visited.get(N) + 1);
			}
		}
	}
}
