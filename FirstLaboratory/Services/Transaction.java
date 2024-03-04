package FirstLaboratory.Services;

import FirstLaboratory.Account.Account;

import java.util.Date;
import java.util.UUID;

public class Transaction {
    private final String _id;
    private final Account _sender;
    private final Account _recipient;
    private final double _amount;
    private final String _date;
    private boolean _isCancelled;

    public Transaction(Account sender, Account recipient, double amount) {
        _id = UUID.randomUUID().toString();
        _sender = sender;
        _recipient = recipient;
        _amount = amount;
        _date = new Date().toString();
        _isCancelled = false;
    }

    public String GetId() {
        return _id;
    }

    public Account GetSenderAccount() {
        return _sender;
    }

    public Account GetRecipientAccount() {
        return _recipient;
    }

    public double GetAmount() {
        return _amount;
    }

    public String GetDate() {
        return _date;
    }

    public void CancelTransaction() {
        if (!_isCancelled) {
            if (_sender != null && _recipient != null) {
                _recipient.Deposit(_amount);
                _sender.Withdraw(_amount);
            } else if (_recipient != null) {
                _recipient.Withdraw(_amount);
            }
            _isCancelled = true;
            System.out.println("Транзакция отменена. ID транзакции: " + _id);
        } else {
            System.out.println("Транзакция уже была отменена ранее.");
        }
    }

    public boolean IsCancelled() {
        return _isCancelled;
    }
}
