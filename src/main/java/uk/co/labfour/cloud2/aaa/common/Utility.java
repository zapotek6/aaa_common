package uk.co.labfour.cloud2.aaa.common;

import uk.co.labfour.bjson.BJsonException;
import uk.co.labfour.bjson.BJsonObject;
import uk.co.labfour.cloud2.protocol.BaseRequest;
import uk.co.labfour.error.BException;

public class Utility {
    public static BJsonObject createApiKeyAuthObject(String apiKey) throws BException {
        BJsonObject auth = new BJsonObject();
        try {
            auth.put(AAAConstants.APIKEY_FLD, apiKey);
            auth.put(AAAConstants.AUTH_MODE_FLD, AAAConstants.AUTH_TYPE_APIKEY);
        } catch (BJsonException e) {
            throw new BException(e);
        }

        return auth;
    }

    public static BaseRequest createRequest(String apiKey, String consumer, String api, String replyTo) throws BException {
        BJsonObject serviceAuth = createApiKeyAuthObject(apiKey);

        BaseRequest request = new BaseRequest();
        request.setAuth(serviceAuth);
        request.setApi(api);
        request.setConsumer(consumer);
        request.setReplyTo(replyTo);

        return request;
    }

}
