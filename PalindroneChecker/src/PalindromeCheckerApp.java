import java.util.*;

public class UseCase13PalindromeCheckerApp {

    public static boolean stackCheck(String input) {

        String s = input.replaceAll("\\s+", "").toLowerCase();

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            stack.push(c);
        }

        for (char c : s.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    public static boolean dequeCheck(String input) {

        String s = input.replaceAll("\\s+", "").toLowerCase();

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            deque.add(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }

    public static boolean reverseCheck(String input) {

        String s = input.replaceAll("\\s+", "").toLowerCase();

        String rev = "";

        for (int i = s.length() - 1; i >= 0; i--) {
            rev += s.charAt(i);
        }

        return s.equals(rev);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String input = sc.nextLine();

        long start1 = System.nanoTime();
        boolean r1 = stackCheck(input);
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        boolean r2 = dequeCheck(input);
        long end2 = System.nanoTime();

        long start3 = System.nanoTime();
        boolean r3 = reverseCheck(input);
        long end3 = System.nanoTime();

        System.out.println("Stack Result: " + r1);
        System.out.println("Stack Time: " + (end1 - start1));

        System.out.println("Deque Result: " + r2);
        System.out.println("Deque Time: " + (end2 - start2));

        System.out.println("Reverse Result: " + r3);
        System.out.println("Reverse Time: " + (end3 - start3));

        sc.close();
    }
}