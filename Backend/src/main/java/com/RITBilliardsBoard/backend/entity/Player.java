package com.RITBilliardsBoard.backend.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.EmbeddedTable;


/**
 *
 * Class for a players basic information
 *
 * Includes general information such as name and major
 * Includes Pool information such as APA rank, Fargo Rating, and leaderboard position
 *
 * Has a OneToOne relationship with the statistic class.
 */
@Entity
@Data
public class Player {

    @Id // This paramater should be treated as the primary key of a Player
    @GeneratedValue(strategy = GenerationType.AUTO) // Each time a new Player is created it should be assigned a new appropriate ID
    private Long PlayerId;
    private String Name;
    private String Major;
    private int APA_rank;
    private int Fargo_rtg;
    private int rank; //  1 - 10 for now, -1 if not on the list

    //private matchHistory match_history;   // To be implemented later, think we should create a separate class for this

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    private Statistics stats;             // To be implemented later, think we should create a separate class for this

    //private scheduledMatches schedule;    // To be implemented later, think we should create a separate class for this


    public Player(String Name, String Major, int APA_rank, int Fargo_rtg, int rank){
        this.Name = Name;
        this.Major = Major;
        this.APA_rank = APA_rank;
        this.Fargo_rtg = Fargo_rtg;
        this.rank = rank;
        this.stats = new Statistics(this);
    }

}
