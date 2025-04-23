package com.example.satya.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.satya.service.IPersonService;
import com.example.satya.vo.Person;

public class MainHibernate {
	
	/**
	 * @return the personService
	 */
	public IPersonService getPersonService() {
		return personService;
	}


	/**
	 * @param personService the personService to set
	 */
	public void setPersonService(IPersonService personService) {
		this.personService = personService;
	}


	private IPersonService personService;

	private static Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		MainHibernate main = (MainHibernate)applicationContext.getBean("main");
		main.excute();
	}

	
	public void excute() {
		logger.info("Main Class");

		Person person = null;
		List<Person> personList = null;
		Person returnObject = null;

		/*
		logger.info("Creating a new record");
		person = new Person("1744786166", "ABCD", "WXYZ", "PQRST", 40, "Male");
		personService.createPerson(person);
		logger.info("The saved record: " + person); 
		
		*/
		
		logger.info("Fetching person by person params");
		Map<String, String> searchCriteria = new HashMap<String, String>();
	//	searchCriteria.put("gender", "male");
	//	searchCriteria.put("age", "40");
		searchCriteria.put("FIRSTNAME", "ABCD");
		personList = personService.getPersonList(searchCriteria);
		logger.info("The total list of object fetched = " + personList.size());
		for (int i = 0; i < personList.size(); i++) {
			logger.info("Person " + personList.get(i));
		}
		
		/*	logger.info("Retrieving All Record");
		personList = personDAO.retriveAll();
		logger.info("The total list of object retrieved = " + personList.size());
		for (int i = 0; i < personList.size(); i++) {
			logger.info("Person " + personList.get(i));
		}
		
		logger.info("Fetching person by person ID");
		person = personDAO.getPersonById("1744786166");
		logger.info("Fetched Person: " + person);
		
		logger.info("Fetching person by person params");
		person = new Person();
		person.setGender("Male");
		person.setAge(40);
		personList = personDAO.getPersonByParam(person);
		logger.info("The total list of object fetched = " + personList.size());
		for (int i = 0; i < personList.size(); i++) {
			logger.info("Person " + personList.get(i));
		}
		
		logger.info("Updating person");
		person = new Person();
		person.setAge(80);
		person.setId("1744786166");
		returnObject = personDAO.update(person);
		logger.info("Person updated " + returnObject);
		if (returnObject.getAge() == 80) {
			person = new Person();
			person.setAge(40);
			person.setId("1744786166");
			returnObject = personDAO.update(person);
			logger.info("Reverted to actual age: " + returnObject.getAge());
		}
		
		logger.info("deleting the person");
		person = new Person();
		person.setId("1744786166");
		personDAO.delete(person);
		logger.info("deleted the person");
		*/
		
	}
}
