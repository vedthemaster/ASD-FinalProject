package edu.miu.cs525.finalproject.banking.service.implement;

import edu.miu.cs525.finalproject.banking.factory.ServiceFactory;
import edu.miu.cs525.finalproject.banking.model.Account;
import edu.miu.cs525.finalproject.banking.repository.AccountRepository;
import edu.miu.cs525.finalproject.banking.repository.implement.AccountRepositoryImpl;
import edu.miu.cs525.finalproject.banking.service.AccountService;
import edu.miu.cs525.finalproject.banking.service.ReportService;
import edu.miu.cs525.finalproject.framework.model.Transaction;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class ReportServiceImpl implements ReportService {

    private AccountService accountService;

    public ReportServiceImpl(AccountService accountService){
        this.accountService = accountService;
    }

    public String generateReport() {

        StringBuilder report = new StringBuilder();

        accountService.getAllAccounts().forEach(
                account -> {
            report.append(generateReport(account));
            report.append("\n----------------------------------------------\n\n");
        });

        return report.toString();
    }


    public String generateReport(Account account) {
        StringBuilder report = new StringBuilder();
        report.append("Account Report\n");
        report.append("Account Number: ").append(account.getAccountNumber()).append("\n");
        report.append("Customer Name: ").append(account.getCustomer().getName()).append("\n");
        report.append("Balance: ").append(account.getBalance()).append("\n");
        report.append("Transactions:\n");
        report.append("Date\t\t\tType\tAmount\t\tBalance\n");

        // Fetch all transactions for the account
        List<Transaction> transactions = account.getTransactions();

        for (Transaction transaction : transactions) {
            report.append(transaction.getDate()).append("\t")
                    .append(transaction.getType()).append("\t")
                    .append(transaction.getAmount()).append("\t\t")
                    .append(transaction.getBalanceAfterTransaction()).append("\n");
        }

        return report.toString();
    }
}
