package com.alphacoder.datastructure;

public class ArrayList {
    private static final int INIT_MAX_SIZE = 15;
    private int[] arr;
    private int length;
    private static int CURRENT_MAX_SIZE;


    public ArrayList() {
        this.arr = new int[INIT_MAX_SIZE];
        this.length = 0;
        CURRENT_MAX_SIZE = INIT_MAX_SIZE;
    }

    public boolean isEmpty() {
        return (this.length <= 0);
    }

    public int size() {
        return this.length;
    }

    public void insert(int element, int index) {
        if (index < 0 || index > length) {
            throw new ArrayIndexOutOfBoundsException();
        }

        this.length++;
        if (length == CURRENT_MAX_SIZE) {
            this.incrementArrayToDoubleSize();
        }
        for ( int i=length; i > index; i--) {
            this.arr[i] = arr[i - 1];
        }

        arr[index] = element;

    }

    public int get(int index) {
        if (index < 0 || index >= length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.arr[index];
    }

    public void update(int element, int index) {
        if (index < 0 || index >= length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.arr[index] = element;
    }

    public void delete(int index) {
        if (index < 0 || index >= this.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.length--;
        for (int i = index; i < length; i++) {
            this.arr[i] = this.arr[i + 1];
        }
    }


    private void incrementArrayToDoubleSize() {
        int newArr[] = new int[2 * CURRENT_MAX_SIZE];
        CURRENT_MAX_SIZE *= 2;

        for (int i = 0; i < this.arr.length; i++) {
            newArr[i] = this.arr[i];
        }
        this.arr = newArr;
    }
}
