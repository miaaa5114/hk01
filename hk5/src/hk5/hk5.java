package hk5;

import java.util.Scanner;

public class hk5 {
   public static void main(String[] args) {
	  var scanner=new Scanner(System.in);
	 
	  var card= new StoreValueCard("NTUNHS001", 1000, 0);
	  
	  
	  
	  int choice=-1;
	  while (choice != 0) {
          // 显示菜单
          System.out.println("請輸入以下指令:1.儲值 2.扣款 3.兌換紅利 4.查看明細 0.離開系統 請選擇操作:");
          card.printDetails();
          choice = scanner.nextInt();
          
          if (choice == 1) {
              System.out.print("請輸入儲值金額:");
              int deposit = scanner.nextInt();
              card.addValue(deposit);
              card.printDetails();
          } else if (choice == 2) {
              System.out.print("請輸入扣款金額:");
              int withdraw = scanner.nextInt();
              card.charge(withdraw);
              card.printDetails();
          } else if (choice == 3) {
              System.out.print("請輸入兌換紅利:");
              int exchange = scanner.nextInt();
              card.exchangeBonus(exchange);
              card.printDetails();
          } else if (choice == 4) {
              card.printDetails();
          } else if (choice == 0) {
              System.out.println("離開系統");
          } else {
              System.out.println("輸入錯誤，請重新輸入！");
          }
      }
      
      scanner.close();
	  	  	   
   }
}






class StoreValueCard{
	static int totalCardNum=0;
	String cardId;
	int balance;
	int bonus;
	
	
	StoreValueCard(String cardId, int balance, int bonus) {
        this.cardId = cardId;
        this.balance = balance;
        this.bonus = bonus;
        totalCardNum++;    
    }
	
    void addValue(int money) {
        if (money >= 0) {
            this.balance += money;
            if (money >= 1000) {
                this.bonus++;
            }
        } else {
            System.out.println("請確認儲值金額不可為負");
        }
    }
	
	 void exchangeBonus(int bonus) {
        if (bonus >= 0) {
            if(bonus<=this.bonus) {
            	this.bonus-=bonus;
            }
            else {
            	 System.out.println("紅利不足無法兌換");
            }
        } 
        else {
            System.out.println("請確認兌換紅利不能為負值");
        }
    }
	
	void charge(int money) {
		if(money>0) {
			if(money<=this.balance) {
				this.balance-=money;
			}
			else {
				System.out.println("餘額不足情儲值");
			}
		}
		else {
			System.out.println("請確認扣款金額不能為負數");
		}
	}
	
     void printDetails() {
        System.out.printf("(%s,%d,%d)%n", this.cardId, this.balance, this.bonus);
    }
	
	
	
}

