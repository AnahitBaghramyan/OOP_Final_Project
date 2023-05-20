public class Bank<T extends Account> {
    private String name;
    private String location;
    private String owner;
    private int numberOfBuildings;
    private EndlessArray<T> accounts;

    public Bank(String name, String location, String owner, int numberOfBuildings) {
        this.name = name;
        this.location = location;
        this.owner = owner;
        this.numberOfBuildings = numberOfBuildings;
        this.accounts = new EndlessArray<>();
    }

    public void addAccount(T account) {
        accounts.addLast(account);
    }

    public EndlessArray<T> getAccounts() {
        return accounts;
    }

    public void removeAccount(T account) {
        accounts.remove(account);
    }

    public void printAccountDetails() {
        System.out.println("Bank: " + name);
        System.out.println("Location: " + location);
        System.out.println("Owner: " + owner);
        System.out.println("Number of Buildings: " + numberOfBuildings);
        System.out.println("Accounts:");

        for (int i = 0; i < accounts.size(); i++) {
            T account = accounts.get(i);
            System.out.println("Account Number: " + account.getNumber());
            System.out.println("Account Owner: " + account.getOwner());
            System.out.println("Account Balance: $" + account.getBalance());
            System.out.println("---------------");
        }
    }
}
