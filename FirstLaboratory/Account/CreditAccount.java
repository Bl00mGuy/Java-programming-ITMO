package FirstLaboratory.Account;

import FirstLaboratory.Account.Client.Client;
import FirstLaboratory.Services.Transaction;

public class CreditAccount extends Account {
    private final double _suspiciousLimit;
    private final double _creditLimit;
    private final double _commission;

    public CreditAccount(Client owner, String password, double creditLimit, double commission, double suspiciousLimit) {
        super(owner, password, AccountType.Credit);
        _creditLimit = creditLimit;
        _commission = commission;
        _suspiciousLimit = suspiciousLimit;
    }

    @Override
    public void Withdraw(double amount) {
        if (_owner.IsConfirmed() || amount <= _suspiciousLimit) {
            if (_balance - amount < -_creditLimit) {
                System.out.println("Превышен кредитный лимит");
                return;
            }
            _balance -= amount;
            System.out.println("Списание " + amount + " руб. со счета " + _id);
            if (_balance < 0) {
                _balance -= _commission;
                System.out.println("Комиссия за использование кредитного лимита: " + _commission + " руб.");
            }
        }
        else {
            System.out.println("Операция отклонена.\nПодтвердите пользовательские данные, чтобы совершать операции свыше " + _suspiciousLimit + " руб. или пополните баланс");
        }
    }

    @Override
    public void Deposit(double amount) {
        if (_owner.IsConfirmed() || amount <= _suspiciousLimit) {
            _balance += amount;
            System.out.println("Пополнение на " + amount + " руб. на счете " + _id);
        }
        else {
            System.out.println("Операция отклонена.\nПодтвердите пользовательские данные, чтобы совершать операции свыше " + _suspiciousLimit + " руб. или пополните баланс");
        }
    }

    @Override
    public void Transfer(Account recipient, double amount) {
        if (_owner.IsConfirmed() || amount <= _suspiciousLimit) {
            if (_balance - amount < -_creditLimit) {
                System.out.println("Превышен кредитный лимит");
                return;
            }
            _balance -= amount;
            recipient.Deposit(amount);
            System.out.println("Перевод " + amount + " руб. со счета " + _id + " на счет " + recipient.GetId());
            if (_balance < 0) {
                _balance -= _commission;
                System.out.println("Комиссия за использование кредитного лимита: " + _commission + " руб.");
            }
            Transaction transaction = new Transaction(this, recipient, amount);
            AddTransaction(transaction);
        }
        else {
            System.out.println("Операция отклонена.\nПодтвердите пользовательские данные, чтобы совершать операции свыше " + _suspiciousLimit + " руб. ");
        }
    }

    @Override
    public void CancelTransaction(Transaction transaction) {
        if (_transactionsHistory.contains(transaction)) {
            _transactionsHistory.remove(transaction);
            transaction.GetSenderAccount().Deposit(transaction.GetAmount());
            transaction.GetRecipientAccount().Withdraw(transaction.GetAmount());
            System.out.println("Транзакция успешно отменена.");
        } else {
            System.out.println("Транзакция не найдена.");
        }
    }

    public double CalculateCommission() {
        return _commission;
    }
}