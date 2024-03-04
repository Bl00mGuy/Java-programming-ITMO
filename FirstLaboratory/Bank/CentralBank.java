package FirstLaboratory.Bank;

import java.util.ArrayList;
import java.util.List;

public class CentralBank {
    private final List<Bank> _registeredBanks;

    public CentralBank() {
        _registeredBanks = new ArrayList<>();
    }

    public void RegisterBank(Bank bank) {
        _registeredBanks.add(bank);
    }

    public void DeleteBank(Bank bank) {
        _registeredBanks.remove(bank);
    }

    public void ProcessBanks() {
        for (Bank bank : _registeredBanks) {
            bank.ProcessAccounts();
        }
    }
}