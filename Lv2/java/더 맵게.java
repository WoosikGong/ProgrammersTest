import java.util.*;

class Solution {

    long[] heap;
    int heapSize = 0;
    int size = 0;

    public int solution(int[] scoville, int K) {
        int answer = -1;
        int count = 0;
        heapSize = scoville.length + 1;
        heap = new long[heapSize];

        Arrays.sort(scoville);
        for(int sc : scoville) heap[++size] = sc;

        while(true){
            if(heap[1] >= K) break;
            if(size == 1) return -1;
            long point = pop() + pop() * 2;
            insert(point);
            count++;

        }

        return count;
    }

    public long pop(){
        int index = 1;
        long root = heap[index];

        if(size == 0) return 0;

        heap[index] = 0;
        swap(index, size);

        while((index * 2) < size){

            if (heap[index*2 + 1] <= 0 || heap[index*2] <= heap[index*2 + 1]) {
                if(heap[index] > heap[index*2]) {
                    swap(index, index * 2);
                    index *= 2;
                }
                else break;
            }
            else if (heap[index*2 + 1] > 0 && heap[index*2] > heap[index*2 + 1]) {
                if(heap[index] > heap[index * 2 + 1]) {
                    swap(index, index * 2 + 1);
                    index = index * 2 + 1;
                }
                else break;
            }
        }
        size--;
        return root;
    }

    public void insert(long n) {
        int index = ++size;
        heap[size] = n;

        while(index > 1){
            if (heap[index] < heap[index / 2]){
                swap(index, index/2);
            }
            else break;

            index/=2;
        }
    }

    public void swap(int n1, int n2){
        long temp = heap[n1];
        heap[n1] = heap[n2];
        heap[n2] = temp;
    }
}