package FirstLaboratory.Account;

import FirstLaboratory.Account.Client.Client;
import FirstLaboratory.Security.PasswordHasher;
import FirstLaboratory.Services.Transaction;

import java.util.List;
import java.util.UUID;

public abstract class Account {
    protected final String _id;
    protected final AccountType _type;
    protected final Client _owner;
    protected String _password;
    protected String _salt;
    protected List<Transaction> _transactionsHistory;
    protected double _balance;
    protected double _accumulatedInterest;

    public Account(Client owner, String password, AccountType type) {
        _id = UUID.randomUUID().toString();
        _type = type;
        _owner = owner;
        _salt = PasswordHasher.generateSalt();
        _password = PasswordHasher.hashPassword(password, _salt);
        _balance = 0.0;
    }

    public abstract void Withdraw(double amount);

    public abstract void Deposit(double amount);

    public abstract void Transfer(Account recipient, double amount);

    public abstract void CancelTransaction(Transaction transaction);

    public String GetId() {
        return _id;
    }

    public AccountType GetAccountType() {
        return _type;
    }

    public double GetBalance() {
        return _balance;
    }

    public String GetPassword() {
        return _password;
    }

    public Client GetAccountClient() {
        return _owner;
    }

    public void AddTransaction(Transaction transaction) {
        _transactionsHistory.add(transaction);
    }

    public String GetSalt() {
        return _salt;
    }
}