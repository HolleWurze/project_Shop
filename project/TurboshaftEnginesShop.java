package ru.itsjava.project;

import java.util.Arrays;
import java.util.Scanner;

public class TurboshaftEnginesShop {
    public static void main(String[] args) {
        String[] items = new String[]{"Вал", "Винтм4х100", "Болтм8х100", "Винтм4х100", "Болтм8х100", "Винтм4х100", "Болтм8х100", "Лопатка1ступени", "Лопатка2ступени", "Лопатка2ступени", "Лопатка2ступени", "Поддержка", "Вал", "Опора", "Стартер"};
        printMenu(items);
        System.out.println("Введите номер пункта меню:");
        Scanner consoleShop = new Scanner(System.in);
        int menuNum;

        while ((menuNum = consoleShop.nextInt()) != 0) {
            if (menuNum == 1) {
                printItems(items);
            } else if (menuNum == 2) {
                items = addItem(items, consoleShop);
            } else if (menuNum == 3) {
                items = purchaseOfGoods(items, consoleShop);
            } else if (menuNum == 4) {
                printContainsItem(items, consoleShop);
            } else if (menuNum == 5) {
                sortItems(items);
            } else if (menuNum == 6) {
                amountOfGoods(items, consoleShop);
            } else if (menuNum == 7) {
                searchItem(items, consoleShop);
            } else if (menuNum == 8) {
                valueOfGoods(items, consoleShop);
            }
            System.out.println("\nВведите номер пункта меню:");
        }
    }

    private static void printMenu(String[] args) {
        System.out.println("//Меню:\n" +
                "1. Показать весь ассортимент\n" +
                "2. Добавить новую деталь\n" +
                "3. Купить детали\n" +
                "4. Проверить наличие\n" +
                "5. Сортировка товара\n" +
                "6. Количество необходимого товара\n" +
                "7. Поиск товара по первой букве\n" +
                "8. Узнать цену товара\n" +
                "0. Выход");
    }

    //1
    public static void printItems(String[] items) {
        System.out.println(Arrays.toString(items));
    }

    //2
    private static String[] addItem(String[] items, Scanner scanner) {
        System.out.println("Введите новый товар: ");
        String inputNewDetail = scanner.next();
        String[] newItemsArray = new String[items.length + 1];

        for (int i = 0; i < items.length; i++) {
            newItemsArray[i] = items[i];
        }
        newItemsArray[items.length] = inputNewDetail;
        return newItemsArray;
    }

    //3
    private static String[] purchaseOfGoods(String[] items, Scanner consoleShop) {
        System.out.println("Введите товар который хотите приобрести: ");
        String imputItemFromAssortment = consoleShop.next();
        String[] resItemsArray = new String[items.length - 1];

        int index;
        for (index = 0; index < items.length; index++) {
            if (imputItemFromAssortment.equals(items[index])) {
                break;
            } else if (index == items.length - 1) {
                return items;
            } else {
                resItemsArray[index] = items[index];
            }
        }
        for (int i = index; i < resItemsArray.length; i++) {
            resItemsArray[i] = items[i + 1];
        }
        return resItemsArray;
    }

    //4
    private static void printContainsItem(String[] items, Scanner consoleShop) {

        System.out.println("Введите название товара, который хотите проверить наличие ");
        String inputDetail = consoleShop.next();

        boolean isContains = false;
        for (String detail : items) {
            if (inputDetail.equals(detail)) {
                isContains = true;
                break;
            }
        }
        if (!isContains) {
            System.out.println("Такого товара нет");
        } else {
            System.out.println("Есть в наличии");
        }
    }

    //5
    private static void sortItems(String[] items) {
        for (int j = 0; j < items.length; j++) {
            for (int i = 0; i < items.length - 1 - j; i++) {
                if (items[i].charAt(0) > items[i + 1].charAt(0)) {
                    String tempString = items[i];
                    items[i] = items[i + 1];
                    items[i + 1] = tempString;
                }
            }
        }
    }

    //6
    private static void amountOfGoods(String[] items, Scanner scanner) {
        System.out.println("Введите название товара, который хотите найти");
        String inputDetail = scanner.next();

        boolean isContains = false;
        for (String detail : items) {
            if (inputDetail.equals(detail)) {
                isContains = true;
                break;
            }
        }
        if (!isContains) {
            System.err.println("Такого товара нет");
        } else {
            System.out.println("Есть в наличии");
            int amount = 0;
            for (String detail : items) {
                if (inputDetail.equals(detail)) {
                    amount++;
                }
            }
            System.out.println("Выбранного вами товара доступно: " + amount);
        }
    }

    //7
    private static void searchItem(String[] items, Scanner consoleShop) {
        System.out.println("Введите первую букву товара ");
        String inputLetter = consoleShop.next();
        boolean thereIsLetter = false;
        for (int i = 0; i < items.length; i++) {
            if (items[i].charAt(0) == inputLetter.charAt(0)) {
                System.out.print(items[i] + " ");
                thereIsLetter = true;
            }
        }
        if (!thereIsLetter) {
            System.err.println("Такого товара нет в продаже");
        }
    }

    //8
    private static void valueOfGoods(String[] items, Scanner consoleShop) {
        System.out.println("Введите название товара ");
        String inputProduct = consoleShop.next();

        if (inputProduct.equalsIgnoreCase("Вал")) {
            System.out.println(inputProduct + " стоит 3000");
        } else if (inputProduct.equalsIgnoreCase("Винтм4х100")) {
            System.out.println(inputProduct + " стоит 10");
        } else if (inputProduct.equalsIgnoreCase("Болтм8х100")) {
            System.out.println(inputProduct + " стоит 15");
        } else if (inputProduct.equalsIgnoreCase("Лопатка1ступени")) {
            System.out.println(inputProduct + " стоит 300");
        } else if (inputProduct.equalsIgnoreCase("Лопатка2ступени")) {
            System.out.println(inputProduct + " стоит 310");
        } else if (inputProduct.equalsIgnoreCase("Поддержка")) {
            System.out.println(inputProduct + " стоит 50");
        } else if (inputProduct.equalsIgnoreCase("Опора")) {
            System.out.println(inputProduct + " стоит 60");
        } else if (inputProduct.equalsIgnoreCase("Стартер")) {
            System.out.println(inputProduct + " стоит 1500");
        }
    }
}

//while ((inputProduct != ("0")) || (inputProduct != ("выход")))
//System.err.println("Для выхода нажмите '0' или напишите 'выход'");

//private static String[] demandForProducts(String[] items) {
//        int left = 0;
//        int right = items.length - 1;
//        if (items[right].length() <= items[left].length()) {
//            int mid = (left + right) / 2;
//            demandForProducts(items);
//            demandForProducts(items, mid + 1, right);
//            String[] merge = (items, left, );
//            System.out.println(merge);
//        }
//    }