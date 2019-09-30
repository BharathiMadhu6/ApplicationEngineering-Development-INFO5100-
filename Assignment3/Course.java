package Assignment3;

public class Course {

    private int courseId;
    private String courseName;
    private int maxCapacity;
    private int professorId;
    private int credits;
    private int[] studentIds;

    Course(int courseId) {
        this.courseId = courseId;
    }

    Course(int courseId, int professorId) {
        this.courseId = courseId;
        this.professorId = professorId;
    }

    Course(int courseId, int professorId, int credits) {
        this.courseId = courseId;
        this.professorId = professorId;
        this.credits = credits;
    }

    //setters
    public void setCourseId(int courseId) {
        if (courseId <= 0) {
            throw new IllegalArgumentException("Course ID cannot be negative or zero");
        }
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        if ((courseName.length() < 10) || (courseName.length() > 60)) {
            throw new IllegalArgumentException("Course name of length" + courseName.length() + " is not acceptable");
        }
        this.courseName = courseName;
    }

    public void setMaxCapacity(int maxCapacity) {
        if ((maxCapacity < 10) || (maxCapacity > 100)) {
            throw new IllegalArgumentException("Maximum capacity should not be less than 10 greater than 100");
        }
        this.maxCapacity = maxCapacity;
    }

    public void setProfessorId(int professorId) {
        int professorLength = String.valueOf(professorId).length();
        if (professorLength != 6) {
            throw new IllegalArgumentException("professor ID has to be of length 6 only");
        }
        this.professorId = professorId;
    }

    public void setCredits(int credits) {
        int creditsLength = String.valueOf(credits).length();
        if ((creditsLength != 1) && (credits <= 0)) {
            throw new IllegalArgumentException("credits has to be a single digit but greater than zero");
        }
        this.credits = credits;
    }

    public void setStudentIds(int[] studentIds) {
        this.studentIds = studentIds;
    }

