package com.RITBilliardsBoard.backend.service;


import com.RITBilliardsBoard.backend.entity.Player;
import com.RITBilliardsBoard.backend.repository.PlayerRepository;
import com.RITBilliardsBoard.backend.repository.TestObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


/**
 * Concrete implementation of {@link TestObjectService}
 * <p>
 * Utilizes {@link TestObjectRepository} to interact with the DB
 * <p>
 * This class contains all the business logic and does not interact with the DB
 * <p>
 * TODO: Only an example, delete before Prod
 *
 * @author Max Avlasevich
 */
@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired //used for automatic dependency injection https://www.baeldung.com/spring-autowire
    private PlayerRepository playerRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Player addPlayer(Player player){ return playerRepository.save(player);}

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Player> getPlayers(){return (List<Player>) playerRepository.findAll();}

    /**
     * {@inheritDoc}
     */
    @Override
    public Player getPlayer(Long playerId){return playerRepository.findById(playerId).get();}

    /**
     * {@inheritDoc}
     */
    @Override
    public Player updatePlayer(Player player, Long playerId){

        Player playerDB = playerRepository.findById(playerId).get();

        if (Objects.nonNull(player.getName())
                && !"".equalsIgnoreCase(
                player.getName())){

            playerDB.setName(player.getName());
            playerDB.setMajor(player.getMajor());
            playerDB.setFargo_rtg(player.getFargo_rtg());
            playerDB.setAPA_rank(player.getAPA_rank());

        }

        return playerRepository.save(playerDB);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deletePlayer(Long playerId){playerRepository.deleteById(playerId);}

}
