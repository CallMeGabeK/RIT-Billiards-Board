package com.RITBilliardsBoard.backend.entity;

import jakarta.persistence.*;


/**
 * Class to track a players Statistics.
 *
 * OneToOne relationship with a Player object
 *
 * When a Player Object is created with HTTP operation then a column is added to the statistics table with the same Id
 *
 * @author Max Avlasevich
 */
@Entity
public class Statistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long statsId;

    @OneToOne(mappedBy = "stats")
    private Player player;

    private int Eight_Ball_Games;
    private double Eight_Ball_Win_Rate;

    private int Nine_Ball_Games;
    private double Nine_Ball_Win_Rate;

    private int Ten_Ball_Games;
    private double Ten_Ball_Win_Rate;

    private int Straight_Games;
    private double Straight_Win_Rate;

    private int One_Pocket_Games;
    private double One_Pocket_Win_Rate;

    protected Statistics(){}

    public Statistics(Player player){
        this.player = player;
    }

}
