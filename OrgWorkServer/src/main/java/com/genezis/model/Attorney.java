package com.genezis.model;

import javax.persistence.*;

/**
 * Created by vadim on 03.04.17.
 */
@Entity
@Table(name="ATTORNEY")
public class Attorney {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idAttorney;


}
