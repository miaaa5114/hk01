import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class hk9_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> grades = new HashMap<>();

        while (true) {
            System.out.println("選擇操作：");
            System.out.println("1. 新增學生成績");
            System.out.println("2. 查詢學生成績");
            System.out.println("3. 修改學生成績");
            System.out.println("4. 刪除學生成績");
            System.out.println("5. 列出所有學生成績");
            System.out.println("0. 結束");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 消耗掉换行符

            switch (choice) {
                case 1:
                    System.out.println("輸入學生名稱：");
                    String name = scanner.nextLine();
                    System.out.println("輸入學生成績：");
                    int grade = scanner.nextInt();
                    scanner.nextLine(); // 消耗掉换行符
                    grades.put(name, grade);
                    break;
                case 2:
                    System.out.println("輸入學生名稱：");
                    String queryName = scanner.nextLine();
                    if (grades.containsKey(queryName)) {
                        System.out.println(queryName + "的成績是：" + grades.get(queryName));
                    } else {
                        System.out.println("沒有找到 " + queryName + " 的成績。");
                    }
                    break;
                case 3:
                    System.out.println("輸入要修改的學生名稱：");
                    String modifyName = scanner.nextLine();
                    if (grades.containsKey(modifyName)) {
                        System.out.println("輸入新的成績：");
                        int newGrade = scanner.nextInt();
                        scanner.nextLine(); // 消耗掉换行符
                        grades.put(modifyName, newGrade);
                        System.out.println("成績修改成功。");
                    } else {
                        System.out.println("沒有找到 " + modifyName + " 的成績，無法修改。");
                    }
                    break;
                case 4:
                    System.out.println("輸入要刪除的學生名稱：");
                    String deleteName = scanner.nextLine();
                    if (grades.containsKey(deleteName)) {
                        grades.remove(deleteName);
                        System.out.println("成功刪除 " + deleteName + " 的成績記錄。");
                    } else {
                        System.out.println("沒有找到 " + deleteName + " 的成績，無法刪除。");
                    }
                    break;
                case 5:
                    System.out.println("所有學生成績列表：");
                    for (Map.Entry<String, Integer> entry : grades.entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue());
                    }
                    break;
                case 0:
                    System.out.println("程式結束。");
                    scanner.close();
                    return;
                default:
                    System.out.println("請輸入正確的操作選項。");
            }
        }
    }
        
        
}
