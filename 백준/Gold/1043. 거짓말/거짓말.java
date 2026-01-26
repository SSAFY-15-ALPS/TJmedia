import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		int N, M, cnt;
		
		// N, M 입력값 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] member = new int[M][];
		
		// 진실을 아는 사람 boolean배열에 true로 저장
		st = new StringTokenizer(br.readLine());
		cnt = Integer.parseInt(st.nextToken());
		boolean[] truth = new boolean[N+1];
		for (int i=0; i<cnt; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			truth[tmp] = true; 
		}
		
		// 파티 정보 업데이트
		for (int j=0; j<M; j++) {
			st = new StringTokenizer(br.readLine());
			int people = Integer.parseInt(st.nextToken());
			member[j] = new int[people];
			for (int k=0; k<people; k++) {
				member[j][k] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 진실 아는 사람 업데이트
		for (int k=0; k<M; k++) {	
			for (int x=0; x<M; x++) {
				for (int y=0; y<member[x].length; y++) {
					if (truth[member[x][y]]==true) {
						for (int z=0; z<member[x].length; z++) {
							truth[member[x][z]] = true;
						}
					}
				}
			}
		}
		
		// 파티 갈래 말래
		int party = M;
		for (int a=0; a<M; a++) {
			for (int b=0; b<member[a].length; b++) {
				if (truth[member[a][b]]==true) {
					party--;
					break;
				}
			}
		}		
		System.out.println(party);
	}
}
