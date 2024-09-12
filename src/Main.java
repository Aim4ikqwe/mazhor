import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Создаем объект сканнера
        System.out.println("Введите длинну массива: ");
        int length = input.nextInt();

        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) { // Цикл для заполнения массива
            System.out.println("Введите элемент массива: ");
            array[i] = input.nextInt();
        }

        System.out.println("Введите процент мажоритарности: ");
        double coefficient = length * (input.nextDouble() / 100); // Находим коэффицент мажоритарности

        HashMap<Integer, Integer> hashMap = new HashMap<>(); // Создаем хэшмапу
        for (int n : array) { // Цикл для заполнения хэшмапы
            hashMap.put(n, hashMap.getOrDefault(n, 0) + 1); // Помещаем в хэшмапу значения где n - ключ(вводимое число), а value (кол-во входов)
        }

        System.out.println("Мажоритарные элементы массива: ");
        boolean majorityElements = false;
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() >= Math.ceil(coefficient)) { // Проверяем кол-во входов числа с коэф. мажоритарности
                System.out.println(entry.getKey()); // Выводим мажоритарное число Key
                majorityElements = true; // Задаем значение true, что мажоритарное число существует
            }
        }
        if (!majorityElements) {
            System.out.println("Нет мажоритарных элементов в массиве.");
        }
    }
}