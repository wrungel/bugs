Transactional CDI Observer Arquillian test.
===========================================

This test shows:
----------------

Sending transactional CDI events in a managed flush doesn't work in Wildfly 8.2.0.Final.

Executing the test 
    
    mvn clean install -Dtest=TxObserverTest#error_during_managed_flush
produces the following log: 

<pre><code>
Running frol.txobserver.TxObserverTest
INFO  [org.jboss.modules] JBoss Modules version 1.3.3.Final
INFO  [org.jboss.msc] JBoss MSC version 1.2.2.Final
INFO  [org.jboss.as] JBAS015899: WildFly 8.2.0.Final "Tweek" starting
INFO  [org.jboss.as.server] JBAS015888: Creating http management service using socket-binding (management-http)
INFO  [org.xnio] XNIO version 3.3.0.Final
INFO  [org.xnio.nio] XNIO NIO Implementation Version 3.3.0.Final
INFO  [org.jboss.as.clustering.infinispan] JBAS010280: Activating Infinispan subsystem.
INFO  [org.wildfly.extension.io] WFLYIO001: Worker 'default' has auto-configured to 16 core threads with 128 task threads based on your 8 available processors
INFO  [org.jboss.as.security] JBAS013171: Activating Security Subsystem
WARN  [org.jboss.as.txn] JBAS010153: Node identifier property is set to the default value. Please make sure it is unique.
INFO  [org.jboss.as.webservices] JBAS015537: Activating WebServices Extension
INFO  [org.jboss.as.naming] JBAS011800: Activating Naming Subsystem
INFO  [org.jboss.as.security] JBAS013170: Current PicketBox version=4.0.21.Final
INFO  [org.jboss.as.jsf] JBAS012615: Activated the following JSF Implementations: [main]
INFO  [org.jboss.as.connector.logging] JBAS010408: Starting JCA Subsystem (IronJacamar 1.1.9.Final)
INFO  [org.wildfly.extension.undertow] JBAS017502: Undertow 1.1.0.Final starting
INFO  [org.wildfly.extension.undertow] JBAS017502: Undertow 1.1.0.Final starting
INFO  [org.jboss.as.connector.subsystems.datasources] JBAS010403: Deploying JDBC-compliant driver class org.h2.Driver (version 1.3)
INFO  [org.jboss.as.connector.deployers.jdbc] JBAS010417: Started Driver service with driver-name = h2
INFO  [org.jboss.as.naming] JBAS011802: Starting Naming Service
INFO  [org.jboss.as.mail.extension] JBAS015400: Bound mail session [java:jboss/mail/Default]
INFO  [org.wildfly.extension.undertow] JBAS017527: Creating file handler for path D:\tmp\bugs\tx-observer-test\target\wildfly-8.2.0.Final/welcome-content
INFO  [com.arjuna.ats.jbossatx] ARJUNA032010: JBossTS Recovery Service (tag: 9aa71) - JBoss Inc.
INFO  [com.arjuna.ats.arjuna] ARJUNA012324: Start RecoveryActivators
INFO  [com.arjuna.ats.arjuna] ARJUNA012296: ExpiredEntryMonitor running at Di, 21 Apr 2015 19:15:18
INFO  [com.arjuna.ats.arjuna] ARJUNA012343: RecoveryManagerImple is ready. Socket listener is turned off.
INFO  [com.arjuna.ats.jbossatx] ARJUNA032013: Starting transaction recovery manager
INFO  [org.jboss.remoting] JBoss Remoting version 4.0.6.Final
INFO  [org.wildfly.extension.undertow] JBAS017525: Started server default-server.
INFO  [org.wildfly.extension.undertow] JBAS017531: Host default-host starting
INFO  [com.arjuna.ats.jbossatx] ARJUNA032017: JBossTS Transaction Service (JTA version - tag: 9aa71) - JBoss Inc.
INFO  [org.wildfly.extension.undertow] JBAS017519: Undertow HTTP listener default listening on /127.0.0.1:8080
INFO  [org.jboss.as.server.deployment.scanner] JBAS015012: Started FileSystemDeploymentService for directory D:\tmp\bugs\tx-observer-test\target\wildfly-8.2.0.Final\standalone\deployments
INFO  [org.jboss.as.connector.subsystems.datasources] JBAS010400: Bound data source [java:jboss/datasources/ExampleDS]
INFO  [org.jboss.ws.common.management] JBWS022052: Starting JBoss Web Services - Stack CXF Server 4.3.2.Final
INFO  [org.jboss.as] JBAS015961: Http management interface listening on http://127.0.0.1:9990/management
INFO  [org.jboss.as] JBAS015951: Admin console listening on http://127.0.0.1:9990
INFO  [org.jboss.as] JBAS015874: WildFly 8.2.0.Final "Tweek" started in 3411ms - Started 184 of 234 services (82 services are lazy, passive or on-demand)
INFO  [org.xnio] XNIO version 3.2.0.Beta4
INFO  [org.xnio.nio] XNIO NIO Implementation Version 3.2.0.Beta4
INFO  [org.jboss.remoting] JBoss Remoting version 4.0.6.Final
INFO  [org.jboss.as.repository] JBAS014900: Content added at location D:\tmp\bugs\tx-observer-test\target\wildfly-8.2.0.Final\standalone\data\content\93\c35853a190453915ea6f7e0f5bff676039c8d3\content
INFO  [org.jboss.as.server.deployment] JBAS015876: Starting deployment of "test.war" (runtime-name: "test.war")
INFO  [org.jboss.as.jpa] JBAS011401: Read persistence.xml for default
INFO  [org.jboss.as.jpa] JBAS011409: Starting Persistence Unit (phase 1 of 2) Service 'test.war#default'
INFO  [org.hibernate.jpa.internal.util.LogHelper] HHH000204: Processing PersistenceUnitInfo [
	name: default
	...]
