package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import tad_fila_prioridade_heap.HeapPriorityQueue;

public class HeapPriorityQueueTests {
    @Test
    public void test(){
        HeapPriorityQueue<Integer, String> P = new HeapPriorityQueue<Integer, String>();
        P.insert(9, "C");
        P.insert(1, "A");
        P.insert(3, "Z");
        P.insert(6, "K");
        P.insert(2, "F");
        P.insert(7, "Q");
        P.insert(8, "B");
        
        System.out.println(P.toString());
        assertEquals("[null, [(1,A),1], [(2,F),2], [(3,Z),3], [(9,C),4], [(6,K),5], [(7,Q),6], [(8,B),7]]", P.toString());
        
    }
}
