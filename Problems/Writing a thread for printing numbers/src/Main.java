class NumbersThread extends Thread {

    public NumbersThread(int from, int to) {
        for (int i = from; i <= to; i++) {
        System.out.println(i);
        }
    }

    @Override
    public void run() {
    }
}