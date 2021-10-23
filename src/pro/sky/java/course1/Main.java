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
        int idDepartment = 2;
        System.out.println("Сотрудник из отдела " + idDepartment + " с минимальной зарплатой это " + employees[minDepartmentSalary(idDepartment)].getName());
        System.out.println("Сотрудник из отдела " + idDepartment + " с максимальной зарплатой это " + employees[maxDepartmentSalary(idDepartment)].getName());
        System.out.println("Общая зарплата по отделу " + idDepartment + " составляет " + totalDepartmentSalary(idDepartment) + " руб.");
        System.out.println("Средняя зарплата по отделу " + idDepartment + " составляет " + middleDepartmentSalary(idDepartment) + " руб.");
        int indexDepartment = 15;
        indexDepartmentSalary(idDepartment, indexDepartment);
        listOfDepartmentEmployees(idDepartment);
        int lessNumber = 250000;
        lessNumber(lessNumber);
        int moreOrEqualNumber = 300000;
        moreOrEqualNumber(moreOrEqualNumber);


    }

    private static void moreOrEqualNumber(int moreOrEqualNumber) {
        for (Employee employee : employees) {
            if (employee.getSalary() >= moreOrEqualNumber) {
                System.out.println("id " + employee.getId() + ". ФИО: " + employee.getName() + ". Зарплата - " + employee.getSalary() + " руб.");
            }
        }
    }

    private static void lessNumber(int lessNumber) {
        for (Employee employee : employees) {
            if (employee.getSalary() < lessNumber) {
                //вывести id, фио и зп в консоль
                System.out.println("id " + employee.getId() + ". ФИО: " + employee.getName() + ". Зарплата - " + employee.getSalary() + " руб.");
            }
        }
    }

    private static void listOfDepartmentEmployees(int idDepartment) {
        for (Employee employee : employees) {
            if (employee.getDepartment() == idDepartment) {
                System.out.println("Сотрудник отдела " + employee.getName() + ". Зарплата сотруднка " + employee.getSalary());
            }
        }
    }

    private static void indexDepartmentSalary(int idDepartment, int indexDepartment) {
        for (Employee employee : employees) {
            if (employee.getDepartment() == idDepartment) {
                employee.setSalary(employee.getSalary() + employee.getSalary() * indexDepartment / 100);
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
        int maxSalaryId = 0;
        for (int i = 0; i < employees.length; i++) {
            if (salary < employees[i].getSalary() && employees[i].getDepartment() == idDepartment) {
                salary = (int) employees[i].getSalary();
                maxSalaryId = i;
            }
        }
        return maxSalaryId;
    }

    private static int minDepartmentSalary(int idDepartment) {
        int salary = 60000000;
        int minSalaryId = 0;
        for (int i = 0; i < employees.length; i++) {
            if (salary > employees[i].getSalary() && employees[i].getDepartment() == idDepartment) {
                salary = (int) employees[i].getSalary();
                minSalaryId = i;
            }
        }
        return minSalaryId;
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
        int salary = 0;
        int maxSalaryId = 0;
        for (int i = 0; i < employees.length; i++) {
            if (salary < employees[i].getSalary()) {
                salary = (int) employees[i].getSalary();
                maxSalaryId = i;
            }
        }
        return maxSalaryId;
    }

    private static int minSalary() {
        int salary = 60000000;
        int minSalaryId = 0;
        for (int i = 0; i < employees.length; i++) {
            if (salary > employees[i].getSalary()) {
                salary = (int) employees[i].getSalary();
                minSalaryId = i;
            }
        }
        return minSalaryId;
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
