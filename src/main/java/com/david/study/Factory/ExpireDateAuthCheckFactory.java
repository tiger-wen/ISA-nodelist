package com.david.study.Factory;

import com.david.study.Impl.ExpireDateAuthCheck;
import com.david.study.Interface.AuthCheck;

public class ExpireDateAuthCheckFactory extends AbstractAuthCheckFactory {
	
	public AuthCheck chkitems;

	public void setAnimal(AuthCheck chkitems) {
		this.chkitems = chkitems;
	}
	
	public AuthCheck createNew() {
		return new ExpireDateAuthCheck();
	}

}
