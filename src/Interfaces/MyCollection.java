package Interfaces;

public interface MyCollection <T> {
      void add(T value);
      void remove(int index);
      void clear();
      int size();
     T get(int index);
}
