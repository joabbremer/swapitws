package com.swapit.ws.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.swapit.ws.entities.Proposition;

@StaticMetamodel(Proposition.class)
public class PropositionMetaModel {
	 public static volatile SingularAttribute<Proposition, Long> id;

}
