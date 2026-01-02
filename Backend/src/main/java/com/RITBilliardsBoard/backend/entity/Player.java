package com.RITBilliardsBoard.backend.entity;


import jakarta.persistence.*;
import lombok.Data;

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

    //private Statistics stats;             // To be implemented later, think we should create a separate class for this

    //private scheduledMatches schedule;    // To be implemented later, think we should create a separate class for this



}
