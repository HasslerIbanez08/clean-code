import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainTravels {
    public static void main(String[] args) {
        Person personOne =new Person("Andres");
        Travels travelOne = new Travels("France");
        Travels travelTwo = new Travels("Dublin");
        personOne.addTravel(travelOne);
        personOne.addTravel(travelTwo);

        Person personTwo = new Person("Eduardo");
        Travels travelTree = new Travels("England");
        Travels travelFour = new Travels("Andorra");
        Travels travelFive = new Travels("Prague");
        personTwo.addTravel(travelTree);
        personTwo.addTravel(travelFour);
        personTwo.addTravel(travelFive);

        List<Person> people = new ArrayList<Person>();
        people.add(personOne);
        people.add(personTwo);

        String contries="";
/*for (Person person : people) {
for (Travels travel : person.getTravelsList()){
System.out.println(travel.getPais());
}

}*/

        people.stream().map(Person::getTravelsList)
                .flatMap(Collection::stream)
                .forEach(travels -> System.out.println(travels.getPais()));
    }
}