INFO  [org.hibernate.Version] HHH000412: Hibernate Core {4.3.7.Final}
INFO  [org.hibernate.cfg.Environment] HHH000206: hibernate.properties not found
INFO  [org.hibernate.cfg.Environment] HHH000021: Bytecode provider name : javassist
INFO  [org.jboss.weld.deployer] JBAS016002: Processing weld deployment test.war
INFO  [org.hibernate.validator.internal.util.Version] HV000001: Hibernate Validator 5.1.3.Final
INFO  [org.jboss.weld.deployer] JBAS016005: Starting Services for CDI deployment: test.war
INFO  [org.jboss.weld.Version] WELD-000900: 2.2.6 (Final)
INFO  [org.jboss.weld.deployer] JBAS016008: Starting weld service for deployment test.war
INFO  [org.jboss.as.jpa] JBAS011409: Starting Persistence Unit (phase 2 of 2) Service 'test.war#default'
INFO  [org.hibernate.annotations.common.Version] HCANN000001: Hibernate Commons Annotations {4.0.4.Final}
INFO  [org.hibernate.dialect.Dialect] HHH000400: Using dialect: org.hibernate.dialect.H2Dialect
WARN  [org.hibernate.dialect.H2Dialect] HHH000431: Unable to determine H2 database version, certain features may not work
INFO  [org.hibernate.hql.internal.ast.ASTQueryTranslatorFactory] HHH000397: Using ASTQueryTranslatorFactory
INFO  [org.hibernate.tool.hbm2ddl.SchemaExport] HHH000227: Running hbm2ddl schema export
INFO  [org.hibernate.tool.hbm2ddl.SchemaExport] HHH000230: Schema export complete
INFO  [org.wildfly.extension.undertow] JBAS017534: Registered web context: /test
INFO  [org.jboss.as.server] JBAS018559: Deployed "test.war" (runtime-name : "test.war")
19:15:26,442 INFO  [frol.txobserver.UpdateListener] (default task-1) event sending
19:15:26,446 INFO  [frol.txobserver.UpdateObserver] (default task-1) IN_PROGRESS event received
WARN  [com.arjuna.ats.arjuna] ARJUNA012125: TwoPhaseCoordinator.beforeCompletion - failed for SynchronizationImple< 0:ffffac136c07:4115d5ad:553685a6:11, org.hibernate.engine.transaction.synchronization.internal.RegisteredSynchronization@458cbc17 >: javax.persistence.PersistenceException: error during managed flush
	at org.hibernate.jpa.spi.AbstractEntityManagerImpl$CallbackExceptionMapperImpl.mapManagedFlushFailure(AbstractEntityManagerImpl.java:1887) [hibernate-entitymanager-4.3.7.Final.jar:4.3.7.Final]
	at org.hibernate.engine.transaction.synchronization.internal.SynchronizationCallbackCoordinatorNonTrackingImpl.beforeCompletion(SynchronizationCallbackCoordinatorNonTrackingImpl.java:119) [hibernate-core-4.3.7.Final.jar:4.3.7.Final]
	at org.hibernate.engine.transaction.synchronization.internal.RegisteredSynchronization.beforeCompletion(RegisteredSynchronization.java:50) [hibernate-core-4.3.7.Final.jar:4.3.7.Final]
	at com.arjuna.ats.internal.jta.resources.arjunacore.SynchronizationImple.beforeCompletion(SynchronizationImple.java:76) [narayana-jts-jacorb-5.0.0.Final.jar:5.0.0.Final (revision: 9aa71)]
	at com.arjuna.ats.arjuna.coordinator.TwoPhaseCoordinator.beforeCompletion(TwoPhaseCoordinator.java:358) [narayana-jts-jacorb-5.0.0.Final.jar:5.0.0.Final (revision: 9aa71)]
	at com.arjuna.ats.arjuna.coordinator.TwoPhaseCoordinator.end(TwoPhaseCoordinator.java:91) [narayana-jts-jacorb-5.0.0.Final.jar:5.0.0.Final (revision: 9aa71)]
	at com.arjuna.ats.arjuna.AtomicAction.commit(AtomicAction.java:162) [narayana-jts-jacorb-5.0.0.Final.jar:5.0.0.Final (revision: 9aa71)]
	at com.arjuna.ats.internal.jta.transaction.arjunacore.TransactionImple.commitAndDisassociate(TransactionImple.java:1166) [narayana-jts-jacorb-5.0.0.Final.jar:5.0.0.Final (revision: 9aa71)]
	at com.arjuna.ats.internal.jta.transaction.arjunacore.BaseTransaction.commit(BaseTransaction.java:126) [narayana-jts-jacorb-5.0.0.Final.jar:5.0.0.Final (revision: 9aa71)]
	at com.arjuna.ats.jbossatx.BaseTransactionManagerDelegate.commit(BaseTransactionManagerDelegate.java:75)
	at com.arjuna.ats.jta.cdi.transactional.TransactionalInterceptorBase.endTransaction(TransactionalInterceptorBase.java:147) [narayana-jts-jacorb-5.0.0.Final.jar:5.0.0.Final (revision: 9aa71)]
	at com.arjuna.ats.jta.cdi.transactional.TransactionalInterceptorBase.invokeInOurTx(TransactionalInterceptorBase.java:93) [narayana-jts-jacorb-5.0.0.Final.jar:5.0.0.Final (revision: 9aa71)]
	at com.arjuna.ats.jta.cdi.transactional.TransactionalInterceptorRequired.intercept(TransactionalInterceptorRequired.java:52) [narayana-jts-jacorb-5.0.0.Final.jar:5.0.0.Final (revision: 9aa71)]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) [rt.jar:1.8.0_20]
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) [rt.jar:1.8.0_20]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) [rt.jar:1.8.0_20]
	at java.lang.reflect.Method.invoke(Method.java:483) [rt.jar:1.8.0_20]
	at org.jboss.weld.interceptor.reader.SimpleInterceptorInvocation$SimpleMethodInvocation.invoke(SimpleInterceptorInvocation.java:74) [weld-core-impl-2.2.6.Final.jar:2014-10-03 10:05]
	at org.jboss.weld.interceptor.chain.AbstractInterceptionChain.invokeNext(AbstractInterceptionChain.java:124) [weld-core-impl-2.2.6.Final.jar:2014-10-03 10:05]
	at org.jboss.weld.interceptor.chain.AbstractInterceptionChain.invokeNextInterceptor(AbstractInterceptionChain.java:102) [weld-core-impl-2.2.6.Final.jar:2014-10-03 10:05]
	at org.jboss.weld.interceptor.proxy.InterceptorMethodHandler.executeInterception(InterceptorMethodHandler.java:43) [weld-core-impl-2.2.6.Final.jar:2014-10-03 10:05]
	at org.jboss.weld.interceptor.proxy.InterceptorMethodHandler.invoke(InterceptorMethodHandler.java:36) [weld-core-impl-2.2.6.Final.jar:2014-10-03 10:05]
	at org.jboss.weld.bean.proxy.CombinedInterceptorAndDecoratorStackMethodHandler.invoke(CombinedInterceptorAndDecoratorStackMethodHandler.java:51) [weld-core-impl-2.2.6.Final.jar:2014-10-03 10:05]
	at frol.txobserver.FooService$Proxy$_$$_WeldSubclass.managedFlush(Unknown Source) [f4da9dfa-ba67-446a-abe8-e5172fa8d5f3.jar:]
	at frol.txobserver.TxObserverTest.error_during_managed_flush(TxObserverTest.java:44) [f4da9dfa-ba67-446a-abe8-e5172fa8d5f3.jar:]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) [rt.jar:1.8.0_20]
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) [rt.jar:1.8.0_20]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) [rt.jar:1.8.0_20]
	at java.lang.reflect.Method.invoke(Method.java:483) [rt.jar:1.8.0_20]
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:47) [arquillian-junit.jar:]
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12) [arquillian-junit.jar:]
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:44) [arquillian-junit.jar:]
	at org.jboss.arquillian.junit.Arquillian$8$1.invoke(Arquillian.java:370) [arquillian-junit.jar:]
	at org.jboss.arquillian.container.test.impl.execution.LocalTestExecuter.execute(LocalTestExecuter.java:60) [arquillian-core.jar:]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) [rt.jar:1.8.0_20]
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) [rt.jar:1.8.0_20]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) [rt.jar:1.8.0_20]
	at java.lang.reflect.Method.invoke(Method.java:483) [rt.jar:1.8.0_20]
	at org.jboss.arquillian.core.impl.ObserverImpl.invoke(ObserverImpl.java:94) [arquillian-core.jar:]
	at org.jboss.arquillian.core.impl.EventContextImpl.invokeObservers(EventContextImpl.java:99) [arquillian-core.jar:]
	at org.jboss.arquillian.core.impl.EventContextImpl.proceed(EventContextImpl.java:81) [arquillian-core.jar:]
	at org.jboss.arquillian.core.impl.ManagerImpl.fire(ManagerImpl.java:145) [arquillian-core.jar:]
	at org.jboss.arquillian.core.impl.ManagerImpl.fire(ManagerImpl.java:116) [arquillian-core.jar:]
	at org.jboss.arquillian.core.impl.EventImpl.fire(EventImpl.java:67) [arquillian-core.jar:]
	at org.jboss.arquillian.container.test.impl.execution.ContainerTestExecuter.execute(ContainerTestExecuter.java:38) [arquillian-core.jar:]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) [rt.jar:1.8.0_20]
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) [rt.jar:1.8.0_20]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) [rt.jar:1.8.0_20]
	at java.lang.reflect.Method.invoke(Method.java:483) [rt.jar:1.8.0_20]
	at org.jboss.arquillian.core.impl.ObserverImpl.invoke(ObserverImpl.java:94) [arquillian-core.jar:]
	at org.jboss.arquillian.core.impl.EventContextImpl.invokeObservers(EventContextImpl.java:99) [arquillian-core.jar:]
	at org.jboss.arquillian.core.impl.EventContextImpl.proceed(EventContextImpl.java:81) [arquillian-core.jar:]
	at org.jboss.arquillian.test.impl.TestContextHandler.createTestContext(TestContextHandler.java:130) [arquillian-core.jar:]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) [rt.jar:1.8.0_20]
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) [rt.jar:1.8.0_20]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) [rt.jar:1.8.0_20]
	at java.lang.reflect.Method.invoke(Method.java:483) [rt.jar:1.8.0_20]
	at org.jboss.arquillian.core.impl.ObserverImpl.invoke(ObserverImpl.java:94) [arquillian-core.jar:]
	at org.jboss.arquillian.core.impl.EventContextImpl.proceed(EventContextImpl.java:88) [arquillian-core.jar:]
	at org.jboss.arquillian.test.impl.TestContextHandler.createClassContext(TestContextHandler.java:92) [arquillian-core.jar:]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) [rt.jar:1.8.0_20]
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) [rt.jar:1.8.0_20]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) [rt.jar:1.8.0_20]
	at java.lang.reflect.Method.invoke(Method.java:483) [rt.jar:1.8.0_20]
	at org.jboss.arquillian.core.impl.ObserverImpl.invoke(ObserverImpl.java:94) [arquillian-core.jar:]
	at org.jboss.arquillian.core.impl.EventContextImpl.proceed(EventContextImpl.java:88) [arquillian-core.jar:]
	at org.jboss.arquillian.test.impl.TestContextHandler.createSuiteContext(TestContextHandler.java:73) [arquillian-core.jar:]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) [rt.jar:1.8.0_20]
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) [rt.jar:1.8.0_20]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) [rt.jar:1.8.0_20]
	at java.lang.reflect.Method.invoke(Method.java:483) [rt.jar:1.8.0_20]
	at org.jboss.arquillian.core.impl.ObserverImpl.invoke(ObserverImpl.java:94) [arquillian-core.jar:]
	at org.jboss.arquillian.core.impl.EventContextImpl.proceed(EventContextImpl.java:88) [arquillian-core.jar:]
	at org.jboss.arquillian.core.impl.ManagerImpl.fire(ManagerImpl.java:145) [arquillian-core.jar:]
	at org.jboss.arquillian.test.impl.EventTestRunnerAdaptor.test(EventTestRunnerAdaptor.java:136) [arquillian-core.jar:]
	at org.jboss.arquillian.junit.Arquillian$8.evaluate(Arquillian.java:363) [arquillian-junit.jar:]
	at org.jboss.arquillian.junit.Arquillian$4.evaluate(Arquillian.java:245) [arquillian-junit.jar:]
	at org.jboss.arquillian.junit.Arquillian.multiExecute(Arquillian.java:422) [arquillian-junit.jar:]
	at org.jboss.arquillian.junit.Arquillian.access$200(Arquillian.java:54) [arquillian-junit.jar:]
	at org.jboss.arquillian.junit.Arquillian$5.evaluate(Arquillian.java:259) [arquillian-junit.jar:]
	at org.jboss.arquillian.junit.Arquillian$7$1.invoke(Arquillian.java:315) [arquillian-junit.jar:]
	at org.jboss.arquillian.container.test.impl.execution.BeforeLifecycleEventExecuter.on(BeforeLifecycleEventExecuter.java:35) [arquillian-core.jar:]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) [rt.jar:1.8.0_20]
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) [rt.jar:1.8.0_20]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) [rt.jar:1.8.0_20]
	at java.lang.reflect.Method.invoke(Method.java:483) [rt.jar:1.8.0_20]
	at org.jboss.arquillian.core.impl.ObserverImpl.invoke(ObserverImpl.java:94) [arquillian-core.jar:]
	at org.jboss.arquillian.core.impl.EventContextImpl.invokeObservers(EventContextImpl.java:99) [arquillian-core.jar:]
	at org.jboss.arquillian.core.impl.EventContextImpl.proceed(EventContextImpl.java:81) [arquillian-core.jar:]
	at org.jboss.arquillian.test.impl.TestContextHandler.createTestContext(TestContextHandler.java:130) [arquillian-core.jar:]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) [rt.jar:1.8.0_20]
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) [rt.jar:1.8.0_20]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) [rt.jar:1.8.0_20]
	at java.lang.reflect.Method.invoke(Method.java:483) [rt.jar:1.8.0_20]
	at org.jboss.arquillian.core.impl.ObserverImpl.invoke(ObserverImpl.java:94) [arquillian-core.jar:]
	at org.jboss.arquillian.core.impl.EventContextImpl.proceed(EventContextImpl.java:88) [arquillian-core.jar:]
	at org.jboss.arquillian.test.impl.TestContextHandler.createClassContext(TestContextHandler.java:92) [arquillian-core.jar:]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) [rt.jar:1.8.0_20]
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) [rt.jar:1.8.0_20]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) [rt.jar:1.8.0_20]
	at java.lang.reflect.Method.invoke(Method.java:483) [rt.jar:1.8.0_20]
	at org.jboss.arquillian.core.impl.ObserverImpl.invoke(ObserverImpl.java:94) [arquillian-core.jar:]
	at org.jboss.arquillian.core.impl.EventContextImpl.proceed(EventContextImpl.java:88) [arquillian-core.jar:]
	at org.jboss.arquillian.test.impl.TestContextHandler.createSuiteContext(TestContextHandler.java:73) [arquillian-core.jar:]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) [rt.jar:1.8.0_20]
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) [rt.jar:1.8.0_20]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) [rt.jar:1.8.0_20]
	at java.lang.reflect.Method.invoke(Method.java:483) [rt.jar:1.8.0_20]
	at org.jboss.arquillian.core.impl.ObserverImpl.invoke(ObserverImpl.java:94) [arquillian-core.jar:]
	at org.jboss.arquillian.core.impl.EventContextImpl.proceed(EventContextImpl.java:88) [arquillian-core.jar:]
	at org.jboss.arquillian.core.impl.ManagerImpl.fire(ManagerImpl.java:145) [arquillian-core.jar:]
	at org.jboss.arquillian.core.impl.ManagerImpl.fire(ManagerImpl.java:116) [arquillian-core.jar:]
	at org.jboss.arquillian.test.impl.EventTestRunnerAdaptor.fireCustomLifecycle(EventTestRunnerAdaptor.java:159) [arquillian-core.jar:]
	at org.jboss.arquillian.junit.Arquillian$7.evaluate(Arquillian.java:311) [arquillian-junit.jar:]
	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:271) [arquillian-junit.jar:]
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:70) [arquillian-junit.jar:]
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:50) [arquillian-junit.jar:]
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:238) [arquillian-junit.jar:]
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63) [arquillian-junit.jar:]
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236) [arquillian-junit.jar:]
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:53) [arquillian-junit.jar:]
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229) [arquillian-junit.jar:]
	at org.jboss.arquillian.junit.Arquillian$2.evaluate(Arquillian.java:204) [arquillian-junit.jar:]
	at org.jboss.arquillian.junit.Arquillian.multiExecute(Arquillian.java:422) [arquillian-junit.jar:]
	at org.jboss.arquillian.junit.Arquillian.access$200(Arquillian.java:54) [arquillian-junit.jar:]
	at org.jboss.arquillian.junit.Arquillian$3.evaluate(Arquillian.java:218) [arquillian-junit.jar:]
	at org.junit.runners.ParentRunner.run(ParentRunner.java:309) [arquillian-junit.jar:]
	at org.jboss.arquillian.junit.Arquillian.run(Arquillian.java:166) [arquillian-junit.jar:]
	at org.junit.runner.JUnitCore.run(JUnitCore.java:160) [arquillian-junit.jar:]
	at org.junit.runner.JUnitCore.run(JUnitCore.java:138) [arquillian-junit.jar:]
	at org.jboss.arquillian.junit.container.JUnitTestRunner.execute(JUnitTestRunner.java:66) [arquillian-junit.jar:]
	at org.jboss.arquillian.protocol.servlet.runner.ServletTestRunner.executeTest(ServletTestRunner.java:159) [arquillian-protocol.jar:]
	at org.jboss.arquillian.protocol.servlet.runner.ServletTestRunner.execute(ServletTestRunner.java:125) [arquillian-protocol.jar:]
	at org.jboss.arquillian.protocol.servlet.runner.ServletTestRunner.doGet(ServletTestRunner.java:89) [arquillian-protocol.jar:]
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:687) [jboss-servlet-api_3.1_spec-1.0.0.Final.jar:1.0.0.Final]
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:790) [jboss-servlet-api_3.1_spec-1.0.0.Final.jar:1.0.0.Final]
	at io.undertow.servlet.handlers.ServletHandler.handleRequest(ServletHandler.java:85) [undertow-servlet-1.1.0.Final.jar:1.1.0.Final]
	at io.undertow.servlet.handlers.security.ServletSecurityRoleHandler.handleRequest(ServletSecurityRoleHandler.java:61) [undertow-servlet-1.1.0.Final.jar:1.1.0.Final]
	at io.undertow.servlet.handlers.ServletDispatchingHandler.handleRequest(ServletDispatchingHandler.java:36) [undertow-servlet-1.1.0.Final.jar:1.1.0.Final]
	at org.wildfly.extension.undertow.security.SecurityContextAssociationHandler.handleRequest(SecurityContextAssociationHandler.java:78)
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43) [undertow-core-1.1.0.Final.jar:1.1.0.Final]
	at io.undertow.servlet.handlers.security.SSLInformationAssociationHandler.handleRequest(SSLInformationAssociationHandler.java:131) [undertow-servlet-1.1.0.Final.jar:1.1.0.Final]
	at io.undertow.servlet.handlers.security.ServletAuthenticationCallHandler.handleRequest(ServletAuthenticationCallHandler.java:56) [undertow-servlet-1.1.0.Final.jar:1.1.0.Final]
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43) [undertow-core-1.1.0.Final.jar:1.1.0.Final]
	at io.undertow.security.handlers.AbstractConfidentialityHandler.handleRequest(AbstractConfidentialityHandler.java:45) [undertow-core-1.1.0.Final.jar:1.1.0.Final]
	at io.undertow.servlet.handlers.security.ServletConfidentialityConstraintHandler.handleRequest(ServletConfidentialityConstraintHandler.java:63) [undertow-servlet-1.1.0.Final.jar:1.1.0.Final]
	at io.undertow.security.handlers.AuthenticationMechanismsHandler.handleRequest(AuthenticationMechanismsHandler.java:58) [undertow-core-1.1.0.Final.jar:1.1.0.Final]
	at io.undertow.servlet.handlers.security.CachedAuthenticatedSessionHandler.handleRequest(CachedAuthenticatedSessionHandler.java:70) [undertow-servlet-1.1.0.Final.jar:1.1.0.Final]
	at io.undertow.security.handlers.SecurityInitialHandler.handleRequest(SecurityInitialHandler.java:76) [undertow-core-1.1.0.Final.jar:1.1.0.Final]
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43) [undertow-core-1.1.0.Final.jar:1.1.0.Final]
	at org.wildfly.extension.undertow.security.jacc.JACCContextIdHandler.handleRequest(JACCContextIdHandler.java:61)
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43) [undertow-core-1.1.0.Final.jar:1.1.0.Final]
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43) [undertow-core-1.1.0.Final.jar:1.1.0.Final]
	at io.undertow.servlet.handlers.ServletInitialHandler.handleFirstRequest(ServletInitialHandler.java:261) [undertow-servlet-1.1.0.Final.jar:1.1.0.Final]
	at io.undertow.servlet.handlers.ServletInitialHandler.dispatchRequest(ServletInitialHandler.java:247) [undertow-servlet-1.1.0.Final.jar:1.1.0.Final]
	at io.undertow.servlet.handlers.ServletInitialHandler.access$000(ServletInitialHandler.java:76) [undertow-servlet-1.1.0.Final.jar:1.1.0.Final]
	at io.undertow.servlet.handlers.ServletInitialHandler$1.handleRequest(ServletInitialHandler.java:166) [undertow-servlet-1.1.0.Final.jar:1.1.0.Final]
	at io.undertow.server.Connectors.executeRootHandler(Connectors.java:197) [undertow-core-1.1.0.Final.jar:1.1.0.Final]
	at io.undertow.server.HttpServerExchange$1.run(HttpServerExchange.java:759) [undertow-core-1.1.0.Final.jar:1.1.0.Final]
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142) [rt.jar:1.8.0_20]
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617) [rt.jar:1.8.0_20]
	at java.lang.Thread.run(Thread.java:745) [rt.jar:1.8.0_20]
