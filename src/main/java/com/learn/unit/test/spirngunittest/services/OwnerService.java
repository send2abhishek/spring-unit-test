package com.learn.unit.test.spirngunittest.services;

import com.learn.unit.test.spirngunittest.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
 }
