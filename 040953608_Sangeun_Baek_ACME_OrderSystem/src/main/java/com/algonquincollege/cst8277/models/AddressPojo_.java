package com.algonquincollege.cst8277.models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-11-19T21:18:05.346-0500")
@StaticMetamodel(AddressPojo.class)
public class AddressPojo_ extends PojoBase_ {
	public static volatile SingularAttribute<AddressPojo, String> type;
	public static volatile SingularAttribute<AddressPojo, String> city;
	public static volatile SingularAttribute<AddressPojo, String> country;
	public static volatile SingularAttribute<AddressPojo, String> postalCode;
	public static volatile SingularAttribute<AddressPojo, String> state;
	public static volatile SingularAttribute<AddressPojo, String> street;
	public static volatile SingularAttribute<AddressPojo, CustomerPojo> owningCustomer;
}
