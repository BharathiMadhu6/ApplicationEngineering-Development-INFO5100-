package Assignment3;

import java.util.Scanner;

public class CourseCheck {

    public static void main(String[] args) {
        Course course = new Course(110, 112233, 4);
        System.out.println("Enter the size of the studentId array");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        int inputs[] = new int[size];

        System.out.println("Enter "+ size + " ID values");
        for (int i = 0; i < size; i++) {
            inputs[i] = sc.nextInt();
        }
        course.registerStudent(inputs);
        System.out.println("-------The studentId array------\n");
        for(int i: course.getStudentIds()) {
            System.out.print(i+" \n");
        }

       int[] newArray=course.removeDuplicates(course.getStudentIds());
        System.out.println("---------The array after removing duplicates--------\n");
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + " \n");
        }

        int c = course.groupsOfStudents(course.getStudentIds());
        System.out.println("------------Even number count function---------\n");
        System.out.println(c+" is the count\n");

        System.out.println("---------Count and say function--------------\n");
        System.out.println("enter the integer between 1 and 30 \n");
        int nNumber=sc.nextInt();
        String seq = course.countAndSay(nNumber);
        System.out.println(seq + " \n");

        System.out.println("-------To reverse a string word by word-------\n");
        System.out.println(course.reverseString("What a beautiful day"));


        System.out.println("------------ZIG ZAG FUNCTION OUTPUT-------------\n");
        System.out.println(course.convert("PAYPALISHIRING", 3));
        System.out.println(course.convert("PAYPALISHIRING", 4));


        System.out.println("-------------------Spiral Array-----------------\n");
        System.out.println("enter the m value for m*n array (1-9)");
        Scanner scanner=new Scanner(System.in);
        int m=scanner.nextInt();
        System.out.println("enter the n value for m*n array (1-9)");
        Scanner scanner1=new Scanner(System.in);
        int n=scanner1.nextInt();
        int[][]matrix=new int[m][n];
        System.out.println("enter the array values");
        for (int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                Scanner input=new Scanner(System.in);
                matrix[i][j] = input.nextInt();
            }
        }
        int[] spiralArray = course.spiralOrder(matrix);
        System.out.println("Values holding spiral elements");
        for (int element : spiralArray){
            System.out.print(element + " ");
        }
    }

}
