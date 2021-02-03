import java.util.ArrayList;
import java.util.List;

public class MainStreamParallels {
    public static void main(String[] args) {
        long timeBefore;
        long tiimeAfter;
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            employees.add(new Employee("Employee-" + i, 100d));
            employees.add(new Employee("Employee-" + i, 120d));
            employees.add(new Employee("Employee-" + i, 130d));
            employees.add(new Employee("Employee-" + i, 740d));
            employees.add(new Employee("Employee-" + i, 500d));
            employees.add(new Employee("Employee-" + i, 160d));
            employees.add(new Employee("Employee-" + i, 1770d));
            employees.add(new Employee("Employee-" + i, 170d));
        }
        timeBefore = System.currentTimeMillis();
        System.out.println("Secuential stream count: " +
                employees.stream()
                        .filter(employee -> employee.getSalary() > 200)
                        .count());
        tiimeAfter = System.currentTimeMillis();
        System.out.println("Secuential time taken: "+ (tiimeAfter-timeBefore));
        timeBefore = System.currentTimeMillis();
        System.out.println("Parralel stream count: " +

                employees.stream().filter(employee -> employee.getSalary()>200).parallel().count());
                //employees.parallelStream().filter(employee -> employee.getSalary()>200).count());
        tiimeAfter = System.currentTimeMillis();
        System.out.println("Parralel time taken: "+ (tiimeAfter-timeBefore));
    }
}
