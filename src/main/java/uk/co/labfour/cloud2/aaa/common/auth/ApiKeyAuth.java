package uk.co.labfour.cloud2.aaa.common.auth;

import uk.co.labfour.bjson.BJsonException;
import uk.co.labfour.bjson.BJsonObject;
import uk.co.labfour.error.BException;

import static uk.co.labfour.cloud2.aaa.common.AAAConstants.*;

public class ApiKeyAuth implements IAuth {
    private String type;
    private String apiKey;

    public ApiKeyAuth() {
        this.type = AUTH_TYPE_APIKEY;
    }

    private ApiKeyAuth(String apiKey) {
        this.type = AUTH_TYPE_APIKEY;
        this.apiKey = apiKey;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getApiKey() {
        return apiKey;
    }

    @Override
    public boolean isAuthTypeSupported(String authType) {
        return (0 == authType.compareTo(AUTH_TYPE_APIKEY));
    }

    public static ApiKeyAuth extract(BJsonObject obj, String authFieldName) {
        ApiKeyAuth apiKeyAuth = null;

        try {
            if (obj.has(AUTH_CONTAINER_FLD)) {
                BJsonObject auth = obj.getElementAsBJsonObject(AUTH_CONTAINER_FLD);
                if (auth.has(AUTH_MODE_FLD)) {
                    String apiKey = auth.getElementAsString(APIKEY_FLD);
                    apiKeyAuth = new ApiKeyAuth(apiKey);
                }
            }
        } catch (BJsonException e) {
            //return null;
        }

        return apiKeyAuth;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public BJsonObject getAsJson() throws BException {
        BJsonObject obj = new BJsonObject();
        try {
            obj.put(AUTH_MODE_FLD, AUTH_TYPE_APIKEY);
            obj.put(APIKEY_FLD, apiKey);
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
