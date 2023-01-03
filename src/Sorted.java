import java.util.HashSet;
import java.util.Set;

public class Sorted {
    public static void main(String[] arg) {
        Sorted s = new Sorted();
        System.out.println("Result=" + s.solution());
    }

    boolean solution() {
        int[] a = {-92, -23, -3, 10, 82, 82, 99, 83, 28, 0, -11,-89};
        if (a.length == 1) {
            return true;
        }
        int[] b = new int[a.length];
        Set s = new HashSet<>();
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            System.out.println("i==" + i + " a[i]=" + a[i] + " a[a.length-1-i]=" + a[a.length - 1 - i]);
            if (i >= a.length - 1 - i) {
                System.out.println("--3");
                break;
            }
            if (a[i] > a[a.length - 1 - i]) {
                System.out.println("--1");
                return false;
            }
            if (i == (a.length - 1 - i) && a[i] < a[i + 1]) {
                System.out.println("--2");
                return false;
            }
            b[j] = a[i];
            s.add(a[i]);
            b[j + 1] = a[a.length - 1 - i];

            s.add(a[a.length - 1 - i]);
            j = j + 2;

        }
        System.out.println("--4");
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i] + " ");
        }
        return s.size() == b.length ? true : false;
    }
}
