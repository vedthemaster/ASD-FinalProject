package edu.miu.cs525.finalproject.banking.command;

import edu.miu.cs525.finalproject.banking.model.Account;
import edu.miu.cs525.finalproject.banking.service.AccountService;
import edu.miu.cs525.finalproject.framework.command.Command;

public class CreateAccountCommand implements Command {
    AccountService accountService;

    public CreateAccountCommand(AccountService accountService){
        this.accountService = accountService;
    }

    @Override
    public void execute(Object... args) throws Exception {
        accountService.createAccount((Account) args[0]);
    }
}
