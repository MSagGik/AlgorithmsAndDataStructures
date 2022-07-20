import java.util.Arrays;
import java.util.Collections;

public class GreedyAlgorithms {
    public static void main(String[] args) {
        int[] digits = {3, 1, 7, 9, 9, 5};
        System.out.println(maxNumberFromDigitsA(digits));

    }
    public static String maxNumberFromDigits(int[] digits) {
        // 1) нужно отсортировать {3, 1, 7, 9, 9, 5} -> {1, 3, 5, 7, 9, 9}
        // сложность сортировки равняется О(n*log(n))
        // 2) получившийся массив нужно сконкетинировать
        // сложность сортировки равняется континеровки массива О(n)
        // итоговая сложность равняется О(n*log(n))
        Arrays.sort(digits);
        String result = ""; // формируется пустая строка
        for(int i = digits.length-1; i>=0; i--) // добавляются к строке задом на перед числа из отсортированного массива
            result += digits[i];
        return result;
    }

    // Альтернативный способ решить задачу с java 8
    public static String maxNumberFromDigitsA(int[] digits) {
        return  String.join("", Arrays.stream(digits).boxed() // метод join имеет 1 аргумент "" раздедитель
                // (по нему происходит склейка массива), а второй аргумент это сам массив
                // stream(digits) - перевод в поток лямда выражения
                // boxed() - для оборачивания примитивов в классы обёртки
                .sorted(Collections.reverseOrder()) // сортировка элементов в обратном порядке
                .map(String::valueOf) // перевод чисел в строки
                .toArray(String[]::new)); // перевод в массив строк
    }
}
