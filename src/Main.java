//Создать внутри класса Main метод main и поле типа Employee[10], которое будет выполнять роль "хранилища" для записей о сотрудниках.

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
        employees[9] = new Employee("Gribov KL", 2, 79000);
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

        System.out.println("\nПовышенная сложность");

        System.out.println("Проиндексировать зарплату (вызвать изменение зп у всех сотрудников на величину аргумента в %");
        indexSalary(20f);                  //Проиндексировать зарплату (вызвать изменение зп у всех сотрудников на величину аргумента в %)
        inputEmployees();
        final int NUMBER_DEPARTMENT = 1;
        final int PERCENT_SALARY = 10;
        final int LIMIT_SALARY = 93000;

        System.out.println("Сотрудник с минимальной зп в отделе №" + NUMBER_DEPARTMENT + " =" + findMinSalaryDepartment(NUMBER_DEPARTMENT).getDepartment() + " " + findMinSalaryDepartment(NUMBER_DEPARTMENT).getName());
        System.out.println("Сотрудник с максимальной зп в отделе №" + NUMBER_DEPARTMENT + " =" + findMaxSalaryDepartment(NUMBER_DEPARTMENT).getDepartment() + " " + findMaxSalaryDepartment(NUMBER_DEPARTMENT).getName());
        System.out.println("Сумма затрат на зп по отделу N" + NUMBER_DEPARTMENT + " =" + sumSalaryDepartment(NUMBER_DEPARTMENT));
        System.out.println("Средняя зп по отделу N" + NUMBER_DEPARTMENT + " =" + averageSalaryDepartment(NUMBER_DEPARTMENT));
        printEmployeeDepartment(NUMBER_DEPARTMENT);
        System.out.println("Проиндексировать зарплату всех сотрудников отдела на " + PERCENT_SALARY + "процентов, который приходит в качестве параметра отдел №" + NUMBER_DEPARTMENT);
        indexSalaryDepartment(NUMBER_DEPARTMENT, PERCENT_SALARY);
        printEmployeeDepartment(NUMBER_DEPARTMENT);
        System.out.println("Получить в качестве параметра число и вывести:" +
                "Всех сотрудников с зп меньше числа " + LIMIT_SALARY + " (распечатать id, фио и зп в консоль);");
        printSalaryLower(LIMIT_SALARY);
        System.out.println("Получить в качестве параметра число и вывести:" +
                "Всех сотрудников с зп больше числа " + LIMIT_SALARY + " (распечатать id, фио и зп в консоль);");
        printSalaryHigher(LIMIT_SALARY);
        ;

    }
    //
    private static void inputEmployees() {          // (вывести в консоль значения всех полей (toString));
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
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
            if (employee != null && (employee.getSalary() < employeeMinSalary.getSalary())) {
                employeeMinSalary = employee;
            }
        }
        return employeeMinSalary;
    }
    private static Employee findMaxSalary() {            //Найти сотрудника с максимальной ЗП;
        Employee employeeMaxSalary = employees[0];
        for (Employee employee : employees) {
            if (employee != null && (employee.getSalary() > employeeMaxSalary.getSalary())) {
                employeeMaxSalary = employee;
            }
        }
        return employeeMaxSalary;
    }
    public static float averageSalary() {
        int numberEmployee = 0;
        int sumSalary = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                numberEmployee++;
                sumSalary+= employee.getSalary();
            }
        }
        float averageSalary = 0;
        try {
            averageSalary = (float) (sumSalary / numberEmployee);
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        }
        return averageSalary;
    }
    public static void printAllStatement()       //Распечатать ФИО всех сотрудников (метод void).
    {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println("ФИО всех сотрудников" + employee.getName());
            }
        }
    }
//  Повышенная сложность
//  1
    public static void indexSalary(float upPercent) {
        float index = ((upPercent + 100) / 100);
        for (Employee employee : employees) {
            if (employee != null) {
                int indexSalary = (int) (employee.getSalary() * index);
                employee.setSalary(indexSalary);
                System.out.println(employee);
            }
        }
    }
    //  2a
    public static Employee findMinSalaryDepartment(int number) {
        Employee MinSalaryDepartment = employees[0];
        int i = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == number) {
                i++;
                if (employee.getSalary() < MinSalaryDepartment.getSalary()) {
                    MinSalaryDepartment = employee;
                }
            }
        }
        if (i == 0) {
            MinSalaryDepartment = null;
            System.out.println("В отделе нет сотрудников");
        }
        return MinSalaryDepartment;
    }
    //  2b
    public static Employee findMaxSalaryDepartment(int number) {
        Employee MaxSalaryDepartment = employees[0];
        int i = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == number) {
                i++;
                if (employee.getSalary() > MaxSalaryDepartment.getSalary()) {
                    MaxSalaryDepartment = employee;
                }
            }
        }
        if (i == 0) {
            MaxSalaryDepartment = null;
            System.out.println("В отделе нет сотрудников");
        }
        return MaxSalaryDepartment;
    }
    //  2c Сумму затрат на зп по отделу;
    public static int sumSalaryDepartment(int number) {
        int sumSalaryDepartment = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == number) {
                sumSalaryDepartment += employee.getSalary();
            }
        }
        return sumSalaryDepartment;
    }
    //  2d
    //  Среднюю зп по отделу (учесть, что количество людей в отделе отличается от employees.length);
    public static float averageSalaryDepartment(int number) {

        int numberEmployeeDepartment = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getDepartment() == number) numberEmployeeDepartment++;
            }
        }
        float result = 0;
        try {result= (float)( sumSalaryDepartment(number) / numberEmployeeDepartment);
        } catch (Exception e) {
            throw new RuntimeException("Деление на ноль");}
            return result;
        }
    //  2e Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра
    public static void indexSalaryDepartment(int number, float upPercent) {
        float index = (float) ((upPercent + 100) / 100);
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getDepartment() == number) {
                    int indexSalary = (int) (employee.getSalary() * index);
                    employee.setSalary(indexSalary);
                }
            }
        }
    }
    //      2f Напечатать всех сотрудников отдела (все данные, кроме отдела)");
    public static void printEmployeeDepartment(int number) {
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getDepartment() == number) {
                    System.out.println(employee.getId() + " " + employee.getName() + " " + employee.getSalary());
                }
            }
        }
    }
    //        3a    Вывести сотрудников с зп меньше числа"(распечатать id, фио и зп в консоль));
    public static void printSalaryLower(int limitSalary) {
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getSalary() < limitSalary) {
                    System.out.println(employee.getId() + " " + employee.getName() + " " + employee.getSalary());
                }
            }
        }
    }
    public static void printSalaryHigher(int limitSalary) {
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getSalary() >= limitSalary) {
                    System.out.println(employee.getId() + " " + employee.getName() + " " + employee.getSalary());
                }
            }
        }
    }

}



