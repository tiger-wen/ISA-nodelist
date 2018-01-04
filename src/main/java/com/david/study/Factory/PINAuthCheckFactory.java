package com.david.study.Factory;

import com.david.study.Impl.PINAuthCheck;
import com.david.study.Interface.AuthCheck;

public class PINAuthCheckFactory extends AbstractAuthCheckFactory{
		
	public AuthCheck createNew() {
		return new PINAuthCheck();
	}

}
