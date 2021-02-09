import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
    //ArrayList<String> alist = new ArrayList<String>();
    Stream<String> employees = listaEmpleados().stream();
    Stream<List<String>> employeesTwo = Stream.of(listaEmpleados());
    public List<String> listaEmpleados() {
        List<String> alist = new ArrayList<>();
        alist.add("Steve");
        alist.add("Tim");
        alist.add("Lucy");
        alist.add("Pat");
        alist.add("Angela");
        alist.add("Tom");
        return alist;
    }

    public void forEach(){
        employees.forEach((employee)->showEmployees(employee));
    }
    public  void peek(){
        employees.filter((employee)->employee.length()>3)
                .peek((employee)->showEmployees(employee));
    }
    public void  map(){
        employees.map((employee)->convertToUpperCase(employee))
                .forEach((employee)->showEmployees(employee));
    }
    public void flatMap(){
//        employees.map((employees)->convertToUpperCase(employees))
//                .collect(Collectors.toList())
//                .stream().flatMap((employe)->employe.);
        employeesTwo
                .flatMap(employe->employe.stream())
                .forEach(System.out::println);
    }
    public void filter(){
        employees.filter((employee)->employee.length()>3)
                .forEach(employees->showEmployees(employees));
    }
    public void skip(){
        employees.skip(3)
        .forEach(emplo->showEmployees(emplo));
    }
    public void limit(){
        employees.limit(3)
                .forEach(emplo->showEmployees(emplo));
    }
    public void generateStream(){
        Stream.generate(Math::random).limit(10)
        .forEach(System.out::println);
    }
    public void iteratorStream(){
        Stream.iterate(1,(i)->i*4)
        .limit(10)
        .forEach(System.out::println);
    }

    //Min y max
    public void intStreamSpecialization(){
//        int valueMin =IntStream.of(2,4,6,8)
//                .min().getAsInt();
//        showValues(valueMin);
        //showValues(IntStream.range(0,15).sum());
//        showValues(IntStream.of(2,2,4,6).distinct().reduce(0,(a,b)->a+b));
        showValues(IntStream.of(2,2,8,6).noneMatch((numero)-> numero % 2 ==0));
//        long resultDistinctCount = IntStream
//                .of(2,2,3,4,4,5,6,6,6,4,6,8)
//                .distinct()
//                .count();
//
//        showValues(Integer.valueOf((int) resultDistinctCount));
    }


    private void showValues(boolean input){
        System.out.println(input);
    }

    private void showEmployees(String employee) {
        System.out.println(employee);
    }
    private String convertToUpperCase(String employee){
        return  employee.toUpperCase();
    }
}
