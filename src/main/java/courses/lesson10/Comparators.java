package courses.lesson10;

import java.util.Arrays;
import java.util.Comparator;

public class Comparators {
    private static final FioComparator fioComparator = new FioComparator();
    private static final AddressComparator addressComparator = new AddressComparator();
    private static final BiComparator adrThenFioComparator = new BiComparator(addressComparator, fioComparator);
    private static final BiComparator fioThenAdrComparator = new BiComparator(fioComparator, addressComparator);

    public static void main(String[] args) {
        Employee[] employees = generateEmployees();

        printArray(employees);


        System.out.println();
        System.out.println("======== Sorted guys =============");
        System.out.println("  by fio: ");

        Arrays.sort(employees, fioComparator);

        printArray(employees);

        System.out.println();
        System.out.println("  by address: ");

        Arrays.sort(employees, addressComparator);

        printArray(employees);

        System.out.println();
        System.out.println("  by address, fio: ");

        Arrays.sort(employees, adrThenFioComparator);

        printArray(employees);

        System.out.println();
        System.out.println("  by fio, address: ");

        Arrays.sort(employees, fioThenAdrComparator);

        printArray(employees);


        System.out.println();
        System.out.println("  by year: ");

        Arrays.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getYear() - o2.getYear();
            }
        });

        printArray(employees);


    }

    private static Employee[] generateEmployees() {
        return new Employee[]{
                new Employee("Иванов", "Иван", "Иванович", "Ивановская наб., 25", 1965),
                new Employee("Иванов", "Петр", "Иванович", "Ивановская наб., 25", 1984),
                new Employee("Иванов", "Иван", "Сидорович", "Ивановская наб., 23", 1976),
                new Employee("Сидоров", "Петр", "Иванович", "Ивановская наб., 26", 1968),
                new Employee("Игнашевич", "Василий", "Иванович", "Пироговская наб., 25", 1970),
                new Employee("Феоктистов", "Феофан", "Бармолеевич", "Серебристый бульвар, 1", 1950),
        };
    }

    private static void printArray(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

}

class Employee {
    private String fa;
    private String im;
    private String ot;

    private String address;

    private int year;

    public Employee(String fa, String im, String ot, String address, int year) {
        this.fa = fa;
        this.im = im;
        this.ot = ot;
        this.address = address;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fa='" + fa + '\'' +
                ", im='" + im + '\'' +
                ", ot='" + ot + '\'' +
                ", address='" + address + '\'' +
                ", year=" + year +
                '}';
    }

    public String getFa() {
        return fa;
    }

    public void setFa(String fa) {
        this.fa = fa;
    }

    public String getIm() {
        return im;
    }

    public void setIm(String im) {
        this.im = im;
    }

    public String getOt() {
        return ot;
    }

    public void setOt(String ot) {
        this.ot = ot;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

class FioComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        int res = o1.getFa().compareTo(o2.getFa());
        if (res == 0) {
            res = o1.getIm().compareTo(o2.getIm());
            if (res == 0) {
                return o1.getOt().compareTo(o2.getOt());
            }
        }
        return res;
    }
}

class FioComparatorRev extends FioComparator {
    @Override
    public int compare(Employee o1, Employee o2) {
        return -super.compare(o1, o2);
    }
}


class AddressComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return -o1.getAddress().compareTo(o2.getAddress());
    }
}

class BiComparator implements Comparator<Employee> {
    private final Comparator<Employee> cmp1;
    private final Comparator<Employee> cmp2;

    public BiComparator(Comparator<Employee> cmp1, Comparator<Employee> cmp2) {
        this.cmp1 = cmp1;
        this.cmp2 = cmp2;
    }

    @Override
    public int compare(Employee o1, Employee o2) {
        int res = cmp1.compare(o1, o2);
        if (res == 0) {
            return cmp2.compare(o1, o2);
        }
        return res;
    }
}