package uk.co.labfour.cloud2.aaa.common.auth;

import uk.co.labfour.bjson.BJsonObject;
import uk.co.labfour.error.BException;

public interface IAuth {

    public String getType();

    public BJsonObject getAsJson() throws BException;

    public void inject(BJsonObject obj) throws BException;

    public boolean isAuthTypeSupported(String authType);
}
