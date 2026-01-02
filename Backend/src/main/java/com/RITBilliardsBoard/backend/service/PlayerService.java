package com.RITBilliardsBoard.backend.service;


import com.RITBilliardsBoard.backend.entity.Player;

import java.util.List;

/**
 * Interface that lays out functionality for CRUD operations relating to the {@link Player} class.
 * <p>
 * Implemented in {@link PlayerServiceImpl}
 * <p>
 *
 * @author Max Avlasevich
 */
public interface PlayerService {

    /**
     * PUT: add new {@link Player}
     * @param player to be added
     * @return player added
     */
    Player addPlayer(Player player);


    /**
     * DELETE: delete {@link Player}
     * @param playerId
     */
    void deletePlayer(Long playerId);


    /**
     * GET: get all {@link Player}
     * @return a list of all {@link Player}
     */
    List<Player> getPlayers();


    /**
     * GET: get all {@link Player}
     * @param playerId player to get
     * @return {@link Player} corresponding with playerId
     */
    Player getPlayer(Long playerId);


    /**
     * updates the {@link Player} with the specified PlayerId
     * @param player updated player
     * @param PlayerId
     * @return updated {@link Player}
     */
    Player updatePlayer(Player player, Long PlayerId);
}