Caused by: java.lang.RuntimeException: java.lang.IllegalStateException: ARJUNA016082: Synchronizations are not allowed! Transaction status isActionStatus.RUNNING
	at org.jboss.as.weld.services.bootstrap.WeldTransactionServices.registerSynchronization(WeldTransactionServices.java:85) [wildfly-weld-8.2.0.Final.jar:8.2.0.Final]
	at org.jboss.weld.event.TransactionalObserverNotifier.deferNotification(TransactionalObserverNotifier.java:67) [weld-core-impl-2.2.6.Final.jar:2014-10-03 10:05]
	at org.jboss.weld.event.TransactionalObserverNotifier.notifyObserver(TransactionalObserverNotifier.java:48) [weld-core-impl-2.2.6.Final.jar:2014-10-03 10:05]
	at org.jboss.weld.event.ObserverNotifier.notifyObservers(ObserverNotifier.java:124) [weld-core-impl-2.2.6.Final.jar:2014-10-03 10:05]
	at org.jboss.weld.event.ObserverNotifier.fireEvent(ObserverNotifier.java:117) [weld-core-impl-2.2.6.Final.jar:2014-10-03 10:05]
	at org.jboss.weld.manager.BeanManagerImpl.fireEvent(BeanManagerImpl.java:673) [weld-core-impl-2.2.6.Final.jar:2014-10-03 10:05]
	at org.jboss.weld.util.ForwardingBeanManager.fireEvent(ForwardingBeanManager.java:101) [weld-core-impl-2.2.6.Final.jar:2014-10-03 10:05]
	at frol.txobserver.UpdateListener.callback(UpdateListener.java:36) [f4da9dfa-ba67-446a-abe8-e5172fa8d5f3.jar:]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) [rt.jar:1.8.0_20]
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) [rt.jar:1.8.0_20]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) [rt.jar:1.8.0_20]
	at java.lang.reflect.Method.invoke(Method.java:483) [rt.jar:1.8.0_20]
	at org.hibernate.jpa.event.internal.jpa.ListenerCallback.performCallback(ListenerCallback.java:49) [hibernate-entitymanager-4.3.7.Final.jar:4.3.7.Final]
	at org.hibernate.jpa.event.internal.jpa.CallbackRegistryImpl.callback(CallbackRegistryImpl.java:112) [hibernate-entitymanager-4.3.7.Final.jar:4.3.7.Final]
	at org.hibernate.jpa.event.internal.jpa.CallbackRegistryImpl.preUpdate(CallbackRegistryImpl.java:76) [hibernate-entitymanager-4.3.7.Final.jar:4.3.7.Final]
	at org.hibernate.jpa.event.internal.core.JpaFlushEntityEventListener.invokeInterceptor(JpaFlushEntityEventListener.java:67) [hibernate-entitymanager-4.3.7.Final.jar:4.3.7.Final]
	at org.hibernate.event.internal.DefaultFlushEntityEventListener.handleInterception(DefaultFlushEntityEventListener.java:342) [hibernate-core-4.3.7.Final.jar:4.3.7.Final]
	at org.hibernate.event.internal.DefaultFlushEntityEventListener.scheduleUpdate(DefaultFlushEntityEventListener.java:293) [hibernate-core-4.3.7.Final.jar:4.3.7.Final]
	at org.hibernate.event.internal.DefaultFlushEntityEventListener.onFlushEntity(DefaultFlushEntityEventListener.java:160) [hibernate-core-4.3.7.Final.jar:4.3.7.Final]
	at org.hibernate.event.internal.AbstractFlushingEventListener.flushEntities(AbstractFlushingEventListener.java:231) [hibernate-core-4.3.7.Final.jar:4.3.7.Final]
	at org.hibernate.event.internal.AbstractFlushingEventListener.flushEverythingToExecutions(AbstractFlushingEventListener.java:102) [hibernate-core-4.3.7.Final.jar:4.3.7.Final]
	at org.hibernate.event.internal.DefaultFlushEventListener.onFlush(DefaultFlushEventListener.java:55) [hibernate-core-4.3.7.Final.jar:4.3.7.Final]
	at org.hibernate.internal.SessionImpl.flush(SessionImpl.java:1222) [hibernate-core-4.3.7.Final.jar:4.3.7.Final]
	at org.hibernate.internal.SessionImpl.managedFlush(SessionImpl.java:425) [hibernate-core-4.3.7.Final.jar:4.3.7.Final]
	at org.hibernate.engine.transaction.synchronization.internal.SynchronizationCallbackCoordinatorNonTrackingImpl.beforeCompletion(SynchronizationCallbackCoordinatorNonTrackingImpl.java:114) [hibernate-core-4.3.7.Final.jar:4.3.7.Final]
	... 160 more
