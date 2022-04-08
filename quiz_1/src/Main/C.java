package Main;

import java.util.Scanner;

public class C {
   int a, b;

   public void input() {
       Scanner s = new Scanner(System.in);
       this.a = s.nextInt();
       this.b = s.nextInt();
   }

   public int evens() {
       int res = 0;
       int cur;
       while (a > 0) {
           cur = a % 10;
           a /= 10;
           if (cur % 2 == 0) {
               res += cur;
           }
       }
       return res;
   }

   public int divisors() {
       int res = b;
       for (int i = 2; i <= b / 2; i++) {
           if (b % i == 0) {
               res *= i;
           }
       }
       return res;
   }

   public void sum() {
       System.out.println(evens() + divisors());
   }
}
