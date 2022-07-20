import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void main(String[] args) {
        final Item item1 = new Item(4, 20);
        final Item item2 = new Item(3, 18);
        final Item item3 = new Item(2, 14);

        final Item[] items = {item1, item2, item3}; // набор всех имеющихся предметов

        // сортировка массива items с помощью компоратора,
        // компаратор куководствуется логикой установленного метода
        // сложность алгоритма быстрой сортировки О(N*log(N)), N - количество предметов в items
        Arrays.sort(items, Comparator.comparingDouble(Item::valuePerUnitOfWeight).reversed());

        System.out.println(Arrays.toString(items)); // вывод на экран отсортированного массива

        final int W = 7; // вместимость рюкзака

        int weightSoFar = 0; // аккумулирование текущего веса
        double valueSoFar = 0; // аккумулирование набранной ценности
        int currentItem = 0; // индекс текущего предмета

        while (currentItem < items.length && weightSoFar != W) {
            if (weightSoFar + items[currentItem].getWeigt() < W) {  // берётся объект целиком
                valueSoFar += items[currentItem].getValue();
                weightSoFar += items[currentItem].getWeigt();
            } else { // берётся часть объекта
                valueSoFar += ((W - weightSoFar) / (double) items[currentItem].getWeigt()) *
                        items[currentItem].getValue();
                weightSoFar = W; // полный рюкзак
            }
            currentItem++;
        }
        System.out.println("Ценность наилучшего набора: " + valueSoFar);
    }
}
class Item{
    private int weigt; // вес
    private int value; // ценность

    public Item(int weigt, int value) {
        this.weigt = weigt;
        this.value = value;
    }

    // метод вычисляющий ценность предмета на единицу веса
    public double valuePerUnitOfWeight() {
        return value / (double) weigt;
    }

    public int getWeigt() {
        return weigt;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        return "{w:" + weigt + ",v:" + value + "}";
    }
}
