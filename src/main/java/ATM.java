import java.util.ArrayList;

public class ATM {

  static ArrayList<User> users;

  public static void main(String[] args) {
    users = new ArrayList<>();

    User user1 = new User();
    User user2 = new User(12200035, 122, 15000, "Jaafar", "Jaafar");
    User user3 = new User(12200036, 126, 22000, "Joseph", "Fares");
    User user4 = new User(12200037, 127, 12000, "Christy", "Achcar");
    User user5 = new User(12200038, 128, 12432, "Ahmad", "Hamade");
    User user6 = new User(12200039, 129, 51244, "Jad", "Jibawi");
    User user7 = new User(12200040, 120, 2000, "Test", "Test");

    users.add(user1);
    users.add(user2);
    users.add(user3);
    users.add(user4);
    users.add(user5);
    users.add(user6);
    users.add(user7);

    new LoginPage();
  }
}
