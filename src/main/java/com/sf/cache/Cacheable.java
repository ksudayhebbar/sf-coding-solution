package com.sf.cache;

public interface Cacheable {
	public boolean isExpired();

	public Object getIdentifier();
}
