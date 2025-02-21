class Pair<T, U> {
    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public U getSecond() {
        return second;
    }

    public void setSecond(U second) {
        this.second = second;
    }

    public static <T> void swap(Pair<T, T> pair) {
        T temp = pair.getFirst();
        pair.setFirst(pair.getSecond());
        pair.setSecond(temp);
    }

    public static <T extends Comparable<T>> T maxOfThree(T a, T b, T c) {
        return (a.compareTo(b) > 0) ? (a.compareTo(c) > 0 ? a : c) : (b.compareTo(c) > 0 ? b : c);
    }

    public static void main(String[] args) {
        Pair<Integer, String> pair = new Pair<>(1, "One");
        System.out.println("First: " + pair.getFirst() + ", Second: " + pair.getSecond());

        Pair<Integer, Integer> numberPair = new Pair<>(10, 20);
        System.out.println("Before swap: " + numberPair.getFirst() + ", " + numberPair.getSecond());
        swap(numberPair);
        System.out.println("After swap: " + numberPair.getFirst() + ", " + numberPair.getSecond());

        System.out.println("Max of 3, 7, 5: " + maxOfThree(3, 7, 5));
    }
}
