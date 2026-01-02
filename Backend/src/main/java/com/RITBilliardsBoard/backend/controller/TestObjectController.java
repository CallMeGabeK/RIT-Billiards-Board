package com.RITBilliardsBoard.backend.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.RITBilliardsBoard.backend.entity.TestObject;
import com.RITBilliardsBoard.backend.service.TestObjectService;

/**
 * Class that contains the API endpoints that will be used by the front end.
 * Utilizes {@link TestObjectService} which contains all the business logic.
 */
@RestController
public class TestObjectController {

    @Autowired //used for automatic dependency injection https://www.baeldung.com/spring-autowire
    private TestObjectService testObjectService;

    // Add operation
    @PostMapping("/testObjects")
    public TestObject addTestObject(@Valid @RequestBody TestObject testObject) {
        return testObjectService.addTestObject(testObject);
    }

    // Read operation
    @GetMapping("/testObjects")
    public List<TestObject> getTestObjects() {
        return testObjectService.getTestObjects();
    }

    // Update operation
    @PutMapping("/testObjects/{id}")
    public TestObject updateTestObject(@RequestBody TestObject department, @PathVariable("id") Long testObjectId) {
        return testObjectService.updateTestObject(department, testObjectId);
    }

    // Delete operation
    @DeleteMapping("/testObjects/{id}")
    public String deleteTestObjectById(@PathVariable("id") Long testObjectId) {
        testObjectService.deleteTestObjectById(testObjectId);
        return "Deleted Successfully";
    }
}