package test;

import com.google.common.collect.Lists;
import examples.TriFunctionExample;

import java.util.LinkedList;


public class MainTest {

    public static void main(String[] args) {

        String[] arrStr = {"[0 - 19]", "[20 - 24]", "[25 - 29]", "[30 - 34]", "[35 - 39]"
                , "[40 - 44]", "[45 - 49]", "[50 - 54]", "[55 - 59]", "[60 - 64]", "[65+]"};

        StringBuilder sb = new StringBuilder();
        String s = "test";


        System.out.println(sb.toString());
        System.out.println();
        System.out.print(s.toString());
//        triFunctionApplication((a, b, c) -> {
//            if (a * b == c) {
//                return true;
//            } else {
//                return false;
//            }
//        });

    }


    /*
     * Esempio del passaggio di un interfaccia funzionale come parametro
     */
    private static void triFunctionApplication(TriFunctionExample<Boolean, Integer, Integer, Integer> trifunc) {
        Boolean res = trifunc.apply(10, 10, 102);
        System.out.println();
        System.out.print("risultato applicazione trifunction " + res);

    }


}
