public class Goods {
    private int goodsId;
    private String name;
    private double price;
    private int inventory;
    private int num;
    private double sumPrice;

    public Goods(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public Goods() {
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(double sumPrice) {
        this.sumPrice = sumPrice;
    }

    public Goods(int goodsId, String name, double price, int inventory) {
        this.goodsId = goodsId;
        this.name = name;
        this.price = price;
        this.inventory = inventory;
    }
        public Goods(int goodsId, String name, double price,int num,double sumPrice) {
        this.goodsId = goodsId;
        this.name = name;
        this.price = price;
        this.num = num;
        this.sumPrice = sumPrice;
        }
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * 获取
     * @return inventory
     */
    public int getInventory() {
        return inventory;
    }

    /**
     * 设置
     * @param inventory
     */
    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public String toString() {
        return "Goods{name = " + name + ", price = " + price + ", inventory = " + inventory + "}";
    }
}
