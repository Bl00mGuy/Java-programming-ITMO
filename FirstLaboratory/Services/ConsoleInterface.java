package FirstLaboratory.Services;

import FirstLaboratory.Security.PasswordHasher;
import FirstLaboratory.Account.Account;
import FirstLaboratory.Account.AccountType;
import FirstLaboratory.Account.Client.Client;
import FirstLaboratory.Bank.Bank;

import java.util.Scanner;

public class ConsoleInterface {
    private final Client _client;
    private final Bank _bank;
    private final Scanner _scanner;

    public ConsoleInterface(Client client, Bank bank) {
        _client = client;
        _bank = bank;
        _scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Открыть счёт");
            System.out.println("2. Войти");
            System.out.println("0. Выйти");

            int choice = _scanner.nextInt();
            _scanner.nextLine(); // очистка буфера

            switch (choice) {
                case 1:
                    openAccount();
                    break;
                case 2:
                    LogIn();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, выберите существующий вариант.");
                    break;
            }
        }
    }

    private void LogIn(){
        System.out.println("Введите ваш ID:");
        String id = _scanner.nextLine();

        System.out.println("Введите ваш пароль:");
        String password = _scanner.nextLine();

        Account account = _bank.GetAccountById(id);

        if (account != null && PasswordHasher.hashPassword(password, account.GetSalt()).equals(account.GetPassword())) {
            System.out.println("Вы вошли в систему как: " + account.GetAccountType().toString() + " счет " + account.GetId());
            DisplayOperationsMenu(account);
        } else {
            System.out.println("Неверный ID или пароль.");
        }
    }

    private void DisplayOperationsMenu(Account account) {
        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("\nВыберите операцию:");
            System.out.println("1. Положить деньги");
            System.out.println("2. Снять деньги");
            System.out.println("3. Перевести пользователю");
            System.out.println("4. Удалить аккаунт");
            System.out.println("0. Выйти");

            int choice = _scanner.nextInt();
            _scanner.nextLine(); // очистка буфера

            switch (choice) {
                case 1:
                    DepositMoney(account);
                    break;
                case 2:
                    WithdrawMoney(account);
                    break;
                case 3:
                    TransferMoney(account);
                    break;
                case 4:
                    CloseAccount(account);
                    loggedIn = false;
                    break;
                case 0:
                    loggedIn = false;
                    break;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, выберите существующий вариант.");
                    break;
            }
        }
    }

    private void DepositMoney(Account account) {
        System.out.println("How much do you want to deposit ?");
        double deposit = _scanner.nextDouble();
        account.Deposit(deposit);
        System.out.println("Operation finished successfully.");
    }

    private void WithdrawMoney(Account account) {
        System.out.println("How much do you want to withdraw ?");
        double withdraw = _scanner.nextDouble();
        account.Withdraw(withdraw);
        System.out.println("Operation finished successfully.");
    }

    private void TransferMoney(Account account) {
        System.out.println("How much do you want to withdraw ?");
        double withdraw = _scanner.nextDouble();
        account.Withdraw(withdraw);
        System.out.println("Operation finished successfully.");
    }

    public void close() {
        _scanner.close();
    }

    private void openAccount() {
        System.out.println("Выберите тип счета:");
        System.out.println("1. Дебетовый");
        System.out.println("2. Кредитный");
        System.out.println("3. Депозитный");

        int accountType = _scanner.nextInt();
        _scanner.nextLine(); // очистка буфера

        switch (accountType) {
            case 1:
                System.out.println("Введите пароль:");
                String password = _scanner.nextLine();
                String debitAccount_id = _bank.OpenDebitAccount(_client, password);
                System.out.println("Аккаунт успешно открыт, ID вашего аккаунта: " + debitAccount_id);
                break;
            case 2:
                System.out.println("Введите пароль:");
                password = _scanner.nextLine();
                String creditAccount_id = _bank.OpenCreditAccount(_client, password);
                System.out.println("Аккаунт успешно открыт, ID вашего аккаунта: " + creditAccount_id);
                break;
            case 3:
                System.out.println("Введите пароль:");
                password = _scanner.nextLine();
                System.out.println("Введите сумму изначального взноса:");
                double initialAmount = _scanner.nextDouble();
                String depositAccount_id = _bank.OpenDepositAccount(_client, password, initialAmount);
                System.out.println("Аккаунт успешно открыт, ID вашего аккаунта: " + depositAccount_id);
                break;
            default:
                System.out.println("Неверный выбор. Пожалуйста, выберите существующий вариант.");
                break;
        }
    }

    public void CloseAccount(Account closing_account) {
        Account accountToClose = null;
        for (Account account : _bank.GetAccounts()) {
            if (account.GetId().equals(closing_account.GetId())) {
                accountToClose = account;
                break;
            }
        }

        if (accountToClose != null) {
            _bank.DeleteAccount(accountToClose);
            System.out.println("Счет успешно закрыт.");
        } else {
            System.out.println("Счет с указанным ID не найден.");
        }
    }
}
