import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int cnt = commands.length;
        int[] answer = new int[cnt];
        
        for (int i = 0; i < cnt; i++) {
            int a = commands[i][0] - 1;
            int b = commands[i][1];
            int k = commands[i][2] - 1;
            // System.out.println("a: " + a);
            // System.out.println("b: " + b);
            // System.out.println("k: " + k);
            
            // 배열 복사
            int[] segment = Arrays.copyOfRange(array, a, b);
            
            // 정렬 후 k번째 수 찾기
            Arrays.sort(segment);
            // System.out.println("segment: " + Arrays.toString(segment));
            answer[i] = segment[k];
        }
        
        return answer;
    }
}