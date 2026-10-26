package ru.netology.javaqa;

public class Radio {
    private int stationCount;
    private int maxStation;

    private int currentStation = 0;
    private int currentVolume = 0;

    private final int maxVolume = 100;
    private final int minVolume = 0;

    public Radio() {
        this.stationCount = 10;
        this.maxStation = stationCount - 1; // 9
    }

    public Radio(int stationCount) {
        this.stationCount = stationCount;
        this.maxStation = stationCount - 1;
    }

    public int getStationCount() {
        return stationCount;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentStation(int newStation) {
        // Проверка: от 0 до максимального номера включительно
        if (newStation < 0 || newStation > maxStation) {
            return;
        }
        currentStation = newStation;
    }

    public void nextStation() {
        if (currentStation == maxStation) {
            currentStation = 0; // С последней на первую
        } else {
            currentStation = currentStation + 1;
        }
    }

    public void prevStation() {
        if (currentStation == 0) {
            currentStation = maxStation; // С первой на последнюю
        } else {
            currentStation = currentStation - 1;
        }
    }

    public void increaseVolume() {
        if (currentVolume < maxVolume) {
            currentVolume = currentVolume + 1;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > minVolume) {
            currentVolume = currentVolume - 1;
        }
    }

    public void setCurrentVolume(int volume) {
        if (volume >= 0 && volume <= 100) {
            this.currentVolume = volume; // <--- ВОТ ЭТА СТРОКА ДОЛЖНА БЫТЬ
        }
    }
}