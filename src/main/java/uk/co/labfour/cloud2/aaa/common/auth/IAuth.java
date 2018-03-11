package uk.co.labfour.cloud2.aaa.common.auth;

import uk.co.labfour.bjson.BJsonObject;
import uk.co.labfour.error.BException;

interface IAuth {

    String getType();

    BJsonObject getAsJson() throws BException;

    void inject(BJsonObject obj) throws BException;

    boolean isAuthTypeSupported(String authType);
}
