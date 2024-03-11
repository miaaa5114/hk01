package hk2_2;

import java.util.Random;
import java.util.Scanner;

public class abc {
	public static void main(String args[]) {
 	   Random rand = new Random();
        int min = 1;
        int max = 100;
        int ans = rand.nextInt(max - min + 1) + min;
        int guess=0;

        
        Scanner sc = new Scanner(System.in);
        System.out.println("歡迎來到終極密碼遊戲！猜一個介於 " + min + " 和 " + max + " 之間的數字。");
        
        while (guess != ans) {
            System.out.println("剩餘範圍: " + min + " - " + max);
            System.out.print("猜一個數字: ");
              guess = sc.nextInt();
            
            
            if (guess < ans) {
                System.out.println("太小了，再大一點！");
                min = guess + 1;
            } else if (guess > ans) {
                System.out.println("太大了，再小一點！");
                max = guess - 1;
            } 
            
        }
        System.out.println("恭喜你，你猜對了！答案是 " + ans);
        
        
        
    }
}
