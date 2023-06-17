package Ejercicio5cd;

import java.util.*;
/**
    La clase Heap<T> es una implementación de un montículo binario utilizando un ArrayList 
    para almacenar los elementos. El tipo genérico T se limita a aquellos tipos que 
    implementan la interfaz Comparable<T>, lo que significa que los elementos pueden ser 
    comparados entre sí. 
    *
 */
class Heap<T extends Comparable<T>> {
    private List<T> heap;

    public Heap() {
        heap = new ArrayList<>();
    }

    public void insert(T item) {
        heap.add(item);
        ajustarEstructura(heap.size() - 1);
    }

    public T remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        T root = heap.get(0);
        T lastItem = heap.remove(heap.size() - 1);
        if (!isEmpty()) {
            heap.set(0, lastItem);
            verificarEsctructura(0);
        }
        return root;
    }

    public T devolverElemento() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private void ajustarEstructura(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && heap.get(index).compareTo(heap.get(parentIndex)) > 0) {
            intercambio(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }


}
