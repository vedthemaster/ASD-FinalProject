package edu.miu.cs525.finalproject.creditcard.command;

import edu.miu.cs525.finalproject.framework.service.AccountService;
import edu.miu.cs525.finalproject.framework.command.Command;

public class CreditCardDepositCommand implements Command {
    AccountService accountService;

    public CreditCardDepositCommand(AccountService accountService){
        this.accountService = accountService;
    }

    @Override
    public void execute(Object... args) throws Exception {
        String accountNumber = (String) args[0];
        double amount = Double.parseDouble((String) args[1]);
        accountService.deposit(accountNumber, amount);
    }
}
