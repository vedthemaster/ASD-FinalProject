package edu.miu.cs525.finalproject.creditcard.service;

import edu.miu.cs525.finalproject.creditcard.model.CreditCard;
import edu.miu.cs525.finalproject.framework.model.Account;
import edu.miu.cs525.finalproject.framework.model.Transaction;
import edu.miu.cs525.finalproject.framework.model.TransactionType;
import edu.miu.cs525.finalproject.framework.service.AccountService;
import edu.miu.cs525.finalproject.framework.service.ReportService;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

public class CreditReportServiceImpl implements ReportService {

    AccountService accountService;

    public CreditReportServiceImpl() {
        this.accountService = CreditCardServiceImpl.getInstance();
    }

    @Override
    public String generateReport() {

        StringBuilder report = new StringBuilder();

        accountService.getAllAccounts().forEach(account -> {
            report.append(generateReport((CreditCard) account));
            report.append(System.lineSeparator());
            report.append("----------------------------------------------");
            report.append(System.lineSeparator());
            report.append(System.lineSeparator());
        });

        return report.toString();
    }

    public String generateReport(CreditCard account) {
        double totalCharges = 0, totalCredits = 0;
        Month thisMonth = LocalDate.now().getMonth();

        List<Transaction> lastMonthTransactions = account.getTransactions().stream()
                .filter(entry -> entry.getDate().getMonth().equals(thisMonth)).collect(Collectors.toList());

        for (Transaction e : lastMonthTransactions) {

            if (e.getType().equals(TransactionType.WITHDRAW)) {
                totalCharges += e.getAmount();
            }
            if (e.getType().equals(TransactionType.DEPOSIT)) {
                totalCredits += e.getAmount();
            }

        }

        double previousBalance = account.getBalance() - totalCredits + totalCharges;
        double newBalance = previousBalance - totalCredits + totalCharges +
                account.getMonthlyInterest() * (previousBalance - totalCredits);
        double totalDue = account.getMinimumPayment() * newBalance;

        return account.getCustomer().getName() + ": "
                + account.getCreditCardType() + "-" + account.getAccountNumber() + System.lineSeparator() +
                "Last Month's balance : '" + previousBalance + "'" + System.lineSeparator() +
                "Total Charges for this Month : '" + totalCharges + "'" + System.lineSeparator() +
                "Total Credits for this Month : '" + totalCredits + "'" + System.lineSeparator() +
                "New balance : '" + newBalance + "'" + System.lineSeparator() +
                "Total due : '" + totalDue + "'";
    }
}
