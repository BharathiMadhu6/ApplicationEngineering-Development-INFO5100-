package A5Question4;

public class MyIndexOutOfBoundException extends Exception {

    private int lowerBound;
    private int upperBound;
    private int index;

    MyIndexOutOfBoundException(int lowerBound, int upperBound, int index) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.index = index;
    }

    public String toString() {
        String msg = "Error Message : Index : "+ index + ", but Lower bound : "+ lowerBound + " , Upper bound : "+ upperBound +"";
        return msg;
    }

    public static void main(String[] args) throws IndexOutOfBoundsException{
        int lowerBound = 1;
        int upperBound = 10;

        try {
            for(int i = lowerBound; i < 15; i++) {
                if(i > upperBound) {
                    throw new MyIndexOutOfBoundException(lowerBound, upperBound, i);
                }
                System.out.println("CurrentIndex" + i);
            }
        }
        catch (MyIndexOutOfBoundException ie) {
            String msg = ie.toString();
            System.out.println(msg);
        }
    }
}
