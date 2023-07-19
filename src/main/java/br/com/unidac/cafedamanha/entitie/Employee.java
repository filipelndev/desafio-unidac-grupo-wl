package br.com.unidac.cafedamanha.entitie;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Entity
public class Employee {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    @NotBlank(message = "Name is required")
	    private String name;

	    @Column(nullable = false, unique = true, length = 11)
	    @Pattern(regexp = "\\d{11}", message = "Invalid CPF")
	    private String cpf;

	    @ElementCollection
	    @NotEmpty(message = "At least one breakfast option must be provided")
	    private List<String> breakfastOptions;

	    @Column(nullable = false)
	    @FutureOrPresent(message = "Breakfast date must be in the present or future")
	    private LocalDate breakfastDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<String> getBreakfastOptions() {
		return breakfastOptions;
	}

	public void setBreakfastOptions(List<String> breakfastOptions) {
		this.breakfastOptions = breakfastOptions;
	}

	public LocalDate getBreakfastDate() {
		return breakfastDate;
	}

	public void setBreakfastDate(LocalDate breakfastDate) {
		this.breakfastDate = breakfastDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(breakfastDate, breakfastOptions, cpf, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(breakfastDate, other.breakfastDate)
				&& Objects.equals(breakfastOptions, other.breakfastOptions) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

    
    
}