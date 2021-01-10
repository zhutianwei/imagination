package com.zhu;

import com.zhu.*;
import java.util.*;
import java.util.concurrent.*;
import org.apache.commons.lang3.*;
// import java.util.Scanner;
// import java.util.Arrays; 
// import com.google.common.collect.*;
// import com.google.common.base;

public class App {
    public static void main(String[] args) {
        
        

    }   

    // O(N * log(N))
    // O()
    public static void findAnagrams() {

        // ArrayList<String> strs = new ArrayList<>(Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat"));
        ArrayList<String> strs = new ArrayList<>(Arrays.asList("EAt", "tEA", "tan", "atE", "nat", "bat", "aabb", "baab"));
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        for (String string: strs) {
            String sortedString = sortedString(string);
            if (!map.containsKey(sortedString)) {
                map.put(sortedString, new ArrayList<String>());
                map.get(sortedString).add(string);
            } else {
                map.get(sortedString).add(string);
            }
        }

        for (ArrayList<String> list: map.values()) {
            System.out.println(list);
        }
    }

    public static String sortedString(String string) {
        String lowercaseString = string.toLowerCase();
        char[] charArray = lowercaseString.toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);

    }

    public static int[] twoSum(int[] arr, int sum) {
         
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        for (int i = 0; i < arr.length; i++) {
            
            if (!map.containsKey(sum - arr[i])) {
                map.put(arr[i], arr[i]);

            } else {
                return new int[] {sum-arr[i], arr[i]};
            }
                
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    public static void test10() {
        int[] array = new int[3];
        System.out.println(array);
        // ArrayList<Integer> list = new ArrayList<>(Arrays.asList(array));
        List<Integer> list = Arrays.asList(1,2,3);
        String s = String.valueOf(list);
        System.out.println(s);

        List<List<Integer>> matrix = new ArrayList<List<Integer>>();
        for (int i = 0; i < list.size(); i++) {
            matrix.add(Arrays.asList(1,2,3));
        }
       
        System.out.println(matrix);

        // PriorityQueue<int[]> prior = new PriorityQueue<int[]>();

        // prior.add({1,2});
        // System.out.println(prior);

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);

        // Set<Entry<String,String>> entrySet = map.entrySet();
        // for (Entry<String, String> entry : entrySet) {
        //     String key = entry.getKey();
        //     String value = entry.getValue();
        // }


        int one = 1;
        int two = 2;
        int max = Math.max(one, two);
        System.out.println(max);

    }

    public static void test9() {
        // StringBuilder str = new StringBuilder();
        // str.append("hello");
        // str.append("world");
        // str.reverse();
        // System.out.println(str);        

        String b = "23";
        int e = 2;
        long g = e;

        String string = "abc ede";
        String[] stringArray = string.split(" ");
        for (int i = 0; i < stringArray.length; i++) {
            System.out.println(stringArray[i]);
        }

        String res = String.join("", stringArray);
        System.out.println(res);
        
        Queue<Integer> result = new LinkedList<>();
        result.add(1);
        System.out.println(result.peek());
    }

    public static void test8() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));
        
        // List<String> array = Lists.newArrayList("a", "b", "c", "d");
        // for (int i = 0; i < array.size(); i++) {
        //     System.out.println(array.get(i));
        // }
    }

    public static void test7() {
        Integer a = 1;
        int b = a;
        System.out.println(a.getClass().getName());       
    }

    public static void test6() {
        String s = "12";
        char a = 'b';
        System.out.println(((Object) a).getClass().getName());
    }

    public static void test5() {
        Helper obj = new Helper(2);
        Helper obj2 = new Helper(2);
        System.out.println(obj.hashCode());
        System.out.println(obj2.hashCode());
        System.out.println(obj.equals(obj2));
    }

    public static void test4() {
        int[] array = {1,3,2};
        // array[0] = 1;

        Arrays.sort(array);

        for (int i=0; i < array.length; i++) {
            System.out.println(array[i]); 
        }
    }

    public static void test3() {
        int x = 12;
        System.out.println(hello(x));

        String chars = "hello";

        if (chars.startsWith("h") && chars.length() == 5) {
            System.out.println("Yes");
        
        }
    }

    public static void test2() {
        String a = "hello word";
        String[] list = a.split(" ");

        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]); 
        }
    }

    public static void test1() {
        int[] arr = {13, 7, 6, 45, 21, 9, 101, 102}; 
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]); 
        }
    }

    public static void test0() {
        List<List<Integer>> result = part(new int[] {1,2,3,4,5,6,7,8,9,10}, 3);
        System.out.println(result);
    }

    public int solution(String input) {
        if(input.length() == 0)
            return 2;
        int result = 0;
        char c = input.charAt(0);
        int countOfAs = c == 'a'?1:0;

        System.out.println(countOfAs);

        result += c != 'a'?2:0;
        for (int i = 1; i <= input.length(); i++) {
            if(i == input.length()){
                result += 2-countOfAs;
                break;
            }
            c = input.charAt(i);
            if(c != 'a'){
                result += 2-countOfAs;
                countOfAs = 0;
    
            }else{
                countOfAs++;
            }
            if(countOfAs>=3)
                return -1;
    
        }
        return result;
    }

    public static int hello(int x) {
        return x * 2;
    }

    public static List<List<Integer>> part(int[] T, int n) {
		int[] sums = new int[n];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		List<List<Integer>> result = new ArrayList<>();
		// for (int i = 0; i < n; i++) {
		// 	result.add(new ArrayList<>());
		// 	pq.add(i);
		// }
		
		for (int i = T.length - 1; i >= 0; i--) {
			int c = pq.poll();
			result.get(c).add(T[i]);
			sums[c] += T[i];
			pq.add(c);
		}
		
		return result;
    }
    
}
