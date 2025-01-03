import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Users {
    private String userId;
    private String name;
    private String password;
    private ArrayList<Goods> Shoping_Car;
    public Users() {
    }

    public Users(String userId, String name, String password) {
        this.userId = userId;
        this.name = name;
        this.password = password;
    }
    public static Users creat_user(String userId, String name, String password) {
        return new Users(userId, name, password);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }







    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public ArrayList<Goods> getShoping_Car() {
        return Shoping_Car;
    }
    public void setShoping_Car(ArrayList<Goods> Shoping_Car){
        this.Shoping_Car=Shoping_Car;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return (userId==users.userId )&&name.equals(users.name) && password.equals(users.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password);
    }

    public void addShoping_Car(Goods good) {
        Shoping_Car.add(good);
    }

    public String toString() {
        return "Users{name = " + name + ", password = " + password + ", Shoping_Car = " + Shoping_Car + "}";
    }


}