    //getters
    public int getCourseId() {
        return this.courseId;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public int getMaxCapacity() {
        return this.maxCapacity;
    }

    public int getProfessorId() {
        return this.professorId;
    }

    public int getCredits() {
        return this.credits;
    }

    public int[] getStudentIds() {
        return this.studentIds;
    }

    public void registerStudent(int[] studentIds) {
        this.studentIds = studentIds;
    }

    public int[] removeDuplicates(int[] studentIds) {
        int temp = 0;
        // new array of same length
        int[] newArray = new int[studentIds.length];
        for (int i = 0; i <= studentIds.length - 1; i++) {
            if (!checkElementExists(studentIds[i], newArray)) {
                newArray[temp] = studentIds[i];
                temp++;
            }
        }

        // reduce the size of newArray and remove empty value
        int[] reducedArray = new int[temp];
        for (int i = 0; i < temp; i++) {
            reducedArray[i] = newArray[i];
        }

        return reducedArray;
    }


    // return true or false
    private boolean checkElementExists(int element, int[] newArray) {
        for (int i = 0; i < newArray.length; i++) {
            if (element == newArray[i]) {
                return true;
            }
        }
        return false;
    }

    public int groupsOfStudents(int[] studentIds) {
        int counter = 0;
        for (int i = 0; i < studentIds.length - 1; i++) {
            for (int j = i + 1; j < studentIds.length; j++) {
                int value = studentIds[i] + studentIds[j];
                if (value % 2 == 0) {
                    counter++;
                }
            }
        }
        return counter;
    }


    public String countAndSay(int n) {

        if(n < 1 || n > 30) {
            throw new IllegalArgumentException("n value must be between 1 and 30");
        }

        if (n == 1) {
            return "1";
        } else if (n == 2) {
            return "11";
        }

        String previousSeq = "11";
        // 1211
        for (int iter = 0; iter < n - 2; iter++) {
            char[] baseChars = previousSeq.toCharArray();
            String seq = "";
            int totalNumberTimes = 1;
            for (int i = 0; i < baseChars.length; i++) {
                int lastSecondIndex = baseChars.length - 2;
                // terminal cases
                if (i == lastSecondIndex) {
                    if (checkSameNumber(baseChars[i], baseChars[i + 1])) {
                        totalNumberTimes++;
                        seq = seq + String.valueOf(totalNumberTimes) + baseChars[i];
                        previousSeq = seq;
                        break;
                    } else {
                        String newSeq = String.valueOf(totalNumberTimes) + baseChars[i];
                        String lastDigitSeq = '1' + String.valueOf(baseChars[i + 1]);
                        seq = seq + newSeq + lastDigitSeq;
                        previousSeq = seq;
                        break;
                    }
                }

                if (checkSameNumber(baseChars[i], baseChars[i + 1])) {
                    totalNumberTimes++;
                } else {
                    seq = seq + String.valueOf(totalNumberTimes) + baseChars[i];
                    totalNumberTimes = 1;
                }
            }
        }
        return previousSeq;
    }


    private boolean checkSameNumber(char original, char nextChar) {
        return original == nextChar;
    }


    private int countNumber(int number) {
        if (number == 1) {
            return 11;
        } else if (number == 2) {
            return 12;
        }
        return 0;
    }


    public String reverseString(String sentence) {
        String[] splitSentence = sentence.split("\\s");
        String reversedString = "";
        for (int i = splitSentence.length - 1; i >= 0; i--) {
            reversedString = reversedString + splitSentence[i] + " ";
        }
        return reversedString;
    }

    public String convert(String inputString, int numRows) {

        if (inputString == null || inputString.isEmpty()) {
            throw new IllegalArgumentException("Input string Invalid.");
        }

        // create arrays to store rows
        char[][] charArrays = new char[numRows][];
        char[] inputChars = inputString.toCharArray();
        String zigzagString = "";

        StringBuilder[] builders = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            builders[i] = new StringBuilder();
        }

        int top = 0;
        int row = 0;
        int bottom = numRows - 1;

        int numberOfChars = inputChars.length;
        int addedChars = 0;
        int index = 0;
        boolean goingUp = false;
        boolean goingDown = true;

       
        while (addedChars != numberOfChars) {

            if (row != bottom && goingDown) {
                addedChars++;
                builders[row].append(inputChars[index]);
                row++;
                index++;
            }

            if (addedChars == numberOfChars) {
                break;
            }

            if (row != top && goingUp || row == bottom) {
                addedChars++;
                builders[row].append(inputChars[index]);
                index++;
                row = row - 1;
                goingUp = true;
                goingDown = false;
            }

            if (addedChars == numberOfChars) {
                break;
            }

            if (addedChars == numberOfChars) {
                break;
            }

            if (row == top) {
                addedChars++;
                builders[row].append(inputChars[index]);
                index++;
                row++;
                goingUp = false;
                goingDown = true;
            }

            if (addedChars == numberOfChars) {
                break;
            }
        }

        for (int i = 0; i < builders.length; i++) {
            zigzagString = zigzagString + builders[i].toString();
        }
        return zigzagString;
    }


    public int[] spiralOrder(int[][] matrix) {

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        int size = matrix.length * matrix[0].length;
        int[] spiralArray = new int[size];
        int elementIndex = 0;

        while (elementIndex != size) {

            for (int i = left; i <= right; i++) {
                spiralArray[elementIndex] = matrix[top][i];
                elementIndex++;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                spiralArray[elementIndex] = matrix[i][right];
                elementIndex++;
            }
            right--;

            for (int i = right; i >= left; i--) {
                spiralArray[elementIndex] = matrix[bottom][i];
                elementIndex++;
            }
            bottom--;

            for (int i = bottom; i >= top; i--) {
                spiralArray[elementIndex] = matrix[i][left];
                elementIndex++;
            }
            left++;

        }
        return spiralArray;
    }
}
