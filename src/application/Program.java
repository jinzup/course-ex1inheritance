package application;

//Imports
import model.Employee;
import model.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of employees");
        int nEmployees = sc.nextInt();
        List<Employee> employees = new ArrayList<>();

        for(int i = 1 ; i <= nEmployees ; i++){
            System.out.println("Employee #" + i + " data:");
            System.out.print("Outsourced? (y/n) ");
            char eType = sc.next().charAt(0);
            System.out.print("Name: ");
            String eName = sc.next();
            System.out.print("Hours: ");
            int eHours = sc.nextInt();
            System.out.print("Value per hour: ");
            double eVPHour = sc.nextDouble();
            if (eType != 'n'){
                System.out.print("Additional Charge: ");
                double adCharge = sc.nextDouble();
                employees.add(new OutsourcedEmployee(eName, eHours, eVPHour,adCharge));
            }else {
                employees.add(new Employee(eName, eHours, eVPHour));
            }
        }
        System.out.println();
        System.out.println("PAYMENTS: ");
        for (Employee std:employees) {
            System.out.printf(std.getName() + " - R$" + String.format("%.2f", std.payment()) + "%n");
        }
        sc.close();
    }
}
