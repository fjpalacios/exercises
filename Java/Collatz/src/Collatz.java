class Collatz {

    private final int number;

    public Collatz(int number) {
        this.number = number;
    }

    public int evenNumber() {
        return this.number/2;
    }

    public int oddNumber() {
        return this.number*3 + 1;
    }

}
