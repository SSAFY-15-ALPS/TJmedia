import java.util.*;

public class Main{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);

    int N;
    N = sc.nextInt();

    for (int i = 1; i < N+1; i++) {
      for (int j = N-i-1; j >= 0; j--) {
        System.out.printf(" "); 
      }
      for (int k = 0; k < i; k++) {
        System.out.printf("*");
      }
      System.out.println("");
    }
  }
}
