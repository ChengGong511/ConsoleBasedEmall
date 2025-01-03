import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {

        try (
                //用户信息
                InputStream ufis = new FileInputStream("D:\\JAVAstudy\\mail\\src\\Users.txt");
                OutputStream ufos = new FileOutputStream("D:\\JAVAstudy\\mail\\src\\Users.txt", true);
                //使用缓冲流
                BufferedInputStream bufis = new BufferedInputStream(ufis);
                BufferedOutputStream bufos = new BufferedOutputStream(ufos);
                //商品信息
                InputStream gfis = new FileInputStream("D:\\JAVAstudy\\mail\\src\\Goods.txt");
                OutputStream gfos = new FileOutputStream("D:\\JAVAstudy\\mail\\src\\Goods.txt", true);
                BufferedInputStream gbufis = new BufferedInputStream(gfis);
                BufferedOutputStream gbufos = new BufferedOutputStream(gfos);
        ) {
             ArrayList<Users> Users = new ArrayList<>();
             ArrayList<Goods> Goods = new ArrayList<>();
            //加载用户信息
            Tool.Load_Users(Users, bufis);
            //加载商品信息
            Tool.Load_Goods(Goods, gbufis);
            Users now_user = new Users();
            //管理员信息
            Admin admin1 = new Admin("admin", "123456");

            System.out.println("******欢迎来到购物管理系统******");
            System.out.println("1.用户注册");
            System.out.println("2.用户登录");
            System.out.println("3.管理员登录");
            System.out.println("4.退出系统");
            System.out.println("**********************");
            Scanner sc = new Scanner(System.in);
            String key;
            while (true) {
                System.out.println("请输入执行的指令：");
                key = sc.next();
                switch (key) {
                    case "1":
                        System.out.println("用户注册");
                        Tool.Register_User(Users);
                        break;
                    case "2":
                        System.out.println("用户登录");
                        Tool.Login_User(Users, Goods);
                        break;
                    case "3":
                        System.out.println("管理员登录");
                        Tool.Login_Admin(admin1, Users, Goods);
                        break;
                    case "4":
                        System.out.println("退出系统");
                        Tool.Write_Users(Users, bufos);
                        Tool.Write_Goods(Goods, gbufos);
                        return;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

}
