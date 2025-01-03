import java.util.ArrayList;
import java.util.Scanner;

public class Admin_Tools {


    public static void addGoods(ArrayList<Goods> Goods) {
        Scanner sc = new Scanner(System.in);
        int goodsId;
        String name;
        double price;
        int inventory;
        System.out.println("请输入商品ID：");
        goodsId = sc.nextInt();
        System.out.println("请输入商品名称：");
        name = sc.next();
        System.out.println("请输入商品价格：");
        price = sc.nextDouble();
        System.out.println("请输入商品库存：");
        inventory = sc.nextInt();
        if (Goods.contains(new Goods(goodsId, name, price, inventory))) {
            System.out.println("商品已存在");
            return;
        }
        Goods.add(new Goods(goodsId, name, price, inventory));
        System.out.println("添加成功");
    }

    public static void deleteGoods(ArrayList<Goods> goods) {
        Scanner sc = new Scanner(System.in);
        int goodsId;
        System.out.println("请输入要删除的商品ID：");
        goodsId = sc.nextInt();
        //商品不存在
        boolean flag = false;
        for(Goods good:goods){
            if(good.getGoodsId()==goodsId){
                flag=true;
                break;
            }
        }
        if(!flag){
            System.out.println("商品不存在");
            return;
        }
        for (Goods good : goods) {
            if (good.getGoodsId() == goodsId) {
                goods.remove(good);
                System.out.println("删除成功");
                return;
            }
        }
    }

    public static void updateGoods(ArrayList<Goods> goods) {
        Scanner sc = new Scanner(System.in);
        int choice;
        int goodsId;
        System.out.println("请确认要修改的商品ID：");
        goodsId = sc.nextInt();
        boolean flag = false;
        for(Goods good:goods){
            if(good.getGoodsId()==goodsId){
                flag=true;
                break;
            }
        }
        if(!flag){
            System.out.println("商品不存在");
            return;
        }
        System.out.println("请输入要修改的内容：1.商品名称 2.商品价格 3.商品库存");
        choice = sc.nextInt();
        for (Goods good : goods) {
            if (good.getGoodsId() == goodsId) {
                System.out.println("商品信息如下：");
                System.out.printf("%-10s%-10s%-10s%-10s%n", "商品ID", "商品名称", "商品价格", "商品库存");
                System.out.printf("%-12d%-10s%-14.2f%-10d%n", good.getGoodsId(), good.getName(), good.getPrice(), good.getInventory());
                switch (choice) {
                    case 1:
                        System.out.println("请输入新的商品名称：");
                        good.setName(sc.next());
                        break;
                    case 2:
                        System.out.println("请输入新的商品价格：");
                        good.setPrice(sc.nextDouble());
                        break;
                    case 3:
                        System.out.println("请输入新的商品库存：");
                        good.setInventory(sc.nextInt());
                        break;
                }
            }
        }
    }
    public static void displayGoods(ArrayList<Goods> goods) {
       Tool.displayGoods(goods);
    }
    public static void displayUsers(ArrayList<Users> users) {
        Tool.displayUsers(users);
    }
    public static void deleteUser(ArrayList<Users> users) {
        Scanner sc = new Scanner(System.in);
      String userId;
        System.out.println("请输入要删除的用户ID：");
        userId = sc.next();
        for(Users user:users){
            if(user.getUserId().equals(userId)){
                users.remove(user);
                System.out.println("删除成功");
                return;
            }
        }
    }
}