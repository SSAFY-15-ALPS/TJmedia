import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {

        // 입력 받기
        int N, M;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 각자 부모를 자기자신으로 초기화
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        // m번 플레이하기
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            // 부모가 같으면 이번에 사이클 만들어졌다!!
            if (find(x) == find(y)) {
                System.out.println(i);
                return;
            }
            // 사이클 아니면 유니온
            union(x, y);
        }

        // 끝까지 사이클 안나왔으면 0출력
        System.out.println(0);
    }

    public static int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);
        if (aParent == bParent) {
            return;
        }
        parent[aParent] = bParent;
    }
}
