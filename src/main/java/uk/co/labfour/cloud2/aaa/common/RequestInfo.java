package uk.co.labfour.cloud2.aaa.common;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import uk.co.labfour.cloud2.aaa.common.IService;
import uk.co.labfour.cloud2.protocol.BaseRequest;
import uk.co.labfour.cloud2.protocol.BaseResponse;
import uk.co.labfour.error.BException;
import uk.co.labfour.net.transport.IGenericTransport;

public class RequestInfo {
	private BaseRequest request;
	private BaseResponse response;
	private long reqId = -1L;
	private IGenericTransport transport;
	private IService service;
	private String apiKey;
	private String targetResourceUuid;
	private String actionOnTargetResource;
	private CountDownLatch syncResponse = null;

	public RequestInfo(BaseRequest request, String apiKey, String targetResourceUuid, String actionOnTargetResource, IGenericTransport transport, IService service) {
		this.request = request;
		this.transport = transport;
		this.service = service;
		this.apiKey = apiKey;
		this.targetResourceUuid = targetResourceUuid;
		this.actionOnTargetResource = actionOnTargetResource;
	}

	public BaseRequest getRequest() {
		return request;
	}

	public void setRequest(BaseRequest request) {
		this.request = request;
	}

	public long getReqId() {
		return reqId;
	}

	public void setReqId(long reqId) {
		this.reqId = reqId;
	}

	public IGenericTransport getTransport() {
		return transport;
	}

	public void setTransport(IGenericTransport transport) {
		this.transport = transport;
	}

	public IService getService() {
		return service;
	}

	public void setService(IService service) {
		this.service = service;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getTargetResourceUuid() {
		return targetResourceUuid;
	}

	public void setTargetResourceUuid(String targetResourceUuid) {
		this.targetResourceUuid = targetResourceUuid;
	}

	public String getActionOnTargetResource() {
		return actionOnTargetResource;
	}

	public void setActionOnTargetResource(String actionOnTargetResource) {
		this.actionOnTargetResource = actionOnTargetResource;
	}

	public BaseResponse getResponse() {
		return response;
	}

	public void setResponse(BaseResponse response) {
		this.response = response;
	}

	public CountDownLatch getSyncResponse() {
		return syncResponse;
	}

	public void setSyncResponse() {
		if (null == syncResponse) {
			syncResponse = new CountDownLatch(1);
		}
	}
	
	public void waitCompletion(long l, TimeUnit timeUnit) throws BException {
		if (null == syncResponse) {
			throw new BException("You cannot wait an async RequestInfo");
		}
		
		try {
			syncResponse.await(l, timeUnit);
		} catch (InterruptedException e) {
			throw new BException(e);
		}
	}
	
	
}
