import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class hk9_2 {
     public static void main(String[] args){
        int sum=0;
        String line;
        boolean isLoop=true;
        Set<String> set =new HashSet<>();
        
        while (isLoop) {
            line=input("請輸入手機號碼，如果結束請輸入0:");
            if(line.equals("0")) isLoop=false;
            else{
                set.add(line);
            }
        }
        System.out.println("您輸入鳩號碼數量有:"+set.size());
        System.out.println(set);
     }

     static String input(String prompt){
        System.out.print(prompt);
        Scanner scanner=new Scanner(System.in);
        String line=scanner.nextLine();
        return line;

     }
}