Caused by: java.lang.IllegalStateException: ARJUNA016082: Synchronizations are not allowed! Transaction status isActionStatus.RUNNING
	at com.arjuna.ats.internal.jta.transaction.arjunacore.TransactionImple.registerSynchronizationImple(TransactionImple.java:375) [narayana-jts-jacorb-5.0.0.Final.jar:5.0.0.Final (revision: 9aa71)]
	at com.arjuna.ats.internal.jta.transaction.arjunacore.TransactionImple.registerSynchronization(TransactionImple.java:352) [narayana-jts-jacorb-5.0.0.Final.jar:5.0.0.Final (revision: 9aa71)]
	at org.jboss.as.weld.services.bootstrap.WeldTransactionServices.registerSynchronization(WeldTransactionServices.java:83) [wildfly-weld-8.2.0.Final.jar:8.2.0.Final]
	... 184 more

INFO  [org.wildfly.extension.undertow] JBAS017535: Unregistered web context: /test
INFO  [org.jboss.as.jpa] JBAS011410: Stopping Persistence Unit (phase 2 of 2) Service 'test.war#default'
INFO  [org.jboss.weld.deployer] JBAS016009: Stopping weld service for deployment test.war
INFO  [org.jboss.as.jpa] JBAS011410: Stopping Persistence Unit (phase 1 of 2) Service 'test.war#default'
INFO  [org.jboss.as.server.deployment] JBAS015877: Stopped deployment test.war (runtime-name: test.war) in 54ms
INFO  [org.jboss.as.repository] JBAS014901: Content removed from location D:\tmp\bugs\tx-observer-test\target\wildfly-8.2.0.Final\standalone\data\content\93\c35853a190453915ea6f7e0f5bff676039c8d3\content
INFO  [org.jboss.as.server] JBAS018558: Undeployed "test.war" (runtime-name: "test.war")
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 10.222 sec - in frol.txobserver.TxObserverTest
INFO  [org.jboss.as.connector.subsystems.datasources] JBAS010409: Unbound data source [java:jboss/datasources/ExampleDS]
INFO  [org.wildfly.extension.undertow] JBAS017532: Host default-host stopping
INFO  [org.wildfly.extension.undertow] JBAS017521: Undertow HTTP listener default suspending
INFO  [org.wildfly.extension.undertow] JBAS017520: Undertow HTTP listener default stopped, was bound to /127.0.0.1:8080
INFO  [org.wildfly.extension.undertow] JBAS017506: Undertow 1.1.0.Final stopping
INFO  [com.arjuna.ats.jbossatx] ARJUNA032018: Destroying TransactionManagerService
INFO  [com.arjuna.ats.jbossatx] ARJUNA032014: Stopping transaction recovery manager
INFO  [org.jboss.as.connector.deployers.jdbc] JBAS010418: Stopped Driver service with driver-name = h2
INFO  [org.jboss.as] JBAS015950: WildFly 8.2.0.Final "Tweek" stopped in 29ms

Results :

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
</code></pre>
