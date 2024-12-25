package org.linkedlist;

import java.util.*;
import java.util.function.Consumer;

public class LinkedList <T> implements List<T> {
    private Node head = null;
    private Node tail = null;
    private int size = 0;

    private class LinkedListIterator implements Iterator<T>{
        private Node curr;

        private LinkedListIterator(){
            this.curr = head;
        }

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public T next() {
            Node result = curr;
            curr = curr.next;
            return result.value;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    @Override
    public void forEach(Consumer action) {
        Iterator<T> iterator = new LinkedListIterator();
        while (iterator.hasNext()){
            action.accept(iterator.next());
        }
    }

    private class Node {
        public Node prev = null;
        public Node next = null;
        public T value;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0)
            throw new IndexOutOfBoundsException("Index must be greater than 0.");

        if (index == 0) {
            addFirst(element);
            return;
        }

        if(index == size){
            addLast(element);
            return;
        }

        Node node = new Node();
        node.value = element;
        if (index > size)
            throw new IndexOutOfBoundsException("Index must be lower then the list size.");

        Node curr = head;
        for (int i = 0; i < index - 1; i++){
            curr = curr.next;
        }

        Node next = curr.next;

        curr.next = node;
        next.prev = node;

        node.prev = curr;
        node.next = next;
        size++;
    }

    private boolean addAllFirst(List<T> c){
        if (c.size() == 0)
            return false;
        addFirst(c.getFirst());

        Node curr = head;

        boolean first = true;

        for (T element : c){
            if (first){
                first = false;
                continue;
            }

            Node next = new Node();
            next.value = element;
            if (curr.next != null)
                curr.next.prev = next;
            curr.next = next;
            curr = next;
            size++;
        }

        return true;
    }

    private boolean addAllLast(List<T> c) {
        if (c.size() == 0)
            return false;
        addLast(c.getLast());

        Node curr = tail;

        boolean first = true;
        for (T element : c){
            if (first) {
                first = false;
                continue;
            }

            Node next = new Node();
            next.value = element;
            curr.next = next;
            next.prev = curr;
            curr = next;
            size++;
        }

        return true;
    }

    @Override
    public boolean addAll(int index, List<T> c) {
        if (index < 0)
            throw new IndexOutOfBoundsException("Index must be greater than 0.");
        if (index > size)
            throw new IndexOutOfBoundsException("Index must be lower then the list size.");

        if (index == 0)
            return addAllFirst(c);

        if (index == size)
            return addAllLast(c);

        Node curr = head;
        for (int i = 0; i < index - 1; i++)
            curr = curr.next;

        for (T element : c){
            Node next = new Node();
            next.value = element;

            curr.next.prev = next; next.next = curr.next;
            curr.next = next; next.prev = curr;

            curr = next;
            size++;
        }

        return true;
    }

    @Override
    public void addFirst(T e) {
        Node node = new Node();
        node.value = e;

        if (size == 0){
            size++;
            head = tail = node;
            return;
        }

        size++;
        node.next = head;
        head.prev = node;
        head = node;
    }

    @Override
    public void addLast(T e) {
        Node node = new Node();
        node.value = e;

        if (size == 0){
            size++;
            tail = head = node;
            return;
        }

        size++;
        node.prev = tail;
        tail.next = node;
        tail = node;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null)
            return false;

        for (T element : this){
            if (o.equals(element))
                return true;
        }

        return false;
    }

    @Override
    public boolean containsAll(List<T> c) {
        Set<T> found = new HashSet<>();
        for (T element : this)
            found.add(element);

        for (T element : c)
            if (!found.contains(element))
                return false;

        return true;
    }

    @Override
    public T get(int index) {
        if (index < 0)
            throw new IndexOutOfBoundsException("Index must be greater than 0.");
        if (index >= size)
            throw new IndexOutOfBoundsException("Index must be lower than list size.");

        Node curr = head;
        for (int i = 0; i < index; i++)
            curr = curr.next;

        return curr.value;
    }

    @Override
    public T getFirst() {
        if (head == null)
            return null;

        return head.value;
    }

    @Override
    public T getLast() {
        if (tail == null)
            return null;

        return tail.value;
    }

    @Override
    public int indexOf(Object o) {
        if (size == 0)
            return -1;

        Node curr = head;
        for (int i = 0; i < size; i++){
            if (o.equals(curr.value))
                return i;

            curr = curr.next;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (size == 0)
            return -1;

        Node curr = head;
        int lastIndex = -1;
        for (int i = 0; i < size; i++){
            if (o.equals(curr.value))
                lastIndex = i;

            curr = curr.next;
        }

        return lastIndex;
    }

    @Override
    public T remove(int index) {
        if (index < 0)
            throw new IndexOutOfBoundsException("Index must be greater than 0.");
        if (index >= size)
            throw new IndexOutOfBoundsException("Index must be lower than list size.");
        if (size == 1) {
            T result = head.value;
            clear();
            return result;
        }
        if (index == 0)
            return removeFirst();
        if (index == size - 1)
            return removeLast();

        size--;
        Node curr = head;
        for (int i = 0; i < index; i++)
            curr = curr.next;

        if (curr.prev != null)
            curr.prev.next = curr.next;
        if (curr.next != null)
            curr.next.prev = curr.prev;

        return curr.value;
    }

    @Override
    public boolean remove(Object o) {
        if (size == 0)
            return false;

        Node curr = head;
        for (int i = 0; i < size; i++){
            if (o.equals(curr.value)){
                if (i == 0) {
                    removeFirst();
                    return true;
                }
                if (i == size - 1) {
                    removeLast();
                    return true;
                }

                size--;
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
                return true;
            }
            curr = curr.next;
        }

        return false;
    }

    @Override
    public T removeFirst() {
        if (head == null)
            return null;
        T result = head.value;

        if (size == 1) {
            clear();
            return result;
        }

        size--;
        head.next.prev = null;
        head = head.next;

        return result;
    }

    @Override
    public T removeLast() {
        if (head == null)
            return null;
        T result = tail.value;

        if (size == 1) {
            clear();
            return result;
        }

        size--;
        tail.prev.next = null;
        tail = tail.prev;

        return result;
    }

    @Override
    public List<T> reversed() {
        List<T> list = new LinkedList<>();
        for (T element : this)
            list.addFirst(element);

        return list;
    }

    @Override
    public void set(int index, T element) {
        if (index < 0)
            throw new IndexOutOfBoundsException("Index must be greater than 0.");
        if (index >= size)
            throw new IndexOutOfBoundsException("Index must be lower than list size");

        Node curr = head;
        for (int i = 0; i < index; i++)
            curr = curr.next;

        curr.value = element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        
        if (size == 0)
            return array;

        Node curr = head;
        for (int i = 0; i < size; i++) {
            array[i] = curr.value;
            curr = curr.next;
        }

        return array;
    }
}
