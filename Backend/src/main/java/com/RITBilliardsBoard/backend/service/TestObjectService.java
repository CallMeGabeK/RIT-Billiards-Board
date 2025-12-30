package com.RITBilliardsBoard.backend.service;

import com.RITBilliardsBoard.backend.entity.TestObject;
import java.util.List;

/**
 * Interface that lays out functionality for CRUD operations relating to the {@link TestObject} class.
 * <p>
 * Implemented in {@link TestObjectServiceImpl}
 * <p>
 * TODO: Only an example, delete before Prod
 *
 * @author Gabriel Kennedy
 */
public interface TestObjectService {

    /**
     * PUT: add new {@link TestObject}
     * @param testObject to be added
     * @return
     */
    TestObject addTestObject(TestObject testObject);

    /**
     * GET: get all {@link TestObject}
     * @return a List of all {@link TestObject}
     */
    List<TestObject> getTestObjects();

    /**
     * POST: update {@link TestObject} with id
     * Sets {@link TestObject} with ID in the db as new {@link TestObject}
     * @param testObject updated {@link TestObject}
     * @param testObjectId id of {@link TestObject} that you want to update
     * @return
     */
    TestObject updateTestObject(TestObject testObject,
                                Long testObjectId);

    // Delete operation
    /**
     * DELETE: delete TestObject 
     * @param testObjectId id of {@link TestObject} 
     */
    void deleteTestObjectById(Long testObjectId);
}
