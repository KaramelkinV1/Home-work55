import org.junit.jupiter.api.Test;
import ru.netology.javaqa.Radio;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioTest {
    @Test
    public void testStationLimits() {
        Radio radio = new Radio();

        // 1. Проверка валидных значений
        radio.setStationNumber(3);
        assertEquals(3, radio.getRadioStationNumber());

        // 2. Проверка невалидных значений
        radio.setStationNumber(10);
        assertEquals(3, radio.getRadioStationNumber()); // Осталось 3

        radio.setStationNumber(-1);
        assertEquals(3, radio.getRadioStationNumber()); // Осталось 3

        // 3. Проверка перехода 9 -> 0
        radio.setStationNumber(9);
        radio.nextStationNumber();
        assertEquals(0, radio.getRadioStationNumber());

        // 4. Проверка перехода 0 -> 9
        radio.setStationNumber(0);
        radio.prevStationNumber();
        assertEquals(9, radio.getRadioStationNumber());
    }


    @Test
    public void testRadioVolume() {
        Radio radio = new Radio();

        radio.increaseVolume(); // 0 -> 1
        assertEquals(1, radio.getRadioVolume());

        // 2. Проверка границы максимума (100)
        radio.setRadioVolume(99); // Ставим 99
        radio.increaseVolume();   // 99 -> 100
        assertEquals(100, radio.getRadioVolume());

        radio.increaseVolume();   // Пытаемся сделать 101
        assertEquals(100, radio.getRadioVolume()); // Должно остаться 100

        // 3. Проверка обычного уменьшения
        radio.decreaseVolume();   // 100 -> 99
        assertEquals(99, radio.getRadioVolume());

        // 4. Проверка границы минимума (0)
        radio.setRadioVolume(1);  // Ставим 1
        radio.decreaseVolume();   // 1 -> 0
        assertEquals(0, radio.getRadioVolume());

        radio.decreaseVolume();   // Пытаемся сделать -1
        assertEquals(0, radio.getRadioVolume()); // Должно остаться 0
    }
}

