package hsearchtest;


import entities.A;
import entities.B;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SearchTest {
    @Test
    public void test() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("h2");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        A a = new A();
        a.setName("xyx");
        B b = new B();
        a.getbList().add(b);
        b.setA(a);
        a = em.merge(a);
        em.getTransaction().commit();

        em.clear();

        em.getTransaction().begin();
        a = em.find(A.class, a.getId());
        a.setName("xxx");
        em.flush();
        em.detach(a);
        em.getTransaction().commit();
//        javax.persistence.RollbackException: Error while committing the transaction
//        at org.hibernate.ejb.TransactionImpl.commit(TransactionImpl.java:92)
//        at hsearchtest.SearchTest.test(SearchTest.java:33)
//        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
//        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
//        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
//        at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:47)
//        at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
//        at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:44)
//        at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
//        at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:271)
//        at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:70)
//        at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:50)
//        at org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)
//        at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)
//        at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)
//        at org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)
//        at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)
//        at org.junit.runners.ParentRunner.run(ParentRunner.java:309)
//        at org.junit.runner.JUnitCore.run(JUnitCore.java:160)
//        at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:74)
//        at com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:211)
//        at com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:67)
//        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
//        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
//        at com.intellij.rt.execution.application.AppMain.main(AppMain.java:134)
//        Caused by: javax.persistence.PersistenceException: org.hibernate.HibernateException: Error while indexing in Hibernate Search (before transaction completion)
//        at org.hibernate.ejb.AbstractEntityManagerImpl.convert(AbstractEntityManagerImpl.java:1377)
//        at org.hibernate.ejb.AbstractEntityManagerImpl.convert(AbstractEntityManagerImpl.java:1300)
//        at org.hibernate.ejb.TransactionImpl.commit(TransactionImpl.java:80)
//        ... 27 more
//        Caused by: org.hibernate.HibernateException: Error while indexing in Hibernate Search (before transaction completion)
//        at org.hibernate.search.backend.impl.EventSourceTransactionContext$DelegateToSynchronizationOnBeforeTx.doBeforeTransactionCompletion(EventSourceTransactionContext.java:194)
//        at org.hibernate.engine.spi.ActionQueue$BeforeTransactionCompletionProcessQueue.beforeTransactionCompletion(ActionQueue.java:662)
//        at org.hibernate.engine.spi.ActionQueue.beforeTransactionCompletion(ActionQueue.java:307)
//        at org.hibernate.internal.SessionImpl.beforeTransactionCompletion(SessionImpl.java:611)
//        at org.hibernate.engine.transaction.internal.jdbc.JdbcTransaction.beforeTransactionCommit(JdbcTransaction.java:105)
//        at org.hibernate.engine.transaction.spi.AbstractTransactionImpl.commit(AbstractTransactionImpl.java:175)
//        at org.hibernate.ejb.TransactionImpl.commit(TransactionImpl.java:75)
//        ... 27 more
//        Caused by: org.hibernate.LazyInitializationException: failed to lazily initialize a collection of role: entities.A.bList, no session or session was closed
//        at org.hibernate.collection.internal.AbstractPersistentCollection.throwLazyInitializationException(AbstractPersistentCollection.java:394)
//        at org.hibernate.collection.internal.AbstractPersistentCollection.throwLazyInitializationExceptionIfNotConnected(AbstractPersistentCollection.java:386)
//        at org.hibernate.collection.internal.AbstractPersistentCollection.initialize(AbstractPersistentCollection.java:379)
//        at org.hibernate.collection.internal.AbstractPersistentCollection.read(AbstractPersistentCollection.java:113)
//        at org.hibernate.collection.internal.PersistentBag.iterator(PersistentBag.java:266)
//        at org.hibernate.search.engine.spi.DocumentBuilderIndexedEntity.buildDocumentFields(DocumentBuilderIndexedEntity.java:517)
//        at org.hibernate.search.engine.spi.DocumentBuilderIndexedEntity.getDocument(DocumentBuilderIndexedEntity.java:398)
//        at org.hibernate.search.engine.spi.DocumentBuilderIndexedEntity.createUpdateWork(DocumentBuilderIndexedEntity.java:337)
//        at org.hibernate.search.engine.spi.DocumentBuilderIndexedEntity.addWorkToQueue(DocumentBuilderIndexedEntity.java:279)
//        at org.hibernate.search.engine.impl.WorkPlan$PerEntityWork.enqueueLuceneWork(WorkPlan.java:506)
//        at org.hibernate.search.engine.impl.WorkPlan$PerClassWork.enqueueLuceneWork(WorkPlan.java:279)
//        at org.hibernate.search.engine.impl.WorkPlan.getPlannedLuceneWork(WorkPlan.java:165)
//        at org.hibernate.search.backend.impl.WorkQueue.prepareWorkPlan(WorkQueue.java:131)
//        at org.hibernate.search.backend.impl.BatchedQueueingProcessor.prepareWorks(BatchedQueueingProcessor.java:73)
//        at org.hibernate.search.backend.impl.PostTransactionWorkQueueSynchronization.beforeCompletion(PostTransactionWorkQueueSynchronization.java:87)
//        at org.hibernate.search.backend.impl.EventSourceTransactionContext$DelegateToSynchronizationOnBeforeTx.doBeforeTransactionCompletion(EventSourceTransactionContext.java:191)
//        ... 33 more
    }
}
