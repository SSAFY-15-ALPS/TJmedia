import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {

        // 입력 받기
        int N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        // 사람 수
        st = new StringTokenizer(br.readLine());
        int people = Integer.parseInt(st.nextToken());

        // 스태프 이름 담는 배열
        List<String> names = new ArrayList<>();
        // 몫 담는 배열
        List<Double> scores = new ArrayList<>();
        // 몫, 스태프 이름 담는 neck 해시맵
        HashMap<Double, String> neck = new HashMap<>();
        // 스태프 이름, 칩 개수 담는 answer 해시맵
        HashMap<String, Integer> answer = new HashMap<>();
        
        // 득표 수
        for (int i = 0; i < people; i++) {
            st = new StringTokenizer(br.readLine());
            String staff = st.nextToken();
            int vote = Integer.parseInt(st.nextToken());
            // 득표수 모자라면 컨티뉴
            if (vote < N * 0.05) continue;

            // 이름 넣기
            names.add(staff);
            answer.put(staff, 0);
            
            // neck 해시맵, scores 배열 채우기
            for (int j = 1; j <= 14; j++) {
                neck.put((double) vote / j, staff);
                scores.add((double) vote / j);
            }
        }   
        
        // 이름 정렬
        Collections.sort(names);
        // 점수 정렬
        Collections.sort(scores);

        // scores 배열에서 높은 점수 꺼내서 neck 해시맵에서 확인
        if (!scores.isEmpty()) {
            for (int k = scores.size() - 1; k >= scores.size() - 14; k--) {
                // 높은 점수 주인 찾기
                String owner = neck.get(scores.get(k));
                // 주인한테 칩 1개 추가
                int tmp = answer.remove(owner);
                answer.put(owner, tmp + 1);
            }
        }

        // 정답 출력 (이름 오름차순, 칩 0개여도 출력)
        for (String name: names) {
            System.out.println(name + " " + answer.get(name));
        }
    }
  }
