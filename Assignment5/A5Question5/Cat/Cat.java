package A5Question5.Cat;

import A5Question5.Boardable.Boardable;
import A5Question5.Pet.Pet;

import java.time.LocalDate;

public class Cat extends Pet implements Boardable {

    private String hairLength;
    private int startMonth;
    private int startDay;
    private int startYear;
    private int endMonth;
    private int endDay;
    private int endYear;

    public Cat(String petName, String ownerName, String color, String hairLength) {
        super(petName, ownerName, color);
        this.hairLength = hairLength;
    }

    public String getHairLength() {
        return hairLength;
    }

    public String toString() {
        String msg = "CAT : \n"+getPetName()+" owned by "+getOwnerName()+"\nColour : "+getColor()+"\nSex : "+getSex()+" \nHair : "+getHairLength()+"";
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
