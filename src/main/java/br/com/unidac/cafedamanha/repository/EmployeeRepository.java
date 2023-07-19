package br.com.unidac.cafedamanha.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.unidac.cafedamanha.entitie.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	@Modifying
    @Query(value = "INSERT INTO employee (name, cpf, breakfast_options, breakfast_date) VALUES (:name, :cpf, :breakfastOptions, :breakfastDate)", nativeQuery = true)
    void insertEmployee(@Param("name") String name, @Param("cpf") String cpf, @Param("breakfastOptions") List<String> breakfastOptions, @Param("breakfastDate") LocalDate breakfastDate);

    @Modifying
    @Query(value = "UPDATE employee SET name = :name, cpf = :cpf, breakfast_options = :breakfastOptions, breakfast_date = :breakfastDate WHERE id = :id", nativeQuery = true)
    void updateEmployee(@Param("id") Long id, @Param("name") String name, @Param("cpf") String cpf, @Param("breakfastOptions") List<String> breakfastOptions, @Param("breakfastDate") LocalDate breakfastDate);

    @Modifying
    @Query(value = "DELETE FROM employee WHERE id = :id", nativeQuery = true)
    void deleteEmployee(@Param("id") Long id);

    @Query(value = "SELECT * FROM employee", nativeQuery = true)
    List<Employee> findAllEmployees();

    @Query(value = "SELECT * FROM employee WHERE id = :id", nativeQuery = true)
    Employee findEmployeeById(@Param("id") Long id);
}