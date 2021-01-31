class Account {

    private volatile long balance = 0;

    public synchronized boolean withdraw(long amount) {
        if (balance - amount > 0) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public synchronized void deposit(long amount) {
       balance += amount;
    }

    public synchronized long getBalance() {
        return balance;
    }
}