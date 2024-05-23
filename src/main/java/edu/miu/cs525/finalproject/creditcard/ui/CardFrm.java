package edu.miu.cs525.finalproject.creditcard.ui;

import edu.miu.cs525.finalproject.creditcard.command.CreateAccountCommand;
import edu.miu.cs525.finalproject.creditcard.command.CreditCardDepositCommand;
import edu.miu.cs525.finalproject.creditcard.command.CreditCardChargeCommand;
import edu.miu.cs525.finalproject.creditcard.model.CreditCard;
import edu.miu.cs525.finalproject.creditcard.service.CreditCardServiceImpl;
import edu.miu.cs525.finalproject.framework.command.CommandInvoker;
import edu.miu.cs525.finalproject.framework.model.Account;
import edu.miu.cs525.finalproject.framework.service.AccountService;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Collection;

/**
 * A basic JFC based application.
 */
public class CardFrm extends javax.swing.JFrame {
    /****
     * init variables in the object
     ****/
    String clientName, street, city, zip, state, accountType, amountDeposit, expdate, ccnumber, email;
    boolean newaccount;
    private DefaultTableModel model;
    private JTable JTable1;
    private JScrollPane JScrollPane1;
    CardFrm thisframe;
    private Object rowdata[];
    private AccountService accountService;
    private CommandInvoker commandInvoker;

    public CardFrm() {
        thisframe = this;
        accountService = CreditCardServiceImpl.getInstance();
        this.commandInvoker = new CommandInvoker();

        setTitle("Credit-card processing Application.");
        setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(0, 0));
        setSize(575, 310);
        setVisible(false);
        JPanel1.setLayout(null);
        getContentPane().add(BorderLayout.CENTER, JPanel1);
        JPanel1.setBounds(0, 0, 575, 310);
		/*
		/Add five buttons on the pane
		/for Adding personal account, Adding company account
		/Deposit, Withdraw and Exit from the system
		*/
        JScrollPane1 = new JScrollPane();
        model = new DefaultTableModel();
        JTable1 = new JTable(model);
        model.addColumn("Name");
        model.addColumn("CC number");
        model.addColumn("Exp date");
        model.addColumn("Type");
        model.addColumn("Balance");
        rowdata = new Object[7];
        newaccount = false;


        JPanel1.add(JScrollPane1);
        JScrollPane1.setBounds(12, 92, 444, 160);
        JScrollPane1.getViewport().add(JTable1);
        JTable1.setBounds(0, 0, 420, 0);
//        rowdata = new Object[8];

        JButton_NewCCAccount.setText("Add Personal Credit Card");
        JPanel1.add(JButton_NewCCAccount);
        JButton_NewCCAccount.setBounds(24, 20, 200, 33);

        JButton_NewCompAccount.setText("Add Company Credit Card");
        JPanel1.add(JButton_NewCompAccount);
        JButton_NewCompAccount.setBounds(24, 50, 200, 33);

        JButton_GenBill.setText("Generate Monthly bills");
        JButton_GenBill.setActionCommand("jbutton");
        JPanel1.add(JButton_GenBill);
        JButton_GenBill.setBounds(240, 20, 192, 33);
        JButton_Deposit.setText("Deposit");
        JPanel1.add(JButton_Deposit);
        JButton_Deposit.setBounds(468, 104, 96, 33);
        JButton_Withdraw.setText("Charge");
        JPanel1.add(JButton_Withdraw);
        JButton_Withdraw.setBounds(468, 164, 96, 33);
        JButton_Exit.setText("Exit");
        JPanel1.add(JButton_Exit);
        JButton_Exit.setBounds(468, 248, 96, 31);


        JButton_GenBill.setActionCommand("jbutton");

        SymWindow aSymWindow = new SymWindow();
        this.addWindowListener(aSymWindow);
        SymAction lSymAction = new SymAction();
        JButton_Exit.addActionListener(lSymAction);
        JButton_NewCCAccount.addActionListener(lSymAction);
        JButton_NewCompAccount.addActionListener(lSymAction);
        JButton_GenBill.addActionListener(lSymAction);
        JButton_Deposit.addActionListener(lSymAction);
        JButton_Withdraw.addActionListener(lSymAction);

        JTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting() && JTable1.getSelectedRow() != -1) {
                    int selectedRow = JTable1.getSelectedRow();
                    ccnumber = (String) model.getValueAt(selectedRow, 1);
                }
            }
        });

        generateCommandList();
    }

    private void generateCommandList() {
        this.commandInvoker.addCommand("CREDIT_CARD_DEPOSIT", new CreditCardDepositCommand(accountService));
        this.commandInvoker.addCommand("CREDIT_CARD_CHARGE", new CreditCardChargeCommand(accountService));
        this.commandInvoker.addCommand("CREATE_CREDIT_CARD_ACCOUNT", new CreateAccountCommand(accountService));

    }

    /*****************************************************
     * The entry point for this application.
     * Sets the Look and Feel to the System Look and Feel.
     * Creates a new JFrame1 and makes it visible.
     *****************************************************/
    static public void main(String args[]) {
        try {
            // Add the following code if you want the Look and Feel
            // to be set to the Look and Feel of the native system.

            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
            }

            //Create a new instance of our application's frame, and make it visible.
            (new CardFrm()).setVisible(true);
        } catch (Throwable t) {
            t.printStackTrace();
            //Ensure the application exits with an error condition.
            System.exit(1);
        }
    }


    javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
    javax.swing.JButton JButton_NewCCAccount = new javax.swing.JButton();
    javax.swing.JButton JButton_NewCompAccount = new javax.swing.JButton();
    javax.swing.JButton JButton_GenBill = new javax.swing.JButton();
    javax.swing.JButton JButton_Deposit = new javax.swing.JButton();
    javax.swing.JButton JButton_Withdraw = new javax.swing.JButton();
    javax.swing.JButton JButton_Exit = new javax.swing.JButton();


    void exitApplication() {
        try {
            this.setVisible(false);    // hide the Frame
            this.dispose();            // free the system resources
            System.exit(0);            // close the application
        } catch (Exception e) {
        }
    }

    class SymWindow extends java.awt.event.WindowAdapter {
        public void windowClosing(java.awt.event.WindowEvent event) {
            Object object = event.getSource();
            if (object == CardFrm.this)
                BankFrm_windowClosing(event);
        }
    }

    void BankFrm_windowClosing(java.awt.event.WindowEvent event) {
        // to do: code goes here.

        BankFrm_windowClosing_Interaction1(event);
    }

    void BankFrm_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
        try {
            this.exitApplication();
        } catch (Exception e) {
        }
    }

    class SymAction implements java.awt.event.ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent event) {
            Object object = event.getSource();
            if (object == JButton_Exit)
                JButtonExit_actionPerformed(event);
            else if (object == JButton_NewCCAccount)
                JButtonNewCCAC_actionPerformed(event);
            else if (object == JButton_NewCompAccount)
                JButtonNewCompanyCCAccount_actionPerformed(event);
            else if (object == JButton_GenBill)
                JButtonGenerateBill_actionPerformed(event);
            else if (object == JButton_Deposit)
                JButtonDeposit_actionPerformed(event);
            else if (object == JButton_Withdraw)
                JButtonWithdraw_actionPerformed(event);

        }
    }

    //When the Exit button is pressed this code gets executed
    //this will exit from the system
    void JButtonExit_actionPerformed(java.awt.event.ActionEvent event) {
        System.exit(0);
    }

    void JButtonNewCCAC_actionPerformed(java.awt.event.ActionEvent event) {
		/*
		 JDialog_AddPAcc type object is for adding personal information
		 construct a JDialog_AddPAcc type object
		 set the boundaries and show it
		*/

        JDialog_AddCCAccount ccac = new JDialog_AddCCAccount(thisframe, commandInvoker);
        ccac.setBounds(450, 20, 300, 380);
        ccac.show();


        if (newaccount) {
            addAccountToGrid((CreditCard) accountService.getAccount(ccnumber));
            JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
            newaccount = false;
        }


    }

    void JButtonNewCompanyCCAccount_actionPerformed(java.awt.event.ActionEvent event) {
		/*
		 JDialog_AddPAcc type object is for adding personal information
		 construct a JDialog_AddPAcc type object
		 set the boundaries and show it
		*/

        JDialog_AddCompAcc ccac = new JDialog_AddCompAcc(thisframe, commandInvoker);
        ccac.setBounds(450, 20, 300, 380);
        ccac.show();

        if (newaccount) {
            // add row to table
            addAccountToGrid((CreditCard) accountService.getAccount(ccnumber));

            JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
            newaccount = false;
        }
    }


    void JButtonGenerateBill_actionPerformed(java.awt.event.ActionEvent event) {
        JDialogGenBill billFrm = new JDialogGenBill();
        billFrm.setBounds(450, 20, 400, 350);
        billFrm.show();

    }

    void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event) {
        // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >= 0) {
            String name = (String) model.getValueAt(selection, 0);

            //Show the dialog for adding deposit amount for the current mane
            JDialog_Deposit dep = new JDialog_Deposit(thisframe, name, commandInvoker);
            dep.setBounds(430, 15, 275, 140);
            dep.show();

            updateAccountGrid();

//             compute new amount
//            long deposit = Long.parseLong(amountDeposit);
//            String samount = (String) model.getValueAt(selection, 4);
//            long currentamount = Long.parseLong(samount);
//            long newamount = currentamount + deposit;
//            model.setValueAt(String.valueOf(newamount), selection, 4);
        }
    }

    void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event) {
        // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >= 0) {
            String name = (String) model.getValueAt(selection, 0);

            //Show the dialog for adding withdraw amount for the current mane
            JDialog_Withdraw wd = new JDialog_Withdraw(thisframe, name, commandInvoker);
            wd.setBounds(430, 15, 275, 140);
            wd.show();

            updateAccountGrid();

//            long deposit = Long.parseLong(amountDeposit);
//            String samount = (String) model.getValueAt(selection, 4);
//            long currentamount = Long.parseLong(samount);
//            long newamount = currentamount - deposit;
//            model.setValueAt(String.valueOf(newamount), selection, 4);
//            if (newamount < 0) {
//                JOptionPane.showMessageDialog(JButton_Withdraw, " " + name + " Your balance is negative: $" + String.valueOf(newamount) + " !", "Warning: negative balance", JOptionPane.WARNING_MESSAGE);
//            }

        }


    }


    private void addAccountToGrid(CreditCard account) {
        Object[] data = new Object[8];

        data[0] = account.getCustomer().getName();
        data[1] = account.getAccountNumber();
        data[2] = expdate;
        data[3] = account.getCreditCardType();
        data[4] = account.getBalance();

        model.addRow(data);
    }

    private void updateAccountGrid() {
        Collection<Account> accounts = accountService.getAllAccounts();
        model.setRowCount(0);
        accounts.forEach(a -> addAccountToGrid((CreditCard) a));
    }

}
