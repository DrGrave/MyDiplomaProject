package com.genezis.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Vadim on 04.04.2017.
 */
@Entity
@Table(name = "M2M_Group_Timeteable")
public class M2MGroupTimeteable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idM2MGroupTimeteable;

    @ManyToOne
        @JoinColumn(name = "IdGroup")
    private
    StudentGroup idGroup;

    @ManyToOne
        @JoinColumn(name = "IdTimeteable")
    private
    Timeteable idTimeteable;

    public int getIdM2MGroupTimeteable() {
        return idM2MGroupTimeteable;
    }

    public void setIdM2MGroupTimeteable(int idM2MGroupTimeteable) {
        this.idM2MGroupTimeteable = idM2MGroupTimeteable;
    }

    public StudentGroup getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(StudentGroup idGroup) {
        this.idGroup = idGroup;
    }

    public Timeteable getIdTimeteable() {
        return idTimeteable;
    }

    public void setIdTimeteable(Timeteable idTimeteable) {
        this.idTimeteable = idTimeteable;
    }
}
