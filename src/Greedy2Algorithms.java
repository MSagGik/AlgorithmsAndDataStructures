import java.util.Arrays;
import java.util.Collections;

public class Greedy2Algorithms {
    public static void main(String[] args) {
        int[] stations = {0, 200, 375, 550, 750, 950};
        System.out.println(minStops(stations, 400));
    }
    public static int minStops(int[] stations, int capacity) {
        int result = 0; // оптимальное количество остановок
        int currentStop = 0; // местоположение автомобиля
        while (currentStop < stations.length - 1) {
            int nextStop = currentStop; // машина на старте

            while (nextStop < stations.length - 1 &&
                    stations[nextStop + 1] - stations[currentStop] <= capacity)
                nextStop++;
            if (currentStop == nextStop) // условие когда растояние между заправками
                // больше чем может проехать машина на одной запраке
                return -1;
            if (nextStop < stations.length - 1)
                result++;
            currentStop = nextStop; // машина доехала до конечной точки
        }
        return result;
    }
}
