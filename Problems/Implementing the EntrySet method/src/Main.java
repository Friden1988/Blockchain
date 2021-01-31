import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
        int s = scanner.nextInt();
        HashTable<String> hashTable = new HashTable<String>(s);
        while (scanner.hasNext()) {
        String asdf = scanner.next();
        String[] st = asdf.split(" ");
        int sadf = Integer.parseInt(st[0]);
        hashTable.put(sadf, st[1]);}
//        System.out.println(s + " " + sadf + " " + Arrays.toString(st));

//        hashTable.put(513, "Alice");
//        hashTable.put(401, "Bob");
//        hashTable.put(513, "Mike");
//        hashTable.put(401, "Kate");
//        hashTable.put(513, "John");
        System.out.println(hashTable.toString());

    }

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
            String val = (get(key) == null) ? "" : get(key);
            if (table.length == 1) {
                table[0] = new TableEntry(key, value);
            } else {
                table[idx] = new TableEntry(key, val + " " + value);
            }
            return true;
        }

        public String get(int key) {
            int idx = findKey(key);

            if (idx == -1 || table[idx] == null) {
                return null;
            }

            return (String) table[idx].getValue();
        }

//        public ??? entrySet() {
//            // put your code here
//        }

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
            // put your code here
        }

        @Override
        public String toString() {
            StringBuilder tableStringBuilder = new StringBuilder();

            for (int i = table.length - 1; i >= 0; i--) {
                TableEntry tableEntry = table[i];
                if (tableEntry != null) {
                tableStringBuilder.append(tableEntry.getKey()).append(": ").append(tableEntry.getValue()).append("\n");
                }
            }

            return tableStringBuilder.toString();
        }
    }
}