import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.*;

public class LoginPage extends JFrame implements ActionListener {

  JFrame loginPage;
  JPanel topPanel, subPanel, rightPanel, leftPanel, centerPanel;

  JTextField cardnumberTextfield;
  JPasswordField pinPasswordfield;
  JLabel bankLabel, cardnumberLabel, pinLabel, wrongLabel;
  JButton loginButton;

  JLabel nameLabel, balanceLabel, titleLabel;
  JButton currencyButton, depositButton, withdrawButton, logButton, allUsers, backButton;

  ArrayList<JLabel> labelArray = new ArrayList<>();
  ArrayList<JLabel> logArray = new ArrayList<>();
  JLabel logLabel;

  JButton back2Button;

  String firstName, lastName;
  int pin;
  int cardNumber;
  long balance;

  boolean isDollar = true;

  NumberFormat numberFormat = NumberFormat.getInstance(); //Time related library.

  DateTimeFormatter timeFormat;
  LocalDateTime time;

  public LoginPage() {
    loginPage = new JFrame("Login Page"); //Design of the main frame.
    loginPage.setLocation(168, 82);
    loginPage.setSize(1200, 700);
    loginPage.getContentPane().setBackground(new Color(230, 230, 230));
    loginPage.setLayout(new BorderLayout(0, 0));
    loginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    loginPage.setResizable(false);

    topPanel = new JPanel(); //Main panels.
    subPanel = new JPanel();
    rightPanel = new JPanel();
    leftPanel = new JPanel();
    centerPanel = new JPanel();

    cardnumberLabel = new JLabel("Enter card number here: "); //Initialising JLabels.
    pinLabel = new JLabel("Enter pin here: ");
    bankLabel = new JLabel("MAZE BANK");
    wrongLabel = new JLabel("Wrong credentials.");
    nameLabel = new JLabel();
    balanceLabel = new JLabel();
    titleLabel = new JLabel();
    logLabel = new JLabel(" ", SwingConstants.CENTER);

    cardnumberTextfield = new JTextField(); //Textfield to store the card number.
    pinPasswordfield = new JPasswordField(); //Passwordfield to store the pin code.
    loginButton = new JButton("Log in"); //Main log in button.

    depositButton = new JButton("Deposit"); //Buttons for the "Welcome" page.
    withdrawButton = new JButton("Withdraw");
    logButton = new JButton("Transaction logs");
    allUsers = new JButton("Accounts above $10,000");
    currencyButton = new JButton("LBP");
    backButton = new JButton("Back");

    back2Button = new JButton("Back"); //Button to go back to the "Welcome" page.

    bankLabel.setFont(new Font("Impact", Font.PLAIN, 100)); //Main label.
    bankLabel.setHorizontalAlignment((int) CENTER_ALIGNMENT);

    cardnumberLabel.setFont(new Font("Impact", Font.PLAIN, 20));
    cardnumberLabel.setBounds(250, 300, 200, 50);

    cardnumberTextfield.setFont(new Font("Impact", Font.PLAIN, 20));
    cardnumberTextfield.setBounds(500, 300, 450, 50);

    pinLabel.setFont(new Font("Impact", Font.PLAIN, 20));
    pinLabel.setBounds(250, 400, 200, 50);

    pinPasswordfield.setFont(new Font("Impact", Font.PLAIN, 20));
    pinPasswordfield.setBounds(500, 400, 450, 50);

    wrongLabel.setFont(new Font("Impact", Font.PLAIN, 30)); //If credentials wrong show this label at the bottom.
    wrongLabel.setBounds(600, 550, 300, 50);

    loginButton.setFont(new Font("Impact", Font.PLAIN, 20));
    loginButton.setBounds(220, 580, 200, 50);
    loginButton.setBackground(new Color(200, 40, 60));
    loginButton.setForeground(Color.white);
    loginButton.setFocusable(false);
    loginButton.addActionListener(this);

    nameLabel.setFont(new Font("Impact", Font.PLAIN, 20)); //When logged in show the name on the user on the top right.
    nameLabel.setForeground(Color.white);
    nameLabel.setBounds(250, 150, 400, 50);

    balanceLabel.setFont(new Font("Impact", Font.PLAIN, 20)); //When logged in display the balance of the user on the top left.
    balanceLabel.setForeground(Color.white);
    balanceLabel.setBounds(800, 150, 400, 50);

    titleLabel.setFont(new Font("Impact", Font.PLAIN, 40)); //Title label to tell the user what to do or what page they are at.
    titleLabel.setBounds(450, 200, 300, 50);

    depositButton.setFont(new Font("Impact", Font.PLAIN, 20)); //Button to deposit amount.
    depositButton.setBounds(450, 300, 300, 50);
    depositButton.setBackground(new Color(200, 40, 60));
    depositButton.setForeground(Color.white);
    depositButton.setFocusable(false);
    depositButton.addActionListener(this);

    withdrawButton.setFont(new Font("Impact", Font.PLAIN, 20)); //Button to withdraw amount (can't over withdraw).
    withdrawButton.setBounds(450, 370, 300, 50);
    withdrawButton.setBackground(new Color(200, 40, 60));
    withdrawButton.setForeground(Color.white);
    withdrawButton.setFocusable(false);
    withdrawButton.addActionListener(this);

    logButton.setFont(new Font("Impact", Font.PLAIN, 20)); //Button to show the user's most 7 recent transactions. They can't see other users' transactions.
    logButton.setBounds(450, 440, 300, 50);
    logButton.setBackground(new Color(200, 40, 60));
    logButton.setForeground(Color.white);
    logButton.setFocusable(false);
    logButton.addActionListener(this);

    allUsers.setFont(new Font("Impact", Font.PLAIN, 20)); //Button to see all users that have accounts over $10000.
    allUsers.setBounds(450, 510, 300, 50);
    allUsers.setBackground(new Color(200, 40, 60));
    allUsers.setForeground(Color.white);
    allUsers.setFocusable(false);
    allUsers.addActionListener(this);

    currencyButton.setFont(new Font("Impact", Font.PLAIN, 20)); //Button on the top right to let the user see their balance either is USD or LBP.
    currencyButton.setBounds(750, 220, 200, 50);
    currencyButton.setBackground(new Color(200, 40, 60));
    currencyButton.setForeground(Color.white);
    currencyButton.setFocusable(false);
    currencyButton.addActionListener(this);

    backButton.setFont(new Font("Impact", Font.PLAIN, 20)); //Go back to log in.
    backButton.setBounds(220, 580, 200, 50);
    backButton.setBackground(new Color(200, 40, 60));
    backButton.setForeground(Color.white);
    backButton.setFocusable(false);
    backButton.addActionListener(this);

    back2Button.setFont(new Font("Impact", Font.PLAIN, 20)); //Go back to "Welcome" page.
    back2Button.setBounds(750, 220, 200, 50);
    back2Button.setBackground(new Color(200, 40, 60));
    back2Button.setForeground(Color.white);
    back2Button.setFocusable(false);
    back2Button.addActionListener(this);

    logLabel.setFont(new Font("Impact", Font.PLAIN, 40)); //Label to display "above $10000" or "Transaction logs." depending on the button pressed.
    logLabel.setBounds(230, 220, 500, 50);
    logLabel.setOpaque(true);
    logLabel.setBackground(new Color(200, 40, 60));
    logLabel.setForeground(Color.white);

    topPanel.setLayout(new BorderLayout(10, 10)); //Design panels.
    subPanel.setBackground(new Color(200, 40, 60));
    subPanel.setBorder(
      BorderFactory.createMatteBorder(0, 0, 5, 0, Color.BLACK)
    );
    topPanel.setBackground(new Color(230, 230, 230));
    rightPanel.setBackground(new Color(210, 210, 210));
    leftPanel.setBackground(new Color(210, 210, 210));

    topPanel.setPreferredSize(new Dimension(200, 200)); //Design panels.
    subPanel.setPreferredSize(new Dimension(50, 50));
    rightPanel.setPreferredSize(new Dimension(200, 200));
    leftPanel.setPreferredSize(new Dimension(200, 200));

    topPanel.add(subPanel, BorderLayout.SOUTH); //Adding main components to the panels to finish the design.
    topPanel.add(bankLabel, BorderLayout.CENTER);

    loginPage.add(cardnumberLabel); //Main log in page components.
    loginPage.add(cardnumberTextfield);
    loginPage.add(pinLabel);
    loginPage.add(pinPasswordfield);
    loginPage.add(loginButton);
    loginPage.add(wrongLabel);
    wrongLabel.setVisible(false); //Label to display "Wrong credentials" set not visible until the login credentials are incorrect.

    loginPage.add(nameLabel); //"Welcome" page components.
    nameLabel.setVisible(false);
    loginPage.add(balanceLabel);
    balanceLabel.setVisible(false);
    loginPage.add(titleLabel);
    titleLabel.setVisible(false);
    loginPage.add(depositButton);
    depositButton.setVisible(false);
    loginPage.add(withdrawButton);
    withdrawButton.setVisible(false);
    loginPage.add(logButton);
    logButton.setVisible(false);
    loginPage.add(allUsers);
    allUsers.setVisible(false);
    loginPage.add(currencyButton);
    currencyButton.setVisible(false);
    loginPage.add(backButton);
    backButton.setVisible(false);

    loginPage.add(logLabel); //logButton and allUsers components.
    logLabel.setVisible(false);
    loginPage.add(back2Button);
    back2Button.setVisible(false);

    for (int i = 0; i < 7; i++) { //Initialising the JLabel array that will hold the labels that display the User transactions.
      JLabel transactionLabel = new JLabel();
      transactionLabel.setOpaque(true);
      transactionLabel.setBackground(new Color(225, 165, 160));
      transactionLabel.setFont(new Font("Impact", Font.PLAIN, 20));
      logArray.add(transactionLabel);
      loginPage.add(logArray.get(i));
      logArray.get(i).setVisible(false);
    }
    for (int i = 0; i < 7; i++) { //Initialising the JLabel array that will hold the labels that display all users above $10000.
      JLabel transactionLabel = new JLabel();
      transactionLabel.setOpaque(true);
      transactionLabel.setBackground(new Color(225, 165, 160));
      transactionLabel.setFont(new Font("Impact", Font.PLAIN, 20));
      labelArray.add(transactionLabel);
      loginPage.add(labelArray.get(i));
      labelArray.get(i).setVisible(false);
    }

    loginPage.add(topPanel, BorderLayout.NORTH); //Add the panels to the frame using a Layout Manager.
    loginPage.add(leftPanel, BorderLayout.WEST);
    loginPage.add(rightPanel, BorderLayout.EAST);
    loginPage.add(centerPanel, BorderLayout.CENTER);

    loginPage.setVisible(true); //Set the main frame visible.
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    timeFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); //Date format.
    time = LocalDateTime.now(); //Retrieve the exact time when the action is done.
    numberFormat.setGroupingUsed(true); //Number format to group all 3 digits together and separate them with a comma.
    cardNumber = Integer.parseInt(cardnumberTextfield.getText()); //Take the card number entered in the textfield.
    pin = Integer.parseInt(String.valueOf(pinPasswordfield.getPassword())); //Take the pin code entered in the passwordfield.
    if (e.getSource() == loginButton) { //When log in is pressed.
      for (int i = 0; i < ATM.users.size(); i++) { //Check all users.
        firstName = ATM.users.get(i).getFistName(); //Save their info.
        lastName = ATM.users.get(i).getLastName();
        balance = (long) ATM.users.get(i).getBalance();

        if (
          cardNumber == ATM.users.get(i).getCreditCardNumber() &&
          pin == ATM.users.get(i).getPin()
        ) { //If credit card number entered and pin code entered match one user.
          cardnumberLabel.setVisible(false); //Proceed to "Welcome" page.
          cardnumberTextfield.setVisible(false);
          pinLabel.setVisible(false);
          pinPasswordfield.setVisible(false);
          loginButton.setVisible(false);
          nameLabel.setVisible(true);
          nameLabel.setText(firstName + " " + lastName + " ");
          balanceLabel.setVisible(true);
          balanceLabel.setText('$' + numberFormat.format(balance));
          titleLabel.setText("Choose a service.");
          titleLabel.setVisible(true);
          depositButton.setVisible(true);
          withdrawButton.setVisible(true);
          logButton.setVisible(true);
          allUsers.setVisible(true);
          backButton.setVisible(true);
          currencyButton.setVisible(true);
          wrongLabel.setVisible(false);
          break; //Break out of the loop.
        } else { //If something entered is wrong.
          wrongLabel.setVisible(true); //Show "Credentials wrong." on the screen.
        }
      }
    } //End of loginButton.
    if (e.getSource() == currencyButton) { //Switch between USD and LBP
      if (isDollar) {
        balance *= 1500;
        balanceLabel.setText(numberFormat.format(balance) + " LBP");
        currencyButton.setText("USD");
        isDollar = false;
      } else {
        balance /= 1500;
        balanceLabel.setText('$' + numberFormat.format(balance));
        currencyButton.setText("LBP");
        isDollar = true;
      }
    }
    PrintWriter pw = null; //To write on file.
    BufferedReader br; //To read file.
    try { //Handle errors.
      pw = new PrintWriter(new FileWriter(new File("Logs.txt"), true));
      br = new BufferedReader(new FileReader(new File("Logs.txt")));

      if (e.getSource() == depositButton) { //When depositButton is pressed.
        int amount = Integer.parseInt(
          JOptionPane.showInputDialog(
            loginPage,
            "Enter the amount you wish to deposit."
          )
        );

        if (isDollar) { //If currency is set to show in USD, add the amount normally.
          balance += amount;
          balanceLabel.setText('$' + numberFormat.format(balance));
        } else { //If the currency is set to show in LBP, add the amount * 1500.
          balance += (amount * 1500);
          balanceLabel.setText(numberFormat.format(balance) + " LBP");
        }

        StringBuilder sb = new StringBuilder(); //Build a string.

        String line = br.readLine(); //Add all the file to this string.
        while (line != null) {
          sb.append(line);
          sb.append("\n");
          line = br.readLine();
        }

        FileOutputStream writer = new FileOutputStream("Logs.txt"); //Clear the Logs file.
        writer.close();

        //Print the newest Transaction of the Logs file.
        pw.println(
          cardNumber +
          "   " +
          firstName +
          "   " +
          lastName +
          " deposited: $" +
          amount +
          "   @" +
          timeFormat.format(time)
        );

        pw.println(sb); //Re-print the whole file.
        //This way we show the newest transactions first.

        JOptionPane.showMessageDialog(
          loginPage,
          "Deposit amount: $" + amount + " @" + timeFormat.format(time),
          "Receipt",
          JOptionPane.WARNING_MESSAGE
        );
        //Print a receipt after the deposit.

        for (int i = 0; i < ATM.users.size(); i++) { //For loop to update the balance of the user.
          if (
            cardNumber == ATM.users.get(i).getCreditCardNumber() &&
            pin == ATM.users.get(i).getPin() &&
            firstName == ATM.users.get(i).getFistName() &&
            lastName == ATM.users.get(i).getLastName()
          ) {
            ATM.users.get(i).setBalance(balance);
            break;
          }
        }
      } //End of depositButton.
      if (e.getSource() == withdrawButton) { //When withdrawButton is pressed.
        int amount = Integer.parseInt(
          JOptionPane.showInputDialog(
            loginPage,
            "Enter the amount you wish to withdraw."
          )
        );

        if (balance - amount < 0) { //Check first if amount entered exceeds the user's balance.
          JOptionPane.showMessageDialog(loginPage, "Try a smaller amount.");
        } else { //If not.
          if (isDollar) { //Check the currency like in the depositButton.
            balance -= amount;
            balanceLabel.setText('$' + numberFormat.format(balance));
          } else {
            balance -= (amount * 1500);
            balanceLabel.setText(numberFormat.format(balance) + " LBP");
          }

          StringBuilder sb = new StringBuilder(); //Write newest Transaction first.
          String line = br.readLine();
          while (line != null) {
            sb.append(line);
            sb.append("\n");
            line = br.readLine();
          }
          FileOutputStream writer = new FileOutputStream("Logs.txt");
          writer.close();

          pw.println(
            cardNumber +
            "   " +
            firstName +
            "   " +
            lastName +
            " withdrew: $" +
            amount +
            "   @" +
            timeFormat.format(time)
          );
          pw.println(sb);
          //Print receipt.
          JOptionPane.showMessageDialog(
            loginPage,
            "Withdraw amount: $" + amount + " @" + timeFormat.format(time),
            "Receipt",
            JOptionPane.WARNING_MESSAGE
          );
        }
        for (int i = 0; i < ATM.users.size(); i++) { //Update the user's balance.
          if (
            cardNumber == ATM.users.get(i).getCreditCardNumber() &&
            pin == ATM.users.get(i).getPin() &&
            firstName == ATM.users.get(i).getFistName() &&
            lastName == ATM.users.get(i).getLastName()
          ) {
            ATM.users.get(i).setBalance(balance);
            break;
          }
        }
      } //End of withdrawButton.
    } catch (IOException ex) {
      ex.printStackTrace(); //Catch all input/output errors related to the files.
    } finally { //Execute this code finally.
      if (pw != null) {
        pw.close(); //Close the stream of the PrintWriter.
      }
    }

