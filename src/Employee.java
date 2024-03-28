//Добавить в класс Employee поле id, которое проставляется из счетчика, а затем счетчик увеличивает свое значение.

import java.util.Objects;


//Создать класс Employee, который содержит информацию о ФИО, отделе и зарплате сотрудника.
// Отделы для простоты должны быть названы от 1 до 5.
public class Employee {

    //Скрыть прямой доступ к полям класса Employee и добавить возможность получать значения полей (геттеры) и устанавливать значения полей отдела и зарплаты (сеттеры).
    private String name;  //ФИО
    private int department;    //Отдел
    private int salary;         //Зарплата сотрудника

    private static int id=0;      //Добавить статическую переменную-счетчик, которая будет отвечать за id.



    //По-умолчанию все поля должны передавать через конструктор (кроме id)
    public Employee(String name, int department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        id++;

    }
//Реализовать в классе Employee контракты equals и hashCode.

    @Override
    public String toString() {
        return "Работник{" +
                "ФИО='" + name + '\'' +
                ", отдел=" + department +
                ", зарплата =" + salary +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;

    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return department == employee.department && salary == employee.salary && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, department, salary);
    }
}
