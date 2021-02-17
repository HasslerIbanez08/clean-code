package co.com.personalsoft.springbootdocker.dao;

import co.com.personalsoft.springbootdocker.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDAO extends JpaRepository<Person,Integer> {
}
