package InterviewBit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {
    private static int solve(ArrayList<Integer> A) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) > 0) {
                set.add(A.get(i));
            }
        }
        if (set.size() == 0) {
            return 1;
        }
        int i=1;
        for (int idx=0; idx<set.size(); idx++) {
            if (!set.contains(i)) {
                break;
            }
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A1 = new ArrayList<>(Arrays.asList(1, 0, 2)); // 3
        ArrayList<Integer> A2 = new ArrayList<>(Arrays.asList(3, 4, -1, 1)); // 2
        ArrayList<Integer> A3 = new ArrayList<>(Arrays.asList(-8, -7, -6)); // 1
        ArrayList<Integer> A4 = new ArrayList<>(Arrays.asList(413, 599, 995, 560, 703, 514, 230, 696, 828, 916, 503, 439, 601, 378, 168, 347, 629, 875, 383, 800, 963, 621, 742, 315, 1, 924, 333, 586, 508, 613, 314, 184, 281, 740, 129, 284, 72, 442, 722, 958, 658, 289, 121, 566, 79, 525, 206, 743, 263, 453, 68, 814, 201, 598, 524, 527, 946, 698, 469, 424, 31, 702, 156, 402, 949, 980, 345, 766, 214, 231, 224, 450, 516, 650, 965, 717, 48, 61, 663, 819, 455, 753, 721, 611, 917, 440, 715, 372, 358, 24, 794, 266, 435, 909, 504, 66, 572, 670, 86, 319, 271, 244, 904, 912, 815, 25, 591, 532, 355, 103, 891, 360, 220, 952, 960, 718, 748, 759, 936, 489, 207, 166, 317, 637, 109, 847, 903, 494, 51, 922, 248, 119, 899, 931, 884, 60, 656, 376, 135, 285, 83, 841, 955, 835, 465, 444, 112, 880, 174, 760, 305, 191, 429, 682, 398, 434, 710, 295, 393, 466, 343, 324, 80, 238, 261, 762, 202, 729, 131, 426, 624, 452, 697, 14, 893, 990, 235, 270, 267, 593, 541, 842, 523, 679, 768)); // 2
//        System.out.println(bfs(A1));
//        System.out.println(bfs(A2));
//        System.out.println(bfs(A3));
        long B = 90;
        System.out.println(new ArrayList<Integer>(Arrays.asList(1, 2)));
        System.out.println(solve(A4));
    }
}

/*
Q: Find first missing number when the array is of size n-1 and integers are from 1 to n
Then we can n*(n-1)/2 - take their sum
 */