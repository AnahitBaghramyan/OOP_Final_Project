import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class BankUI {
    private JFrame mainFrame;
    private JList<Account> accountList;
    private DefaultListModel<Account> accountListModel;
    private JButton addButton;
    private JButton removeButton;

    private Bank<Account> bank;

    public BankUI(Bank<Account> bank) {
        this.bank = bank;
        initialize();
    }

    private void initialize() {
        mainFrame = new JFrame("Bank Application");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());

        accountListModel = new DefaultListModel<>();
        accountList = new JList<>(accountListModel);
        JScrollPane accountScrollPane = new JScrollPane(accountList);
        mainFrame.add(accountScrollPane, BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel(new FlowLayout());
        addButton = new JButton("Add Account");
        removeButton = new JButton("Remove Account");
        buttonsPanel.add(addButton);
        buttonsPanel.add(removeButton);
        mainFrame.add(buttonsPanel, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String accountNumber = JOptionPane.showInputDialog(mainFrame, "Enter account number:");
                    String accountBalance = JOptionPane.showInputDialog(mainFrame, "Enter account balance:");
                    String accountOwner = JOptionPane.showInputDialog(mainFrame, "Enter account owner:");

                    Account account = new Account(accountNumber, Double.parseDouble(accountBalance), accountOwner) {
                        @Override
                        public void depositMoney() {
                            System.out.println("Money deposited");
                        }

                        @Override
                        public void withdrawMoney() {
                            System.out.println("Money withdrawn");
                        }

                        @Override
                        public void calculateInterest() {
                            System.out.println("Interest calculated");
                        }
                    };
                    bank.addAccount(account);
                    updateAccountList();
                    saveAccountToFile(account);
                } catch (NumberFormatException ex) {
                    throw new IllegalArgumentException("Invalid account balance format");
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Account selectedAccount = accountList.getSelectedValue();
                if (selectedAccount != null) {
                    bank.removeAccount(selectedAccount);
                    updateAccountList();
                    deleteAccountFromFile(selectedAccount);
                }
            }
        });

        mainFrame.setSize(400, 300);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    public void updateAccountList() {
        accountListModel.clear();

        for (Account account : bank.getAccounts().toArray()) {
            accountListModel.addElement(account);
        }
    }

    public void saveAccountToFile(Account account) {
        try {
            FileWriter writer = new FileWriter("accounts.txt", true);
            writer.write(account.getNumber() + "," + account.getBalance() + "," + account.getOwner() + "\n");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException("Error writing to the file", e);
        }
    }

    public void deleteAccountFromFile(Account account) {
        try {
            File inputFile = new File("accounts.txt");
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] parts = currentLine.split(",");
                if (!parts[0].equals(account.getNumber())) {
                    writer.write(currentLine + System.lineSeparator());
                }
            }

            reader.close();
            writer.close();

            if (inputFile.delete()) {
                if (!tempFile.renameTo(inputFile)) {
                    throw new IOException("Error replacing the file");
                }
            } else {
                throw new IOException("Error deleting the file");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error modifying the file", e);
        }
    }

    public static void main(String[] args) {
        Bank<Account> bank = new Bank<>("My Bank", "Location", "Owner", 1);
        BankUI bankUI = new BankUI(bank);
        loadAccountsFromFile(bank);
        bankUI.updateAccountList();
    }

    public static void loadAccountsFromFile(Bank<Account> bank) {
        try {
            File file = new File("accounts.txt");
            if (file.exists()) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] parts = line.split(",");
                    if (parts.length == 3) {
                        String accountNumber = parts[0];
                        double accountBalance = Double.parseDouble(parts[1]);
                        String accountOwner = parts[2];
                        Account account = new Account(accountNumber, accountBalance, accountOwner) {
                            @Override
                            public void depositMoney() {
                                System.out.println("Money deposited");
                            }

                            @Override
                            public void withdrawMoney() {
                                System.out.println("Money withdrawn");
                            }

                            @Override
                            public void calculateInterest() {
                                System.out.println("Interest calculated");
                            }
                        };
                        bank.addAccount(account);
                    }
                }
                scanner.close();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found", e);
        }
    }
}
