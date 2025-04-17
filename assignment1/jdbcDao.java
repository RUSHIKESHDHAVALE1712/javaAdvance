
package javaproject;

import java.util.Collection;

public interface jdbcDao <T,K>
{
	//READ
	Collection<T> getAll(); //get all the object of the specific type
	T getOne(K key); //Get one object of the specific type based upon its identity.
	
	//CREATE
	void add(T t); //Add a new entry into the existing table
	//UPDATE
	void update(T t); //Update the existing Record
	
	void delete(K Key); //Delete the Specific  Record against its Identity.

}

// this is generic interface which provides a basic template-
//for performing CRUD operations.