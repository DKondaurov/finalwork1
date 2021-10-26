package pro.sky.java.course1;

public class Main {

    public static final Employee[] employees = new Employee[10];

    public static void main(String[] args) {

        employees[0] = new Employee("Новиков Донат Аристархович", 259645, 5);
        employees[1] = new Employee("Давыдов Виссарион Федосеевич", 437676, 1);
        employees[2] = new Employee("Горбачёв Юрий Дмитриевич", 23372, 2);
        employees[3] = new Employee("Попов Ермолай Пантелеймонович", 208953, 3);
        employees[4] = new Employee("Зиновьев Станислав Святославович", 380712, 5);
        employees[5] = new Employee("Сысоев Наум Альвианович", 410747, 4);
        employees[6] = new Employee("Носков Клим Артёмович", 485483, 2);
        employees[7] = new Employee("Белоусов Митрофан Валентинович", 415403, 2);
        employees[8] = new Employee("Федотов Аверьян Александрович", 86071, 2);
        employees[9] = new Employee("Селезнёв Василий Эльдарович", 354469, 1);

        listOfAllEmployees();
        System.out.println("Общая зарплата = " + totalSalary() + " руб.");
        System.out.println("Сотрудник с минимальной зарплатой " + employees[minSalary()].getName() + ".");
        System.out.println("Сотрудник с максимальной зарплатой " + employees[maxSalary()].getName() + ".");
        System.out.println("Средняя зарплата = " + totalSalary() / employees.length + " руб.");
        employeesName();
        int index = 15;
        indexSalary(index);
        int departmentId = 2;
        System.out.println("Сотрудник из отдела " + departmentId + " с минимальной зарплатой это " + employees[minDepartmentSalary(departmentId)].getName());
        System.out.println("Сотрудник из отдела " + departmentId + " с максимальной зарплатой это " + employees[maxDepartmentSalary(departmentId)].getName());
        System.out.println("Общая зарплата по отделу " + departmentId + " составляет " + totalDepartmentSalary(departmentId) + " руб.");
        System.out.println("Средняя зарплата по отделу " + departmentId + " составляет " + middleDepartmentSalary(departmentId) + " руб.");
        int percent = 15;
        increaseSalaryOfDepartment(departmentId, percent);
        printEmployeesOfDepartment(departmentId);
        int lessNumber = 250000;
        lessNumber(lessNumber);
        int moreOrEqualNumber = 300000;
        printAllWithSalaryMoreThan(moreOrEqualNumber);


    }

    private static void printAllWithSalaryMoreThan(int moreOrEqualNumber) {
        for (Employee employee : employees) {
            if (employee.getSalary() >= moreOrEqualNumber) {
/* По заданию нужно вывести id, фио и зп в консоль
System.out.println(employee) Будет выводить ФИО, зарплату и отдел, если id ещё можно добавить, то что бы убрать отдел придётся менять toString, что делает некорректной остальную часть кода
*/
                System.out.println("id " + employee.getId() + ". ФИО: " + employee.getName() + ". Зарплата - " + employee.getSalary() + " руб.");
            }
        }
    }

    private static void lessNumber(int lessNumber) {
        for (Employee employee : employees) {
            if (employee.getSalary() < lessNumber) {
/* По заданию нужно вывести id, фио и зп в консоль
System.out.println(employee) Будет выводить ФИО, зарплату и отдел, если id ещё можно добавить, то что бы убрать отдел придётся менять toString, что делает некорректной остальную часть кода
*/
                System.out.println("id " + employee.getId() + ". ФИО: " + employee.getName() + ". Зарплата - " + employee.getSalary() + " руб.");
            }
        }
    }

    private static void printEmployeesOfDepartment(int departmentId) {
        for (Employee employee : employees) {
            if (employee.getDepartment() == departmentId) {
                System.out.println("Сотрудник отдела " + employee.getName() + ". Зарплата сотруднка " + employee.getSalary());
            }
        }
    }

    private static void increaseSalaryOfDepartment(int idDepartment, int percent) {
        for (Employee employee : employees) {
            if (employee.getDepartment() == idDepartment) {
                employee.setSalary(employee.getSalary() + employee.getSalary() * percent / 100);
            }
        }
    }

    private static double middleDepartmentSalary(int idDepartment) {
        double middleDepartmentSalary = 0;
        int personInTheDepartment = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == idDepartment) {
                middleDepartmentSalary += employee.getSalary();
                personInTheDepartment++;
            }
        }
        middleDepartmentSalary = middleDepartmentSalary / personInTheDepartment;
        return middleDepartmentSalary;
    }

    private static double totalDepartmentSalary(int idDepartment) {
        double totalDepartmentSalary = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == idDepartment) {
                totalDepartmentSalary += employee.getSalary();
            }
        }
        return totalDepartmentSalary;
    }

    private static int maxDepartmentSalary(int idDepartment) {
        int salary = 0;
        int maxDepartmentSalaryEmployee = 0;
        for (int i = 0; i < employees.length; i++) {
            if (salary < employees[i].getSalary() && employees[i].getDepartment() == idDepartment) {
                salary = (int) employees[i].getSalary();
                maxDepartmentSalaryEmployee = i;
            }
        }
        return maxDepartmentSalaryEmployee;
    }

    private static int minDepartmentSalary(int idDepartment) {
        double salary = 600000;
        int minDepartmentSalaryEmployee = 0;
        for (int i = 0; i < employees.length; i++) {
            if (salary > employees[i].getSalary() && employees[i].getDepartment() == idDepartment) {
                salary = employees[i].getSalary();
                minDepartmentSalaryEmployee = i;
            }
        }
        return minDepartmentSalaryEmployee;
    }

    private static void indexSalary(int index) {
        for (Employee employee : employees) {
            employee.setSalary(employee.getSalary() + employee.getSalary() * index / 100);
        }
    }

    private static void employeesName() {
        for (Employee employee : employees) {
            System.out.println("ФИО: " + employee.getName());
        }
    }

    private static int maxSalary() {
        double salary = 0;
        int maxSalaryEmployee = 0;
        for (int i = 0; i < employees.length; i++) {
            if (salary < employees[i].getSalary()) {
                salary = employees[i].getSalary();
                maxSalaryEmployee = i;
            }
        }
        return maxSalaryEmployee;
    }

    private static int minSalary() {
        double salary = 60000000;
        int minSalaryEmployee = 0;
        for (int i = 0; i < employees.length; i++) {
            if (salary > employees[i].getSalary()) {
                salary = employees[i].getSalary();
                minSalaryEmployee = i;
            }
        }
        return minSalaryEmployee;
    }


    private static double totalSalary() {
        double totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += employee.getSalary();
        }
        return totalSalary;
    }

    private static void listOfAllEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
