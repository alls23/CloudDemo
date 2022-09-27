package com.practice.demo.models;/**
 * @author Iurie Gordineco
 */

import lombok.*;

import javax.persistence.*;

/********************************************************************************
 * Copyright 2022 Kyriba Corp. All Rights Reserved.                             *
 * The content of this file is copyrighted by Kyriba Corporation and can not be *
 * reproduced, distributed, altered or used in any form, in whole or in part.   *
 *******************************************************************************/
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Entity(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id;

    @Column
    String name;

}
