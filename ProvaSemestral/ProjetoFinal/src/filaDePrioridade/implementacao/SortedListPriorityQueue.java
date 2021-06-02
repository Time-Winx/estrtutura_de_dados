package filaDePrioridade.implementacao;

import java.util.Comparator;

import javax.swing.text.Position;

import listaDeNodos.implementacao.NodePositionList;
import listaDeNodos.implementacao.PositionList;

public class SortedListPriorityQueue<K, V> implements PriorityQueue<K, V> {
    
    protected PositionList<Entry<K, V>> entries;
    protected Comparator<K> compa;
    protected Position<Entry<K, V>> actionPos;

    protected static class MyEntry<K, V> implements Entry<K, V> {
        protected K k;
        protected V v;
        public MyEntry(K key, V value) {
            k = key;
            v = value;
        }

        public K getKey() {return k;}
        public V getValue() {return v;}

        public String toString() {return "(" + k + "," + v + ")";}
    }

    public SortedListPriorityQueue() {
        entries = new NodePositionList<Entry<K, V>>(); 
        compa = new DefaultComparator<K>();
    }

    public SortedListPriorityQueue(Comparator<K> comp) {
        entries = new NodePositionList<Entry<K, V>>();
        compa = comp;
    }

    public SortedListPriorityQueue(PositionList<Entry<K, V>> list, Comparator<k> comp) {
        entries = list;
        compa = comp;
    }

    public void setComparator(Comparator<K> comp) throws IllegalStateException {
        if (!isEmpty()) throw new IllegalStateException("Priority queue is not empty");
        compa = comp;
    }

    public int size() {return entries.size();}

    public boolean isEmpty() {return entries.isEmpty();}

    public Entry<K, V> min() throws EmptyPriorityQueueException {
        if (entries.isEmpty()) throw new EmptyPriorityQueueException("priority queue is empty"); 
        else return entries.first().element();
    }

}