package com.david.study.Impl;

import com.david.study.Interface.AuthCheck;

public abstract class AbstractAuthCheck implements AuthCheck {


	public void execute() {
		System.out.println("++++Logging Processsing in AbstractAuthCheck++++");
		processing();
		finish();
	}

	protected abstract void processing();
	
	public void finish() {
		System.out.println("++++Logging Processsing(finish) in AbstractAuthCheck++++");
	}

}
