import java.util.NoSuchElementException;

public class EndlessArray<T> {
    private T[] arrStorage;
    private int size;

    public EndlessArray() {
        this.arrStorage = (T[]) new Object[50];
        this.size = 0;
    }

    public EndlessArray(int cap) {
        if (cap <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.arrStorage = (T[]) new Object[cap];
        this.size = 0;
    }

    public T get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        return this.arrStorage[index];
    }

    public int size() {
        return this.size;
    }

    private void ensureCapacity() {
        if (this.size == this.arrStorage.length) {
            int newCap = this.arrStorage.length * 2;
            T[] newArrStorage = (T[]) new Object[newCap];
            System.arraycopy(arrStorage, 0, newArrStorage, 0, size);
            this.arrStorage = newArrStorage;
        }
    }

    public void addLast(T e) {
        ensureCapacity();
        this.arrStorage[size] = e;
        this.size++;
    }

    public void addFirst(T e) {
        ensureCapacity();
        for (int i = this.size; i > 0; i--) {
            arrStorage[i] = arrStorage[i - 1];
        }
        this.arrStorage[0] = e;
        this.size++;
    }

    public void addAt(T e, int index) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        ensureCapacity();
        for (int i = this.size; i > index; i--) {
            arrStorage[i] = arrStorage[i - 1];
        }
        this.arrStorage[index] = e;
        this.size++;
    }

    public void removeLast() {
        if (this.size == 0) {
            throw new NoSuchElementException("Cannot remove from empty array");
        }
        this.arrStorage[this.size - 1] = null;
        this.size--;
    }

    public void removeFirst() {
        if (this.size == 0) {
            throw new NoSuchElementException("Cannot remove from empty array");
        }
        for (int i = 0; i < this.size - 1; i++) {
            this.arrStorage[i] = arrStorage[i + 1];
        }
        this.arrStorage[this.size - 1] = null;
        this.size--;
    }

    public void removeAt(int index) {
        if (this.size == 0) {
            throw new NoSuchElementException("Cannot remove from empty array");
        }
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        for (int i = index; i < this.size - 1; i++) {
            this.arrStorage[i] = arrStorage[i + 1];
        }
        this.arrStorage[this.size - 1] = null;
        this.size--;
    }

    public boolean contains(T e) {
        if (this.size == 0) {
            throw new NoSuchElementException("Cannot find in empty array");
        }
        for (int i = 0; i < this.size; i++) {
            if (this.arrStorage[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(T e) {
        if (this.size == 0) {
            throw new NoSuchElementException("Cannot find in empty array");
        }
        for (int i = 0; i < this.size; i++) {
            if (this.arrStorage[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public void remove(T e) {
        if (contains(e)) {
            removeAt(indexOf(e));
        }
    }

    public T getAt(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return this.arrStorage[index];
    }

    public T[] toArray() {
        T[] result = (T[]) new Object[size];
        System.arraycopy(arrStorage, 0, result, 0, size);
        return result;
    }
}
