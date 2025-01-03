import java.util.ArrayList;
import java.util.Scanner;

public class Users_Win {
    public static void user_menu(Users now_users, ArrayList<Goods> Goods){
        System.out.println("用户登录成功！！！");
        Scanner sc=new Scanner(System.in);
        while (true) {
            System.out.println("******用户菜单******");
            System.out.println("1.购买商品");
            System.out.println("2.查看购物车");
            System.out.println("3.退出");
            System.out.println("*****************");
            System.out.println("请输入执行的指令：");
            String key;
            key=sc.next();
            switch (key){
                case "1":
                    System.out.println("购买商品");
                    Users_Tools.Shopping(now_users,Goods);
                    break;
                case "2":
                    System.out.println("查看购物车");
                    Users_Tools.Display_Shopping_Car(now_users);
                    break;
                case "3":
                    System.out.println("退出");
                    return;
            }
        }

    }
}
