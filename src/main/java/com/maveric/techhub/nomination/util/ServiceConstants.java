package com.maveric.techhub.nomination.util;

import java.util.UUID;

public class ServiceConstants {

    public static final String ID_IS_MANDATORY = "ID is mandatory";
    public static final String TECHNOLOGIES_IS_MANDATORY = "Technologies is mandatory";

    public static final String NOMINEE_ID_IS_MANDATORY = "Subscriber Id is mandatory";

    public static final String TYPE_IS_MANDATORY = "Type is mandatory";

    public static final String TYPE_ID_IS_MANDATORY = "Type Id is mandatory";

    public static final String ENTITY_ALREADY_EXISTS = "Entity already exists for the given parameter - [%s]";
    public static final String ENTITY_NOT_FOUND = "Entity not found for the given id - %s";

    public static final String ENTITY_DELETED = "Entity deleted for the given id - %s";
    public static String _UUID(){ return UUID.randomUUID().toString(); }
}
