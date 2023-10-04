package knowledege;

import java.util.Objects;

import lombok.EqualsAndHashCode;

//@EqualsAndHashCode to over ride equals() and hashCode() automatically coming from lombok library

public class Employees {
	
	public int id;
	public String name;
	
	public Employees(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		Employees emp = (Employees)obj;
		return this.id==emp.id && this.name == emp.name;
	}
	
	public int hashCode() {
		return Objects.hash(id, name);
	}

}
