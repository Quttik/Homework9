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
        Object[] newArray = new Object[this.array.length - 1];
        int newI = 0;
        for(int i = 0; i < array.length; i++) {
            if(i == index) {
                continue;
            }
            newArray[newI] = array[i];
            newI++;
        }
        array = newArray;
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

