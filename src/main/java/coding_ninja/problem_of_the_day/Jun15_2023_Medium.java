package coding_ninja.problem_of_the_day;

import java.util.* ;

public class Jun15_2023_Medium {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[][] trans = new int[8][4];
        trans[0] = new int[]{790594156,1081,778,3};
        trans[1] = new int[]{119562861,97,788,5};
        trans[2] = new int[]{506060393,251,629,36};
        trans[3] = new int[]{76786416,1024,657,41};
        trans[4] = new int[]{455639442,27,1189,58};
        trans[5] = new int[]{650478459,799,1009,2};
        trans[6] = new int[]{642126938,374,1020,13};
        trans[7] = new int[]{191304279,630,443,1};

//        int[][] trans = new int[2][4];
//        trans[0] = new int[]{1,30,1500,1};
//        trans[1] = new int[]{1,20,500,2};

        final List<int[]> ints = invalid_transactions(trans, 8);
        System.out.println("output");
        printList(ints);
    }

    static int custid_idx = 0;
    static int time_idx = 1;
    static int amount_idx = 2;
    static int city_idx = 3;

    public static ArrayList<int[]> invalid_transactions(int[][] transactions, int n) {

        Set<int []> resSet = new HashSet<>();
        ArrayList<int []> resArr = new ArrayList<>();
        Map<Integer, List<int []>> map = new LinkedHashMap<>();

        for (int i=0; i<n; i++) {
            int[] trans = transactions[i];
            if (trans[amount_idx] > 1000) {
                System.out.println("adding " + trans[custid_idx]);
                resSet.add(trans);
                resArr.add(trans);
            }
            List<int []> l = map.getOrDefault(trans[custid_idx], new ArrayList<>());
            l.add(trans);
            map.put(trans[custid_idx], l);
        }

        printRes(resSet);

        printMap(map);

        System.out.println("..............");

        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[time_idx] - t2[time_idx];
            }
        };

        for (int cust_id : map.keySet()) {
            List<int[]> l = map.get(cust_id);
            if (l.size() > 1) {
                l.sort(comparator);
                System.out.println("cust_id " + cust_id);
                printList(l);
                getInvalid(l, resSet, resArr);
            }
        }
        System.out.println("printing out put set");
        printRes(resSet);
        return resArr;
    }
    public static void getInvalid(List<int[]> l, Set<int[]> resSet, List<int[]> resArr) {
        for (int i=1; i<l.size(); i++) {
            int[] prev = l.get(i-1);
            int[] next = l.get(i);
            System.out.println("prev next");;
            display(prev);
            display(next);
            if (prev[city_idx] != next[city_idx]) {
                if (prev[time_idx] + 60 > next[time_idx] ) {
                    if(!resSet.contains(prev)) {
                        resArr.add(prev);
                        resSet.add(prev);
                    }
                    if(!resSet.contains(next)) {
                        resArr.add(next);
                        resSet.add(next);
                    }
                }
            }
        }
    }

    public static void printRes( Set<int []> l) {
        System.out.println("printing Result array");
        for (int[] tr : l) {
            display(tr);
        }
    }

    public static void printList( List<int []> l) {
        for (int[] tr : l) {
            display(tr);
        }
    }

    public static void printMap(Map<Integer, List<int []>> map) {
        System.out.println("printing map");
        for (int i : map.keySet()) {
            System.out.println("key - " + i);
            printList(map.get(i));
        }
    }

    public static void display(int[] trans) {
        for (int t : trans) {
            System.out.print(t + " ");
        }
        System.out.print("\n");
    }
}