package lib;

import javax.inject.Inject;
import javax.inject.Provider;

public class A {
    @Inject Provider<B> b;
}
