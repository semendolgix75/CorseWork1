public class EmployeeBook {
    private final static int EMPLOYEE_NUMBER = 10;
    private Employee[] employeeBook;
    private int size;

    public EmployeeBook() {
        this.employeeBook = new Employee[EMPLOYEE_NUMBER];
    }

    public void setEmployeeBook(Employee[] employeeBook) {
        this.employeeBook = employeeBook;
    }

    public Employee[] getEmployeeBook() {
        return employeeBook;
    }

    // Метод заполняет массив сотрудниками первоначально
    public void inputFirstEmployee() {
        Employee inputEmployee = new Employee("Ivanov AA", 1, 70000);
        employeeBook[size++] = inputEmployee;
        inputEmployee = new Employee("Petrov HK", 2, 68000);
        employeeBook[size++] = inputEmployee;
        inputEmployee = new Employee("Sidorov AD", 1, 75000);
        employeeBook[size++] = inputEmployee;
        inputEmployee = new Employee("Alekseev RT", 3, 86000);
        employeeBook[size++] = inputEmployee;
        inputEmployee = new Employee("Smirnov KA", 5, 82000);
        employeeBook[size++] = inputEmployee;
        inputEmployee = new Employee("Putin VV", 4, 75000);
        employeeBook[size++] = inputEmployee;
        inputEmployee = new Employee("Haritonov NM", 3, 69000);
        employeeBook[size++] = inputEmployee;
        inputEmployee = new Employee("Davankov VA", 4, 71000);
        employeeBook[size++] = inputEmployee;
        inputEmployee = new Employee("Slutskiy KE", 5, 76000);
        employeeBook[size++] = inputEmployee;
        inputEmployee = new Employee("Gribov KL", 2, 79000);
        employeeBook[size++] = inputEmployee;
    }


    //    Добавить нового сотрудника. (метод должен найти свободную ячейку в массиве и положить нового сотрудника в нее.
//    Поиск свободных ячеек происходит с начала массива. Если свободных мест для сотрудника нет,
//    то метод должен вернуть false, если для сотрудника нашлось место, то метод должен вернуть true)
    public boolean addNewEmployee(Employee employee) {
        if (size >= employeeBook.length) {
            return false;
        }
        Employee newEmployee = new Employee(employee.getName(), employee.getDepartment(), employee.getSalary());
        employeeBook[size++] = newEmployee;
        return true;
    }

    //    Удалить сотрудника (находим сотрудника по id, нуллим его ячейку в массиве);


    public void removeEmployees(int id) {
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i].getId() == id && employeeBook[i] != null) {
                System.arraycopy(employeeBook, i + 1, employeeBook, i, size - i - 1);
                employeeBook[size - 1] = null;
                size--;
                break;
            }
        }
    }

    //    Добавить метод для получения сотрудника по id
    public Employee findEmployeeID(int id) {
        Employee result = null;
        for (Employee employee : employeeBook) {
            if ((employee != null) && (employee.getId() == id)) {
                result = employee;
            }
        }
        return result;
    }

    public void outputEmployees() {
        for (int i = 0; i < size; i++) {
            Employee employee = employeeBook[i];
            System.out.println(employeeBook[i].toString());
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
        Employee employeeMinSalary = null;
        for (Employee employee : employeeBook) {
            if (employee != null) {
                employeeMinSalary = employee;
                break;
            }
        }
        if (employeeMinSalary != null)
            for (Employee employee : employeeBook) {
                if (employee != null && employee.getSalary() < employeeMinSalary.getSalary()) {
                    employeeMinSalary = employee;
                }
            }
        return employeeMinSalary;
    }

    public Employee findMaxSalary() {            //Найти сотрудника с максимальной ЗП;
        Employee employeeMaxSalary = null;
        for (Employee employee : employeeBook) {
            if (employee != null) {
                employeeMaxSalary = employee;
                break;
            }
        }
        for (Employee employee : employeeBook) {
            if (employee != null && employee.getSalary() > employeeMaxSalary.getSalary()) {
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
        if (numberEmployee != 0) {
            averageSalary = (float) (sumSalary / numberEmployee);
        } else {
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
        float index = (upPercent + 100) / 100;
        for (Employee employee : employeeBook) {
            if (employee != null) {
                int indexSalary = (int) (employee.getSalary() * index);
                employee.setSalary(indexSalary);

            }
        }
    }

    //      2a
    public Employee findMinSalaryDepartment(int number) {
        Employee minSalaryDepartment = null;
        for (Employee employee : employeeBook) {
            if (employee != null) {
                minSalaryDepartment = employee;
                break;
            }
        }

        for (Employee employee : employeeBook) {
            if (employee != null && employee.getDepartment() == number) {
                if (minSalaryDepartment == null) {
                    minSalaryDepartment = employee;
                }
                if (employee.getSalary() < minSalaryDepartment.getSalary()) {
                    minSalaryDepartment = employee;
                }
            }
        }
        return minSalaryDepartment;
    }

    //  2b
    public Employee findMaxSalaryDepartment(int number) {
        Employee maxSalaryDepartment = null;
        for (Employee employee : employeeBook) {
            if (employee != null) {
                maxSalaryDepartment = employee;
                break;
            }
        }
        for (Employee employee : employeeBook) {
            if (employee != null && employee.getDepartment() == number) {
                if (employee.getSalary() > maxSalaryDepartment.getSalary()) {
                    maxSalaryDepartment = employee;
                }
            }
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
            if (employee != null && employee.getDepartment() == number) {
                numberEmployeeDepartment++;
            }
        }
        float result;
        if (numberEmployeeDepartment != 0) {
            result = (float) (sumSalaryDepartment(number) / numberEmployeeDepartment);
        } else {
            result = 0;
        }
        return result;
    }

    //  2e Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра
    public void indexSalaryDepartment(int number, float upPercent) {
        float index = (upPercent + 100) / 100;
        for (Employee employee : employeeBook) {
            if (employee != null && employee.getDepartment() == number) {
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
            if (employee != null && employee.getSalary() < limitSalary) {
                System.out.println(employee.getId() + " " + employee.getName() + " " + employee.getSalary());

            }
        }
    }

    public void printSalaryHigher(int limitSalary) {
        for (Employee employee : employeeBook) {
            if (employee != null && employee.getSalary() >= limitSalary) {
                System.out.println(employee.getId() + " " + employee.getName() + " " + employee.getSalary());

            }
        }
    }
}
