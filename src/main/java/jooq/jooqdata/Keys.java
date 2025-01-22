/*
 * This file is generated by jOOQ.
 */
package jooqdata;


import jooqdata.tables.Customer;
import jooqdata.tables.Lot;
import jooqdata.tables.records.CustomerRecord;
import jooqdata.tables.records.LotRecord;

import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * purchase.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<CustomerRecord> CUSTOMER_PKEY = Internal.createUniqueKey(Customer.CUSTOMER, DSL.name("customer_pkey"), new TableField[] { Customer.CUSTOMER.CUSTOMER_CODE_MAIN }, true);
    public static final UniqueKey<CustomerRecord> UNIQUE_CUSTOMER_CODE = Internal.createUniqueKey(Customer.CUSTOMER, DSL.name("unique_customer_code"), new TableField[] { Customer.CUSTOMER.CUSTOMER_CODE }, true);
    public static final UniqueKey<CustomerRecord> UNIQUE_CUSTOMER_INN_KPP = Internal.createUniqueKey(Customer.CUSTOMER, DSL.name("unique_customer_inn_kpp"), new TableField[] { Customer.CUSTOMER.CUSTOMER_INN, Customer.CUSTOMER.CUSTOMER_KPP }, true);
    public static final UniqueKey<LotRecord> LOT_PKEY = Internal.createUniqueKey(Lot.LOT, DSL.name("lot_pkey"), new TableField[] { Lot.LOT.LOT_ID }, true);
    public static final UniqueKey<LotRecord> UNIQUE_LOT_NAME = Internal.createUniqueKey(Lot.LOT, DSL.name("unique_lot_name"), new TableField[] { Lot.LOT.LOT_NAME }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<LotRecord, CustomerRecord> LOT__FK_CUSTOMER = Internal.createForeignKey(Lot.LOT, DSL.name("fk_customer"), new TableField[] { Lot.LOT.CUSTOMER_CODE }, Keys.CUSTOMER_PKEY, new TableField[] { Customer.CUSTOMER.CUSTOMER_CODE_MAIN }, true);
}
