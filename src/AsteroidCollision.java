import java.util.ArrayList;
import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> currAsteroids = new Stack<>();

        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                currAsteroids.push(asteroid);
            } else {
                boolean broke = false;

                while (!currAsteroids.isEmpty() && currAsteroids.peek() > 0 && !broke) {
                    int peekAsteroid = currAsteroids.pop();
                    if (Math.abs(asteroid) < peekAsteroid) {
                        currAsteroids.push(peekAsteroid);
                        broke = true;
                    } else if (Math.abs(asteroid) == peekAsteroid) {
                        broke = true;
                    }
                }

                if ((currAsteroids.isEmpty() || currAsteroids.peek() < 0) && !broke) {
                    currAsteroids.push(asteroid);
                }
            }
        }

        ArrayList<Integer> remainAsteroids = new ArrayList<>();
        while (!currAsteroids.isEmpty()) {
            remainAsteroids.add(0, currAsteroids.pop());
        }

        return remainAsteroids.stream().mapToInt(i -> i).toArray();
    }
}
