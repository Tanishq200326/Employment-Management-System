package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import com.toedter.calendar.JDateChooser;

public class AddEmployee extends JFrame implements ActionListener {

    Random ran = new Random();
    int number = ran.nextInt(999999);

    JTextField tfname,tffname,tfaddress,tfphone,tfaadhar,tfemail,tfsalary,tfdesignation;
    JDateChooser dcdob;
    JComboBox cbeducation;
    JLabel lblempId;
    JButton add,back;
    AddEmployee(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN_SARIF",Font.BOLD,25));
        add(heading);

        JLabel lablename = new JLabel("Name");
        lablename.setBounds(50,150,150,30);
        lablename.setFont(new Font("serif",Font.PLAIN,20));
        add(lablename);

        tfname = new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);

        JLabel lablefname = new JLabel("Father's Name");
        lablefname.setBounds(400,150,150,30);
        lablefname.setFont(new Font("serif",Font.PLAIN,20));
        add(lablefname);

        tffname = new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);

        JLabel lablefdob = new JLabel("Date of Birth");
        lablefdob.setBounds(50,200,150,30);
        lablefdob.setFont(new Font("serif",Font.PLAIN,20));
        add(lablefdob);

        dcdob = new JDateChooser();
        dcdob.setBounds(200,200,150,30);
        add(dcdob);

        JLabel lablesalary = new JLabel("Salary");
        lablesalary.setBounds(400,200,150,30);
        lablesalary.setFont(new Font("serif",Font.PLAIN,20));
        add(lablesalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(600,200,150,30);
        add(tfsalary);

        JLabel lableaddress = new JLabel("Address");
        lableaddress.setBounds(50,250,150,30);
        lableaddress.setFont(new Font("serif",Font.PLAIN,20));
        add(lableaddress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);

        JLabel lablephone = new JLabel("Phone");
        lablephone.setBounds(400,250,150,30);
        lablephone.setFont(new Font("serif",Font.PLAIN,20));
        add(lablephone);

        tfphone = new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);

        JLabel lableemail = new JLabel("Email");
        lableemail.setBounds(50,300,150,30);
        lableemail.setFont(new Font("serif",Font.PLAIN,20));
        add(lableemail);

        tfemail = new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);

        JLabel lableeducation = new JLabel("Higest Education");
        lableeducation.setBounds(400,300,150,30);
        lableeducation.setFont(new Font("serif",Font.PLAIN,20));
        add(lableeducation);

        String cources[] = {"BBA","BCA","BA","BSC","B.COM","BTech","MBA","MCA","MA","MTech","MSC","PHD"};
        cbeducation = new JComboBox(cources);
        cbeducation.setBackground(Color.WHITE);
        cbeducation.setBounds(600,300,150,30);
        add(cbeducation);

        JLabel labledesignation = new JLabel("Designation");
        labledesignation.setBounds(50,350,150,30);
        labledesignation.setFont(new Font("serif",Font.PLAIN,20));
        add(labledesignation);

        tfdesignation = new JTextField();
        tfdesignation.setBounds(200,350,150,30);
        add(tfdesignation);

        JLabel lableaadhar = new JLabel("Aadhar Number");
        lableaadhar.setBounds(400,350,150,30);
        lableaadhar.setFont(new Font("serif",Font.PLAIN,20));
        add(lableaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(600,350,150,30);
        add(tfaadhar);

        JLabel lableempId = new JLabel("Employee Id");
        lableempId.setBounds(50,400,150,30);
        lableempId.setFont(new Font("serif",Font.PLAIN,20));
        add(lableempId);

        lblempId = new JLabel("" + number);
        lblempId.setBounds(200,400,150,30);
        lblempId.setFont(new Font("serif",Font.PLAIN,20));
        add(lblempId);

        add = new JButton("Add Details");
        add.setBounds(250,550,150,40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);

        back = new JButton("Back");
        back.setBounds(450,550,150,40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

        setBounds(200,0,900,700);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String name = tfname.getText();
            String fname = tffname.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = (String) cbeducation.getSelectedItem();
            String designation = tfdesignation.getText();
            String aadhar = tfaadhar.getText();
            String empId = lblempId.getText();

            try {
                Conn c = new Conn();
                String query = "insert into employee values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+aadhar+"','"+empId+"')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Details added Successfully");

                setVisible(false);
                new Home();
            }catch (Exception e){
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
