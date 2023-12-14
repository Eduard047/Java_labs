package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Cinema cinema = new Cinema();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Виберіть зал (від 1 до " + cinema.getNumHalls() + "):");

        for (int i = 0; i < cinema.getNumHalls(); i++) {
            System.out.println((i + 1) + ". " + cinema.getHallNames()[i]);
        }

        int hallNumber = scanner.nextInt();

        if (hallNumber < 1 || hallNumber > cinema.getNumHalls()) {
            System.out.println("Некоректний номер залу.");
            return;
        }

        System.out.println("Ви обрали " + cinema.getHallNames()[hallNumber - 1]);

        cinema.printSeatingArrangement(hallNumber - 1); // Виправлено індекс залу

        System.out.println("Бажаєте вибирати місця вручну (1) чи автоматично (2)?");
        int choice = scanner.nextInt();

        if (choice == 1) {
            // Ручний вибір
            System.out.println("Введіть номер ряду:");
            int row = scanner.nextInt();
            System.out.println("Введіть номери місць (через пробіл):");
            scanner.nextLine(); // Очистка буфера
            String seatsInput = scanner.nextLine();
            int[] seats = Arrays.stream(seatsInput.split(" ")).mapToInt(Integer::parseInt).toArray();

            cinema.bookSeats(hallNumber - 1, row, seats);
        } else if (choice == 2) {
            // Автоматичний вибір
            System.out.println("Введіть кількість місць для автоматичного бронювання:");
            int numSeats = scanner.nextInt();

            cinema.autoBook(hallNumber - 1, numSeats);
        } else {
            System.out.println("Некоректний вибір.");
        }
    }
}
