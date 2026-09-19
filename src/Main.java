import java.util.Locale;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Main {
    // Задание 1 (Методы)
    // 1)
    public double fraction(double x) {
        return x - (int) x;
    }
    // 2)
    public int sumLastNums(int x) {
        x = Math.abs(x);
        int last = x % 10;
        int secondLast = (x / 10) % 10;

        return last + secondLast;
    }
    // 6)
    public boolean isUpperCase(char x) {
        return x >= 'A' && x <= 'Z';
    }
    // 7)
    public boolean isInRange(int a, int b, int num) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);

        return num >= min && num <= max;
    }
    // 10)
    public int lastNumSum(int a, int b) {
        return (a % 10) + (b % 10);
    }

    // Задание 2. Условия
    // 1)
    public int abs(int x) {
        if (x < 0) return -x;
        return x;
    }
    // 4)
    public String makeDecision(int x, int y) {
        if (x < y) return x + " < " + y;
        if (x > y) return x + " > " + y;
        return x + " == " + y;
    }
    // 5)
    public int max3(int x, int y, int z) {
        int max = x;
        if (y > max) max = y;
        if (z > max) max = z;
        return max;
    }
    // 8)
    public String age(int x) {
        int lastDigit = x % 10;
        int lastTwoDigits = x % 100;

        if (lastTwoDigits >= 11 && lastTwoDigits <= 24) {
            return x + " лет";
        }
        if (lastDigit == 1) {
            return x +  " год";
        }
        if (lastDigit >= 2 && lastDigit <= 4) {
            return x + " года";
        }
        return x + " лет";
    }
    // 9)
    public String day(int x) {
        switch (x) {
            case 1: return "понедельник";
            case 2: return "вторник";
            case 3: return "среда";
            case 4: return "четверг";
            case 5: return "пятница";
            case 6: return "суббота";
            case 7: return "воскресенье";
            default: return "это не день недели";
        }
    }

    // Задание 3. Циклы
    // 2)
    public String reverseListNums(int x) {
        if (x < 0) {
            return "Ошибка: число не может быть меньше 0";
        }

        StringBuilder result = new StringBuilder();

        for (int i = x; i >= 0; i--) {
            result.append(i);
            if (i > 0) {
                result.append(" ");
            }
        }

        return result.toString();
    }
    // 3)
    public String chet(int x) {
        if (x < 0) {
            return "Ошибка: число не может быть меньше 0";
        }
        StringBuilder result = new StringBuilder("0");
        for (int i = 2; i <= x; i += 2) {
            result.append(" ").append(i);
        }

        return result.toString();
    }
    // 7)
    public void square(int x) {
        if (x <= 0) {
            System.out.println("Ошибка: размер квадрата должен быть больше 0");
            return;
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    // 8)
    public void leftTriangle(int x) {
        if (x <= 0) {
            System.out.println("Ошибка: высота треугольника должна быть больше 0");
            return;
        }

        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    // 10)
    public void guessGame() {
        Scanner scan = new Scanner(System.in);

        int secretNumber = (int) (Math.random() * 10);
        int attempts = 0;

        System.out.println("Я загадал число от 0 до 9. Попробуйте угадать!");

        while (true) {
            System.out.print("Введите число от 0 до 9: ");

            if (!scan.hasNext()) {
                System.out.println("Ошибка: нужно ввести целое число!");
                scan.nextLine();
                continue;
            }

            int userNumber = scan.nextInt();

            if (userNumber < 0 || userNumber > 9) {
                System.out.println("Ошибка: число должно быть от 0 до 9!");
                continue;
            }

            attempts++;

            if (userNumber == secretNumber) {
                System.out.println("Вы угадали!");
                System.out.println("Вы отгадали число за " + attempts + " попытки");
                break;
            } else {
                System.out.println("Вы не угадали, введите число от 0 до 9:");
            }
        }

        scan.close();
    }

    // Задание 4. Массивы
    // 3)
    public int maxAbs(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("Ошибка: массив пуст или не существует");
            return 0;
        }

        int maxAbsValue = Math.abs(arr[0]);
        int result = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int currentAbs = Math.abs(arr[i]);
            if (currentAbs > maxAbsValue) {
                maxAbsValue = currentAbs;
                result = arr[i];
            }
        }
        return result;
    }
    // 4)
    public int[] add(int[] arr, int x, int pos) {
        if (arr == null || pos < 0 || pos > arr.length) {
            System.out.println("Ошибка: некорректная позиция для вставки");
            return arr;
        }

        int[] result = new int[arr.length + 1];

        for (int i = 0; i < pos; i++) {
            result[i] = arr[i];
        }

        result[pos] = x;

        for (int i = pos; i < arr.length; i++) {
            result[i + 1] = arr[i];
        }

        return result;
    }
    // 5)
    public int[] add(int[] arr, int[] ins, int pos) {
        if (arr == null || ins == null || pos < 0 || pos > arr.length) {
            System.out.println("Ошибка: некорректные данные");
            return arr;
        }

        int[] result = new int[arr.length + ins.length];

        for (int i = 0; i < pos; i++) {
            result[i] = arr[i];
        }

        for (int i = 0; i < ins.length; i++) {
            result[pos + i] = ins[i];
        }

        for (int i = pos; i < arr.length; i++) {
            result[i + ins.length] = arr[i];
        }

        return result;
    }
    // 6)
    public void reverse(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
    // 9)
    public int[] findAll(int[] arr, int x) {
        if (arr == null) {
            return new int[0];
        }

        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                indices.add(i);
            }
        }

        int[] result = new int[indices.size()];
        for (int i = 0; i < indices.size(); i++) {
            result[i] = indices.get(i);
        }

        return result;
    }


    // func main
    public static void main(String[] args) {
        Main lab = new Main();

        double num1 = 5.25;

        // 1.1
        System.out.println("\nЗадание 1.1");
        System.out.print("Число: " + num1);
        System.out.println("  Дробная часть: " + lab.fraction(num1));

        // 1.2
        int num2 = 4568;
        System.out.println("\nЗадание 1.2");
        System.out.print("Число: " + num2);
        System.out.println(" Сумма двух последних цифр: " + lab.sumLastNums(num2));

        // 1.6
        char char1 = 'D';
        char char2 = 'q';
        System.out.println("\nЗадание 1.6");
        System.out.print("Символ: '" + char1 + "' -> Результат: " + lab.isUpperCase(char1));
        System.out.println("  Символ: '" + char2 + "' -> Результат: " + lab.isUpperCase(char2));

        // 1.7
        System.out.println("\nЗадание 1.7");
        System.out.print("a=5, b=1, num=3 -> " + lab.isInRange(5, 1, 3));
        System.out.println("  a=2, b=15, num=33 -> " + lab.isInRange(2, 15, 33));

        // 1.10
        System.out.println("\nЗадание 1.10");
        int[] numbers = {5, 11, 123, 14, 1};
        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            System.out.print(result + " + " + numbers[i] + " = ");
            result = lab.lastNumSum(result, numbers[i]);
            System.out.println(result);
        }

        // 2.1
        int num3 = 5;
        int num4 = -3;
        System.out.println("\nЗадание 2.1");
        System.out.println("x = " + num3 + "  =>  |x| = " + lab.abs(num3));
        System.out.println("x = " + num4 + "  =>  |x| = " + lab.abs(num4));

        // 2.4
        System.out.println("\nЗадание 2.4");
        System.out.println("x=5, y=7   =>  " + lab.makeDecision(5, 7));
        System.out.println("x=8, y=-1  =>  " + lab.makeDecision(8, -1));
        System.out.println("x=4, y=4   =>  " + lab.makeDecision(4, 4));

        // 2.5
        System.out.println("\nЗадание 2.5");
        System.out.println("x=5, y=7, z=7  =>  max = " + lab.max3(5, 7, 7));
        System.out.println("x=8, y=-1, z=4 =>  max = " + lab.max3(8, -1, 4));

        // 2.8
        System.out.println("\nЗадание 2.8");
        System.out.println("x=5   =>  " + lab.age(5));
        System.out.println("x=31  =>  " + lab.age(31));
        System.out.println("x=44  =>  " + lab.age(44));

        // 2.9
        System.out.println("\nЗадание 2.9");
        System.out.println("x=1  =>  " + lab.day(1));
        System.out.println("x=5  =>  " + lab.day(5));
        System.out.println("x=7  =>  " + lab.day(7));
        System.out.println("x=9  =>  " + lab.day(9));

        // 3.2
        int x1 = 5;
        System.out.println("\nЗадание 3.2");
        System.out.println("Исходное число (x): " + x1);
        System.out.println("Результат: \"" + lab.reverseListNums(x1) + "\"");

        // 3.3
        int x2 = 9;
        System.out.println("\nЗадание 3.3");
        System.out.println("x = " + x2);
        System.out.println("Результат: \"" + lab.chet(x2) + "\"");

        // 3.7
        System.out.println("\nЗадание 3.7");
        System.out.println("Квадрат. x = 2:");
        lab.square(2); // сразу передаём значение, без лишней переменной

        System.out.println("Квадрат. x = 4:");
        lab.square(4);

        // 3.8
        System.out.println("\nЗадание 3.8");
        System.out.println("Левый треугольник. x = 2:");
        lab.leftTriangle(2);

        System.out.println(" Левый треугольник. x = 4:");
        lab.leftTriangle(4);

        // 3.10
        System.out.println("\nЗадание 3.10");
        lab.guessGame();

        // 4.3
        System.out.println("\nЗадание 4.3");
        int[] arr1 = {1, -2, -7, 4, 2, 2, 5};
        System.out.println("Массив: [1, -2, -7, 4, 2, 2, 5]");
        System.out.println("Максимум по модулю: " + lab.maxAbs(arr1));

        int[] arr2 = {-3, 5, -5, 2};
        System.out.println("Массив: [-3, 5, -5, 2]");
        System.out.println("Максимум по модулю: " + lab.maxAbs(arr2));

        int[] arr3 = {10, -3, 7};
        System.out.println("Массив: [10, -3, 7]");
        System.out.println("Максимум по модулю: " + lab.maxAbs(arr3));

        // 4.4
        int[] arr4 = {1, 2, 3, 4, 5};
        int x4 = 9;
        int pos = 3;
        System.out.println("\nЗадание 4.4");
        System.out.println("Исходный массив: " + Arrays.toString(arr4));
        System.out.println("Вставить " + x4 + " на позицию " + pos);
        int[] result2 = lab.add(arr4, x4, pos);
        System.out.println("Результат: " + Arrays.toString(result2));

        // 4.5
        int[] arr5 = {1, 2, 3, 4, 5};
        int[] ins = {7, 8, 9};

        System.out.println("\nЗадание 4.5");
        System.out.println("arr: " + Arrays.toString(arr5));
        System.out.println("ins: " + Arrays.toString(ins));
        System.out.println("Вставка на pos=3: "
                + Arrays.toString(lab.add(arr5, ins, 3)));

        // 4.6
        int[] arr6 = {1, 2, 3, 4, 5};
        System.out.println("\nЗадание 4.6");
        System.out.println("Исходный массив: " + Arrays.toString(arr6));

        lab.reverse(arr6);
        System.out.println("После реверса:   " + Arrays.toString(arr6));

        // 4.9
        int[] arr7 = {1, 2, 3, 8, 2, 2, 9};
        int x5 = 2;
        System.out.println("\nЗадание 4.9");
        System.out.println("Массив: " + Arrays.toString(arr7));
        System.out.println("Ищем число: " + x5);
        System.out.println("Индексы вхождений: " + Arrays.toString(lab.findAll(arr7, x5)));
    }
}