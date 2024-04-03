//Добавить в класс Employee поле id, которое проставляется из счетчика, а затем счетчик увеличивает свое значение.

import java.util.Objects;


//Создать класс Employee, который содержит информацию о ФИО, отделе и зарплате сотрудника.
// Отделы для простоты должны быть названы от 1 до 5.
public class Employee {

    //Скрыть прямой доступ к полям класса Employee и добавить возможность получать значения полей (геттеры) и устанавливать значения полей отдела и зарплаты (сеттеры).
    private String name;  //ФИО
    private int department;    //Отдел
    private int salary;         //Зарплата сотрудника
    private int id;

    private static int counter; //Добавить статическую переменную-счетчик, которая будет отвечать за id.


    //По-умолчанию все поля должны передавать через конструктор (кроме id)
    public Employee(String name, int department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        id = ++counter;


    }
//Реализовать в классе Employee контракты equals и hashCode.

    @Override
    public String toString() {
        return "Работник{ id= " + id + " " +
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

    public int getId() {
        return id;
    }

    public int getSalary() {
        return salary;
    }


    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setNullEmployee(Employee employee) {
        this.department = 0;
        this.salary = 0;
        this.name="null";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && salary == employee.salary && id == employee.id && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, department, salary, id);
    }

}
