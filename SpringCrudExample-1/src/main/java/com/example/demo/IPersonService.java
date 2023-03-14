package com.example.demo;

import java.util.List;

public interface IPersonService {
	
	public abstract void getAll(); 
	
	public abstract List<Person> listPerson();

	public abstract List<Person> search(String name);

	public abstract String add(Person p);
	
	public abstract String delete (int id);
	
	public abstract String edit (Person p);
}
