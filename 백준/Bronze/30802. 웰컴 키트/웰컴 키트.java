import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 자바에서 입력 속도 챙기려면 BufferedReader가 국룰인 거 알지?
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 전체 참가자 수 N 입력
        int n = Integer.parseInt(br.readLine());

        // 2. 사이즈별 티셔츠 신청자 수 입력 (6개 사이즈)
        int[] shirts = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            shirts[i] = Integer.parseInt(st.nextToken());
        }

        // 3. 티셔츠 묶음 수 T, 펜 묶음 수 P 입력
        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        // --- 티셔츠 묶음 계산 시작 ---
        int totalTshirtBundles = 0;
        for (int count : shirts) {
            // 각 사이즈별로 몇 묶음이 필요한지 계산해야 함
            // count / t 가 몫이고, 나머지가 있으면 한 묶음 더 주문해야지?
            totalTshirtBundles += count / t;
            if (count % t != 0) {
                totalTshirtBundles++;
            }
        }

        // --- 펜 묶음 계산 시작 ---
        // 펜은 남거나 모자라면 안 되고 최대한 묶음으로 사고 나머지는 한 자루씩!
        int penBundles = n / p;
        int penIndividual = n % p;

        // 결과 출력
        System.out.println(totalTshirtBundles);
        System.out.print(penBundles + " " + penIndividual);
    }
}