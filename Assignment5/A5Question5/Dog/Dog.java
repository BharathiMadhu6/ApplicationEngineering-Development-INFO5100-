package A5Question5.Dog;

import A5Question5.Boardable.Boardable;
import A5Question5.Pet.Pet;

import java.time.LocalDate;

public class Dog extends Pet implements Boardable {

    private String size;
    private int startMonth;
    private int startDay;
    private int startYear;
    private int endMonth;
    private int endDay;
    private int endYear;

    public Dog(String petName, String ownerName, String color, String size) {
        super(petName, ownerName, color);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public String toString() {
        String msg = "DOG : \n" + getPetName() + " is owned by " + getOwnerName() + "\nColour : " + getColor() + "\nSex : " + getSex() + "\nSize : " + getSize() + "";
        return msg;
    }

    public void setBoardStart(int month, int day, int year) {
        this.startMonth = month;
        this.startDay = day;
        this.startYear = year;
    }

    public void setBoardEnd(int month, int day, int year) {
        this.endMonth = month;
        this.endDay = day;
        this.endYear = year;
    }


    public boolean boarding(int month, int day, int year) {

        LocalDate boardingDate = LocalDate.of(year, month, day);

        LocalDate start = LocalDate.of(startYear,startMonth,startDay);
        LocalDate stop = LocalDate.of(endYear,endMonth,endDay);

        if (boardingDate.isAfter(stop)) {
            return false;
        }
        if (boardingDate.isBefore(start)) {
            return false;
        }
        return true;
    }
}
