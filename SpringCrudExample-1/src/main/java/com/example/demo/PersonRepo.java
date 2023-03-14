package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

@Repository
public class PersonRepo {

	private List<Person> list = new ArrayList<Person>();

	public void getAll() {
		List<Person> list = List.of(new Person(1, "Raj", "Verma", "raj.verma@imagine.com", 35),
				new Person(2, "Vaibhav", "Telang", "v.telang@futureready.com", 29),
				new Person(3, "Ketan", "Bahadur", "k.bahadur@infonext.com", 32),
				new Person(4, "Abhishek", "Raj", "abhi.raj@softsol.com", 30));
		for (Person person : list) {
			list.add(person);
		}

	}

	public List<Person> listPerson() {
		return list;
	}

	public List<Person> search(String name) {
		return list.stream().filter(x -> x.getfName().startsWith(name)).collect(Collectors.toList());
	}

	public String add(Person p) {
		Person obj = new Person();
		obj.setId(p.getId());
		obj.setfName(p.getfName());
		obj.setlName(p.getlName());
		obj.seteMail(p.geteMail());
		obj.setAge(p.getAge());

		list.add(obj);
		return null;
	}

	public String delete(Integer id) {
		list.removeIf(x -> x.getId() == (id));
		return null;
	}

	public String edit(Person person) {
		int idx = 0;
		int id = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == (person.getId())) {
				id = person.getId();
				idx = i;
				break;
			}
		}

		Person p = new Person();
		p.setId(id);
		p.setfName(person.getfName());
		p.setlName(person.getlName());
		p.seteMail(person.geteMail());
		p.setAge(person.getAge());
		list.set(idx, p);

		return null;
	}
}
