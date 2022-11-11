package Interfaces;

public interface MyCollection <T> {
    public  void add(T value);
    public  void remove(int index);
    public  void clear();
    public  int size();
    public T get(int index);
}
