package lib;

import javax.inject.Inject;
import javax.inject.Provider;


public class ProjectionsImpl {

    /// [1]
    @Inject QFactoryImpl qFactoryImpl;
    @Inject Provider<CurrentUser> currentUserProvider;


   // [0]
   // @Inject QFactoryImpl qFactoryImpl;
   // @Inject CurrentUser currentUserProvider;

   // [0]
   // @Inject QFactoryImpl qFactoryImpl;

}
