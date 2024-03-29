CREATE TABLE CUST_ADDR (
    ADDR_ID INTEGER IDENTITY NOT NULL,
    ADDR_TYPE VARCHAR(1),
    CITY VARCHAR,
    COUNTRY VARCHAR,
    CREATED TIMESTAMP,
    POSTAL_CODE VARCHAR,
	STATE VARCHAR,
	STREET VARCHAR,
	UPDATED TIMESTAMP,
	VERSION INTEGER,
	ALSOSHIPPING BOOLEAN,
	PRIMARY KEY (ADDR_ID)
);

CREATE TABLE ORDERLINE (
	ORDERLINE_NO INTEGER NOT NULL,
	OWNING_ORDER_ID INTEGER NOT NULL,
    AMOUNT DOUBLE,
    PRICE DOUBLE,
	PRODUCT_ID INTEGER,
	PRIMARY KEY (ORDERLINE_NO, OWNING_ORDER_ID)
);

CREATE TABLE ORDER_TBL (
    ORDER_ID INTEGER IDENTITY NOT NULL,
	CREATED TIMESTAMP,
	DESCRIPTION VARCHAR,
	UPDATED TIMESTAMP,
	VERSION INTEGER,
	OWNING_CUST_ID INTEGER,
	PRIMARY KEY (ORDER_ID)
);

CREATE TABLE CUSTOMER (
    ID INTEGER IDENTITY NOT NULL,
	CREATED TIMESTAMP,
	EMAIL VARCHAR,
	FNAME VARCHAR,
	LNAME VARCHAR,
	PHONENUMBER VARCHAR,
	UPDATED TIMESTAMP,
	VERSION INTEGER,
	BILLING_ADDR INTEGER,
	SHIPPING_ADDR INTEGER,
	PRIMARY KEY (ID)
);

CREATE TABLE PRODUCT (
    PRODUCT_ID INTEGER IDENTITY NOT NULL,
	CREATED TIMESTAMP,
	DESCRIPTION VARCHAR,
	SERIALNUMBER VARCHAR,
	UPDATED TIMESTAMP,
	VERSION INTEGER,
	PRIMARY KEY (PRODUCT_ID)
);

CREATE TABLE STORES (
    STORE_ID INTEGER IDENTITY NOT NULL,
    STORENAME VARCHAR,
    CREATED TIMESTAMP,
    UPDATED TIMESTAMP,
    VERSION INTEGER,
    PRIMARY KEY (STORE_ID)
);

CREATE TABLE STORES_PRODUCTS (
    STORE_ID INTEGER NOT NULL,
    PRODUCT_ID INTEGER NOT NULL,
    PRIMARY KEY (STORE_ID, PRODUCT_ID)
);

ALTER TABLE ORDERLINE ADD CONSTRAINT FK_ORDERLINE_OWNING_ORDER_ID FOREIGN KEY (OWNING_ORDER_ID) REFERENCES ORDER_TBL (ORDER_ID);
ALTER TABLE ORDERLINE ADD CONSTRAINT FK_ORDERLINE_PRODUCT_ID FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCT (PRODUCT_ID);
ALTER TABLE ORDER_TBL ADD CONSTRAINT FK_ORDER_TBL_OWNING_CUST_ID FOREIGN KEY (OWNING_CUST_ID) REFERENCES CUSTOMER (ID);
ALTER TABLE CUSTOMER ADD CONSTRAINT FK_CUSTOMER_BILLING_ADDR FOREIGN KEY (BILLING_ADDR) REFERENCES CUST_ADDR (ADDR_ID);
ALTER TABLE CUSTOMER ADD CONSTRAINT FK_CUSTOMER_SHIPPING_ADDR FOREIGN KEY (SHIPPING_ADDR) REFERENCES CUST_ADDR (ADDR_ID);
ALTER TABLE STORES_PRODUCTS ADD CONSTRAINT FK_STORES_PRODUCTS_STORE_ID FOREIGN KEY (STORE_ID) REFERENCES STORES (STORE_ID);
ALTER TABLE STORES_PRODUCTS ADD CONSTRAINT FK_STORES_PRODUCTS_PRODUCT_ID FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCT (PRODUCT_ID);
