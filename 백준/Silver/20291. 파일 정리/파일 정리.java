import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {

        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        // Hashmap으로 개수 세기
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            String stn = str.split("\\.")[1];
            if (map.containsKey(stn)) map.put(stn, map.get(stn)+1);
            else map.put(stn, 1);
        }
        // 정렬할 배열
        ArrayList<String> sortStrings = new ArrayList<>(map.keySet());
//        for (String key: map.keySet()) {
//            sortStrings.add(key);
//        }

        // 배열 정렬
        Collections.sort(sortStrings);

        for (int i = 0; i < sortStrings.size(); i++) {
            System.out.println(sortStrings.get(i) + " " + map.get(sortStrings.get(i)));
        }

    }
}
