package com.david.study.Factory;

import com.david.study.Interface.AuthCheck;
import com.david.study.Interface.AuthCheckFactory;

public abstract class AbstractAuthCheckFactory implements AuthCheckFactory  {

	public AbstractAuthCheckFactory(){
		this.getAuthCheckItem();
	}
	
	public AuthCheck getAuthCheckItem() {
		return createNew();
	}
	
	public abstract AuthCheck createNew();
}
