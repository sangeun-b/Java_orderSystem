package com.algonquincollege.cst8277.models;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-11-19T18:48:30.132-0500")
@StaticMetamodel(PojoBase.class)
public class PojoBase_ {
	public static volatile SingularAttribute<PojoBase, Integer> id;
	public static volatile SingularAttribute<PojoBase, Integer> version;
	public static volatile SingularAttribute<PojoBase, LocalDateTime> created;
	public static volatile SingularAttribute<PojoBase, LocalDateTime> updated;
}
