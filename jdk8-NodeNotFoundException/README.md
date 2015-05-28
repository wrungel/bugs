com.sun.tools.javac.comp.Infer$GraphStrategy$NodeNotFoundException
==================================================================

This Project shows compilation error which occurs when the Java source language is 8.

## How to reproduce the error    
    mvn clean compile 

### Standard output (stdout):

    [INFO] Scanning for projects...
    [INFO]                                                                         
    [INFO] ------------------------------------------------------------------------
    [INFO] Building make-it-easy-jdk8-NodeNotFoundException 1.0-SNAPSHOT
    [INFO] ------------------------------------------------------------------------
    [INFO] 
    [INFO] --- maven-clean-plugin:2.4.1:clean (default-clean) @ make-it-easy-jdk8-NodeNotFoundException ---
    [INFO] Deleting D:\tmp\bugs\make-it-easy-jdk8-NodeNotFoundException\target
    [INFO] 
    [INFO] --- maven-resources-plugin:2.5:resources (default-resources) @ make-it-easy-jdk8-NodeNotFoundException ---
    [debug] execute contextualize
    [INFO] Using 'UTF-8' encoding to copy filtered resources.
    [INFO] skip non existing resourceDirectory D:\tmp\bugs\make-it-easy-jdk8-NodeNotFoundException\src\main\resources
    [INFO] 
    [INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ make-it-easy-jdk8-NodeNotFoundException ---
    [INFO] Changes detected - recompiling the module!
    [INFO] Compiling 1 source file to D:\tmp\bugs\make-it-easy-jdk8-NodeNotFoundException\target\classes
    [INFO] -------------------------------------------------------------
    [ERROR] COMPILATION ERROR : 
    [INFO] -------------------------------------------------------------
    [ERROR] An unknown compilation problem occurred
    [INFO] 1 error
    [INFO] -------------------------------------------------------------
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD FAILURE
    [INFO] ------------------------------------------------------------------------
    [INFO] Total time: 3.404s
    [INFO] Finished at: Thu May 28 09:10:21 CEST 2015
    [INFO] Final Memory: 18M/656M
    [INFO] ------------------------------------------------------------------------
    [ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.1:compile (default-compile) on project make-it-easy-jdk8-NodeNotFoundException: Compilation failure
    [ERROR] An unknown compilation problem occurred
    [ERROR] -> [Help 1]
    [ERROR] 
    [ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
    [ERROR] Re-run Maven using the -X switch to enable full debug logging.
    [ERROR] 
    [ERROR] For more information about the errors and possible solutions, please read the following articles:
    [ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException


### Standard error (stderr):


    An exception has occurred in the compiler (1.8.0_45). Please file a bug at the Java Developer Connection (http://java.sun.com/webapps/bugreport)  after checking the Bug Parade for duplicates. Include your program and the following diagnostic in your report.  Thank you.
    com.sun.tools.javac.comp.Infer$GraphStrategy$NodeNotFoundException
            at com.sun.tools.javac.comp.Infer$LeafSolver.pickNode(Infer.java:1217)
            at com.sun.tools.javac.comp.Infer$GraphSolver.solve(Infer.java:1585)
            at com.sun.tools.javac.comp.Infer$InferenceContext.solve(Infer.java:2204)
            at com.sun.tools.javac.comp.Infer$InferenceContext.solve(Infer.java:2196)
            at com.sun.tools.javac.comp.Infer$InferenceContext.solve(Infer.java:2211)
            at com.sun.tools.javac.comp.Infer.instantiateMethod(Infer.java:186)
            at com.sun.tools.javac.comp.Resolve.rawInstantiate(Resolve.java:567)
            at com.sun.tools.javac.comp.Resolve.selectBest(Resolve.java:1441)
            at com.sun.tools.javac.comp.Resolve.findFun(Resolve.java:1862)
            at com.sun.tools.javac.comp.Resolve$8.doLookup(Resolve.java:2393)
            at com.sun.tools.javac.comp.Resolve$BasicLookupHelper.lookup(Resolve.java:3084)
            at com.sun.tools.javac.comp.Resolve.lookupMethod(Resolve.java:3335)
            at com.sun.tools.javac.comp.Resolve.lookupMethod(Resolve.java:3320)
            at com.sun.tools.javac.comp.Resolve.resolveMethod(Resolve.java:2389)
            at com.sun.tools.javac.comp.Attr.visitIdent(Attr.java:3134)
            at com.sun.tools.javac.tree.JCTree$JCIdent.accept(JCTree.java:2011)
            at com.sun.tools.javac.comp.Attr.attribTree(Attr.java:566)
            at com.sun.tools.javac.comp.Attr.visitApply(Attr.java:1806)
            at com.sun.tools.javac.tree.JCTree$JCMethodInvocation.accept(JCTree.java:1465)
            at com.sun.tools.javac.comp.Attr.attribTree(Attr.java:566)
            at com.sun.tools.javac.comp.DeferredAttr.attribSpeculative(DeferredAttr.java:386)
            at com.sun.tools.javac.comp.DeferredAttr$2.complete(DeferredAttr.java:279)
            at com.sun.tools.javac.comp.DeferredAttr$DeferredType.check(DeferredAttr.java:245)
            at com.sun.tools.javac.comp.DeferredAttr$DeferredType.check(DeferredAttr.java:232)
            at com.sun.tools.javac.comp.Resolve$MethodResultInfo.check(Resolve.java:1003)
            at com.sun.tools.javac.comp.Resolve$4.checkArg(Resolve.java:829)
            at com.sun.tools.javac.comp.Resolve$AbstractMethodCheck.argumentsAcceptable(Resolve.java:734)
            at com.sun.tools.javac.comp.Resolve$4.argumentsAcceptable(Resolve.java:838)
            at com.sun.tools.javac.comp.Infer.instantiateMethod(Infer.java:162)
            at com.sun.tools.javac.comp.Resolve.rawInstantiate(Resolve.java:567)
            at com.sun.tools.javac.comp.Resolve.selectBest(Resolve.java:1441)
            at com.sun.tools.javac.comp.Resolve.findFun(Resolve.java:1862)
            at com.sun.tools.javac.comp.Resolve$8.doLookup(Resolve.java:2393)
            at com.sun.tools.javac.comp.Resolve$BasicLookupHelper.lookup(Resolve.java:3084)
            at com.sun.tools.javac.comp.Resolve.lookupMethod(Resolve.java:3335)
            at com.sun.tools.javac.comp.Resolve.lookupMethod(Resolve.java:3320)
            at com.sun.tools.javac.comp.Resolve.resolveMethod(Resolve.java:2389)
            at com.sun.tools.javac.comp.Attr.visitIdent(Attr.java:3134)
            at com.sun.tools.javac.tree.JCTree$JCIdent.accept(JCTree.java:2011)
            at com.sun.tools.javac.comp.Attr.attribTree(Attr.java:566)
            at com.sun.tools.javac.comp.Attr.visitApply(Attr.java:1806)
            at com.sun.tools.javac.tree.JCTree$JCMethodInvocation.accept(JCTree.java:1465)
            at com.sun.tools.javac.comp.Attr.attribTree(Attr.java:566)
            at com.sun.tools.javac.comp.DeferredAttr.attribSpeculative(DeferredAttr.java:386)
            at com.sun.tools.javac.comp.DeferredAttr$2.complete(DeferredAttr.java:279)
            at com.sun.tools.javac.comp.DeferredAttr$DeferredType.check(DeferredAttr.java:245)
            at com.sun.tools.javac.comp.DeferredAttr$DeferredType.check(DeferredAttr.java:232)
            at com.sun.tools.javac.comp.Resolve$MethodResultInfo.check(Resolve.java:1003)
            at com.sun.tools.javac.comp.Resolve$4.checkArg(Resolve.java:829)
            at com.sun.tools.javac.comp.Resolve$AbstractMethodCheck.argumentsAcceptable(Resolve.java:734)
            at com.sun.tools.javac.comp.Resolve$4.argumentsAcceptable(Resolve.java:838)
            at com.sun.tools.javac.comp.Infer.instantiateMethod(Infer.java:162)
            at com.sun.tools.javac.comp.Resolve.rawInstantiate(Resolve.java:567)
            at com.sun.tools.javac.comp.Resolve.selectBest(Resolve.java:1441)
            at com.sun.tools.javac.comp.Resolve.findFun(Resolve.java:1862)
            at com.sun.tools.javac.comp.Resolve$8.doLookup(Resolve.java:2393)
            at com.sun.tools.javac.comp.Resolve$BasicLookupHelper.lookup(Resolve.java:3084)
            at com.sun.tools.javac.comp.Resolve.lookupMethod(Resolve.java:3335)
            at com.sun.tools.javac.comp.Resolve.lookupMethod(Resolve.java:3320)
            at com.sun.tools.javac.comp.Resolve.resolveMethod(Resolve.java:2389)
            at com.sun.tools.javac.comp.Attr.visitIdent(Attr.java:3134)
            at com.sun.tools.javac.tree.JCTree$JCIdent.accept(JCTree.java:2011)
            at com.sun.tools.javac.comp.Attr.attribTree(Attr.java:566)
            at com.sun.tools.javac.comp.Attr.visitApply(Attr.java:1806)
            at com.sun.tools.javac.tree.JCTree$JCMethodInvocation.accept(JCTree.java:1465)
            at com.sun.tools.javac.comp.Attr.attribTree(Attr.java:566)
            at com.sun.tools.javac.comp.DeferredAttr.attribSpeculative(DeferredAttr.java:386)
            at com.sun.tools.javac.comp.DeferredAttr$2.complete(DeferredAttr.java:279)
            at com.sun.tools.javac.comp.DeferredAttr$DeferredType.check(DeferredAttr.java:245)
            at com.sun.tools.javac.comp.DeferredAttr$DeferredType.check(DeferredAttr.java:232)
            at com.sun.tools.javac.comp.Resolve$MethodResultInfo.check(Resolve.java:1003)
            at com.sun.tools.javac.comp.Resolve$4.checkArg(Resolve.java:829)
            at com.sun.tools.javac.comp.Resolve$AbstractMethodCheck.argumentsAcceptable(Resolve.java:750)
            at com.sun.tools.javac.comp.Resolve$4.argumentsAcceptable(Resolve.java:838)
            at com.sun.tools.javac.comp.Infer.instantiateMethod(Infer.java:162)
            at com.sun.tools.javac.comp.Resolve.rawInstantiate(Resolve.java:567)
            at com.sun.tools.javac.comp.Resolve.selectBest(Resolve.java:1441)
            at com.sun.tools.javac.comp.Resolve.findFun(Resolve.java:1862)
            at com.sun.tools.javac.comp.Resolve$8.doLookup(Resolve.java:2393)
            at com.sun.tools.javac.comp.Resolve$BasicLookupHelper.lookup(Resolve.java:3084)
            at com.sun.tools.javac.comp.Resolve.lookupMethod(Resolve.java:3335)
            at com.sun.tools.javac.comp.Resolve.lookupMethod(Resolve.java:3320)
            at com.sun.tools.javac.comp.Resolve.resolveMethod(Resolve.java:2389)
            at com.sun.tools.javac.comp.Attr.visitIdent(Attr.java:3134)
            at com.sun.tools.javac.tree.JCTree$JCIdent.accept(JCTree.java:2011)
            at com.sun.tools.javac.comp.Attr.attribTree(Attr.java:566)
            at com.sun.tools.javac.comp.Attr.visitApply(Attr.java:1806)
            at com.sun.tools.javac.tree.JCTree$JCMethodInvocation.accept(JCTree.java:1465)
            at com.sun.tools.javac.comp.Attr.attribTree(Attr.java:566)
            at com.sun.tools.javac.comp.DeferredAttr.attribSpeculative(DeferredAttr.java:386)
            at com.sun.tools.javac.comp.DeferredAttr$2.complete(DeferredAttr.java:279)
            at com.sun.tools.javac.comp.DeferredAttr$DeferredType.check(DeferredAttr.java:245)
            at com.sun.tools.javac.comp.DeferredAttr$DeferredType.check(DeferredAttr.java:232)
            at com.sun.tools.javac.comp.Resolve$MethodResultInfo.check(Resolve.java:1003)
            at com.sun.tools.javac.comp.Resolve$4.checkArg(Resolve.java:829)
            at com.sun.tools.javac.comp.Resolve$AbstractMethodCheck.argumentsAcceptable(Resolve.java:734)
            at com.sun.tools.javac.comp.Resolve$4.argumentsAcceptable(Resolve.java:838)
            at com.sun.tools.javac.comp.Infer.instantiateMethod(Infer.java:162)
            at com.sun.tools.javac.comp.Resolve.rawInstantiate(Resolve.java:567)
            at com.sun.tools.javac.comp.Resolve.selectBest(Resolve.java:1441)
            at com.sun.tools.javac.comp.Resolve.findFun(Resolve.java:1862)
            at com.sun.tools.javac.comp.Resolve$8.doLookup(Resolve.java:2393)
            at com.sun.tools.javac.comp.Resolve$BasicLookupHelper.lookup(Resolve.java:3084)
            at com.sun.tools.javac.comp.Resolve.lookupMethod(Resolve.java:3335)
            at com.sun.tools.javac.comp.Resolve.lookupMethod(Resolve.java:3320)
            at com.sun.tools.javac.comp.Resolve.resolveMethod(Resolve.java:2389)
            at com.sun.tools.javac.comp.Attr.visitIdent(Attr.java:3134)
            at com.sun.tools.javac.tree.JCTree$JCIdent.accept(JCTree.java:2011)
            at com.sun.tools.javac.comp.Attr.attribTree(Attr.java:566)
            at com.sun.tools.javac.comp.Attr.visitApply(Attr.java:1806)
            at com.sun.tools.javac.tree.JCTree$JCMethodInvocation.accept(JCTree.java:1465)
            at com.sun.tools.javac.comp.Attr.attribTree(Attr.java:566)
            at com.sun.tools.javac.comp.Attr.visitReturn(Attr.java:1667)
            at com.sun.tools.javac.tree.JCTree$JCReturn.accept(JCTree.java:1384)
            at com.sun.tools.javac.comp.Attr.attribTree(Attr.java:566)
            at com.sun.tools.javac.comp.Attr.attribStat(Attr.java:635)
            at com.sun.tools.javac.comp.Attr.attribStats(Attr.java:651)
            at com.sun.tools.javac.comp.Attr.visitBlock(Attr.java:1105)
            at com.sun.tools.javac.tree.JCTree$JCBlock.accept(JCTree.java:909)
            at com.sun.tools.javac.comp.Attr.attribTree(Attr.java:566)
            at com.sun.tools.javac.comp.Attr.attribStat(Attr.java:635)
            at com.sun.tools.javac.comp.Attr.visitMethodDef(Attr.java:994)
            at com.sun.tools.javac.tree.JCTree$JCMethodDecl.accept(JCTree.java:778)
            at com.sun.tools.javac.comp.Attr.attribTree(Attr.java:566)
            at com.sun.tools.javac.comp.Attr.attribStat(Attr.java:635)
            at com.sun.tools.javac.comp.Attr.attribClassBody(Attr.java:4330)
            at com.sun.tools.javac.comp.Attr.attribClass(Attr.java:4240)
            at com.sun.tools.javac.comp.Attr.attribClass(Attr.java:4169)
            at com.sun.tools.javac.comp.Attr.attrib(Attr.java:4144)
            at com.sun.tools.javac.main.JavaCompiler.attribute(JavaCompiler.java:1248)
            at com.sun.tools.javac.main.JavaCompiler.compile2(JavaCompiler.java:901)
            at com.sun.tools.javac.main.JavaCompiler.compile(JavaCompiler.java:860)
            at com.sun.tools.javac.main.Main.compile(Main.java:523)
            at com.sun.tools.javac.api.JavacTaskImpl.doCall(JavacTaskImpl.java:129)
            at com.sun.tools.javac.api.JavacTaskImpl.call(JavacTaskImpl.java:138)
            at org.codehaus.plexus.compiler.javac.JavaxToolsCompiler.compileInProcess(JavaxToolsCompiler.java:126)
            at org.codehaus.plexus.compiler.javac.JavacCompiler.performCompile(JavacCompiler.java:169)
            at org.apache.maven.plugin.compiler.AbstractCompilerMojo.execute(AbstractCompilerMojo.java:785)
            at org.apache.maven.plugin.compiler.CompilerMojo.execute(CompilerMojo.java:129)
            at org.apache.maven.plugin.DefaultBuildPluginManager.executeMojo(DefaultBuildPluginManager.java:101)
            at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:209)
            at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:153)
            at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:145)
            at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject(LifecycleModuleBuilder.java:84)
            at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject(LifecycleModuleBuilder.java:59)
            at org.apache.maven.lifecycle.internal.LifecycleStarter.singleThreadedBuild(LifecycleStarter.java:183)
            at org.apache.maven.lifecycle.internal.LifecycleStarter.execute(LifecycleStarter.java:161)
            at org.apache.maven.DefaultMaven.doExecute(DefaultMaven.java:320)
            at org.apache.maven.DefaultMaven.execute(DefaultMaven.java:156)
            at org.apache.maven.cli.MavenCli.execute(MavenCli.java:537)
            at org.apache.maven.cli.MavenCli.doMain(MavenCli.java:196)
            at org.apache.maven.cli.MavenCli.main(MavenCli.java:141)
            at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
            at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
            at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
            at java.lang.reflect.Method.invoke(Method.java:497)
            at org.codehaus.plexus.classworlds.launcher.Launcher.launchEnhanced(Launcher.java:290)
            at org.codehaus.plexus.classworlds.launcher.Launcher.launch(Launcher.java:230)
            at org.codehaus.plexus.classworlds.launcher.Launcher.mainWithExitCode(Launcher.java:409)
            at org.codehaus.plexus.classworlds.launcher.Launcher.main(Launcher.java:352)
