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

    private void verificarEsctructura(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int largestIndex = index;

        if (leftChildIndex < heap.size() && heap.get(leftChildIndex).compareTo(heap.get(largestIndex)) > 0) {
            largestIndex = leftChildIndex;
        }
        if (rightChildIndex < heap.size() && heap.get(rightChildIndex).compareTo(heap.get(largestIndex)) > 0) {
            largestIndex = rightChildIndex;
        }
        if (largestIndex != index) {
            intercambio(index, largestIndex);
            verificarEsctructura(largestIndex);
        }
    }

    private void intercambio(int index1, int index2) {
        T temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }
    
    public void mostrarDatosInsertados(Heap<?> heap) {
        System.out.println("Datos insertados en el Heap:");
        
        while (!heap.isEmpty()) {
        System.out.print("["+heap.remove()+"]");
        }
        System.out.println();
    } 

}
