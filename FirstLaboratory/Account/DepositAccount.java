package FirstLaboratory.Account;

import FirstLaboratory.Account.Client.Client;
import FirstLaboratory.Services.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DepositAccount extends Account {
    private final double _suspiciousLimit;
    private final double _dailyInterestRate;

    public DepositAccount(Client owner, String password, double initialAmount, double suspiciousLimit, double dailyInterestRate) {
        super(owner, password, AccountType.Deposit);
        Deposit(initialAmount);
        _suspiciousLimit = suspiciousLimit;
        _dailyInterestRate = dailyInterestRate;
    }

    @Override
    public void Withdraw(double amount) {
        System.out.println("Снятие средств с депозитного счета не допускается.");
    }

    @Override
    public void Deposit(double amount) {
        if (_owner.IsConfirmed() || amount <= _suspiciousLimit) {
            _balance += amount;
            ProcessDaily();
            System.out.println("Пополнение на " + amount + " руб. на счете " + _id);
        }
        else {
            System.out.println("Операция отклонена.\nПодтвердите пользовательские данные, чтобы совершать операции свыше " + _suspiciousLimit + " руб. или пополните баланс");
        }
    }

    @Override
    public void Transfer(Account recipient, double amount) {
        System.out.println("Переводы с депозитного счета не допускаются.");
    }

    @Override
    public void CancelTransaction(Transaction transaction) {
        System.out.println("Операции по депозитному счету не могут быть отменены.");
    }

    public void ProcessDaily() {
        double dailyInterest = _balance * (_dailyInterestRate / 100 / 365);
        _accumulatedInterest += dailyInterest;
    }

    public void ProcessMonthly() {
        _balance += _accumulatedInterest;
        _accumulatedInterest = 0;
    }
}