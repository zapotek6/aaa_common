package uk.co.labfour.cloud2.aaa.common.auth;

import uk.co.labfour.bjson.BJsonException;
import uk.co.labfour.bjson.BJsonObject;
import uk.co.labfour.cloud2.aaa.common.AAAConstants;
import uk.co.labfour.error.BException;

class Auth {

    public static BJsonObject getAuth(BJsonObject obj) throws BException {
        return getAuth(obj, AAAConstants.AUTH_CONTAINER_FLD);
    }

    private static BJsonObject getAuth(BJsonObject obj, String authObjectNane) throws BException {
        try {
            if (obj.has(authObjectNane)) {
                return obj.getElementAsBJsonObject(authObjectNane);
            } else {
                throw new BException("No auth found");
            }
        } catch (BJsonException e) {
            throw new BException("Invalid input object");
        }
    }

    public static String getAuthType(BJsonObject auth) throws BException {
        try {
            if (auth.has(AAAConstants.AUTH_MODE_FLD)) {
                return auth.getElementAsString(AAAConstants.AUTH_MODE_FLD);
            } else {
                throw new BException("No auth type found");
            }
        } catch (BJsonException e) {
            throw new BException("Invalid auth object");
        }
    }
}
