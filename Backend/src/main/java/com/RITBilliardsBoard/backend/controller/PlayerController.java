package com.RITBilliardsBoard.backend.controller;


import com.RITBilliardsBoard.backend.entity.Player;
import com.RITBilliardsBoard.backend.service.PlayerService;
import com.RITBilliardsBoard.backend.service.PlayerServiceImpl;
import com.RITBilliardsBoard.backend.service.TestObjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class that contains the API endpoints that will be used by the front end.
 * Utilizes {@link PlayerService} which contains all the business logic.
 */
@RestController
@RequestMapping("api/users")
public class PlayerController {

    @Autowired //used for automatic dependency injection https://www.baeldung.com/spring-autowire
    private PlayerService playerService;

    @GetMapping()
    public List<Player> getPlayers(){
        return playerService.getPlayers();
    }

    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable("id") Long player_id){
        return playerService.getPlayer(player_id);
    }

    @PostMapping()
    public Player addPlayer(@Valid @RequestBody Player player){
        return playerService.addPlayer(player);
    }

}
