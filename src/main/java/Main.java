import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main2(String[] args) {
        Parent p1 = new Parent();
        p1.build(); // Parent's build

        Child c1 = new Child();
        c1.build(); // Child's build

        Parent p2 = new Child();
        p2.build(); // Parent's build

        // Pair<Integer, Integer> p = new Pair<>(1,2);
        Map<Platform, Pair<Integer, Integer>> map = new HashMap<>();
        map.put(Platform.NETFLIX, new Pair<>(10,10));
        map.put(Platform.SONY_LIV, new Pair<>(2,5));
        map.put(Platform.HOTSTAR, new Pair<>(1,5));

        // method(viewingHoursOfNetflix, viewingHoursOfHotstar)
        final Pair<Integer, Integer> netflix = map.get(Platform.NETFLIX);
//        calAmount(netflix, viewingHoursOfNetflix);

//        Child c2 = (Child) new Parent();
//        c2.build(); ClassCastException
    }
}

/*
class Streaming
- Map<String, Pair<Integer, Integer>> map;
private calAmount(pair, viewingHours){*, / return amount;}
- amount to pay(viewingHoursOfNetflix=0, viewingHoursOfSonyLiv=0, viewingHoursOfHotstar=0) {
    pair p = map.get("netflix")
    calamount(p, viewingHoursOfNetflix)
}

Map<String, Pair<Integer, Integer>>

Main() {
    psvm(){
        map
        Streaming s = new Streaming(map);
    }
}

 */