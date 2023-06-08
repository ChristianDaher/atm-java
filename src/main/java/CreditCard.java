public class CreditCard {

  private long creditCardNumber;
  private int pin;
  private long balance;

  public CreditCard() { //Default constructor.
    this.creditCardNumber = 12200034;
    this.pin = 122;
    this.balance = 100000;
  }

  public CreditCard(long creditCardNumber, int pin, long balance) { //Overloaded constructor.
    this.creditCardNumber = creditCardNumber;
    this.pin = pin;
    this.balance = (balance >= 0 ? balance : 0);
  }

  public long getCreditCardNumber() {
    return creditCardNumber;
  }

  public void setCreditCardNumber(long creditCardNumber) {
    this.creditCardNumber = creditCardNumber;
  }

  public int getPin() {
    return pin;
  }

  public void setPin(int pin) {
    this.pin = pin;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(long balance) {
    this.balance = balance;
  }

  @Override
  public String toString() {
    return (
      "creditCardNumber=" +
      creditCardNumber +
      ", pin=" +
      pin +
      ", balance=" +
      balance +
      ' '
    );
  }
}
