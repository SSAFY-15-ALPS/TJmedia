import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {

        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = str.length();
        String[] suffix = new String[N];

        // substring으로 잘라서 배열에 추가
        for (int i = 0; i < N; i++) {
            suffix[i] = str.substring(N - i - 1);
        }

        // 정렬
        Arrays.sort(suffix);

        // 하나씩 출력
        for  (int i = 0; i < N; i++) {
            System.out.println(suffix[i]);
        }

    }
}