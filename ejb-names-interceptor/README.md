EJBs with same Java class name not intercepted by CDI interceptors
=======================================================================================

Given
-----
* two or more EJBs with the same Java class name but from different Java packages.

Problem
-------
Interceptor intercepts method calls to only one of the EJBs.

An EJB to be intercepted seems to be chosen randomly after each redeployment.

Workaround
----------
Rename __Java class names__ of the EJBs so all names are __unique__.

Also tried to override the names of EJBs according to JSR 318 (EJB 3.1) spec:<br/>
<cite>&lt;bean-name&gt; is the ejb-name of the enterprise bean. For enterprise beans defined via annotation,
it defaults to the unqualified name of the session bean class, unless specified in the contents of the
Stateless/Stateful/Singleton annotation name() attribute.
For enterprise beans defined via ejb-jar.xml, it’s specified in the &lt;ejb-name&gt; deployment descriptor element.)
</cite>

but without success:

*   Overriding the EJB names of the beans in ejb-jar.xml
*   Overriding the EJB names of the beans using `@Stateless(name="...")`


How to reproduce
----------------
1. Deploy EAR file to Wildfly
2. Call the Webservice http://localhost:8080/MyWebservice/v1/MyEjbImpl?wsdl
3. Call the Webservice http://localhost:8080/MyWebservice/v2/MyEjbImpl?wsdl
4. Check server.log<br/>
   expected 2 lines containing: `Intercepted v1.MyEjbImpl` and `Intercepted v2.MyEjbImpl`<br/>
   but actually only one line (either containing `v1.MyEjbImpl` or `v2.MyEjbImpl`) exists.



