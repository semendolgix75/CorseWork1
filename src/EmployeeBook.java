public class EmployeeBook {
    private final static int EMPLOYEE_NUMBER = 10;
    private Employee[] employeeBook;
    private int size;

    public EmployeeBook() {
        this.employeeBook = new Employee[EMPLOYEE_NUMBER];
    }

    //    Добавить нового сотрудника. (метод должен найти свободную ячейку в массиве и положить нового сотрудника в нее.
//    Поиск свободных ячеек происходит с начала массива. Если свободных мест для сотрудника нет,
//    то метод должен вернуть false, если для сотрудника нашлось место, то метод должен вернуть true)
    public boolean addNewEmployee(String fullName, int department, int salary) {
        if (size >= employeeBook.length) {
            return false;
        }
        Employee newEmployee = new Employee(fullName, department, salary);
        employeeBook[size++] = newEmployee;
        return true;
    }

    //    Удалить сотрудника (находим сотрудника по id, нуллим его ячейку в массиве);


    public void removeEmployees(int id) {
        for (int i=0;i<employeeBook.length;i++) {
            if (employeeBook[i].getId() == id) {
                System.arraycopy(employeeBook,i+1,employeeBook,i,size-i-1);
                employeeBook[i-1]=null;
                size--;
            }
        }
    }
    //    Добавить метод для получения сотрудника по id
    public Employee findEmployeeID(int id) {
        Employee result = null;
        for (Employee employee : employeeBook) {
            if ((employee != null) && (employee.getId()==id))
            {result=employee;}
        }
        return result;
    }

    public void outputEmployees() {
        for (int i = 0; i < size; i++) {
            if(employeeBook[i]!=null){
                Employee employee = employeeBook[i];
                System.out.println(employeeBook[i].toString());}
        }
    }
    public int sumMoney() {              //Посчитать сумму затрат на ЗП в месяц;
        int sum = 0;
        for (Employee employee : employeeBook) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }
    public Employee findMinSalary() {            //Найти сотрудника с минимальной ЗП;
        Employee employeeMinSalary = employeeBook[0];
        for (Employee employee : employeeBook) {
            if (employee != null && (employee.getSalary() < employeeMinSalary.getSalary())) {
                employeeMinSalary = employee;
            }
        }
        return employeeMinSalary;
    }
    public Employee findMaxSalary() {            //Найти сотрудника с максимальной ЗП;
        Employee employeeMaxSalary = employeeBook[0];
        for (Employee employee : employeeBook) {
            if (employee != null && (employee.getSalary() > employeeMaxSalary.getSalary())) {
                employeeMaxSalary = employee;
            }
        }
        return employeeMaxSalary;
    }
    public float averageSalary() {
        int numberEmployee = 0;
        int sumSalary = 0;
        for (Employee employee : employeeBook) {
            if (employee != null) {
                numberEmployee++;
                sumSalary += employee.getSalary();
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

    public void printAllStatement()       //Распечатать ФИО всех сотрудников (метод void).
    {
        for (Employee employee : employeeBook) {
            if (employee != null) {
                System.out.println(employee.getName());
            }
        }
    }

    //  Повышенная сложность
//      1
    public void indexSalary(float upPercent) {
        float index = ((upPercent + 100) / 100);
        for (Employee employee : employeeBook) {
            if (employee != null) {
                int indexSalary = (int) (employee.getSalary() * index);
                employee.setSalary(indexSalary);

            }
        }
    }

    //      2a
    public Employee findMinSalaryDepartment(int number) {
        Employee minSalaryDepartment = employeeBook[0];
        int i = 0;
        for (Employee employee : employeeBook) {
            if (employee != null && employee.getDepartment() == number) {
                i++;
                if (employee.getSalary() < minSalaryDepartment.getSalary()) {
                    minSalaryDepartment = employee;
                }
            }
        }
        if (i == 0) {
            minSalaryDepartment = null;
            System.out.println("В отделе нет сотрудников");
        }
        return minSalaryDepartment;
    }

    //  2b
    public Employee findMaxSalaryDepartment(int number) {
        Employee maxSalaryDepartment = employeeBook[0];
        int i = 0;
        for (Employee employee : employeeBook) {
            if (employee != null && employee.getDepartment() == number) {
                i++;
                if (employee.getSalary() > maxSalaryDepartment.getSalary()) {
                    maxSalaryDepartment = employee;
                }
            }
        }
        if (i == 0) {
            maxSalaryDepartment = null;
            System.out.println("В отделе нет сотрудников");
        }
        return maxSalaryDepartment;
    }

    //  2c Сумму затрат на зп по отделу;
    public int sumSalaryDepartment(int number) {
        int sumSalaryDepartment = 0;
        for (Employee employee : employeeBook) {
            if (employee != null && employee.getDepartment() == number) {
                sumSalaryDepartment += employee.getSalary();
            }
        }
        return sumSalaryDepartment;
    }

    //  2d
    //  Среднюю зп по отделу (учесть, что количество людей в отделе отличается от employees.length);
    public float averageSalaryDepartment(int number) {
        int numberEmployeeDepartment = 0;
        for (Employee employee : employeeBook) {
            if ((employee != null) && (employee.getDepartment() == number)) {
                numberEmployeeDepartment++;
            }
        }
        float result;
        if (numberEmployeeDepartment != 0) {
            result = (float) (sumSalaryDepartment(number) / numberEmployeeDepartment);
        } else {
            System.out.println("В отделе не числятся работники");
            result = 0;
        }
        return result;
    }

    //  2e Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра
    public void indexSalaryDepartment(int number, float upPercent) {
        float index = ((upPercent + 100) / 100);
        for (Employee employee : employeeBook) {
            if ((employee != null) && (employee.getDepartment() == number)) {
                int indexSalary = (int) (employee.getSalary() * index);
                employee.setSalary(indexSalary);

            }
        }
    }
    //      2f Напечатать всех сотрудников отдела (все данные, кроме отдела)");
    public void printEmployeeDepartment(int number) {
        for (Employee employee : employeeBook) {
            if ((employee != null) && (employee.getDepartment() == number)) {
                System.out.println(employee.getId() + " " + employee.getName() + " " + employee.getSalary());
            }

        }
    }
    //        3a    Вывести сотрудников с зп меньше числа"(распечатать id, фио и зп в консоль));
    public void printSalaryLower(int limitSalary) {
        for (Employee employee : employeeBook) {
            if ((employee != null) && (employee.getSalary() < limitSalary)) {
                System.out.println(employee.getId() + " " + employee.getName() + " " + employee.getSalary());

            }
        }
    }
    public void printSalaryHigher(int limitSalary) {
        for (Employee employee : employeeBook) {
            if ((employee != null) && (employee.getSalary() >= limitSalary)) {
                System.out.println(employee.getId() + " " + employee.getName() + " " + employee.getSalary());

            }
        }
    }
}
