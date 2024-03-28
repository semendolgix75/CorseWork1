//Создать внутри класса Main метод main и поле типа Employee[10], которое будет выполнять роль "хранилища" для записей о сотрудниках.

import java.util.Arrays;

//Распечатать ФИО всех сотрудников (метод ничего).
public class Main {
//    private static Employee[] employees;

    //Создать внутри класса Main метод main и поле типа Employee[10],
    // которое будет выполнять роль "хранилища" для записей о сотрудниках.
    public static void main(String[] args) {

        EmployeeBook employees = new EmployeeBook();
        employees.addEmployee("Ivanov AA", 1, 70000);
        employees.addEmployee("Petrov HK", 2, 68000);
        employees.addEmployee("Sidorov AD", 1, 75000);
        employees.addEmployee("Alekseev RT", 3, 86000);
        employees.addEmployee("Smirnov KA", 5, 82000);
        employees.addEmployee("Putin VV", 4, 75000);
        employees.addEmployee("Haritonov NM", 3, 69000);
        employees.addEmployee("Davankov VA", 4, 71000);
        employees.addEmployee("Slutskiy KE", 5, 76000);
        employees.addEmployee("Gribov KL", 2, 79000);


        System.out.println("Базовая сложность");
        System.out.println("\nВывести в консоль значения всех полей (toString))");
        employees.inputEmployees();                   // (вывести в консоль значения всех полей (toString));
        System.out.println("\nПосчитать сумму затрат на ЗП в месяц;");
        employees.sumMoney();                         //Посчитать сумму затрат на ЗП в месяц;
        System.out.println("\nНайти сотрудника с минимальной и максимальной ЗП");

        employees.findMinMaxSalary();                 //Найти сотрудника с минимальной и максимальной ЗП;
        System.out.println("\nПодсчитать среднее значение зарплат (можно использовать для этого метод из пункта b");
        employees.averageSalary();                    //Подсчитать среднее значение зарплат (можно использовать для этого метод из пункта b);

        System.out.println("\nРаспечатать ФИО всех сотрудников (метод void)");
        employees.printAllStatement();                //Распечатать ФИО всех сотрудников (метод void).

        System.out.println("\nПовышенная сложность");

        System.out.println("\nПроиндексировать зарплату (вызвать изменение зп у всех сотрудников на величину аргумента в %");
        employees.indexSalary(1.2f);                  //Проиндексировать зарплату (вызвать изменение зп у всех сотрудников на величину аргумента в %)
        System.out.println("\nСотрудник с минимальной зп в отделе");
        employees.findMinSalaryDepartment(2);         //Сотрудника с минимальной зп;
        System.out.println("\nСотрудник с минимальной зп в отделе");
        employees.findMaxSalaryDepartment(3);         //Сотрудника с максимальной зп;
        System.out.println("\nСумма затрат на зп по отделу");

        employees.sumMoneySalaryDepartment(1);        // Сумму затрат на зп по отделу;
        System.out.println("\nСредняя зп по отделу");
        employees.averageSalaryDepartment(4);         //Среднюю зп по отделу (учесть, что количество людей в отделе отличается от employees.length);
        System.out.println("\nПроиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра");
        employees.indexSalaryDepartment(1.3f, 1);// Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра;
        employees.printAllStatement();
        System.out.println("\nНапечатать всех сотрудников отдела (все данные, кроме отдела)");
        employees.printDepartment(1);                 // Напечатать всех сотрудников отдела (все данные, кроме отдела).
        System.out.println("\nВывести сотрудников с зп меньше числа");
        employees.printSalaryLower(90000);   //Всех сотрудников с зп меньше числа (распечатать id, фио и зп в консоль);
        System.out.println("\nВывести сотрудников с зп больше (или равно) числа");
        employees.printSalaryHigher(90000);   //Всех сотрудников с зп больше (или равно) числа (распечатать id, фио и зп в консоль).
    }
}



