package FirstLaboratory.Bank;

import FirstLaboratory.Account.Account;
import FirstLaboratory.Account.Client.Client;
import FirstLaboratory.Account.CreditAccount;
import FirstLaboratory.Account.DebitAccount;
import FirstLaboratory.Account.DepositAccount;
import FirstLaboratory.Services.Notification;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Bank {
    public final String _id;
    protected List<Client> _clients;
    protected List<Client> _subscribedClients;
    protected List<Account> _accounts;
    private double _creditLimit;
    private double _dailyInterestRate;
    private double _commissionRate;
    private double _suspiciousLimit;

    public Bank(double dailyInterestRate, double commissionRate, double suspiciousLimit, double creditLimit) {
        _id = UUID.randomUUID().toString();
        _clients = new ArrayList<>();
        _accounts = new ArrayList<>();
        _dailyInterestRate = dailyInterestRate;
        _commissionRate = commissionRate;
        _suspiciousLimit = suspiciousLimit;
        _creditLimit = creditLimit;
    }

    public void AddClient(Client client) {
        _clients.add(client);
    }

    public void DeleteClient(Client client) {
        _clients.remove(client);
    }

    public void DeleteAccount(Account account) {
        _accounts.remove(account);
    }

    public String OpenDepositAccount(Client client, String password, double initialAmount) {
        if (!_clients.contains(client)) _clients.add(client);
        Account account = new DepositAccount(client, password, _dailyInterestRate, initialAmount, _suspiciousLimit);
        _accounts.add(account);
        return account.GetId();
    }

    public String OpenDebitAccount(Client client, String password) {
        if (!_clients.contains(client)) _clients.add(client);
        Account account = new DebitAccount(client, password, _dailyInterestRate, _creditLimit, _suspiciousLimit);
        _accounts.add(account);
        return account.GetId();
    }

    public String OpenCreditAccount(Client client, String password) {
        if (!_clients.contains(client)) _clients.add(client);
        Account account = new CreditAccount(client, password, _creditLimit, _commissionRate, _suspiciousLimit);
        _accounts.add(account);
        return account.GetId();
    }

    public void SetInterestRate(double newRate) {
        _dailyInterestRate = newRate;
        NotifySubscribedClients(new Notification("Изменение процентной ставки"));
    }

    public double GetInterestRate() {
        return _dailyInterestRate;
    }

    public void SetCommissionRate(double newRate) {
        _commissionRate = newRate;
    }

    public double GetCommissionRate() {
        return _commissionRate;
    }

    public void SetSuspiciousLimit(double suspiciousLimit) {
        _suspiciousLimit = suspiciousLimit;
    }

    public double GetSuspiciousLimit() {
        return _suspiciousLimit;
    }

    public double GetCreditLimit() {
        return _creditLimit;
    }

    public void SetCreditLimit(double creditLimit) {
        _creditLimit = creditLimit;
        NotifySubscribedClients(new Notification("Изменение кредитного лимита"));
    }

    public List<Account> GetAccounts(){
        return _accounts;
    }

    public Account GetAccountById(String id) {
        for (Account account : _accounts) {
            if (account.GetId().equals(id)) {
                return account;
            }
        }
        return null;
    }

    public void SubscribeClient(Client client) {
        _subscribedClients.add(client);
    }

    public void UnsubscribeClient(Client client) {
        _subscribedClients.remove(client);
    }

    private void NotifySubscribedClients(Notification message) {
        for (Client client : _subscribedClients) {
            client.ReceiveNotification(message);
        }
    }

    public void ProcessAccounts() {
        for (Account account : _accounts) {
            if (account instanceof DebitAccount debitAccount) {
                debitAccount.ProcessMonthly();
            }
            if (account instanceof DepositAccount depositAccount) {
                depositAccount.ProcessMonthly();
            }
            if (account instanceof CreditAccount creditAccount) {
                if (creditAccount.GetBalance() < 0) {
                    double commission = creditAccount.CalculateCommission();
                    creditAccount.Withdraw(commission);
                }
            }
        }
    }
}