import java.util.Arrays;
import java.util.Scanner;

public class Main {
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
            int hash;
            while ((hash = findKey(key)) < 0) {
                rehash();
            }
            table[hash] = new TableEntry<>(key, value);
            return true;
        }

        public T get(int key) {
            int idx = findKey(key);

            if (idx == -1 || table[idx] == null) {
                return null;
            }

            return (T) table[idx].getValue();
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
            int newSize =size * 2;
            HashTable hashTable = new HashTable(newSize);
            for (int i = 0; i < table.length; i++) {
            hashTable.put(table[i].getKey(),table[i].getValue());
            }
            this.table = hashTable.table;
            this.size = hashTable.size;
        }

        @Override
        public String toString() {
            StringBuilder tableStringBuilder = new StringBuilder();

            for (int i = 0; i < table.length; i++) {
                if (table[i] == null) {
                    tableStringBuilder.append(i + ": null");
                } else {
                    tableStringBuilder.append(i + ": key=" + table[i].getKey()
                            + ", value=" + table[i].getValue());
                }

                if (i < table.length - 1) {
                    tableStringBuilder.append("\n");
                }
            }

            return tableStringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter("\\n");
        HashTable table = new HashTable(5);
        int asc = sc.nextInt();
        String[] hold = new String[2];
        for (int i = 0; i <= asc-1; i++) {
            String sa= sc.next();
            hold = sa.split(" ");
            table.put(Integer.parseInt(hold[0]), hold[1]);
        }
//        System.out.println(Arrays.toString(hold));
        System.out.println(table.toString());
    }
}