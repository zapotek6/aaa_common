package uk.co.labfour.cloud2.aaa.common;

import uk.co.labfour.cloud2.aaa.common.RequestInfo;
import uk.co.labfour.cloud2.protocol.BaseResponse;
import uk.co.labfour.error.BException;

public interface IAAAClient {

	BaseResponse doProcess(BaseResponse response) throws BException;

	BaseResponse doAuthz(RequestInfo requestInfo, String apiKey) throws BException;

	BaseResponse doCreateComplexEntity(RequestInfo requestInfo, String apiKey) throws BException;
}