    BufferedReader br1 = null;
    try {
      br1 = new BufferedReader(new FileReader(new File("Logs.txt"))); //To read the Logs file.
      String line;
      if (e.getSource() == logButton) { //Go to the user's transactions logs page.
        currencyButton.setVisible(false);
        depositButton.setVisible(false);
        withdrawButton.setVisible(false);
        logButton.setVisible(false);
        allUsers.setVisible(false);
        backButton.setVisible(false);
        titleLabel.setVisible(false);
        logLabel.setVisible(true);
        logLabel.setText("Transaction logs.");
        back2Button.setVisible(true);

        int y = 0;
        int counter = 0;
        while ((line = br1.readLine()) != null) { //If Logs file has a line that isn't empty.
          if (counter < labelArray.size()) { //And if the Labels aren't at max capacity.
            if (
              cardNumber ==
              Integer.parseInt(line.substring(0, Math.min(line.length(), 8)))
            ) {
              //If the first 8 digits of the first line in the logs match the user's credit card number
              labelArray.get(counter).setText(line);
              labelArray.get(counter).setBounds(230, 280 + y, 720, 50);
              y += 52;
              labelArray.get(counter).setVisible(true);
              counter++;
              //Print the transaction on the screen.
            }
          } //Keep doing it until the screen is full of transactions.
        } //Keep doing it until the end of the Logs file.
      } //End of logButton.
    } catch (IOException ex) {
      ex.printStackTrace(); //Catch all io errors.
    }
    if (e.getSource() == allUsers) { //Go to the "Above $10000" page.
      currencyButton.setVisible(false);
      depositButton.setVisible(false);
      withdrawButton.setVisible(false);
      logButton.setVisible(false);
      allUsers.setVisible(false);
      backButton.setVisible(false);
      titleLabel.setVisible(false);
      logLabel.setVisible(true);
      logLabel.setText("Accounts above $10,000.");
      back2Button.setVisible(true);

      int y = 0;
      for (int i = 0; i < ATM.users.size(); i++) { //For loop for all users present in the array.
        if (ATM.users.get(i).getBalance() >= 10000) { //Check each user's balance if it's over $10000.
          long creditCard = ATM.users.get(i).getCreditCardNumber();
          String firstName = ATM.users.get(i).getFistName();
          String lastName = ATM.users.get(i).getLastName();
          double balance = ATM.users.get(i).getBalance();
          //Print the user's info on the label.
          labelArray
            .get(i)
            .setText(
              creditCard +
              "         " +
              firstName +
              " " +
              lastName +
              "      $" +
              balance
            );
          labelArray.get(i).setBounds(230, 280 + y, 720, 50);
          y += 52;
          labelArray.get(i).setVisible(true);
        } //Keep going until there's no user balance over $10000.
      } //Keep going until there's no users anymore.
    } //End of allUsers.
    if (e.getSource() == backButton) { //Go back from the Welcome page to the Login page.
      nameLabel.setVisible(false);
      balanceLabel.setVisible(false);
      titleLabel.setVisible(false);
      depositButton.setVisible(false);
      withdrawButton.setVisible(false);
      logButton.setVisible(false);
      allUsers.setVisible(false);
      backButton.setVisible(false);
      backButton.setBounds(220, 580, 200, 50);
      currencyButton.setVisible(false);
      wrongLabel.setVisible(false);
      cardnumberLabel.setVisible(true);
      cardnumberTextfield.setVisible(true);
      pinLabel.setVisible(true);
      pinPasswordfield.setVisible(true);
      loginButton.setVisible(true);
      cardnumberTextfield.setText("");
      pinPasswordfield.setText("");
      for (int i = 0; i < labelArray.size(); i++) {
        labelArray.get(i).setVisible(false);
      }
      for (int i = 0; i < logArray.size(); i++) {
        logArray.get(i).setVisible(false);
      }
    }
    if (e.getSource() == back2Button) { //Go back from the Logs page or allUsers page to the Welcome page.
      back2Button.setVisible(false);
      logLabel.setVisible(false);
      for (int i = 0; i < labelArray.size(); i++) {
        labelArray.get(i).setVisible(false);
      }
      for (int i = 0; i < logArray.size(); i++) {
        logArray.get(i).setVisible(false);
      }
      backButton.setVisible(true);
      currencyButton.setVisible(true);
      withdrawButton.setVisible(true);
      depositButton.setVisible(true);
      logButton.setVisible(true);
      allUsers.setVisible(true);
      titleLabel.setVisible(true);
    }
  } //End of ActionPerfomed.
} //End of class.
