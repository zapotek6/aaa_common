package uk.co.labfour.cloud2.aaa.common.auth;

import uk.co.labfour.bjson.BJsonException;
import uk.co.labfour.bjson.BJsonObject;
import uk.co.labfour.error.BException;

import static uk.co.labfour.cloud2.aaa.common.AAAConstants.*;

public class CredentialsAuth implements IAuth {
    String type;
    String uid;
    String pwd;

    public CredentialsAuth() {
        this.type = AUTH_TYPE_CREDENTIALS;
    }

    public CredentialsAuth(String uid, String pwd) {
        this.type = AUTH_TYPE_CREDENTIALS;
        this.uid = uid;
        this.pwd = pwd;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public boolean isAuthTypeSupported(String authType) {
        return (0 == authType.compareTo(AUTH_TYPE_CREDENTIALS));
    }

    public static CredentialsAuth extract(BJsonObject auth, String authFieldName) throws BException {
        CredentialsAuth credentials = null;

        String type = Auth.getAuthType(auth);
        try {
            if (auth.has(AUTH_MODE_FLD) && (0==type.compareTo(AUTH_MODE_FLD))) {
                String uid = auth.getElementAsString(CREDENTIALS_UID_FLD);
                String pwd = auth.getElementAsString(CREDENTIALS_PWD_FLD);
                credentials= new CredentialsAuth(uid, pwd);
            }

        } catch (BJsonException e) {
            //return null;
        }

        return credentials;
    }

    public BJsonObject getAsJson() throws BException {
        BJsonObject obj = new BJsonObject();
        try {
            obj.put(AUTH_MODE_FLD, type);
            obj.put(CREDENTIALS_UID_FLD, uid);
            obj.put(CREDENTIALS_PWD_FLD, pwd);
        } catch (BJsonException e) {
            throw new BException(e);
        }

        return obj;
    }

    public void inject(BJsonObject obj) throws BException {
        try {
            obj.put(AUTH_CONTAINER_FLD, getAsJson());
        } catch (BJsonException e) {
            throw new BException(e);
        }
    }
}
