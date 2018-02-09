package uk.co.labfour.cloud2.aaa.common;

import uk.co.labfour.cloud2.protocol.BaseRequest;
import uk.co.labfour.cloud2.protocol.BaseResponse;
import uk.co.labfour.error.BException;

public interface IService {
	
	public BaseResponse doExec(BaseRequest request) throws BException;
}
