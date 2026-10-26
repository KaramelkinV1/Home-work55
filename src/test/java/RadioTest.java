import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.Radio;

public class RadioTest {

    // 1. Проверка конструктора по умолчанию (10 станций)
    @Test
    public void testDefaultConstructor() {
        Radio radio = new Radio();

        // Количество станций = 10, значит maxStation = 9
        Assertions.assertEquals(10, radio.getStationCount());
        Assertions.assertEquals(0, radio.getCurrentStation());
        Assertions.assertEquals(0, radio.getCurrentVolume());
    }

    // 2. Проверка конструктора с кастомным количеством станций
    @Test
    public void testCustomStationCount() {
        // 30 станций -> последняя = 29
        Radio radio = new Radio(30);

        Assertions.assertEquals(30, radio.getStationCount());
        Assertions.assertEquals(0, radio.getCurrentStation());
    }

    // 3. Проверка сеттера станции (границы)
    @Test
    public void testSetStationLimits() {
        Radio radio = new Radio(10); // 0..9

        // Валидное значение
        radio.setCurrentStation(5);
        Assertions.assertEquals(5, radio.getCurrentStation());

        // Невалидное: больше максимума
        radio.setCurrentStation(10);
        Assertions.assertEquals(5, radio.getCurrentStation());

        // Невалидное: меньше нуля
        radio.setCurrentStation(-1);
        Assertions.assertEquals(5, radio.getCurrentStation());
    }

    // 4. Проверка переключения next (включая циклический переход)
    @Test
    public void testNextStation() {
        Radio radio = new Radio(10); // 0..9

        // Обычный переход
        radio.setCurrentStation(5);
        radio.nextStation();
        Assertions.assertEquals(6, radio.getCurrentStation());

        // Переход с максимума на 0
        radio.setCurrentStation(9);
        radio.nextStation();
        Assertions.assertEquals(0, radio.getCurrentStation());
    }

    // 5. Проверка переключения prev (включая циклический переход)
    @Test
    public void testPrevStation() {
        Radio radio = new Radio(10); // 0..9

        // Обычный переход
        radio.setCurrentStation(5);
        radio.prevStation();
        Assertions.assertEquals(4, radio.getCurrentStation());

        // Переход с 0 на максимум
        radio.setCurrentStation(0);
        radio.prevStation();
        Assertions.assertEquals(9, radio.getCurrentStation());
    }

    // 6. Проверка громкости (границы)
    @Test
    public void testVolumeLimits() {
        Radio radio = new Radio();

        // Увеличение до максимума
        radio.setCurrentVolume(99);
        radio.increaseVolume();
        Assertions.assertEquals(100, radio.getCurrentVolume());

        // Попытка превысить максимум
        radio.increaseVolume();
        Assertions.assertEquals(100, radio.getCurrentVolume());

        // Уменьшение до минимума
        radio.setCurrentVolume(1);
        radio.decreaseVolume();
        Assertions.assertEquals(0, radio.getCurrentVolume());

        // Попытка уйти ниже нуля
        radio.decreaseVolume();
        Assertions.assertEquals(0, radio.getCurrentVolume());
    }
}