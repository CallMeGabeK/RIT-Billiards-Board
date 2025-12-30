package com.RITBilliardsBoard.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TestObject for h2 testing and demo
 * <p>
 * This is what's known as a POJO (Plain Old Java Object)
 * It is just an object with a few added things that will deal with:
 * - How it is treated by h2 (Our Relational Database) using jakarta (the Java
 * standard for Object-Relational Mapping)
 * - Reducing boilerplate code (stuff like
 * getters/setters/constructors/toString/equals) through lombok
 * <p>
 * Every time you see @___ it is known as an annotation
 * These provide metadata to the compiler and framework
 * Or put more simply, information on what to do with or how to treat the entity
 * it is applied to
 * <p>
 * TODO: Only an example, delete before Prod
 *
 * @author Gabriel Kennedy
 */
@Entity // Jakarta: Signals that this class represents a table in a relational database.
        // Each instance of the entity class corresponds to a row in that table, and its
        // fields or properties map to the table's columns.
@Data // Lombok: Generates public getters, setters, toString(), equals(), and
      // hashCode() methods
@NoArgsConstructor // Lombok: generates a no arg constructor
@AllArgsConstructor // Lombok: generates an all arg constructor
@Builder // Lombok: Harder to explain but could be nice
         // https://projectlombok.org/features/Builder
public class TestObject {
    @Id // This paramater should be treated as the primary key of TestObject
    @GeneratedValue(strategy = GenerationType.AUTO) // Each time a new TestObject is created it should be assigned a new appropriate ID
    private Long testObjectId;
    private String name;
}