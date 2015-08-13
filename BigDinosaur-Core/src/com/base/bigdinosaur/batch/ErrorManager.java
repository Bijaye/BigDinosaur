package com.base.bigdinosaur.batch;

public abstract class ErrorManager {
	 abstract boolean isSystemError();
	 abstract boolean isApplicationError();
	 abstract boolean isErrorExists();

}
