import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.HashMap;
import java.util.LinkedList;

public class Main 
{
	public static void main(String[] args) throws IOException {

		// 입력 받기
		int N, M;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, Integer> ladder = new HashMap<>();
		for (int i = 0; i < N+M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			ladder.put(u, v); // 뽑아낼 땐 ladder.get(u)
		}
		
		// 큐 만들기(LinkedList) -> 추가 offer(), 꺼내기 poll(), 맨 앞 확인 peek()
		Queue<Integer> q = new LinkedList<>();
		// 방문처리 배열
		int[] visited = new int[101];
		
		// 큐에 초기값 담기
		q.offer(1);
		// 1에 사다리 있으면 바로 타기
		if (ladder.get(1) != null) {
			q.poll();
			q.offer(ladder.get(1));
		}
		
		// bfs 시작
		while (!q.isEmpty()) {
			int curr = q.poll();                         		 						  		// 큐에서 꺼내기
			
			if (curr == 100) break;																// 현재 위치가 100이면 반복 종료

			for (int dice = 1; dice < 7; dice++) { 								         	    // 주사위 1~6
				int next = curr + dice;
				if (next > 100) continue;														// 100보다 큰 칸은 넘어가기
				if (visited[next] == 0) {														// 방문한 적 없음
					visited[next] = visited[curr] + 1;											// 주사위 굴린 곳 방문 처리
					if (ladder.get(next) != null && visited[ladder.get(next)] == 0) {			// 사다리 있음 && 끝지점 방문한 적 없음
						visited[ladder.get(next)] = visited[curr] + 1;							// 사다리 끝지점(v)도 방문처리
						q.offer(ladder.get(next));												// 사다리 끝지점(v) 큐에 넣기
					}
					else if (ladder.get(next) == null)q.offer(next);							// 사다리 없음 -> 주사위 굴린 곳 큐에 넣기
				}
				// System.out.println("현재위치: " + next + ", 주사위: " + visited[next] + "번");	// 확인 출력
			}
		}
		// 결과 출력
		if (visited[100] != 0) System.out.println(visited[100]);
		else System.out.println("100에 도달할 수 없어요!");
	}
}
