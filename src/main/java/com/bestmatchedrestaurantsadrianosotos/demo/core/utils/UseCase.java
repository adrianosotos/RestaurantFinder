package com.bestmatchedrestaurantsadrianosotos.demo.core.utils;

public interface UseCase<Input, Output> {
    Output invoke(Input input);
}
