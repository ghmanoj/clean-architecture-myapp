package com.mghimire.myapp.presenter.usecases;

import com.mghimire.myapp.core.usecases.UseCase;
import com.mghimire.myapp.core.usecases.UseCase.InputValues;
import com.mghimire.myapp.core.usecases.UseCase.OutputValues;
import com.mghimire.myapp.core.usecases.UseCaseExecutor;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import org.springframework.stereotype.Service;

@Service
public class UseCaseExecutorImpl implements UseCaseExecutor {

  @Override
  public <RX, I extends InputValues, O extends OutputValues> CompletableFuture<RX> execute(
      UseCase<I, O> useCase, I input, Function<O, RX> outputMapper) {
    return CompletableFuture
        .supplyAsync(() -> input)
        .thenApplyAsync(useCase::execute)
        .thenApplyAsync(outputMapper);
  }

}
