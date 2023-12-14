import org.example.Cinema;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
public class CinemaTests {
    @Test
    public void testBookSeats() {
        Cinema cinema = new Cinema();
        int hallNumber = 0;
        int row = 1;
        int[] seats = {1, 2, 3};

        cinema.bookSeats(hallNumber, row, seats);

        // Перевірка, чи були місця заброньовані
        assertTrue(cinema.isSeatBooked(hallNumber, row, 1));
        assertTrue(cinema.isSeatBooked(hallNumber, row, 2));
        assertTrue(cinema.isSeatBooked(hallNumber, row, 3));

        // Перевірка, чи інші місця залишилися незаброньованими
        assertFalse(cinema.isSeatBooked(hallNumber, row, 4));
        assertFalse(cinema.isSeatBooked(hallNumber, row, 5));
    }

    @Test
    public void testAutoBook() {
        Cinema cinema = new Cinema();
        int hallNumber = 0;
        int numSeats = 3;

        cinema.autoBook(hallNumber, numSeats);

        // Перевірка, чи автоматично заброньовані місця
        assertTrue(cinema.isSeatBooked(hallNumber, 1, 1));
        assertTrue(cinema.isSeatBooked(hallNumber, 1, 2));
        assertTrue(cinema.isSeatBooked(hallNumber, 1, 3));

        // Перевірка, чи інші місця залишилися незаброньованими
        assertFalse(cinema.isSeatBooked(hallNumber, 1, 4));
        assertFalse(cinema.isSeatBooked(hallNumber, 1, 5));
    }

    @Test
    public void testCancelBooking() {
        Cinema cinema = new Cinema();
        int hallNumber = 0;
        int row = 1;
        int[] seats = {1, 2, 3};

        cinema.bookSeats(hallNumber, row, seats);
        cinema.cancelBooking(hallNumber, row, seats);

        // Перевірка, чи були місця скасовані
        assertFalse(cinema.isSeatBooked(hallNumber, row, 1));
        assertFalse(cinema.isSeatBooked(hallNumber, row, 2));
        assertFalse(cinema.isSeatBooked(hallNumber, row, 3));
    }

    @Test
    public void testCheckAvailability() {
        Cinema cinema = new Cinema();
        int hallNumber = 0;
        int row = 1;
        int[] seats = {1, 2, 3};

        // Перевірка доступності місць перед бронюванням
        assertTrue(cinema.checkAvailability(hallNumber, row, seats));

        // Бронювання місць
        cinema.bookSeats(hallNumber, row, seats);

        // Перевірка недоступності заброньованих місць
        assertFalse(cinema.checkAvailability(hallNumber, row, seats));

        // Перевірка доступності інших місць
        assertTrue(cinema.checkAvailability(hallNumber, row, new int[]{4, 5, 6}));
    }

    @Test
    public void testFindBestAvailable() {
        Cinema cinema = new Cinema();
        int hallNumber = 0;
        int numSeats = 3;

        // Перевірка знаходження найкращих доступних місць
        assertFalse(cinema.findBestAvailable(hallNumber, numSeats).isEmpty());
    }

    @Test
    public void testPrintSeatingArrangement() {
        Cinema cinema = new Cinema();
        int hallNumber = 0;

        // Бронювання місць
        cinema.bookSeats(hallNumber, 1, new int[]{1, 2, 3});

        // Виведення схеми
        cinema.printSeatingArrangement(hallNumber);
    }

}
