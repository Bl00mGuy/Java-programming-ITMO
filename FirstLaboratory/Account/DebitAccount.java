package FirstLaboratory.Account;

import FirstLaboratory.Account.Client.Client;
import FirstLaboratory.Services.Transaction;

public class DebitAccount extends Account {
    private final double _suspiciousLimit;
    private final double _creditLimit;
    private final double _dailyInterestRate;

    public DebitAccount(Client owner, String password, double creditLimit, double suspiciousLimit, double dailyInterestRate) {
        super(owner, password, AccountType.Debit);
        _creditLimit = creditLimit;
        _suspiciousLimit = suspiciousLimit;
        _dailyInterestRate = dailyInterestRate;
    }

    @Override
    public void Withdraw(double amount) {
        if (amount > _balance) {
            System.out.println("Недостаточно средств на счете");
            return;
        }
        if (amount > _suspiciousLimit) {
            System.out.println("Операция отклонена.\nПодтвердите пользовательские данные, чтобы совершать операции свыше " + _suspiciousLimit + " руб.");
            return;
        }
        _balance -= amount;
        processDaily();
        System.out.println("Списание " + amount + " руб. со счета " + _id);
    }

    @Override
    public void Deposit(double amount) {
        if (_owner.IsConfirmed() || amount <= _suspiciousLimit) {
            _balance += amount;
            processDaily();
            System.out.println("Пополнение на " + amount + " руб. на счете " + _id);
        }
        else {
            System.out.println("Операция отклонена.\nПодтвердите пользовательские данные, чтобы совершать операции свыше " + _suspiciousLimit + " руб.");
        }
    }

    @Override
    public void Transfer(Account recipient, double amount) {
        if (_owner.IsConfirmed() || amount <= _suspiciousLimit) {
            if (amount > _balance + _creditLimit) {
                System.out.println("Недостаточно средств на счете");
                return;
            }
            _balance -= amount;
            recipient.Deposit(amount);
            System.out.println("Перевод " + amount + " руб. со счета " + _id + " на счет " + recipient.GetId());
            Transaction transaction = new Transaction(this, recipient, amount);
            AddTransaction(transaction);
        }
        else {
            System.out.println("Операция отклонена.\nПодтвердите пользовательские данные, чтобы совершать операции свыше " + _suspiciousLimit + " руб.");
        }
    }

    @Override
    public void CancelTransaction(Transaction transaction) {
        transaction.CancelTransaction();
    }

    public void processDaily() {
        double dailyInterest = _balance * (_dailyInterestRate / 100 / 365); // Расчет ежедневного процента
        _accumulatedInterest += dailyInterest; // Накопление процентов
    }

    public void ProcessMonthly() {
        _balance += _accumulatedInterest; // Выплата накопленных процентов
        _accumulatedInterest = 0; // Обнуление накопленных процентов
    }
}