package edu.miu.cs525.finalproject.banking.command;

import edu.miu.cs525.finalproject.banking.model.Account;
import edu.miu.cs525.finalproject.banking.service.AccountService;
import edu.miu.cs525.finalproject.framework.command.Command;

public class AccountWithdrawCommand implements Command {
    AccountService accountService;

    public AccountWithdrawCommand(AccountService accountService){
        this.accountService = accountService;
    }

    @Override
    public void execute(Object... args) throws Exception {
        String accountNumber = (String) args[0];
        double amount = Double.parseDouble((String) args[1]);
        accountService.withdraw(accountNumber, amount);
    }
}
