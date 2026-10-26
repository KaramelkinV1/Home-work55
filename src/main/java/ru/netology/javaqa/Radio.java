package ru.netology.javaqa;

public class Radio {
    private int radioStationNumber; //номер станции
    private int radioVolume; //громкость радио


    public Radio() {
        this.radioStationNumber = 0;
        this.radioVolume = 0;
    }

    public void setStationNumber(int level) { // настройка номера станции
        if (level >= 0 && level <= 9) {
            this.radioStationNumber = level;
        }
    }

    //следующая станция
    public void nextStationNumber() {
        if (this.radioStationNumber == 9) {
            this.radioStationNumber = 0; //
        } else {
            this.radioStationNumber = this.radioStationNumber + 1;
        }
    }

    //предыдущая станция
    public void prevStationNumber() {
        if (this.radioStationNumber == 0) {
            this.radioStationNumber = 9; //
        } else {
            this.radioStationNumber = this.radioStationNumber - 1;
        }
    }

    //увеличить громкость
    public void increaseVolume() {
        if (this.radioVolume < 100) {
            this.radioVolume = this.radioVolume + 1;
        }
    }

    //уменьшение громкость
    public void decreaseVolume() {
        if (this.radioVolume > 0) {
            this.radioVolume = this.radioVolume - 1;
        }
    }

    public int getRadioStationNumber() {
        return radioStationNumber;
    }

    public int getRadioVolume() {
        return radioVolume;
    }

    public void setRadioVolume(int volume) {
        if (volume >= 0 && volume <= 100) {
            this.radioVolume = volume;
        }
    }


}
