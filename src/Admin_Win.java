import java.util.ArrayList;
import java.util.Scanner;

public class Admin_Win {
    public static void admin_mwnu(Admin now_admin, ArrayList<Users> Users, ArrayList<Goods> Goods){
        System.out.println("管理员登录成功！！！");
        Scanner sc=new Scanner(System.in);
        while (true) {
            System.out.println("******管理员菜单******");
            System.out.println("1.添加商品");
            System.out.println("2.删除商品");
            System.out.println("3.修改商品");
            System.out.println("4.查看商品");
            System.out.println("5.查看用户");
            System.out.println("6.删除用户");
            System.out.println("7.退出");
            System.out.println("*****************");
            System.out.println("请输入执行的指令：");
            String key;
            key=sc.next();
           switch (key){
                case "1":
                    System.out.println("添加商品");
                    Admin_Tools.addGoods(Goods);
                    break;
                case "2":
                    System.out.println("删除商品");
                    Admin_Tools.deleteGoods(Goods);
                    break;
                case "3":
                    System.out.println("修改商品");
                    Admin_Tools.updateGoods(Goods);
                    break;
                case "4":
                    System.out.println("查看商品");
                    Admin_Tools.displayGoods(Goods);
                    break;
                case "5":
                    System.out.println("查看用户");
                    Admin_Tools.displayUsers(Users);
                    break;
                case "6":
                    System.out.println("删除用户");
                    Admin_Tools.deleteUser(Users);
                    break;
                case "7":
                    System.out.println("退出");
                    return;
            }
        }

    }
}
