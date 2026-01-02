package com.RITBilliardsBoard.backend.repository;


import com.RITBilliardsBoard.backend.entity.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



/**
 * This interface provides the functionality for a DAO (Data Access Object) for the {@link Player} class
 * <p>
 * It extends the {@link CrudRepository} which provides standard methods for performing CRUD (Create, Read, Update, Delete) operations on entities in a database
 * and passes the TestObject in to indicate that we want to do such with TestObjects IN THE DATABASE
 * <p>
 * It also passes a Long which would be the ID of the {@link Player} we want to interact with.
 * <p>
 *
 * @author Gabriel Kennedy
 */
@Repository
public interface PlayerRepository
        extends CrudRepository<Player, Long>{
}
