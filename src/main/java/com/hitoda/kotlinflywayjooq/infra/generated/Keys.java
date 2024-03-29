/*
 * This file is generated by jOOQ.
 */
package com.hitoda.kotlinflywayjooq.infra.generated;


import com.hitoda.kotlinflywayjooq.infra.generated.tables.FlywaySchemaHistory;
import com.hitoda.kotlinflywayjooq.infra.generated.tables.Users;
import com.hitoda.kotlinflywayjooq.infra.generated.tables.records.FlywaySchemaHistoryRecord;
import com.hitoda.kotlinflywayjooq.infra.generated.tables.records.UsersRecord;

import javax.annotation.Generated;

import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>PUBLIC</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<UsersRecord, Long> IDENTITY_USERS = Identities0.IDENTITY_USERS;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<UsersRecord> CONSTRAINT_4D = UniqueKeys0.CONSTRAINT_4D;
    public static final UniqueKey<UsersRecord> CONSTRAINT_4 = UniqueKeys0.CONSTRAINT_4;
    public static final UniqueKey<FlywaySchemaHistoryRecord> FLYWAY_SCHEMA_HISTORY_PK = UniqueKeys0.FLYWAY_SCHEMA_HISTORY_PK;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<UsersRecord, Long> IDENTITY_USERS = Internal.createIdentity(Users.USERS, Users.USERS.ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<UsersRecord> CONSTRAINT_4D = Internal.createUniqueKey(Users.USERS, "CONSTRAINT_4D", Users.USERS.ID);
        public static final UniqueKey<UsersRecord> CONSTRAINT_4 = Internal.createUniqueKey(Users.USERS, "CONSTRAINT_4", Users.USERS.EMAIL);
        public static final UniqueKey<FlywaySchemaHistoryRecord> FLYWAY_SCHEMA_HISTORY_PK = Internal.createUniqueKey(FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY, "flyway_schema_history_pk", FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.INSTALLED_RANK);
    }
}
