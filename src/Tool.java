import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Tool {
    public static void Register_User(ArrayList<Users> users)  {
        Scanner sc = new Scanner(System.in);
        String name;
        String password;
        String userId;
        while (true) {

            System.out.println("请输入ID：");
            userId = sc.next();
            for(Users user:users){
                if(user.getUserId().equals(userId)){
                    System.out.println("ID已存在，请重新输入。");
                    return;
                }
            }
            break;
        }
        while (true) {
            System.out.println("请输入用户名：  (用户名格式为：字母开头，长度在6到20之间，只包含字母和数字)");
            name = sc.next();

            if (!isValidUsername(name)) {
                System.out.println("用户名格式不正确，请重新输入。");
                continue;
            }
            for(Users user:users){
                if(user.getName().equals(name)){
                    System.out.println("用户名已存在，请重新输入。");
                    return;
                }
            }
            break;
        }
        while (true) {
            System.out.println("请输入密码：  (密码格式为：至少8个字符，包含至少一个大写字母、一个小写字母、一个数字和一个特殊字符)");
            password = sc.next();
            if (!isValidPassword(password)) {
                System.out.println("密码格式不正确，请重新输入。");
                continue;
            }
            break;
        }

        Users user = new Users(userId, name, password);
        user.setShoping_Car(new ArrayList<Goods>());
        users.add(user);
        System.out.println("注册成功！");
    }

    public static void Login_User(ArrayList<Users> users, ArrayList<Goods> Goods) {
        Scanner sc = new Scanner(System.in);
        Users u1 = new Users();

        System.out.println("请输入用户名：  (用户名格式为：字母开头，长度在6到20之间，只包含字母和数字)");
        u1.setName(sc.next());
        if (!isValidUsername(u1.getName())) {
            System.out.println("用户名格式不正确，请重新输入。");
            return ;
        }
        System.out.println("请输入密码：  (密码格式为：至少8个字符，包含至少一个大写字母、一个小写字母、一个数字和一个特殊字符)");
        u1.setPassword(sc.next());
        if (!isValidPassword(u1.getPassword())) {
            System.out.println("密码格式不正确，请重新输入。");
            return ;
        }
        // 遍历用户集合，查找是否存在该用户
        for (Users user : users) {
            if (u1.getName().equals(user.getName()) && u1.getPassword().equals(user.getPassword())) {
                Users_Win.user_menu(user,Goods);//登录成功
                return ;
            }
        }
        System.out.println("用户名或密码错误，请重新输入。");
    }

    public static void Login_Admin(Admin admin, ArrayList<Users> Users, ArrayList<Goods> Goods) {
        Scanner sc = new Scanner(System.in);
        Admin a1 = new Admin();

        System.out.println("请输入用户名：");
        a1.setName(sc.next());
        System.out.println("请输入密码：");
        a1.setPassword(sc.next());

        if (a1.getName().equals(admin.getName()) && a1.getPassword().equals(admin.getPassword())) {
            Admin_Win.admin_mwnu(admin, Users, Goods);
            return ;
        }

        System.out.println("用户名或密码错误，请重新输入。");
        return ;
    }

    public static void displayGoods(ArrayList<Goods> goods) {
        System.out.printf("%-10s%-10s%-10s%-10s%n", "商品ID", "商品名称", "商品价格", "商品库存");
        for (Goods good : goods) {
            System.out.printf("%-12d%-10s%-14.2f%-10d%n", good.getGoodsId(), good.getName(), good.getPrice(), good.getInventory());
        }
    }

    public static void displayUsers(ArrayList<Users> users) {
        System.out.printf("%-10s%-10s%-10s%n", "用户ID", "用户名", "密码");
        for (Users user : users) {
            System.out.printf("%-12s%-12s%-10s%n", user.getUserId(), user.getName(), user.getPassword());
        }
    }
    public static boolean isValidUsername(String username) {
        // 假设用户名格式为：字母开头，长度在6到20之间，只包含字母和数字
        String regex = "^[a-zA-Z][a-zA-Z0-9]{5,19}$";
        return Pattern.matches(regex, username);
    }

    public static boolean isValidPassword(String password) {
        // 假设密码格式为：至少8个字符，包含至少一个大写字母、一个小写字母、一个数字和一个特殊字符
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return Pattern.matches(regex, password);
    }

    //重新读入用户信息
    public static void Load_Users(ArrayList<Users> users, InputStream bufis) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(bufis));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] userInfo = line.split(",");
            Users u1=Users.creat_user(userInfo[0], userInfo[1], userInfo[2]);
            u1.setShoping_Car(new ArrayList<Goods>());
            users.add(u1);

        }
    }

    //重新读入商品信息
    public static void Load_Goods(ArrayList<Goods> goods, InputStream bufis) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(bufis));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] goodsInfo = line.split(",");
            goods.add(new Goods(Integer.parseInt(goodsInfo[0]), goodsInfo[1], Double.parseDouble(goodsInfo[2]), Integer.parseInt(goodsInfo[3])));
        }
    }
    //重新写入用户信息
    public static void Write_Users(ArrayList<Users> users, OutputStream bufos) throws IOException {
        //先删除Users.txt里的内容



        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\JAVAstudy\\mail\\src\\Users.txt", false)))) {
            // 清空文件内容
        }
        // 然后写入新的用户信息
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(bufos));
        for (Users user : users) {
            writer.write(user.getUserId() + "," + user.getName() + "," + user.getPassword() + "\n");
        }
        writer.flush();
    }
    //重新写入商品信息
    public static void Write_Goods(ArrayList<Goods> goods, OutputStream bufos) throws IOException {
        //先删除Goods.txt里的内容
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\JAVAstudy\\mail\\src\\Goods.txt", false))) ) {
            // 清空文件内容
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(bufos));
        for (Goods good : goods) {
            writer.write(good.getGoodsId() + "," + good.getName() + "," + good.getPrice() + "," + good.getInventory() + "\n");
        }
        writer.flush();
    }
}