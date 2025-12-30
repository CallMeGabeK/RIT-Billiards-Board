package com.RITBilliardsBoard.backend.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RITBilliardsBoard.backend.entity.TestObject;
import com.RITBilliardsBoard.backend.repository.TestObjectRepository;

@Service
public class TestObjectServiceImpl implements TestObjectService {

    @Autowired
    private TestObjectRepository testObjectRepository;

    @Override
    public TestObject addTestObject(TestObject testObject) {
        return testObjectRepository.save(testObject);
    }

    @Override
    public List<TestObject> getTestObjects() {
        return (List<TestObject>) testObjectRepository.findAll();
    }

    @Override
    public TestObject updateTestObject(TestObject testObject, Long testObjectId) {
        TestObject testObjectDB = testObjectRepository.findById(testObjectId)
                .get();

        if (Objects.nonNull(testObject.getName())
                && !"".equalsIgnoreCase(
                        testObject.getName())) {
            testObjectDB.setName(
                    testObject.getName());
        }

        return testObjectRepository.save(testObjectDB);
    }

    @Override
    public void deleteTestObjectById(Long testObjectId) {
        testObjectRepository.deleteById(testObjectId);
    }

}
