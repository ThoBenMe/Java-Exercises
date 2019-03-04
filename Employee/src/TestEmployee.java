import java.util.Scanner;

public class TestEmployee {

    public static void main(String[] args) {
        Employee e1 = new Employee("Mueller, Samuel");
        Employee e2 = new Employee("Daxenberger, Susanne");
        Employee e3 = new Employee("Stern, Kylar");

        Employee[] employees = new Employee[3];
        employees[0] = e1;
        employees[1] = e2;
        employees[2] = e3;

        Scanner scanner = new Scanner(System.in);
        float value;
        for(int i = 0; i < employees.length; i++){
            System.out.println("Please enter the employee's salary:");
            value = scanner.nextFloat();
            employees[i].setMonatsgehalt(value);
        }


        float sum = 0;
        for(int i = 0; i < employees.length; i++){
            sum += employees[i].getMonatsgehalt();
        }

        float average = sum / 3;
        average = Math.round(average);

        System.out.println(average);
    }


}
