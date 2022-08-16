package uk.co.labfour.cloud2.aaa.common.model;

import uk.co.labfour.cloud2.entity.identity.Identity;
import uk.co.labfour.cloud2.entity.primitive.BaseObject;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@ModelAnnotation(index = { "_id", "token" })
public class Token extends BaseObject {
	public final static String TYPE = "TOKEN";
	public static final String TOKEN_KEY = "token";
	private String token;
	private Identity linkedResource;
	private Long notValidBefore;
	private Long notValidAfter;
	private Set<String> usages = new HashSet<>();
	private String refreshToken;
	
	public Token(UUID uuid) {
		super(new Identity(uuid, TYPE));
	}
	
	public Token() {
		super(TYPE);
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Identity getLinkedResource() {
		return linkedResource;
	}

	public void setLinkedResource(Identity linkedResource) {
		this.linkedResource = linkedResource;
	}

	public Long getNotValidBefore() {
		return notValidBefore;
	}

	public Token setNotValidBefore(Long notValidBefore) {
		this.notValidBefore = notValidBefore;
		return this;
	}

	public Long getNotValidAfter() {
		return notValidAfter;
	}

	public Token setNotValidAfter(Long notValidAfter) {
		this.notValidAfter = notValidAfter;
		return this;
	}

	public Set<String> getUsages() {
		return usages;
	}

	public Token setUsages(Set<String> usages) {
		this.usages = usages;
		return this;
	}

	public Token add(String usage) {
		usages.add(usage);
		return this;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public Token setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
		return this;
	}
}
