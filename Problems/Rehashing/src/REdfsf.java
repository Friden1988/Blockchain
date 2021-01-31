import java.util.Arrays;
import java.util.Scanner;

public class REdfsf {
    private static class TableEntry<T> {
        private final int key;
        private final T value;

        public TableEntry(int key, T value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public T getValue() {
            return value;
        }
    }

    private static class HashTable<T> {
        private int size;
        private TableEntry[] table;

        public HashTable(int size) {
            this.size = size;
            table = new TableEntry[size];
        }

        public boolean put(int key, T value) {
            int idx = findKey(key);

            if (idx == -1) {
                return false;
            }
            if (idx > table.length - 1) {
                rehash();
            }
            if (table[idx] != null) {
                table[idx] = new TableEntry(key, table[idx].value + " " + value);
            } else {
                table[idx] = new TableEntry(key, value);
            }

            return true;
        }

        public T get(int key) {
            int idx = findKey(key);

            if (idx == -1 || table[idx] == null) {
                return null;
            }

            return (T) table[idx].getValue();
        }

        public void entrySet() {
            for (TableEntry n: table) {
                if (n != null) {
                    System.out.println(n.getKey() + ": " + n.getValue());
                }
            }
        }

        private int findKey(int key) {
            int hash = key % size;

            while (!(table[hash] == null || table[hash].getKey() == key)) {
                hash = (hash + 1) % size;

                if (hash == key % size) {
                    return -1;
                }
            }

            return hash;
        }

        private void rehash() {
            table = Arrays.copyOf(table, table.length * 2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashTable table = new HashTable(Integer.parseInt(sc.nextLine()));
        while (sc.hasNext()) {
            String[] hold = sc.nextLine().split(" ");
            table.put(Integer.parseInt(hold[0]), hold[1]);
        }
        table.entrySet();
    }
}
