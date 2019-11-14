package A8Question2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class StudentView implements ActionListener {
    private JLabel label1,label2,label3,label4,label5,label6;
    private JTextField textField1,textField2,textField3;
    private JRadioButton radioButton1, radioButton2;
    private JComboBox courseList;
    private JButton button1, button2;
    private JFrame frame;
    private JPanel panel;
    private JTable table;
    private DefaultTableModel tableModel;
    private StudentController controller = new StudentController();

    public void load() {
        frame = new JFrame("STUDENT ENROLLMENT FORM");
        defineComponents();
        GridLayout grid = new GridLayout(10,1);
        panel = new JPanel();
        panel.setBackground(Color.gray);
        panel.setLayout(grid);
        frame.getContentPane().add(panel);
        addComponents();
        frame.setSize(900,500);
        frame.setVisible(true);
    }

    public void defineComponents() {
        label1 = new JLabel(" Enter your ID     ");
        label2 = new JLabel(" Enter your Name    ");
        label3 = new JLabel(" Enter your Age     ");
        label4 = new JLabel(" Gender       ");
        label5 = new JLabel(" Select the course    ");
        label6 = new JLabel(" Status : ");
        radioButton1 = new JRadioButton("F");
        radioButton2 = new JRadioButton("M");
        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        courseList = new JComboBox(new String[] {"MSIS","MSCS","MIS","DataAnalytics"});
        button1 = new JButton(" ADD STUDENT ");
        button2 = new JButton(" VIEW STUDENTS ");
        textField1 = new JTextField(20);
        textField2 = new JTextField(30);
        textField3 = new JTextField(30);
    }

    public void addComponents() {
        panel.add(label1);
        panel.add(textField1);
        panel.add(Box.createVerticalStrut(10));
        panel.add(label2);
        panel.add(textField2);
        panel.add(Box.createVerticalStrut(10));
        panel.add(label3);
        panel.add(textField3);
        panel.add(Box.createVerticalStrut(5));
        panel.add(label4);
        panel.add(radioButton1);
        panel.add(radioButton2);
        panel.add(Box.createVerticalStrut(10));
        panel.add(label5);
        panel.add(courseList);
        panel.add(button1);
        button1.addActionListener(this);
        panel.add(button2);
        button2.addActionListener(this);
        panel.add(Box.createVerticalStrut(10));
        panel.add(label6);
        panel.add(Box.createVerticalStrut(10));
        panel.add(Box.createVerticalStrut(10));
        addTable();
    }

    public void addTable() {
        String column[] = {" ID", "Name", "Age", "Gender", "Course "};
        tableModel = new DefaultTableModel(column, 0);
        table = new JTable(tableModel);
        JScrollPane js = new JScrollPane(table);
        js.getVerticalScrollBar().setValue(1000);
        table.getColumnModel().getColumn(0).setMaxWidth(50);
        table.getColumnModel().getColumn(2).setMaxWidth(50);
        table.getColumnModel().getColumn(4).setMinWidth(60);
        table.setSize(panel.getWidth(),panel.getHeight());
        panel.add(js);
        table.setFillsViewportHeight(true);

    }

    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == button1) {
        int ID = Integer.parseInt(textField1.getText());
        String name = textField2.getText();
        int age = Integer.parseInt(textField3.getText());
        String gender = "";
        if(radioButton1.isSelected()) {
            gender = "F";
        }
        if(radioButton2.isSelected()) {
            gender = "M";
        }
        String course = courseList.getSelectedItem().toString();
        controller.addStudent(ID,name,age,gender,course);
        String status = "Student "+name+" added";
        label6.setText(status);
        }
        if (event.getSource() == button2) {
            label6.setText("");
            clear();
            displayStudents();
        }
    }

    public void clear() {
        tableModel.setRowCount(0);
    }

    public void displayStudents() {
        List<StudentModel> studentList = controller.getDisplayStudents();
        for (int i = 0; i < studentList.size(); i++) {
            StudentModel s = studentList.get(i);
            int ID = studentList.get(i).getID();
            String name = studentList.get(i).getName();
            int age = studentList.get(i).getAge();
            String gender = studentList.get(i).getGender();
            String course = studentList.get(i).getCourse();
            Object[] students = {ID,name,age,gender,course};
            tableModel.addRow(students);
        }
    }

    public static void main(String[] args) {
        StudentView view = new StudentView();
        view.load();
    }

}
