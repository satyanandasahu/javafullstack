package com.example.satya.service;

import java.util.List;
import java.util.Map;

import com.example.satya.dao.IPersonDAO;
import com.example.satya.vo.Person;

public class PersonService implements IPersonService{
	
	IPersonDAO personDAO;

	
	/**
	 * @return the personDAO
	 */
	public IPersonDAO getPersonDAO() {
		return personDAO;
	}

	/**
	 * @param personDAO the personDAO to set
	 */
	public void setPersonDAO(IPersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	@Override
	public List<Person> getPersonList(Map<String, String> searchCriteria) {
		List<Person> personList = personDAO.getPersonByParam(searchCriteria);
		return personList;
	}

	@Override
	public Person getPerson(Person person) {
		Person personObject = personDAO.getPersonById(person.getId());
		return personObject;
	}

	@Override
	public Person createPerson(Person person) {
		personDAO.save(person);
		return person;
	}

	@Override
	public Person deletePerson(Person person) {
		personDAO.delete(person);
		return person;
	}

	@Override
	public Person update(Person person) {
		Person personObject = personDAO.update(person);
		return personObject;
	}

}
