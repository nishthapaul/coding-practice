package InterviewBit.arrays;

import java.util.*;

public class SpiralMatrix {
    public static ArrayList<Integer> spiralOrder(final ArrayList<ArrayList<Integer>> A) {
        int r = A.size();
        int c = A.get(0).size();
        ArrayList<Integer> B = new ArrayList<>(r * c);
        int rs = 0, cs = 0, re = r, ce = c;
        while (rs < re && cs < ce) {
            // right
            for (int j = cs; j < ce; j++) {
                B.add(A.get(rs).get(j));
            }
            rs++;

            // down
            for (int j = rs; j < re; j++) {
                B.add(A.get(j).get(ce - 1));
            }
            ce--;

            // left
            for (int j = ce - 1; j >= cs && re != rs; j--) {
                B.add(A.get(re - 1).get(j));
            }
            re--;

            // up
            for (int j = re - 1; j >= rs && ce != cs; j--) {
                B.add(A.get(j).get(cs));
            }
            cs++;
        }
        return B;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A1 = new ArrayList<>();
        A1.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        A1.add(new ArrayList<>(Arrays.asList(5, 6, 7, 8)));
        A1.add(new ArrayList<>(Arrays.asList(9, 10, 11, 12)));
        A1.add(new ArrayList<>(Arrays.asList(13, 14, 15, 16)));
        System.out.println(spiralOrder(A1));

        // [1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]

//        ArrayList<ArrayList<Integer>> A2 = new ArrayList<>();
//        A2.add(new ArrayList<>(Arrays.asList(5, 6, 7, 8)));
//        A2.add(new ArrayList<>(Arrays.asList(9, 10, 11, 12)));
//        A2.add(new ArrayList<>(Arrays.asList(13, 14, 15, 16)));
//        System.out.println(spiralOrder(A2));
        // [5, 6, 7, 8, 12, 16, 15, 14, 13, 9, 10, 11]
    }

    class StockPrice {
        HashMap<Integer, Integer> stock;
        int current_timestamp;
        PriorityQueue<Integer> minHeap;
        PriorityQueue<Integer> maxHeap;
        TreeMap<Integer, Integer> tmp;

        public StockPrice() {
            stock = new HashMap<>();
            tmp = new TreeMap<>();

            current_timestamp = 0;
            minHeap = new PriorityQueue<Integer>();
            minHeap.poll();
            maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        }

        public void update(int timestamp, int price) {
            Stack st = new Stack();
            Integer oldPrice = stock.put(timestamp, price);
            if (oldPrice != null) {
                minHeap.remove(price);
                maxHeap.remove(price);
            }
            current_timestamp = Math.max(current_timestamp, timestamp);
            minHeap.add(price);
            maxHeap.add(price);
        }

        public int current() {
            return stock.get(current_timestamp);
        }

        public int maximum() {
            return maxHeap.peek();
        }

        public int minimum() {
            return minHeap.peek();
        }
    }
}
