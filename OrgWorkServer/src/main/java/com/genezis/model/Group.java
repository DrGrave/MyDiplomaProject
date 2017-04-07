package com.genezis.model;

import javax.persistence.*;

/**
 * Created by vadim on 03.04.17.
 */
@Entity
@Table(name="StudentGroup")
public class Group {
    @Id
    @Column(name="IdGroup")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private
    int idGroup;

    @Column(name = "NumberOfGroup")
    private
    String numberOfGroup;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdUserStarosta", nullable = false)
    private myUser idMyUserStarosta;

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    public String getNumberOfGroup() {
        return numberOfGroup;
    }

    public void setNumberOfGroup(String numberOfGroup) {
        this.numberOfGroup = numberOfGroup;
    }

    public myUser getIdMyUserStarosta() {
        return idMyUserStarosta;
    }

    public void setIdMyUserStarosta(myUser idMyUserStarosta) {
        this.idMyUserStarosta = idMyUserStarosta;
    }

    @Override
    public String toString() {
        return "Group{" +
                "idGroup=" + idGroup +
                ", numberOfGroup='" + numberOfGroup + '\'' +
                ", idMyUserStarosta=" + idMyUserStarosta +
                '}';
    }
}
