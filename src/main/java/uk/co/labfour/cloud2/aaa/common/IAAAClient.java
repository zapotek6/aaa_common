package uk.co.labfour.cloud2.aaa.common;

import uk.co.labfour.cloud2.aaa.common.RequestInfo;
import uk.co.labfour.cloud2.protocol.BaseResponse;
import uk.co.labfour.error.BException;

public interface IAAAClient {

	public BaseResponse doProcess(BaseResponse response) throws BException;

	public BaseResponse doAuthz(RequestInfo requestInfo, String apiKey) throws BException;

	public BaseResponse doCreateComplexEntity(RequestInfo requestInfo, String apiKey) throws BException;
}