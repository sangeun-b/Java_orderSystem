package com.algonquincollege.cst8277.models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-11-20T00:01:19.100-0500")
@StaticMetamodel(OrderPojo.class)
public class OrderPojo_ extends PojoBase_ {
	public static volatile SingularAttribute<OrderPojo, String> description;
	public static volatile ListAttribute<OrderPojo, OrderLinePojo> orderLines;
	public static volatile SingularAttribute<OrderPojo, CustomerPojo> owningCustomer;
}
