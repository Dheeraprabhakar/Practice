import java.util.ArrayDeque;
import java.util.Deque;

class Collision {
    public static void main(String a[]){
        Collision s = new Collision();
        int[] asteroids = new int[]{10,2,-5};
        s.asteroidCollision(asteroids);
    }
    public int[] asteroidCollision(int[] asteroids) {
        if (null == asteroids || 0 == asteroids.length)
            return new int[]{};

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < asteroids.length; ++i) {
            int curr = asteroids[i];
            boolean push = true;
            while (!stack.isEmpty() && stack.peek() > 0 && curr < 0) {
                int peekAbs = Math.abs(stack.peek());
                int currAbs = Math.abs(curr);

                if (peekAbs >= currAbs) {
                    push = false;
                    if (peekAbs == currAbs) {
                        stack.pop();
                    }

                    break;
                } else {
                    stack.pop();
                }
            }

            if (push) {
                stack.push(curr);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; --i)
            result[i] = stack.pop();

        return result;
    }
}