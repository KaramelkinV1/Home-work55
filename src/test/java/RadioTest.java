import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.Radio;

public class RadioTest {

    @Test
    public void testDefaultConstructor() {
        Radio radio = new Radio();

        Assertions.assertEquals(10, radio.getStationCount());
        Assertions.assertEquals(0, radio.getCurrentStation());
        Assertions.assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void testCustomStationCount() {
        Radio radio = new Radio(30);

        Assertions.assertEquals(30, radio.getStationCount());
        Assertions.assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testSetStationLimits() {
        Radio radio = new Radio(10);

        radio.setCurrentStation(5);
        Assertions.assertEquals(5, radio.getCurrentStation());

        radio.setCurrentStation(10);
        Assertions.assertEquals(5, radio.getCurrentStation());

        radio.setCurrentStation(-1);
        Assertions.assertEquals(5, radio.getCurrentStation());
    }

    @Test
    public void testNextStation() {
        Radio radio = new Radio(10);

        radio.setCurrentStation(5);
        radio.nextStation();
        Assertions.assertEquals(6, radio.getCurrentStation());

        radio.setCurrentStation(9);
        radio.nextStation();
        Assertions.assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testPrevStation() {
        Radio radio = new Radio(10);

        radio.setCurrentStation(5);
        radio.prevStation();
        Assertions.assertEquals(4, radio.getCurrentStation());

        radio.setCurrentStation(0);
        radio.prevStation();
        Assertions.assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void testVolumeLimits() {
        Radio radio = new Radio();

        radio.setCurrentVolume(99);
        radio.increaseVolume();
        Assertions.assertEquals(100, radio.getCurrentVolume());

        radio.increaseVolume();
        Assertions.assertEquals(100, radio.getCurrentVolume());

        radio.setCurrentVolume(1);
        radio.decreaseVolume();
        Assertions.assertEquals(0, radio.getCurrentVolume());

        radio.decreaseVolume();
        Assertions.assertEquals(0, radio.getCurrentVolume());
    }
    @Test
    public void testSetInvalidVolume() {
        Radio radio = new Radio();

        radio.setCurrentVolume(-1);
        Assertions.assertEquals(0, radio.getCurrentVolume());

        radio.setCurrentVolume(101);
        Assertions.assertEquals(0, radio.getCurrentVolume());
    }
}