package uk.co.labfour.cloud2.aaa.common;

import uk.co.labfour.cloud2.protocol.BaseRequest;

import java.util.concurrent.TimeUnit;

public class AAAConstants {
    public static final String AAA_CONSUMER = "aaa";
    public static final String AAA_AUTHORIZATOR_API = "aaa.authorizator";
    public static final String AAA_AUTHENTICATOR_API = "aaa.authenticator";
    public static final String AAA_CREATE_COMPLEX_ENTITY_API = "aaa.createComplexEntity";

    public static final String AUTH_CONTAINER_FLD = "auth"; //BaseRequest.kAuth;
    public static final String AUTH_MODE_FLD = "mode";
    public static final String APIKEY_FLD = "apikey";
    public static final String AUTH_TYPE_APIKEY = "apikey";
    public static final String AUTH_TYPE_CREDENTIALS = "credentials";
    public static final String CREDENTIALS_UID_FLD = "uid";
    public static final String CREDENTIALS_PWD_FLD = "pwd";

    public static final String AUTHZ_CONTAINER_FLD = "authz";

    public static final String OPERATIONS_ARRAY_CONTAINER_FLD = "operations";
    public static final String OPEID_FLD = "opeId";
    public static final String ADD_OPE = "add";
    public static final String ACTION_FLD = "action";
    public static final String PARENT_UUID_FLD = "parentUuid";
    public static final String NAME_FLD = "name";
    public static final String DESCRIPTION_FLD = "description";
    public static final String OWNER_UUID_FLD = "ownerUuid";
    public static final String SPLIT_DOMAIN_FLD = "splitDomain";
    public static final String PERMISSIONS_FLD = "perms";
    public static final String PERMISSION_ROLE_UUID_FLD = "roleUuid";
    public static final String PERMISSION_DOMAIN_UUID_FLD = "domainUuid";
    public static final String PERMISSION_ACTION_FLD = "action";
    public static final String PERMISSION_ALLOW_FLD = "allow";
    public static final String ROLES_FLD = "roles";
    public static final String ROLE_ROLE_UUID_FLD = "roleUuid";
    public static final String ROLE_PARENT_UUID_FLD = "parentUuid";
    public static final String ROLE_GRANT_ON_SUBDOMAINS_FLD = "grantOnSubDomains";



    public static final String INNER_AUTH_CONTAINER_FLD = "auth";

    public static final String ENTITY_UUID_FLD = "entityUuid";

    public static final long DEFAULT_AAA_TIMEOUT_VALUE = 4;
    public static final TimeUnit DEFAULT_AAA_TIMEOUT_TIMEUNIT = TimeUnit.SECONDS;
}
