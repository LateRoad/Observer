package com.lateroad.kickstart.collection;

import com.lateroad.kickstart.entity.shape.AbstractShape;
import com.lateroad.kickstart.entity.shape.observer.Characteristics;

import java.util.*;

public class ShapeObservableList<E extends AbstractShape> implements List {
    private static final ShapeObservableList instance = new ShapeObservableList();

    private List<E> list;

    public static ShapeObservableList getInstance() {
        return instance;
    }

    private ShapeObservableList() {
        list = new ArrayList<>();
    }


    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public Iterator iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public boolean add(Object o) {
        E shape = (E) o;
        shape.registerObserver(new Characteristics());
        shape.notifyObservers();
        return list.add(shape);
    }

    @Override
    public boolean remove(Object o) {
        E shape = (E) o;
        shape.removeObservers();
        return list.remove(shape);
    }

    @Override
    public boolean addAll(Collection c) {
        boolean result = true;
        List<E> additionList = (ArrayList<E>) c;
        for (E shape : additionList) {
            shape.registerObserver(new Characteristics());
            shape.notifyObservers();
            if (!list.add(shape)) {
                result = false;
            }
        }
        return result;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        boolean result = true;
        List<E> additionList = (ArrayList<E>) c;
        for (E shape : additionList) {
            shape.registerObserver(new Characteristics());
            shape.notifyObservers();
            list.add(index++, shape);
        }
        return result;
    }

    @Override
    public void clear() {
        for (E shape : list) {
            shape.removeObservers();
        }
        list.clear();
    }

    @Override
    public E get(int index) {
        return list.get(index);
    }

    @Override
    public E set(int index, Object element) {
        E newShape = (E) element;
        E oldShape = list.get(index);
        oldShape.removeObservers();
        newShape.registerObserver(new Characteristics());
        return list.set(index, newShape);
    }

    @Override
    public void add(int index, Object element) {
        E newShape = (E) element;
        newShape.registerObserver(new Characteristics());
        newShape.notifyObservers();
        list.add(index, newShape);
    }

    @Override
    public E remove(int index) {
        list.get(index).removeObservers();
        return list.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return list.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return list.lastIndexOf(o);
    }

    @Override
    public ListIterator listIterator() {
        return list.listIterator();
    }

    @Override
    public ListIterator listIterator(int index) {
        return list.listIterator(index);
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return list.subList(fromIndex, toIndex);
    }

    @Override
    public boolean retainAll(Collection c) {
        return list.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection c) {
        List<E> listForDelete = (ArrayList<E>) c;
        for (E shape : listForDelete) {
            shape.removeObservers();
        }
        return list.removeAll(c);
    }

    @Override
    public boolean containsAll(Collection c) {
        return list.containsAll(c);
    }

    @Override
    public Object[] toArray(Object[] a) {
        return list.toArray(a);
    }
}
