import java.util.ArrayList;
import java.util.Scanner;

public class Users_Tools {
    public static void Shopping(Users user,ArrayList<Goods>goods){
        Tool.displayGoods(goods);
        while (true) {
            System.out.println("请输入商品编号：");
            Scanner sc=new Scanner(System.in);
            int goodsId=sc.nextInt();
            for(Goods good:goods){
                if(good.getGoodsId()==goodsId){
                    break;
                }
            }
            System.out.println("您将购买的商品信息如下：");
            for (Goods good : goods) {
                if(good.getGoodsId()==goodsId){
                    System.out.println(good.getGoodsId()+"   "+good.getName()+"   "+good.getPrice()+"   "+good.getInventory());
                    int num= 0;
                    while (true) {
                        System.out.println("请输入购买数量：");
                        num = sc.nextInt();
                        if(num>good.getInventory()){
                            System.out.println("商品库存不足");
                            continue;
                        }
                        if(num<0){
                            System.out.println("数量不能为负数");
                            continue;
                        }
                        break;
                    }
                    Goods good1=new Goods(good.getGoodsId(),good.getName(),good.getPrice(),num, (num*good.getPrice()));
                    user.addShoping_Car(good1);
                    good.setInventory(good.getInventory()-num);
                    //System.out.println(good.getGoodsId()+"   "+good.getName()+"   "+good.getPrice()+"   "+good.getInventory());
                }
            }
            System.out.println("是否继续添加(Y/N)：");
            String choice=sc.next();
            if(choice.equals("N")){
                break;
            }
        }
    }
    public static void Display_Shopping_Car(Users user){
        System.out.println("购物车信息如下：");
        System.out.printf("%-10s%-10s%-10s%-10s%n", "商品ID", "商品名称", "商品价格", "商品数量");
        double sum=0;
        for (Goods good : user.getShoping_Car()) {
            System.out.printf("%-12d%-10s%-14.2f%-10d%n", good.getGoodsId(), good.getName(), good.getPrice(), good.getNum());
            sum+=good.getPrice()*good.getNum();
        }
        System.out.println("总价："+sum);
    }
}
