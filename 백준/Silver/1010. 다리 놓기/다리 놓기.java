import java.util.*;

public class Main
{
    public static void main(String[] args){
        int num, west, east;
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        for(int i=0; i<num; i++) {
    		west = sc.nextInt();
    		east = sc.nextInt();
    		long answer = 1;
    		for(int j=0; j<west; j++) {
        		answer *= (east - j);
        		answer /= (j + 1);
    		}
    		System.out.println(answer);
        }
        sc.close();
    }
}