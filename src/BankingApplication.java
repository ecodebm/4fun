import java.util.Scanner;
// need to add deposit calculator
public class BankingApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount bank1 = new BankAccount("Yerkebulan", "0001");
        bank1.showMenu();
    }
}
class BankAccount {
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    BankAccount(String cname, String cid){
        customerName = cname;
        customerId = cid;
    }
    void deposit(int amount){
        if (amount != 0){
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount){
        if (amount != 0){
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction(){
        if (previousTransaction > 0){
            System.out.println("Депозит " + previousTransaction);
        } else if(previousTransaction < 0){
            System.out.println("Снято " + Math.abs(previousTransaction));
        } else {
            System.out.println("Нет транзакции");
        }
    }

     void showMenu(){
        char option = '\0';
        Scanner sc = new Scanner(System.in);
         System.out.println("Добро пожаловать " + customerName);
         System.out.println("Ваш ID " + customerId);
         System.out.println();
         System.out.println("1. Проверить баланс");
         System.out.println("2. Депозит");
         System.out.println("3. Снятие");
         System.out.println("4. Предыдущая транзакция");
         System.out.println("5. Выход");

         do {
             System.out.println("-------------------------");
             System.out.println("Выберите");
             System.out.println("-------------------------");
              option = sc.next().charAt(0);

              switch (option){
                  case  '1':
                      System.out.println("-------------------------");
                      System.out.println("Баланс " + balance);
                      System.out.println("-------------------------");
                      System.out.println();
                      break;

                  case '2':
                      System.out.println("-------------------------");
                      System.out.println("Введите сумму для депозита");
                      System.out.println("-------------------------");
                      int amount = sc.nextInt();
                      deposit(amount);
                      System.out.println();
                      break;

                  case '3':
                      System.out.println("-------------------------");
                      System.out.println("Введите сумму для снятия");
                      System.out.println("-------------------------");
                      int amount2 = sc.nextInt();
                      withdraw(amount2);
                      System.out.println();
                      break;

                  case '4':
                      System.out.println("-------------------------");
                      getPreviousTransaction();
                      System.out.println("-------------------------");
                      System.out.println();
                      break;

                  case '5':
                      System.out.println("-------------------------");
                      break;

                  default:
                      System.out.println("Ошибка при выборе операции. Повторите, пожалуйста.");
                      break;
              }
         }  while (option != 'E');
     }
}