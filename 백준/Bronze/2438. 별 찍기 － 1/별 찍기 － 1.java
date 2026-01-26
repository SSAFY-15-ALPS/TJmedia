import java.util.*;

public class Main{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);

    int a;
    a = sc.nextInt();

    for (int i = 1; i < a+1; i++) {
      for (int j = 1; j < i+1; j++){
       System.out.print("*"); 
      }
      System.out.println("");
    }
  }
}
