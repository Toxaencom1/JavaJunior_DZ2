package com.taxah.jj.dz2.task3.models;


import com.taxah.jj.dz2.task3.Column;

import java.util.UUID;

@com.taxah.jj.dz2.task3.Entity
public class Entity {

    @Column(name = "id", primaryKey = true)
    private UUID id;

}
