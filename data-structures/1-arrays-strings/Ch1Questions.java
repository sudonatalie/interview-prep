import java.util.*;
import java.io.*;

public class Ch1Questions {

    // Q1.1
    static boolean allUnique(String str) {
        if (str == null) return true;
        int n = str.length();
        for (int i = 0; i < n; i++) {
            // current character
            char current = str.charAt(i);
            // compare to every character after
            for (int j = i + 1; j < n; j++) {
                char compare = str.charAt(j);
                if (current == compare) return false;
            }
        }
        // no matches found
        return true;
    }

    static void test1() {
        assert(allUnique(null));
        assert(allUnique(""));
        assert(allUnique("a"));
        assert(allUnique("abc123"));
        assert(allUnique("aAbB"));
        assert(!allUnique("aa"));
        assert(!allUnique("Lorem ipsum"));
    }

    // Q1.3
    static HashMap<Character, Integer> getCharFrequency(String str) {
        HashMap<Character, Integer> freq = new HashMap<Character, Integer>();

        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (freq.containsKey(c))
                freq.put(c, freq.get(c) + 1);
            else
                freq.put(c, 1);
        }

        return freq;
    }

    static boolean equalFrequency(HashMap<Character, Integer> f1, HashMap<Character, Integer> f2) {
        if (f1.size() != f2.size()) {
            return false;
        }
        else {
            for(HashMap.Entry<Character, Integer> entry : f1.entrySet()) {
                Character character1 = entry.getKey();
                Integer count1 = entry.getValue();
                Integer count2 = f2.get(character1);
                if (count2 == null || count1 != count2)
                    return false;
            }

            return true;
        }
    }

    static boolean isPermutation(String str1, String str2) {
        if (str1 == null || str2 == null) return false;
        HashMap<Character, Integer> freq1, freq2;
        freq1 = getCharFrequency(str1);
        freq2 = getCharFrequency(str2);
        return (equalFrequency(freq1, freq2));
    }

    static void test3() {
        assert(!isPermutation(null, null));
        assert(isPermutation("", ""));
        assert(isPermutation("a", "a"));
        assert(isPermutation("abc", "acb"));
        assert(!isPermutation("foo", "bar"));
        assert(isPermutation("AAaaBB", "BAaBAa"));
        assert(!isPermutation("AAaaBB", "AaB"));
    }


    public static void main(String[] args) {
        test1();
        test3();
    }
}