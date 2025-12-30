package com.RITBilliardsBoard.backend.controller;

// java Program to Illustrate DepartmentController File

import java.util.List;
// Importing required classes
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.RITBilliardsBoard.backend.entity.TestObject;
import com.RITBilliardsBoard.backend.service.TestObjectService;

// Annotation
@RestController

// Class
public class TestObjectController {

    @Autowired
    private TestObjectService testObjectService;

    // Add operation
    @PostMapping("/testObjects")
    public TestObject addTestObject(
            @Valid @RequestBody TestObject testObject) {
        return testObjectService.addTestObject(testObject);
    }

    // Read operation
    @GetMapping("/testObjects")
    public List<TestObject> getTestObjects() {
        return testObjectService.getTestObjects();
    }

    // Update operation
    @PutMapping("/testObjects/{id}")
    public TestObject updatTestObject(@RequestBody TestObject department,
            @PathVariable("id") Long testObjectId) {
        return testObjectService.updateTestObject(
                department, testObjectId);
    }

    // Delete operation
    @DeleteMapping("/testObjects/{id}")
    public String deleteTestObjectById(@PathVariable("id") Long testObjectId) {
        testObjectService.deleteTestObjectById(
                testObjectId);
        return "Deleted Successfully";
    }
}