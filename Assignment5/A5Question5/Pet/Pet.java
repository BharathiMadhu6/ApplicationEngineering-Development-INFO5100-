package A5Question5.Pet;

public class Pet {

    private String petName;
    private String ownerName;
    private String color;

    public static final int MALE = 1;
    public static final int FEMALE = 2;
    public static final int SPAYED =3;
    public static final int NEUTERED =4;
    protected int sex;

    public Pet(String petName, String ownerName, String color){
        this.petName = petName;
        this.ownerName = ownerName;
        this.color = color;
    }

    public String getPetName() {
        return petName;
    }

    public String getOwnerName() {
        return ownerName;
    }

     public String getColor() {
        return color;
     }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSex(int sexId) {
        this.sex = sexId;
     }

     public String getSex() {
        if(sex == MALE){
            return "MALE";
        }
        else if(sex == FEMALE){
            return "FEMALE";
        }
        else if(sex == SPAYED){
            return "SPAYED";
        }
        else if (sex == NEUTERED)
            return "NEUTERED";
        return "BLOOP";
     }

     public String toString() {
        String data = getPetName()+" owned by "+getOwnerName()+"\n Colour : "+getColor()+"\n Sex : "+getSex();
        return data;
     }

}
