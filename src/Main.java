//Создать внутри класса Main метод main и поле типа Employee[10], которое будет выполнять роль "хранилища" для записей о сотрудниках.

//Распечатать ФИО всех сотрудников (метод ничего).
public class Main {
    private static Employee[] employees;

    //Создать внутри класса Main метод main и поле типа Employee[10],
    // которое будет выполнять роль "хранилища" для записей о сотрудниках.
    public static void main(String[] args) {
        employees = new Employee[10];
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
        System.out.println("\nвывести в консоль значения всех полей (toString))");
        inputEmployees();                   // (вывести в консоль значения всех полей (toString));
        System.out.println("\nПосчитать сумму затрат на ЗП в месяц;");
        sumMoney();                         //Посчитать сумму затрат на ЗП в месяц;
        System.out.println("\nНайти сотрудника с минимальной и максимальной ЗП");

        findMinMaxSalary();                 //Найти сотрудника с минимальной и максимальной ЗП;
        System.out.println("\nПодсчитать среднее значение зарплат (можно использовать для этого метод из пункта b");
        averageSalary();                    //Подсчитать среднее значение зарплат (можно использовать для этого метод из пункта b);

        System.out.println("\nРаспечатать ФИО всех сотрудников (метод void)");
        printAllStatement();                //Распечатать ФИО всех сотрудников (метод void).

        System.out.println("\nПовышенная сложность");

        System.out.println("\nПроиндексировать зарплату (вызвать изменение зп у всех сотрудников на величину аргумента в %");
        indexSalary(1.2f);                  //Проиндексировать зарплату (вызвать изменение зп у всех сотрудников на величину аргумента в %)
        System.out.println("\nСотрудника с минимальной зп");

        findMinSalaryDepartment(2);         //Сотрудника с минимальной зп;
        findMaxSalaryDepartment(3);         //Сотрудника с максимальной зп;
        sumMoneySalaryDepartment(1);        // Сумму затрат на зп по отделу;
        averageSalaryDepartment(4);         //Среднюю зп по отделу (учесть, что количество людей в отделе отличается от employees.length);
        indexSalaryDepartment(1.3f, 1);// Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра;
        printAllStatement();
        printDepartment(1);                 // Всех сотрудников с зп больше (или равно) числа (распечатать id, фио и зп в консоль).
        printSalaryLower(90000);   //Всех сотрудников с зп меньше числа (распечатать id, фио и зп в консоль);
        printSalaryHigher(90000);   //Всех сотрудников с зп больше (или равно) числа (распечатать id, фио и зп в консоль).
    }
    //Создать статические методы, которые будут взаимодействовать с массивом из пункта 6
    // и возвращать результат:

    //Получить список всех сотрудников со всеми имеющимися по ним данными

    public static void inputEmployees() {

        for (Employee i : employees) {
            System.out.println(i.toString());
        }
    }

        //Посчитать сумму затрат на ЗП в месяц;
    public static int sumMoney() {
        int sumSalary = 0;
        for (Employee i : employees) {
            sumSalary = sumSalary + i.getSalary();
        }
        System.out.println("Общие затраты на ЗП в месяц= " + sumSalary);

        return sumSalary;
    }

