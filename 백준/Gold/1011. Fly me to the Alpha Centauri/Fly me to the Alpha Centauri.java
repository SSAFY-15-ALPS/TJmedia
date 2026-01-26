import java.util.*;
import java.lang.*;

public class Main
{
    public static void main(String[] args){
        int num; 
        long x, y, distance;
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        for(int i=0; i<num; i++) {
        	x = sc.nextLong();
        	y = sc.nextLong();
        	distance = y - x;
        	
        	long sqrt = (long) Math.sqrt(distance);
        	if (distance == ((sqrt) * (sqrt)))
        		System.out.println((sqrt*2 - 1));
        	else if ( distance <= (sqrt)*(sqrt+1))
        		System.out.println(sqrt*2);
        	else {
        		System.out.println(sqrt*2 + 1);
        	}
        		
        }
        sc.close();
    }
}

// 거리: 01 02 04 06 09 12 16 20 25 30 36 42 49 -> 거리 마지노선
// 이동: 01 02 03 04 05 06 07 08 09 10 11 12 13 -> 1번 이동, 2번 이동, ... 
// 곱셈: 11 12 22 23 33 34 44 45 55 56 66 67 77 -> 1*1, 1*2, 2*2 ...