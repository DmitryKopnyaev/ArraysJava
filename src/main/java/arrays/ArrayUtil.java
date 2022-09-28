package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class ArrayUtil {
    /* evenIndexes
Дан массив целых чисел. Выведите все элементы массива с четными индексами. В программе запрещено использовать условную инструкцию для проверки четности индексов.
Решение оформить 2 способами:
-возвращать строковое представление массива в формате JSON
-используя ArrayList для накопления элементов, удовлетворяющих условию задачи*/

    public static String evenIndexes(int[] array) {
        String word = "[";
        boolean has = false;
        for (int i = 0; i < array.length; i += 2) {
            if (has)
                word += ", ";
            word += array[i];
            has = true;
        }
        word += "]";
        return word;
    }

    //версия с ArrayList
    public static String evenIndexes2(int[] src) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < src.length; i++)
            if (isEven(i)) list.add(src[i]);
        return Arrays.toString(list.toArray(new Integer[0]));
    }

/* fillRandom
Дан массив целых чисел. Заполнить данный массив числами в диапазоне от a до b
Указание: Для генерации случайного числа в диапазоне от a до b реализовать отдельный метод getRandomNumber*/

    public static void fillRandom(int[] array, int a, int b) {
        for (int i = 0; i < array.length; i++)
            array[i] = getRandomNumber(a, b);
    }

    public static int getRandomNumber(int a, int b) {
        if (a > b)
            throw new IllegalArgumentException("не верный интервал");
        return (int) (Math.random() * (b - a)) + a;
    }

/* evenData
Дан массив целых чисел. Выведите все четные элементы массива.
Указание:
Для проверки четности элемента массива реализовать отдельный метод isEven, который будет проверять, является ли переданный ей элемент четным.
Решение оформить 2 способами:
-возвращать строковое представление массива в формате JSON
-используя ArrayList для накопления элементов, удовлетворяющих условию задачи*/

    public static String evenData(int[] array) {
        String word = "[";
        boolean notFirstElement = false;
        for (int i = 0; i < array.length; i++) {
            if (!isEven(array[i]))
                continue;
            if (notFirstElement)
                word += ", ";
            word += array[i];
            notFirstElement = true;
        }
        word += "]";
        return word;
    }

    public static boolean isEven(int i) {
        return i % 2 == 0;
    }

    //версия с ArrayList
    public static String evenData2(int[] src) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < src.length; i++)
            if (isEven(src[i])) list.add(src[i]);
        return Arrays.toString(list.toArray(new Integer[0]));
    }

    /* countPositive
    Дан массив целых чисел. Определить количество положительных элементов в данном массиве.*/
    public static int countPositive(int[] array) {
        int count = 0;
        for (int value : array) {
            if (value > 0)
                count++;
        }
        return count;
    }


