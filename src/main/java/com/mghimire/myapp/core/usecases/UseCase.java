package com.mghimire.myapp.core.usecases;

import com.mghimire.myapp.core.usecases.UseCase.InputValues;
import com.mghimire.myapp.core.usecases.UseCase.OutputValues;

public abstract class UseCase<I extends InputValues, O extends OutputValues> {

	// gets input and executes and returns output value
	public abstract O execute(I input);

	public interface InputValues {
	}

	public interface OutputValues {
	}

}
