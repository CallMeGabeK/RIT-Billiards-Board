package com.RITBilliardsBoard.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.RITBilliardsBoard.backend.entity.TestObject;

/**
 * This interface provides the functionality for a DAO (Data Access Object) for the {@link TestObject} class
 * 
 * It extends the {@link CrudRepository} which provides standard methods for performing CRUD (Create, Read, Update, Delete) operations on entities in a database
 * and passes the TestObject in to indicate that we want to do such with TestObjects.
 * 
 * It also passes a Long which would be the ID of the {@link TestObject} we want to interact with. 
 * 
 * @author Gabriel Kennedy
 * TODO: Only an example, delete before Prod
 */
@Repository // Used to indicate that a class is a Data Access Object (DAO) or part of the persistence layer.
public interface TestObjectRepository
        extends CrudRepository<TestObject, Long> {
}