/* greatPrev
Дан массив целых чисел. Выведите все элементы массива, которые больше предыдущего элемента.
Решение оформить 2 способами:
-возвращать строковое представление массива в формате JSON
-используя ArrayList для накопления элементов, удовлетворяющих условию задачи*/

    public static String greatPrev(int[] array) {
        String word = "[";
        boolean notFirstElement = false;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) continue;
            if (notFirstElement)
                word += ", ";
            word += array[i];
            notFirstElement = true;
        }
        word += "]";
        return word;
    }

    //версия с ArrayList ++
    public static String greatPrev2(int[] src) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < src.length; i++)
            if (src[i - 1] < src[i]) list.add(src[i]);
        return Arrays.toString(list.toArray(new Integer[0]));
    }

    /*
    greaterNeighbours
    Дан массив целых чисел. Определите, сколько в этом массиве элементов,
    которые больше двух своих соседей и выведите количество таких элементов.*/
    public static int greaterNeighbours(int[] array) {
        int count = 0;
        for (int i = 1; i < array.length - 1; i++)
            if (array[i] > array[i - 1] && array[i] > array[i + 1])
                count++;
        return count;
    }

    /*max
    Дан массив целых чисел. Выведите значение наибольшего элемента в массиве*/
    public static int max(int[] array) {
        if (array.length < 1)
            throw new IndexOutOfBoundsException("в массиве недостаточно элементов");
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++)
            if (array[i] > max)
                max = array[i];
        return max;
    }


    /*maxValues
    Дан массив целых чисел. Выведите все индексы наибольшего значения данного массива
    Указание:
    -Вернуть результат в виде массива
    -Вернуть результат в виде массива используя ArrayList*/
    public static int[] maxValues(int[] array) {
        int lengthReturnedArray = 0;
        int maxValue = max(array);
        for (int i = 0; i < array.length; i++)
            if (array[i] == maxValue) lengthReturnedArray++;
        int[] returnedArray = new int[lengthReturnedArray];
        for (int i = 0, j = 0; i < array.length; i++)
            if (array[i] == maxValue) returnedArray[j++] = i;
        return returnedArray;
    }

    //версия с ArrayList ++
    public static Integer[] maxValues2(int[] src) {
        ArrayList<Integer> list = new ArrayList<>();
        int maxValue = max(src);
        for (int i = 0; i < src.length; i++) {
            if (src[i] == maxValue) list.add(i);
        }
        return list.toArray(new Integer[0]);
    }

    /*minPositive
    Дан массив целых чисел. Выведите значение наименьшего из всех положительных элементов в массиве.
    Известно, что в массиве есть хотя бы один положительный элемент.*/
    public static int minPositive(int[] array) {
        int minPositive = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0 && array[i] < minPositive)
                minPositive = array[i];
        }
        return minPositive;
    }

    /*minOdd
    Дан массив целых чисел. Выведите значение наименьшего нечетного элемента массива, а если в массиве
    нет нечетных элементов см. способы реализации.
    Указание:
    Для проверки нечетности элемента использовать заранее написанную функцию из п.5
    Решение оформить 2 способами:
    -Вернуть значение 0 при отсутствии элементов, удовлетворяющих условию задачи
    -Вернуть значение null, указав тип возвращаемого значения объектную оболочку типа int – Integer.*/
    public static int minOdd(int[] array) {
        int minOddValue = 0;
        for (int i = 0; i < array.length; i++) {
            if (isEven(array[i])) continue;
            if (minOddValue == 0 || array[i] < minOddValue)
                minOddValue = array[i];
        }
        return minOddValue;
    }

    public static Integer minOdd(Integer[] array) {
        Integer minOddValue = null;
        for (int i = 0; i < array.length; i++) {
            if (isEven(array[i])) continue;
            if (minOddValue == null || array[i] < minOddValue)
                minOddValue = array[i];
        }
        return minOddValue;
    }

    /*nearest
    Дан массив целых чисел и число x. Найдите в данном массиве элемент, ближайший к x(элемент с минимальной абсолютной разницей с х). Если таких чисел несколько, выведите см. способы реализации.
    Решение оформить 3 способами:
    -Вернуть последний элемент, удовлетворяющий условиям задачи
    -Вернуть все элементы, удовлетворяющие условиям задачи, используя массивы
    -Вернуть все элементы, удовлетворяющие условиям задачи, используя ArrayList*/

    public static int nearest(int[] array, int x) {
        if (array.length < 1) throw new IndexOutOfBoundsException("в массиве недостаточно элементов");
        int nearXElement = array[0];
        for (int i = 1; i < array.length; i++) {
            if (Math.abs(x - array[i]) <= x - nearXElement)
                nearXElement = array[i];
        }
        return nearXElement;
    }

    public static int[] nearestAll(int[] array, int x) {
        int lengthNewArray = 0;
        int nearXElement = nearest(array, x);
        for (int i = 0; i < array.length; i++) {
            if (Math.abs(x - array[i]) == Math.abs(x - nearXElement)) lengthNewArray++;
        }
        int[] returnedArray = new int[lengthNewArray];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (Math.abs(x - array[i]) == Math.abs(x - nearXElement)) returnedArray[j++] = array[i];
        }
        return returnedArray;
    }

    //версия с ArrayList
    public static Integer[] nearestAll2(int[] src, int x) {
        ArrayList<Integer> list = new ArrayList<>();
        int nearXElement = nearest(src, x);
        for (int i = 0, j = 0; i < src.length; i++)
            if (Math.abs(x - src[i]) == Math.abs(x - nearXElement)) list.add(src[i]);
        return list.toArray(new Integer[0]);
    }

    /*nearest
    Найдите в массиве два ближайших элемента (то есть два элемента с минимальной абсолютной разностью)
    (НЕ РЯДОМ СТОЯЩИЕ СРАВНИВАТЬ А ПО ВСЕМУ МАССИВУ)*/
    public static int[] nearest(int[] array) {
        if (array.length < 2) throw new IndexOutOfBoundsException("в массиве недостаточно элементов");
        int[] returnedArray = new int[2];
        int delta = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (Math.abs(array[i] - array[j]) <= delta) {
                    returnedArray[0] = array[i];
                    returnedArray[1] = array[j];
                    delta = Math.abs(returnedArray[0] - returnedArray[1]);
                }
            }
        }
        return returnedArray;
    }

    /*indexInsertion
    Дана невозрастающая последовательность целых чисел в виде массива и число x.
    Вывести номер в этой последовательности, куда можно было бы вставить данный элемент х,
    чтобы правило не возрастания сохранилось, учитывая, что нумерация элементов в последовательности
    начинается с 1. Если в последовательности уже есть элементы, равные х, то считается,
    что данный элемент вставляется после них.*/
    public static int indexInsertion(int[] array, int x) {
        int i = 0;
        while (!(i == array.length - 1 || x > array[i])) {
            i++;
        }
        if (i == array.length - 1 && array[i] >= x)
            i++;
        return i + 1;
    }

    /*countDifferent
    Дан массив целых чисел, упорядоченный по неубыванию элементов в нем.
    Определите, сколько в нем различных элементов (количество неравных друг другу элементов).*/
    public static int countDifferent(int[] array) {
        if (array.length == 0) return -1;
        int count = 1;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] != array[i + 1])
                count++;
        }
        return count;
    }

    /*reverse
    Дан массив целых чисел. Переставьте элементы данного массива в обратном порядке.
    Метод должен производить разворот исходного массива, ничего не возвращая.*/
    public static void reverse(int[] array) {
        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
            int x = array[i];
            array[i] = array[j];
            array[j] = x;
        }
    }

    /*reverseNeighbours
    Дан массив целых чисел. Переставьте соседние элементы массива.
    Если элементов нечетное число, то последний элемент остается на своем месте.*/
    public static void reverseNeighbours(int[] array) {
        for (int i = 0; i < array.length - 1; i += 2) {
            int x = array[i];
            array[i] = array[i + 1];
            array[i + 1] = x;
        }
    }

    /*delete
    Дан массив целых чисел и номер элемента в массиве k. Удалите из массива элемент с индексом k.
    Решение оформить 2 способами:
    -использовать вспомогательный массив для хранения элементов
    -использовать ArrayList для выполнения операции удаления*/
    public static int[] delete(int[] array, int k) {
        int[] returnedArray = new int[array.length - 1];
        System.arraycopy(array, 0, returnedArray, 0, k);
        System.arraycopy(array, k + 1, returnedArray, k, array.length - k - 1);
        return returnedArray;
    }

    public static Integer[] delete(Integer[] array, int k) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(array));
        list.remove(k);
        return list.toArray(new Integer[0]);
    }

    /*insert
    Дан массив целых чисел, число k и значение C.
    Необходимо вставить в массив на позицию с индексом k элемент, равный C
    Решение оформить 2 способами:
    -использовать вспомогательный массив для хранения элементов
    -использовать ArrayList для выполнения операции вставки*/
    public static int[] insert(int[] array, int k, int c) {
        if (k < 0 || k > array.length) throw new IndexOutOfBoundsException("k выходит за границы массива");
        int[] returnedArray = new int[array.length + 1];
        System.arraycopy(array, 0, returnedArray, 0, k);
        returnedArray[k] = c;
        System.arraycopy(array, k, returnedArray, k + 1, array.length - k);
        return returnedArray;
    }

    public static Integer[] insert(Integer[] array, int k, Integer c) {
        if (k < 0 || k > array.length) throw new IndexOutOfBoundsException("k выходит за границы массива");
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(array));
        list.add(k, c);
        return list.toArray(new Integer[0]);
    }

    /*shift
    Дан массив целых чисел и параметр k. Если данный параметр истинный, то выполнить циклический сдвиг
    массива на одну позицию вправо, если ложный, то влево. Метод должен производить операции над массивом,
    ничего не возвращая.*/
    public static void shift(int[] array, boolean k) {
        if (array.length < 2) throw new IndexOutOfBoundsException("в массиве недостаточно элементов");
        if (k) {
            int num = array[array.length - 1];
            for (int i = array.length - 1; i > 0; i--)
                array[i] = array[i - 1];
            array[0] = num;
        } else {
            int num = array[0];
            for (int i = 0; i < array.length - 1; i++)
                array[i] = array[i + 1];
            array[array.length - 1] = num;
        }
    }

    /*shift
    Дан массив целых чисел и число k. Выполнить циклический сдвиг массива на |k| позиций вправо,
    если k>0 или влево, если k<0. Метод должен производить операции над массивом, ничего не возвращая.*/
    public static void shift(int[] array, int k) {
        for (int i = 0; i < Math.abs(k); i++)
            shift(array, k > 0);
    }

    /*countEqualPairs
    Дан массив целых чисел. Посчитайте, сколько в нем пар элементов, равных друг другу.
    Считается, что любые два элемента, равные друг другу образуют одну пару, которую необходимо посчитать.*/
    public static int countEqualPairs(int[] array) {
        int countPairs = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j])
                    countPairs++;
            }
        }
        return countPairs;
    }


    /*countDifferent
    Дан массив целых чисел. Посчитайте, сколько в нем различных элементов, не изменяя самого массива.*/
    public static int countDifferent2(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) break;
                if (j == array.length - 1) count++;
            }
            if (i == array.length - 1) count++;
        }
        return count;
    }

    public static int countDifferent2(String[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].equals(array[j])) break;
                if (j == array.length - 1) count++;
            }
            if (i == array.length - 1) count++; //т.к. последнему элементу i не с чем сравнивать и он не учелся бы сам
        }
        return count;
    }


    /*unique
    Дан массив целых чисел. Выведите те его элементы, которые встречаются в массиве только один раз.
    Элементы нужно выводить в том порядке, в котором они встречаются в массиве.*/
    public static int[] unique(int[] array) {
        int lengthReturnedArray = 0;
        for (int i = 0; i < array.length; i++) {
            boolean isUnique = true;
            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j] && j != i) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) lengthReturnedArray++;
        }
        int[] returnedArray = new int[lengthReturnedArray];
        for (int i = 0, k = 0; i < array.length; i++) {
            boolean isUnique = true;
            for (int j = 0; j < array.length; j++) {   //аналогично
                if (array[i] == array[j] && j != i) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) returnedArray[k++] = array[i];
        }
        return returnedArray;
    }

    public static Integer[] uniqueV2(int[] array) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            boolean isUnique = true;
            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j] && j != i) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) list.add(array[i]);
        }
        return list.toArray(new Integer[0]);
    }

    /*frequent
    Дан массив целых чисел. Не изменяя массива определить, какое число в этом массиве встречается чаще всего.
    Если таких чисел несколько, выведите см. способы реализации.
    Решение оформить 3 способами:
    -Вернуть первый элемент, удовлетворяющий условиям задачи
    -Вернуть все элементы, удовлетворяющие условиям задачи, используя дополнительный массив
    -Вернуть все элементы, удовлетворяющие условиям задачи, используя ArrayList*/
    public static int frequent(int[] array) {
        if (array.length < 1) throw new IndexOutOfBoundsException("в массиве недостаточно элементов");
        int maxCount = 1;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            int count = 1;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) count++;
            }
            if (count > maxCount) {
                index = i;
                maxCount = count;
            }
        }
        return array[index];
    }

    public static int[] frequent2(int[] array) {
        int maxCount = 1;
        int lengthReturnedArray = 0;
        for (int i = 0; i < array.length; i++) {
            int count = 1;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) count++;
            }
            if (count == maxCount) {
                lengthReturnedArray++;
            }
            if (count > maxCount) {
                maxCount = count;
                lengthReturnedArray = 1;
            }
        }
        int[] returnedArray = new int[lengthReturnedArray];
        for (int i = 0, k = 0; i < array.length; i++) {
            int count = 1;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) count++;
            }
            if (count == maxCount) returnedArray[k++] = array[i];
        }
        return returnedArray;
    }

    public static Integer[] frequent3(int[] src) {
        ArrayList<Integer> list = new ArrayList<>();
        int maxCount = 1;
        for (int i = 0; i < src.length; i++) {
            int count = 1;
            for (int j = i + 1; j < src.length; j++) {
                if (src[i] == src[j]) count++;
            }
            if (count > maxCount) {
                maxCount = count;
                list.clear();
            }
            if (count == maxCount)
                list.add(src[i]);
        }
        return list.toArray(new Integer[0]);
    }

    /*kBonachi
     Назовем последовательность чисел последовательностью k-боначчи, если каждый элемент этой последовательности
     является суммой k предыдущих членов последовательности. В частности, последовательность 2-боначчи является
     последовательностью Фибоначчи.
     Более формально, i−й элемент последовательности ki равен 1, если 0≤i≤k−1 и равен сумме k предыдущих членов
     последовательности ki−1+ki−2+...+ki−k при i≥k.
     Даны два числа k и n (k≥2, n≥0). Вычислите n-й член последовательности k-боначчи kn.
     Решение оформить 2 способами:
     -использовать массив для хранения элементов
     -использовать ArrayList для накопления элементов*/
    public static int kBonachi(int k, int n) {
        if (!(k >= 2 && n >= 0)) return -1;
        int[] array = new int[n + 1];
        int num = 1;
        for (int i = 0; i < array.length; i++) {
            if (!(i <= k - 1)) {
                num = 0;
                for (int r = i - 1, j = 0; j < k; j++) {
                    num += array[r--];
                }
            }
            array[i] = num;
        }
        return array[array.length - 1];
    }

    public static int kBonachiV2(int k, int n) {
        if (!(k >= 2 && n >= 0)) return -1;
        ArrayList<Integer> list = new ArrayList<>(n + 1);
        int num = 1;
        for (int i = 0; i < n + 1; i++) {
            if (!(i <= k - 1)) {
                num = 0;
                for (int r = i - 1, j = 0; j < k; j++) {
                    num += list.get(r--);
                }
            }
            list.add(num);
        }
        return list.get(list.size() - 1);
    }

    /*search
     Дан массив целых чисел и число key. Методом линейного поиска при помощи цикла for найти
     индекс вхождения числа key в массиве*/

    public static int search(int[] array, int k) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == k) return i;
        }
        return -1;
    }

    /*search
     Модернизировать программу таким образом,  чтобы она вернула индексы всех вхождений числа key в массиве.
     Решение оформить 2 способами:
     -использовать массив для хранения элементов
     -использовать ArrayList для накопления элементов*/

    public static int[] search2(int[] array, int k) {
        int lengthNewArray = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == k)
                lengthNewArray++;
        }
        int[] resultsArray = new int[lengthNewArray];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == k)
                resultsArray[index++] = i;
        }
        return resultsArray;
    }

    public static Integer[] search3(int[] array, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == k)
                list.add(i);
        }
        return list.toArray(new Integer[0]);
    }

    /*equals
     Даны два массива целых чисел. Сравнить их на равенство.
     Указание:
     Под равенством двух массивов понимать их тождественное равенство, то есть два массива с одинаковыми длинами,
     одинаковыми элементами, но разным порядком этих элементов считаются разными*/
    public static boolean equals(int[] src1, int[] src2) {
        if (src1.length != src2.length) return false;
        for (int i = 0; i < src1.length; i++) {
            if (src1[i] != src2[i]) return false;
        }
        return true;
    }

    /*equalsIgnoreCase
     Даны два массива целых чисел. Сравнить их на равенство по содержанию,
     то есть не учитывая порядок этих элементов и количество*/
    public static boolean equalsIgnoreCase(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            boolean has = false;
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) has = true;
            }
            if (!has) return false;
        }

        for (int i = 0; i < arr2.length; i++) {
            boolean has = false;
            for (int j = 0; j < arr1.length; j++) {
                if (arr2[i] == arr1[j]) has = true;
            }
            if (!has) return false;
        }
        return true;
    }

    /*copyOf
    Дан массив, сделать его копию
    Указание:
    Метод должен принимать на вход 2 параметра: исходный массив, который надо скопировать
    и длину нового массива. Если длина исходного массива больше длины нового массива,
    то копируется только часть исходного массива, если длина исходного массива меньше
    длины нового массива, то в новый массив исходный массив копируется полностью,
    а оставшаяся незаполненная часть записывается нулями, если же размер нового массива совпадает
    с размером исходного, то в новый массив копируется полностью исходный*/
    public static int[] copyOf(int[] src, int length) {
        int[] newArray = new int[length];
        System.arraycopy(src, 0, newArray, 0, Math.min(src.length, newArray.length));
        return newArray;
    }

    /*copyOfRange
     Дан массив и два целых числа b и e, сделать копию исходного массива начиная
     с индекса а и заканчивая b
     Указание:
     Метод должен принимать на вход 3 параметра: исходный массив, который надо скопировать
     и границы копирования. Если длина исходного массива меньше числа a, то вернуть null.
     Если длина исходного массива меньше  числа b, то в новый массив исходный массив
     копируется полностью, а оставшаяся незаполненная часть записывается нулями*/
    public static int[] copyOfRange(int[] src, int from, int to) {
        if (src.length < from) return null;
        int length = to - from;
        int[] newArray = new int[length];
        System.arraycopy(src, from, newArray, 0, Math.min(newArray.length, src.length - from));
        return newArray;
    }

    /*Sort
     Дан массив целых чисел. Выполнить сортировку массива пузырьком и сортировкой отбором (линейная сортировка).
     Решение оформить 2 способами:
     -Выполнить данные сортировки если Comparator=null
     -Выполнить данные сортировки, принимая в качестве аргумента Comparator для сравнения элементов
     */
    public static void sortBubble(int[] src, Comparator<Integer> cmp) {
        boolean isSorted = false;
        int buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < src.length - 1; i++) {
                if (cmp != null && cmp.compare(src[i], src[i + 1]) > 0 || cmp == null && src[i] > src[i + 1]) {
                    isSorted = false;
                    buf = src[i];
                    src[i] = src[i + 1];
                    src[i + 1] = buf;
                }
            }
        }
    }

    public static void sortSelection(int[] src, Comparator<Integer> cmp) {
        for (int i = 0; i < src.length; i++) {
            int min = src[i];
            int minId = i;
            for (int j = i + 1; j < src.length; j++) {
                if (cmp != null && cmp.compare(src[j], min) < 0 || cmp == null && src[j] < min) {
                    min = src[j];
                    minId = j;
                }
            }
            int buf = src[i];
            src[i] = min;
            src[minId] = buf;
        }
    }

    /*isOrder
    Дан массив целых чисел. Определить, является ли он упорядоченным*/
    public static boolean isOrder(int[] src) {
        int down = 0;
        int rise = 0;
        int equal = 0;
        for (int i = 0; i < src.length - 1; i++) {
            if (!(i == rise + equal || i == down + equal)) return false;
            if (src[i] > src[i + 1]) down++;
            if (src[i] < src[i + 1]) rise++;
            if (src[i] == src[i + 1]) equal++;
        }
        return true;
    }

    /*fillPrimeRandom
    Дан массив. Заполнить исходный массив целыми случайными простыми числами
    Указание:
    Для проверки простоты числа написать отдельный метод isPrime*/
    public static boolean isPrime(int number) {
        if (number < 2)
            return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    public static void fillPrimeRandom(int[] src) {
        Random random = new Random();
        for (int i = 0; i < src.length; ) {
            int randomNum = random.nextInt();
            if (isPrime(randomNum))
                src[i++] = randomNum;
        }
    }

    /*averagePoint
    Вводится следующая система вычисления среднего балла работоспособности разработчиков в компании «СберТех»:
    вычисляется среднее арифметическое всех баллов, поставленных тимлидом за определенный период времени, и ставится
    ближайшая целая оценка, не превосходящая среднего арифметического.
    При этом если у разработчика есть «двойка», а следующий за ней балл – выше «двойки», то двойка считается отработанной,
    и при вычислении среднего арифметического не учитывается.
    Вводится N натуральных чисел в диапазоне от 2 до 5 через пробел – баллы разработчика за определённый период времени.
    Вычислить натуральное число (от 2 до 5) – его средний балл за текущий период.
    */
    public static int averagePoint(int[] arrI) {
        if (arrI.length == 0)
            return -1;
        int sum = arrI[arrI.length - 1];
        int index = 1;
        for (int i = 0; i < arrI.length - 1; i++) {
            if (!(arrI[i] == 2 && arrI[i + 1] > 2)) {
                sum += arrI[i];
                index++;
            }
        }
        return sum / index;
    }

    /*countPassengersTime
     Для изучения пассажиропотока в метро было записано время входа и время выхода в метро каждого
     пассажира. На основании этих данных определите, сколько пассажиров было в метро в некоторый
     заданный момент времени T.
     Программа получает на вход двумерный массив данных P из N строк – числа пассажиров за текущий
     день и двух столбцов, а так же время T. В первом столбце массива определяется время
     входа P(i, 1) и во втором – время выхода P(i, 2) каждого пассажира, где P(i,1)≤P(i,2).
     Время задается в минутах от начала работы метрополитена.
     Вычислите одно значение: количество пассажиров в момент времени T. Если какой-то пассажир
     в момент T входит или выходит, то его тоже необходимо посчитать.
     */
    public static int countPassengersTime(int[][] time, int t) {
        int count = 0;
        for (int i = 0; i < time.length; i++) {
            if (time[i][0] <= t && t <= time[i][1])
                count++;
        }
        return count;
    }

    /*towards
    Дан массив вещественных чисел. Сформировать его строковое представление в формате JSON следующем порядке: первое число, последнее, второе, предпоследнее и так далее все числа (см. пример).
    Пример:
    Входные данные:  1 2 3 4 5
    Выходные данные:  [1, 5, 2, 4, 3]*/
    public static String towards(int[] src) {
        String word = "[";
        for (int i = 0; i < src.length / 2; i++) {
            if (!word.equals("["))
                word += ", ";
            word += src[i] + ", " + src[src.length - 1 - i];
        }
        word += (src.length % 2 != 0 ? src[src.length / 2] : "") + "]";
        return word;
    }

    /*rushHour
    Дан массив целых чисел – количество пассажиров в метро за каждый час его работы
    и число k – продолжительность часа пик. Определить K подряд идущих часов работы
    метрополитена с максимальным суммарным числом пассажиров и вычислить суммарное
    число пассажиров за эти часы*/
    public static int rushHour(int[] src, int k) {
        if (k > src.length)
            return -1;
        int maxCount = 0;
        for (int i = 0; i <= src.length - k; i++) {
            int count = 0;
            for (int j = i; j < i + k; j++) {
                count += src[j];
            }
            if (count > maxCount) maxCount = count;
        }
        return maxCount;
    }

    /*equalItems
    Дан массив. Найдите элементы, равные друг другу.
    Решение оформить 2 способами:
    -использовать массив для хранения элементов(для определения количества равных использовать метод из задачи  23)
    -использовать ArrayList для накопления элементов*/
    public static int[] equalItems(int[] src) {
        int countUnique = 0;
        for (int i = 0; i < src.length; i++) {
            for (int j = 0; j < src.length; j++) {
                if (src[i] == src[j] && i != j) break;
                if (j == src.length - 1) countUnique++;
            }
        }
        int[] returnedArray = new int[src.length - countUnique];
        for (int i = 0, k = 0; i < src.length; i++) {
            for (int j = 0; j < src.length; j++) {
                if (src[i] == src[j] && i != j) {
                    returnedArray[k++] = src[i];
                    break;
                }
            }
        }
        return returnedArray;

    }

    public static Integer[] equalItems2(int[] src) {
        ArrayList<Integer> list = new ArrayList<>(src.length);
        for (int i = 0; i < src.length; i++) {
            boolean firstElementAdded = false;
            if (!list.contains(src[i])) {
                for (int j = i + 1; j < src.length; j++) {
                    if (src[i] == src[j]) {
                        if (!firstElementAdded) list.add(src[i]);
                        firstElementAdded = true;
                        list.add(src[i]);
                    }
                }
            }
        }
        return list.toArray(new Integer[0]);
    }

    /*group
    Дан массив строковых данных. Сформировать на основании данного массива новый массив, элементами которого будут новые строки,
    скрепленные между собой по принципу их равности. То есть необходимо реализовать алгоритм группировки строк по их равенству.
    Пример:
    Входные данные: [“aa”, “b”, “a”, “bb”, “aa”, “bb”]
    Выходные данные: [“aa aa”, “b”, “a”, “bb bb”]
    Указание:
    Для сравнения строк использовать механизм str1.equals(str2). Оператор == для строк использовать нельзя
    Решение оформить 2 способами:
    -использовать массив для хранения элементов
    -использовать ArrayList для накопления элементов*/
    public static String[] group(String[] src) {
        String[] returnedArray = new String[countDifferent2(src)];
        boolean[] was = new boolean[src.length];
        Arrays.fill(was, false);
        for (int i = 0, k = 0; i < src.length; i++) {
            if (!was[i]) {
                was[i] = true;
                String word = src[i];
                for (int j = i + 1; j < src.length; j++) {
                    if (src[i].equals(src[j])) {
                        word += " " + src[j];
                        was[j] = true;
                    }
                }
                returnedArray[k++] = word;
            }
        }
        return returnedArray;
    }

    public static String[] group2(String[] src) {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> was = new ArrayList<>();
        for (int i = 0; i < src.length; i++) {
            if (!was.contains(src[i])) {
                String word = src[i];
                for (int j = i + 1; j < src.length; j++) {
                    if (src[i].equals(src[j])) {
                        was.add(src[i]);
                        word += " " + src[j];
                    }
                }
                list.add(word);
            }
        }
        return list.toArray(new String[0]);
    }

    /*setDiam
     На плоскости даны N точек, заданных своими координатами. Найти две наиболее удаленные точки и вычислить расстояние между ними.
     Программа получает на вход двумерный массив T целых чисел из N строк – количества точек. В первом столбце T(i, 1) записана координата по оси х, во втором столбце T(i, 2) – координата y.
     Вычислить одно действительное число — наибольшее расстояние между двумя из данных точек*/

    public static double setDiam(int[][] src) {
        double maxLength = 0;
        for (int i = 0; i < src.length; i++) {
            for (int j = i + 1; j < src.length; j++) {
                double length = Math.sqrt(Math.pow(src[i][0] - src[j][0], 2) + Math.pow(src[i][1] - src[j][1], 2));
                if (length > maxLength)
                    maxLength = length;
            }
        }
        return maxLength;
    }

    /*debts++
    В одном карточном клубе состоит N джентльменов. Иногда азарт некоторых из них берет верх над благоразумием,
    и кто-то проигрывает больше денег, чем у него есть с собой. В этом случае проигравший обычно берет в долг у
    кого-то из посетителей клуба, чтобы расплатиться с партнерами по игре. Чтобы начать новый год “с чистого листа”,
    джентльмены решили собраться в клубе и оплатить все долговые расписки, которые накопились у них друг к другу.
    Однако выяснилось, что иногда одни и те же джентльмены в разные дни выступали как в роли должников, так и в роли
    кредиторов. Поскольку истинные джентльмены считают мелочный подсчет денег ниже своего достоинства, то расчетами
    придется заняться уполномоченному программисту.
    Написать программу, которая по заданным распискам вычислит, сколько всего должен каждый джентльмен выплатить
    другим (или получить с других).
    На вход методу подается двумерный массив D состоящий из K строк — количество долговых расписок и 3 столбцов,
    число N — количество джентльменов. D(i, 1) - номер джентльмена взявшего в долг; D(i, 2) - номер джентльмена
    давшего деньги; D(i, 3) - сумма.
    Вычислить массив balance из N чисел — суммы, которые должны получить соответствующие джентльмены. balance(i)
    положительное число, если этот джентльмен должен получить деньги от других, отрицательное — если он должен
    отдать деньги другим
    (нумерация людей с 1 а в масиве с 0)*/
    public static int[] debts(int[][] src) {
        int length = 0;
        for (int i = 0; i < src.length; i++) {
            if (Math.max(src[i][0], src[i][1]) > length)
                length = Math.max(src[i][0], src[i][1]);
        }
        int[] array = new int[length];
        for (int i = 0; i < src.length; i++) {
            int indexAccepting = src[i][0] - 1;
            int indexGiving = src[i][1] - 1;
            array[indexAccepting] -= src[i][2];
            array[indexGiving] += src[i][2];
        }
        return array;
    }

    /*pascalTriangle
    По данному числу N сформировать первые N+1 строку треугольника Паскаля*/
    public static int[][] pascalTriangle(int n) {
        String word = "";
        int[][] src = new int[n + 1][];
        for (int i = 0; i < src.length; i++) {
            src[i] = new int[i + 1];
            for (int j = 0; j < src[i].length; j++) {
                if (j == 0 || j == src[i].length - 1 || i < 2) {
                    src[i][j] = 1;
                } else {
                    src[i][j] = src[i - 1][j - 1] + src[i - 1][j];
                }
            }
        }
        return src;
    }

    /*temperatureMinimum
    Метеорологи ведут многолетние наблюдения за тем, в каком году была минимальная температура в данный день года.
    Например, абсолютный минимум температуры в Москве 8 марта был -32 градуса (1890).
    В течение k лет метеорологи вели наблюдения за n днями года. Для каждого из этих n дней укажите минимальную
    температуру, которая была в этот день за k лет наблюдений.
    Данные подаются в виде двумерного массива из k строк и n столбцов. Далее идет k строк, i-я строка содержит n чисел:
    значения температур для n дней наблюдений i-го года.
    Программа должна сформировать массив из n чисел: минимальное значение температуры для каждого из дней наблюдений*/
    public static int[] temperatureMinimum(int[][] src) {
        int[] array = new int[src[0].length];
        for (int i = 0; i < src[0].length; i++) {
            array[i] = src[0][i];
            for (int j = 1; j < src.length; j++) {
                if (src[j][i] < array[i])
                    array[i] = src[j][i];
            }
        }
        return array;
    }

    /*minimumPrecipitation
    Даны результаты метеорологических наблюдений: количество осадков в каждый из 31 дня марта. Метеорологи хотят
    определить, какая из недель марта была наименее дождливой. Неделя — это семь дней с понедельника до воскресенья,
    то есть в марте может быть три или четыре полные недели.
    Программа получает на вход массив из 31 целого неотрицательное число через пробел: количество осадков для каждого
    из дней и число k от 1 до 7: день недели, на который приходится 1 марта (1 означает понедельник, 2  вторник и так далее).
    Программа должна определить неделю с наименьшим суммарным числом осадков и вывести суммарное число остатков на этой неделе.*/
    public static int minimumPrecipitation(int[] src, int k) {
        if (src.length != 31 || k > 7 || k < 1)
            return -1;
        int firstNum = 0;
        if (k != 1) firstNum = 8 - k;
        int minCount = Integer.MAX_VALUE;
        for (int i = firstNum; i + 6 < src.length; i += 7) {
            int count = 0;
            for (int j = i, d = 0; d < 7; d++) {
                count += src[j++];
                if (d == 6 && count < minCount)
                    minCount = count;
            }
        }
        return minCount;
    }

    public static Integer[] maxSum(int[] src) {
        ArrayList<Integer> list = new ArrayList<>(2);
        list.add(0);
        list.add(0);
        int maxValue = 0;
        for (int i = 0; i < src.length; i++) {
            int max = src[i];
            for (int j = i + 1; j < src.length; j++) {
                max += src[j];
                if (max > maxValue || max == maxValue
                        && (j < list.get(1) || j == list.get(1) && i > list.get(0))) {
                    maxValue = max;
                    list.set(0, i);
                    list.set(1, j);
                }
            }

        }
        return list.toArray(new Integer[0]);
    }
}
