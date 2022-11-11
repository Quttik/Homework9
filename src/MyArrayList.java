import java.util.Arrays;
import Interfaces.MyCollection;

public class MyArrayList <T> implements MyCollection<T> {
    Object[] array;

    public Object[] getArray() {
        return array;
    }

    public void setArray(Object[] array) {
        this.array = array;
    }
    @Override
    public void  add (T value) {
        if (this.array == null) {
           array = new Object[] {value};
            System.out.println("Element has been added to array");
        } else {
            Object[] array = new Object[this.array.length + 1];
            System.arraycopy(this.array, 0, array, 0, this.array.length);
            array[array.length - 1] = value;
            this.array = Arrays.copyOf(array, array.length);
            System.out.println("Element has been added to array");
        }
    }
    @Override
    public void remove(int index) {
        Object[] array1 = new Object[this.array.length];
        if (index >= 0 && index <= this.array.length - 1) {
            if (index > 0 && index < this.array.length - 1) {
                System.arraycopy(this.array, 0, array1, 0, index);
                System.arraycopy(this.array, index + 1, array1, index, this.array.length - index - 1);
                this.array = Arrays.copyOf(array1, array1.length - 1);
                System.out.println("Element number " + index + " has been removed");
            }
            if (index == 0) {
                System.arraycopy(this.array, 1, array1, 0, this.array.length - 1);
                this.array = Arrays.copyOf(array1, array1.length - 1);
                System.out.println("First element has been removed");
            }
            if (index == this.array.length - 1 && index != 0) {
                System.arraycopy(this.array, 0, array1, 0, index);
                this.array = Arrays.copyOf(array1, array1.length - 1);
                System.out.println("Last element has been removed");
            }
        }else {
            System.out.println("Index out of bounds, there are no changes in array");
        }
    }
    @Override
    public void clear() {
        Object[] array2 = new Object[this.array.length];
        for (int i = 0; i < array2.length; i++) {
            System.arraycopy(this.array, 1, array2, 0, this.array.length - 1);
            this.array = Arrays.copyOf(array2, array2.length);
        }

        System.out.println("Array has been cleared");
    }
    @Override
    public int size(){
        int counter = 0;
        for (Object o : this.array) {
            if (o != null) {
                counter++;
            }
        }
        System.out.println("Array size is");
        return counter;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        System.out.println("Element number " + index + " is :");
        return (T) array[index];
    }
}

