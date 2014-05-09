CDI Interceptors sometimes do not work if multiple EJBs with same name implement the same interace
==================================================================================================

Given
-----
* two EJBs with the same @Remote interface and with the same Java class name but from different Java packages.

Problem
-------
EJB method calls not always intercepted.

If after new start of Wildfly Server intercepors work during the first call to some of the EJB methods, then they will work for any subsequent calls.
If after new start of Wildfly Server intercepors DO NOT work during the first call to some of the EJB methods, then they will NOT work for any subsequent calls.

After some debugging I realized, that the bug could be in
`org.jboss.weld.interceptor.builder.InterceptionModelImpl#getInterceptors()`
where for the method being called, enabled method interceptors are looked up.
The `HashMap` which maps methods (key is `java.lang.reflect.Method`) to interceptors (`List<org.jboss.weld.interceptor.spi.metadata.InterceptorMetadata>`) always
contains the method of one the beans with the same name.
Both methods are different (because their declaring classes are different).
If the Map accidentally contains the right Method as key then interceptors are executed.


Workaround
----------
Rename Java class names of the EJBs so all names are unique.

Also tried without success:

*   Overriding the EJB names of the beans in ejb-jar.xml
*   Overriding the EJB names of the beans using `@Stateless(name="...")`


How to reproduce
----------------
1. Deploy EAR file to Wildfly
2. Call the Webservice http://localhost:8080/MyWebservice/v2/MyEjbImpl
3. Check server.log for output from `lib.MyInterceptor: Intercepted ws.MyEjbImpl.foo`
4. If no log output from `lib.MyInterceptor` is seen, then restart the server and continue with step 2.


