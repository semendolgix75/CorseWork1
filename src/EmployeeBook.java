import java.util.Arrays;

public class EmployeeBook {
    private Employee[] employees;
    private int size;

    public EmployeeBook() {
        this.employees = new Employee[10];
    }

    public void addEmployee(String name, int department, int salary) {
        if (size >= employees.length) {
            System.out.println("Нет места в ведомости");

        }
        Employee newContact = new Employee(name, department, salary);
        employees[size++] = newContact;

    }

    @Override
    public String toString() {
        return "Ведомость сотрудников{" +
                "employees=" + Arrays.toString(employees) +
                '}';
    }

    //Создать статические методы, которые будут взаимодействовать с массивом из пункта 6
//    // и возвращать результат:
//
//    //Получить список всех сотрудников со всеми имеющимися по ним данными
//
    public void inputEmployees() {

        for (Employee i : employees) {
            System.out.println(i.toString());
        }
    }

    //Посчитать сумму затрат на ЗП в месяц;
    public int sumMoney() {
        int sumSalary = 0;
        for (Employee i : employees) {
            sumSalary = sumSalary + i.getSalary();
        }
        System.out.println("Общие затраты на ЗП в месяц= " + sumSalary);

        return sumSalary;
    }

    //    //Найти сотрудника с минимальной ЗП;
    public void findMinMaxSalary() {

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

    //    Подсчитать среднее значение зарплат (можно использовать для этого метод из пункта b);
    public float averageSalary() {
        float average = (float) sumMoney() / employees.length;
        System.out.println("Cреднее значение зарплат = " + average);
        return average;
    }

    public void printAllStatement() {
        System.out.println("ФИО ");
        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }
    }

    //        Создать дополнительные статические методы для решения следующих задач.
//
//        Проиндексировать зарплату (вызвать изменение зп у всех сотрудников на величину аргумента в %)
    public void indexSalary(float index) {

        for (Employee employee : employees) {
            int indexSalary = (int) (employee.getSalary() * index);
            employee.setSalary(indexSalary);
            System.out.println(employee.toString());
        }
    }

    //        Получить в качестве параметра номер отдела (1-5) и найти (всего 6 методов):
//        Сотрудника с минимальной зп;
    public void findMinSalaryDepartment(int department) {
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
    public void findMaxSalaryDepartment(int department) {
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
    public void sumMoneySalaryDepartment(int department) {

        int sumSalary = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                sumSalary += employee.getSalary();
            }
        }
        System.out.println("Сумму затрат на зарплату по отделу " + department + " " + sumSalary + "р. ");

    }

    //        Среднюю зп по отделу (учесть, что количество людей в отделе отличается от employees.length);
    public void averageSalaryDepartment(int department) {

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
    public void indexSalaryDepartment(float index, int department) {

        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                int indexSalary = (int) (employee.getSalary() * index);
                employee.setSalary(indexSalary);
                System.out.println(employee.getName() + "  " + employee.getSalary() + "р.");
            }
        }
    }

    //        Напечатать всех сотрудников отдела (все данные, кроме отдела).
    public void printDepartment(int department) {
        System.out.println("Сотрудники отдела: " + department);
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                System.out.println(employee.getName() + " зарплата " + employee.getSalary() + "р.");

            }
        }
    }


    //        Получить в качестве параметра число и вывести:
//        Всех сотрудников с зп меньше числа (распечатать id, фио и зп в консоль);
    public void printSalaryLower(int minSalary) {
        System.out.println("Сотрудники с зарплатой меньше: " + minSalary);
        for (Employee employee : employees) {
            if (employee.getSalary() < minSalary) {
                System.out.println("Сотрудник: " + employee.getName() + " отдел - " + employee.getDepartment() + " зарплата " + employee.getSalary());

            }
        }
    }

    //        Всех сотрудников с зп больше (или равно) числа (распечатать id, фио и зп в консоль).
    public void printSalaryHigher(int maxSalary) {
        System.out.println("Сотрудники с зарплатой меньше: " + maxSalary);
        for (Employee employee : employees) {
            if (employee.getSalary() >= maxSalary) {
                System.out.println("Сотрудник: " + employee.getName() + " отдел - " + employee.getDepartment() + " зарплата " + employee.getSalary());

            }
        }
    }
}


