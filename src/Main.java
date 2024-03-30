//Создать внутри класса Main метод main и поле типа Employee[10], которое будет выполнять роль "хранилища" для записей о сотрудниках.

import java.util.Arrays;

//Распечатать ФИО всех сотрудников (метод ничего).
public class Main {
    private final static int EMPLOYEE_NUMBER = 10;
    private static Employee[] employees = new Employee[EMPLOYEE_NUMBER];

    //Создать внутри класса Main метод main и поле типа Employee[10],
    // которое будет выполнять роль "хранилища" для записей о сотрудниках.
    public static void main(String[] args) {

        employees[0] = new Employee("Ivanov AA", 1, 70000);
        employees[1] = new Employee("Petrov HK", 2, 68000);
        employees[2] = new Employee("Sidorov AD", 1, 75000);
        employees[3] = new Employee("Alekseev RT", 3, 86000);
        employees[4] = new Employee("Smirnov KA", 5, 82000);
        employees[5] = new Employee("Putin VV", 4, 75000);
        employees[6] = new Employee("Haritonov NM", 3, 69000);
        employees[7] = new Employee("Davankov VA", 4, 71000);
        employees[8] = new Employee("Slutskiy KE", 5, 76000);
//        employees[9] = new Employee("Gribov KL", 2, 79000);
        System.out.println("Базовая сложность");
        System.out.println("\nВывести в консоль значения всех полей (toString))");
        inputEmployees();
        System.out.println("\nПосчитать сумму затрат на ЗП в месяц;");
        System.out.println("Cумма затрат на ЗП в месяц " + sumMoney());
        System.out.println("Сотрудник с минимальной зарплатой " + findMinSalary().getName());
        System.out.println("Сотрудник с максимальной зарплатой " + findMaxSalary().getName());
        System.out.println("\nCреднее значение зарплаты " + averageSalary());
        System.out.println("\nРаспечатать ФИО всех сотрудников (метод void)");
        printAllStatement();

    }


    //
    private static void inputEmployees() {          // (вывести в консоль значения всех полей (toString));
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private static int sumMoney() {              //Посчитать сумму затрат на ЗП в месяц;
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;

    }

    private static Employee findMinSalary() {            //Найти сотрудника с минимальной ЗП;
        Employee employeeMinSalary = employees[0];
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getSalary() < employeeMinSalary.getSalary()) {
                    employeeMinSalary = employee;
                }
            }
        }
        return employeeMinSalary;
    }

    private static Employee findMaxSalary() {            //Найти сотрудника с максимальной ЗП;
        Employee employeeMaxSalary = employees[0];
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getSalary() > employeeMaxSalary.getSalary()) {
                    employeeMaxSalary = employee;
                }
            }
        }
        return employeeMaxSalary;
    }

    public static float averageSalary() {
        int numberEmployee = 0;
        for (Employee employee : employees) {
            if (employee != null) numberEmployee++;
        }
        ;
        return (float) (sumMoney() / numberEmployee);
    }

    public static void printAllStatement()       //Распечатать ФИО всех сотрудников (метод void).
    {
        for (Employee employee : employees) {
            if (employee != null) {

                System.out.println("ФИО всех сотрудников" + employee.getName());
            }
        }


    }
}




