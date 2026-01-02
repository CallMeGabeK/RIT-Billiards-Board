package com.RITBilliardsBoard.backend.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RITBilliardsBoard.backend.entity.TestObject;
import com.RITBilliardsBoard.backend.repository.TestObjectRepository;

/**
 * Concrete implementation of {@link TestObjectService}
 * <p>
 * Utilizes {@link TestObjectRepository} to interact with the DB
 * <p>
 * This class contains all the business logic and does not interact with the DB
 * <p>
 * TODO: Only an example, delete before Prod
 *
 * @author Gabriel Kennedy
 */
@Service //marks a class as a service provider within the application's business logic layer
public class TestObjectServiceImpl implements TestObjectService {

    @Autowired //used for automatic dependency injection https://www.baeldung.com/spring-autowire
    private TestObjectRepository testObjectRepository;


    public TestObject addTestObject(TestObject testObject) {
        return testObjectRepository.save(testObject);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<TestObject> getTestObjects() {
        return (List<TestObject>) testObjectRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TestObject updateTestObject(TestObject testObject, Long testObjectId) {
        TestObject testObjectDB = testObjectRepository.findById(testObjectId).get();

        if (Objects.nonNull(testObject.getName())
                && !"".equalsIgnoreCase(
                        testObject.getName())) {
            testObjectDB.setName(
                    testObject.getName());
        }

        return testObjectRepository.save(testObjectDB);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteTestObjectById(Long testObjectId) {
        testObjectRepository.deleteById(testObjectId);
    }

}
