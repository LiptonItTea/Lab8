package org.linkedlist;

public interface List<T> extends Iterable<T>{
    void add(int index, T element);
    boolean addAll(int index, List<T> c);
    void addFirst(T e);
    void addLast(T e);
    void clear();
    boolean contains(Object o);
    boolean containsAll(List<T> c);
    boolean equals(Object o);
    T get(int index);
    T getFirst();
    T getLast();
    int hashCode();
    int indexOf(Object o);
    boolean isEmpty();
    int lastIndexOf(Object o);
    T remove(int index);
    boolean remove(Object o);
    T removeFirst();
    T removeLast();
    List<T> reversed();
    void set(int index, T element);
    int size();
    Object[] toArray();
}
