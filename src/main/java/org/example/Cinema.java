package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cinema {

    private static final int NUM_HALLS = 5;
    private static final int NUM_ROWS = 10;
    private static final int NUM_SEATS_PER_ROW = 20;

    private final int[][][] seatingArrangement;
    private final String[] hallNames;

    public Cinema() {
        this.seatingArrangement = new int[NUM_HALLS][NUM_ROWS][NUM_SEATS_PER_ROW];
        this.hallNames = generateHallNames();
        initializeSeatingArrangement();
    }

    private String[] generateHallNames() {
        String[] names = new String[NUM_HALLS];
        for (int i = 0; i < NUM_HALLS; i++) {
            names[i] = "Зал " + (i + 1);
        }
        return names;
    }

    public String[] getHallNames() {
        return hallNames;
    }

    public int getNumHalls() {
        return NUM_HALLS;
    }

    private void initializeSeatingArrangement() {
        for (int[][] hall : seatingArrangement) {
            for (int[] row : hall) {
                Arrays.fill(row, 0);
            }
        }
    }

    public void printSeatingArrangement(int hallNumber) {
        System.out.println("Схема розміщення місць для " + hallNames[hallNumber] + ":");

        for (int row = 1; row <= NUM_ROWS; row++) {
            for (int seat = 1; seat <= NUM_SEATS_PER_ROW; seat++) {
                System.out.print(seatingArrangement[hallNumber][row - 1][seat - 1] + " ");
            }
            System.out.println();
        }
    }

    // Оновлений метод для бронювання місць
    public void bookSeats(int hallNumber, int row, int[] seats) {
        for (int seat : seats) {
            if (isSeatBooked(hallNumber, row, seat)) {
                System.out.println("Місце " + seat + " у ряду " + row + " залу " + hallNames[hallNumber] + " вже заброньоване.");
            } else {
                seatingArrangement[hallNumber][row - 1][seat - 1] = 1; // Збільшено на 1
                System.out.println("Місце " + seat + " у ряду " + row + " залу " + hallNames[hallNumber] + " успішно заброньоване.");

                // Виведення схеми після ручного бронювання
                printSeatingArrangement(hallNumber);
            }
        }
    }
    public List<Integer> findBestAvailable(int hallNumber, int numSeats) {
        List<Integer> bestSeats = new ArrayList<>();
        int currentConsecutiveSeats = 0;
        int startSeatIndex = -1;

        for (int seat = 0; seat < NUM_SEATS_PER_ROW; seat++) {
            if (seatingArrangement[hallNumber][0][seat] == 0) {
                if (currentConsecutiveSeats == 0) {
                    startSeatIndex = seat;
                }
                currentConsecutiveSeats++;

                if (currentConsecutiveSeats == numSeats) {
                    for (int i = startSeatIndex; i < startSeatIndex + numSeats; i++) {
                        bestSeats.add(i);
                    }
                    return bestSeats;
                }
            } else {
                currentConsecutiveSeats = 0;
            }
        }
        return bestSeats;
    }
    // Оновлений метод для автоматичного бронювання та виводу схеми
    public void autoBook(int hallNumber, int numSeats) {
        List<Integer> bestSeats = findBestAvailable(hallNumber, numSeats);
        if (bestSeats.isEmpty()) {
            System.out.println("Немає достатньо вільних послідовних місць для бронювання " + numSeats + " місць у " + hallNames[hallNumber] + ".");
        } else {
            int[] seatsArray = new int[bestSeats.size()];
            for (int i = 0; i < bestSeats.size(); i++) {
                seatsArray[i] = bestSeats.get(i) + 1; // Збільшено на 1, оскільки місця починаються з 1
            }
            bookSeats(hallNumber, 1, seatsArray); // Змінено ряд на 1
            System.out.println("Автоматичне бронювання " + numSeats + " місць у " + hallNames[hallNumber] + " успішно виконано.");

            // Виведення схеми після автоматичного бронювання
            printSeatingArrangement(hallNumber);
        }
    }


    private boolean isSeatBooked(int hallNumber, int row, int seat) {
        return seatingArrangement[hallNumber][row - 1][seat - 1] == 1;
    }

    private boolean isSeatFree(int hallNumber, int row, int seat) {
        return seatingArrangement[hallNumber][row][seat] == 0;
    }
}
