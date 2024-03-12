package FirstLaboratory;

import FirstLaboratory.Account.Client.*;
import FirstLaboratory.Bank.Bank;
import FirstLaboratory.Bank.CentralBank;
import FirstLaboratory.Services.ConsoleInterface;

import java.lang.constant.Constable;

public class Main {
    public static void main(String[] args) {
        // Демонстрация создания пользователя
        String firstName = "Said", lastName = "Oliver";

        // -- Для подтверждения аккаунта
        Address clientAddress = new Address("New-York", "Time Square", 34, 10036);
        Passport clientPassport = new Passport(241239, 8239, new Date(20,1,2006), Sex.Male, "New-York");
        // --

        Client client = new Client(firstName, lastName);
        client.UpdateInfo(clientAddress, clientPassport); // подтверждение аккаунта
        // Демонстрация создания банка
        CentralBank RussianCentralBank = new CentralBank();
        final double DailyInterestRate = 3.5;
        final double CommissionRate = 2.1;
        final double SuspiciousLimit = 1000.00;
        final double CreditLimit = 1500000.00;
        Bank TinkoffBank = new Bank(DailyInterestRate,CommissionRate,SuspiciousLimit,CreditLimit);
        RussianCentralBank.RegisterBank(TinkoffBank);

        ConsoleInterface consoleInterface = new ConsoleInterface(client, TinkoffBank);
        consoleInterface.start();
        consoleInterface.close();
    }
}

