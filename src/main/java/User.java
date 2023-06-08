public class User extends CreditCard { //Each user inherits a credit card.

  private CreditCard creditCard;
  private String fistName;
  private String lastName;

  public User() { //Default constructor.
    super();
    this.creditCard = new CreditCard();
    this.fistName = "Christian";
    this.lastName = "Daher";
  }

  public User(
    long creditCardNumber,
    int pin,
    long balance,
    String fistName,
    String lastName
  ) { //Overloaded constructor.
    super(creditCardNumber, pin, balance);
    this.fistName = fistName;
    this.lastName = lastName;
  }

  public String getFistName() {
    return fistName;
  }

  public void setFistName(String fistName) {
    this.fistName = fistName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    return super.toString() + "fistName=" + fistName + ", lastName=" + lastName;
  }
}