    //Найти сотрудника с минимальной ЗП;
    public static void findMinMaxSalary() {

        String nameMinSalary = employees[0].getName();
//Найти сотрудника с максимальной ЗП;
        String nameMaxSalary = employees[0].getName();
        int minSalary = employees[0].getSalary();
        int maxSalary = employees[0].getSalary();
        for (Employee employee : employees) {
            if (minSalary > employee.getSalary()) {
                minSalary = employee.getSalary();
                nameMinSalary = employee.getName();
            }

            if (maxSalary < employee.getSalary()) {
                maxSalary = employee.getSalary();
                nameMaxSalary = employee.getName();
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой= " + minSalary + "р. - " + nameMinSalary);
        System.out.println("Сотрудник с мaксимальной зарплатой= " + maxSalary + "р. - " + nameMaxSalary);
    }

    //Подсчитать среднее значение зарплат (можно использовать для этого метод из пункта b);
    public static float averageSalary() {
        float average = (float) sumMoney() / employees.length;
        System.out.println("Cреднее значение зарплат = " + average);
        return average;
    }

    public static void printAllStatement() {
        System.out.println("ФИО             Отдел            Зарплата");
        for (Employee employee : employees) {
            System.out.println(employee.getName() + "         " + employee.getDepartment() + "           " + employee.getSalary());
        }
    }

    //        Создать дополнительные статические методы для решения следующих задач.
//
//        Проиндексировать зарплату (вызвать изменение зп у всех сотрудников на величину аргумента в %)
    public static void indexSalary(float index) {

        for (Employee employee : employees) {
            int indexSalary = (int) (employee.getSalary() * index);
            employee.setSalary(indexSalary);
        }
    }

    //        Получить в качестве параметра номер отдела (1-5) и найти (всего 6 методов):
//        Сотрудника с минимальной зп;
    public static void findMinSalaryDepartment(int department) {
        String nameMinSalary = employees[0].getName();
        int minSalary = employees[0].getSalary();
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                if (minSalary > employee.getSalary()) {
                    minSalary = employee.getSalary();
                    nameMinSalary = employee.getName();
                }
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой в отделе " + department + " " + minSalary + "р. - " + nameMinSalary);

    }

    //        Сотрудника с максимальной зп;
    public static void findMaxSalaryDepartment(int department) {
        String nameMaxSalary = employees[0].getName();
        int maxSalary = employees[0].getSalary();
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                if (maxSalary < employee.getSalary()) {
                    maxSalary = employee.getSalary();
                    nameMaxSalary = employee.getName();
                }
            }
        }
        System.out.println("Сотрудник с максимальной зарплатой в отделе " + department + " " + maxSalary + "р. - " + nameMaxSalary);

    }

    //        Сумму затрат на зп по отделу;
    public static void sumMoneySalaryDepartment(int department) {

        int sumSalary = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                sumSalary += employee.getSalary();
            }
        }
        System.out.println("Сумму затрат на зарплату по отделу " + department + " " + sumSalary + "р. ");

    }

    //        Среднюю зп по отделу (учесть, что количество людей в отделе отличается от employees.length);
    public static void averageSalaryDepartment(int department) {

        int sumSalary = 0;
        float averageSalary = 0;
        int i = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                sumSalary += employee.getSalary();
                i++;
            }
        }
        averageSalary = (float) sumSalary / i;
        System.out.println("Средняя зарплата по отделу " + department + " " + averageSalary + "р. ");

    }

    //        Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра;
    public static void indexSalaryDepartment(float index, int department) {

        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                int indexSalary = (int) (employee.getSalary() * index);
                employee.setSalary(indexSalary);
            }
        }
    }

    //        Напечатать всех сотрудников отдела (все данные, кроме отдела).
    public static void printDepartment(int department) {
        System.out.println("Сотрудники отдела: "+department);
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                System.out.println(employee.getName() );

            }
        }
    }


//        Получить в качестве параметра число и вывести:
//        Всех сотрудников с зп меньше числа (распечатать id, фио и зп в консоль);
public static void printSalaryLower(int minSalary) {
    System.out.println("Сотрудники с зарплатой меньше: "+minSalary);
    for (Employee employee : employees) {
        if (employee.getSalary() < minSalary) {
            System.out.println("Сотрудник: "+employee.getName()+" отдел - "+employee.getDepartment()+" зарплата "+employee.getSalary() );

        }
    }
}

//        Всех сотрудников с зп больше (или равно) числа (распечатать id, фио и зп в консоль).
public static void printSalaryHigher(int maxSalary) {
    System.out.println("Сотрудники с зарплатой меньше: "+maxSalary);
    for (Employee employee : employees) {
        if (employee.getSalary() >= maxSalary) {
            System.out.println("Сотрудник: "+employee.getName()+" отдел - "+employee.getDepartment()+" зарплата "+employee.getSalary() );

        }
    }
}

}

