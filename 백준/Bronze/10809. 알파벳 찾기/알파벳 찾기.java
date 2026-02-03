import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {

        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String S = br.readLine();

        int[] answer = new int[26];
        for (int i = 0; i < 26; i++){
            answer[i] = -1;
        }

        for (int j = 0; j < S.length(); j++){
            if (answer[S.charAt(j) - 'a'] != -1) continue;
            else answer[S.charAt(j) - 'a'] = j;
        }

        for (int k = 0; k < 26; k++) {
            System.out.print(answer[k] + " ");
        }
    }
  }
