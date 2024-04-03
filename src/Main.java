//Создать внутри класса Main метод main и поле типа Employee[10], которое будет выполнять роль "хранилища" для записей о сотрудниках.

//Распечатать ФИО всех сотрудников (метод ничего).
public class Main {

    //Создать внутри класса Main метод main и поле типа Employee[10],
    // которое будет выполнять роль "хранилища" для записей о сотрудниках.
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();

        employeeBook.addNewEmployee("Ivanov AA", 1, 70000);
        employeeBook.addNewEmployee("Petrov HK", 2, 68000);
        employeeBook.addNewEmployee("Sidorov AD", 1, 75000);
        employeeBook.addNewEmployee("Alekseev RT", 3, 86000);
        employeeBook.addNewEmployee("Smirnov KA", 5, 82000);
        employeeBook.addNewEmployee("Putin VV", 4, 75000);
        employeeBook.addNewEmployee("Haritonov NM", 3, 69000);
        employeeBook.addNewEmployee("Davankov VA", 4, 71000);
        employeeBook.addNewEmployee("Slutskiy KE", 5, 76000);
        employeeBook.addNewEmployee("Gribov KL", 2, 79000);

        System.out.println("Базовая сложность");
        System.out.println("\nВывести в консоль значения всех полей (toString))");
        employeeBook.outputEmployees();
        System.out.println("\nПосчитать сумму затрат на ЗП в месяц;");
        System.out.println("Cумма затрат на ЗП в месяц " + employeeBook.sumMoney());
        System.out.println("Сотрудник с минимальной зарплатой " + employeeBook.findMinSalary().getName());
        System.out.println("Сотрудник с максимальной зарплатой " + employeeBook.findMaxSalary().getName());
        System.out.println("Усредненное значение зарплаты " + employeeBook.averageSalary());
        System.out.println("\nРаспечатать ФИО всех сотрудников (метод void)");
        employeeBook.printAllStatement();

        System.out.println("\nПовышенная сложность");

        System.out.println("Проиндексировать зарплату (вызвать изменение зп у всех сотрудников на величину аргумента в %");
        employeeBook.indexSalary(20f);                  //Проиндексировать зарплату (вызвать изменение зп у всех сотрудников на величину аргумента в %)
//        employeesBook.sumMoney(employeesBook);
        final int NUMBER_DEPARTMENT = 1;
        final int PERCENT_SALARY = 10;
        final int LIMIT_SALARY = 93000;

        System.out.println("Сотрудник с минимальной зп в отделе №" + NUMBER_DEPARTMENT + " =" + employeeBook.findMinSalaryDepartment(NUMBER_DEPARTMENT).getDepartment() + " " + employeeBook.findMinSalaryDepartment(NUMBER_DEPARTMENT).getName());
        System.out.println("Сотрудник с максимальной зп в отделе №" + NUMBER_DEPARTMENT + " =" + employeeBook.findMaxSalaryDepartment(NUMBER_DEPARTMENT).getDepartment() + " " + employeeBook.findMaxSalaryDepartment(NUMBER_DEPARTMENT).getName());
        System.out.println("Сумма затрат на зп по отделу N" + NUMBER_DEPARTMENT + " =" + employeeBook.sumSalaryDepartment(NUMBER_DEPARTMENT));
        System.out.println("Средняя зп по отделу N" + NUMBER_DEPARTMENT + " =" + employeeBook.averageSalaryDepartment(NUMBER_DEPARTMENT));
        employeeBook.printEmployeeDepartment(NUMBER_DEPARTMENT);
        System.out.println("Проиндексировать зарплату всех сотрудников отдела на " + PERCENT_SALARY + "процентов, который приходит в качестве параметра отдел №" + NUMBER_DEPARTMENT);
        employeeBook.indexSalaryDepartment(NUMBER_DEPARTMENT, PERCENT_SALARY);
        employeeBook.printEmployeeDepartment(NUMBER_DEPARTMENT);
        System.out.println("Получить в качестве параметра число и вывести:" +
                "Всех сотрудников с зп меньше числа " + LIMIT_SALARY + " (распечатать id, фио и зп в консоль);");
        employeeBook.printSalaryLower(LIMIT_SALARY);
        System.out.println("Получить в качестве параметра число и вывести:" +
                "Всех сотрудников с зп больше числа " + LIMIT_SALARY + " (распечатать id, фио и зп в консоль);");
        employeeBook.printSalaryHigher(LIMIT_SALARY);

        System.out.println("\nОчень сложно");
        System.out.println("Удалить сотрудника id=7");
        employeeBook.removeEmployees(7);
        employeeBook.outputEmployees();
        System.out.println("Добавить метод для получения сотрудника по id");
        System.out.println(employeeBook.findEmployeeID(4));
    }

}











