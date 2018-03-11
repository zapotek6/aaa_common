package uk.co.labfour.cloud2.aaa.common;

import uk.co.labfour.bjson.BJsonArray;
import uk.co.labfour.bjson.BJsonException;
import uk.co.labfour.bjson.BJsonObject;
import uk.co.labfour.error.BException;

import static uk.co.labfour.cloud2.aaa.common.AAAConstants.*;

public class AAAEntityOperationBuilder {
    BJsonObject ope = new BJsonObject();
    BJsonObject auth = new BJsonObject();
    BJsonArray perms = new BJsonArray();
    BJsonArray roles = new BJsonArray();

    public AAAEntityOperationBuilder setAction(String opeId, String action, String name, String description, String parentUuid, String ownerUuid) throws BException {
        ope = new BJsonObject();
        try {
            ope.put(OPEID_FLD, opeId);
            ope.put(ACTION_FLD, action);
            ope.put(NAME_FLD, name);
            ope.put(DESCRIPTION_FLD, description);
            ope.put(PARENT_UUID_FLD, parentUuid);
            ope.put(OWNER_UUID_FLD, ownerUuid);
        } catch (BJsonException e) {
            throw new BException("Fatal error creating json operation object");
        }
        return this;
    }


    public AAAEntityOperationBuilder setAuthWithCredentials(String uid, String pwd) throws BException {
        auth = new BJsonObject();

        try {
            auth.put(AUTH_MODE_FLD, AUTH_TYPE_CREDENTIALS);
            auth.put(CREDENTIALS_UID_FLD, uid);
            auth.put(CREDENTIALS_PWD_FLD, pwd);
        } catch (BJsonException e) {
            throw new BException("Fatal error creating json operation object");
        }
        return this;

    }

    public AAAEntityOperationBuilder setAuthWithApiKey(String apiKey) throws BException {
        auth = new BJsonObject();

        try {
            auth.put(AAAConstants.AUTH_MODE_FLD, AAAConstants.AUTH_TYPE_APIKEY);
            auth.put(AAAConstants.APIKEY_FLD, apiKey);
        } catch (BJsonException e) {
            throw new BException("Fatal error creating json operation object");
        }
        return this;

    }

    public AAAEntityOperationBuilder addPermission(String roleUuid, String action, boolean allow) throws BException {
        BJsonObject perm = new BJsonObject();
        try {
            perm.put(PERMISSION_ROLE_UUID_FLD, roleUuid);
            perm.put(PERMISSION_ACTION_FLD, action);
            perm.put(PERMISSION_ALLOW_FLD, allow);
            perms.add(perm);
        } catch (BJsonException e) {
            throw new BException("Fatal error creating json operation object");
        }
        return this;
    }

    public AAAEntityOperationBuilder addRole(String roleUuid, String domainUuid) throws BException {
        BJsonObject role = new BJsonObject();
        try {
            role.put(ROLE_VALIDITY_DOMAIN_UUID_FLD, domainUuid);
            role.put(ROLE_ROLE_UUID_FLD, roleUuid);
            role.put(ROLE_GRANT_ON_SUBDOMAINS_FLD, false);
            roles.add(role);

        } catch (BJsonException e) {
            throw new BException("Fatal error creating json operation object");
        }
        return this;
    }



    public BJsonObject build() throws BException {
        try {
            ope.put(AUTH_CONTAINER_FLD, auth);
            ope.put(PERMISSIONS_FLD, perms);
            ope.put(ROLES_FLD, roles);

            return ope;
        } catch (BJsonException e) {
            throw new BException("Fatal error creating json operation object");
        }
    }
}
