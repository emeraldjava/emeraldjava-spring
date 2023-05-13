# spring-aop-multi

The log shows stuff working in order.

    2023-05-13 16:07:47.774  INFO 6578 --- [  restartedMain] i.e.springaop.serviceb.ServiceBImpl      : ServiceBImpl.postConstruct
    2023-05-13 16:07:47.797  INFO 6578 --- [  restartedMain] i.e.springaop.servicea.ServiceAImpl      : ServiceAImpl.postConstruct
    2023-05-13 16:07:47.803  INFO 6578 --- [  restartedMain] i.e.s.aspect.ServiceALoggingAspect       : ServiceALoggingAspect.postConstruct
    2023-05-13 16:07:47.803  INFO 6578 --- [  restartedMain] i.e.s.aspect.ServiceBLoggingAspect       : ServiceBLoggingAspect.postConstruct
    2023-05-13 16:07:48.010  INFO 6578 --- [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729
    2023-05-13 16:07:48.037  INFO 6578 --- [  restartedMain] ie.emeraldjava.springaop.Main            : Started Main in 6.355 seconds (JVM running for 6.817)
    2023-05-13 16:07:48.039  INFO 6578 --- [  restartedMain] ie.emeraldjava.springaop.Main            : run
    2023-05-13 16:07:48.041  INFO 6578 --- [  restartedMain] i.e.s.aspect.ServiceALoggingAspect       : In ServiceALoggingAspect from logPointcutServiceA
    2023-05-13 16:07:48.050  INFO 6578 --- [  restartedMain] i.e.springaop.servicea.ServiceAImpl      : doesStuff
    2023-05-13 16:07:48.051  INFO 6578 --- [  restartedMain] i.e.s.aspect.ServiceBLoggingAspect       : In ServiceBLoggingAspect from beforeLogPointcutServiceB
    2023-05-13 16:07:48.054  INFO 6578 --- [  restartedMain] i.e.springaop.serviceb.ServiceBImpl      : doesSomething

and then we get

    2023-05-13 21:21:41.233  INFO 14986 --- [  restartedMain] ie.emeraldjava.springaop.Main            : Started Main in 1.17 seconds (JVM running for 6.739)
    2023-05-13 21:21:41.234  INFO 14986 --- [  restartedMain] ie.emeraldjava.springaop.Main            : run
    2023-05-13 21:21:41.237  INFO 14986 --- [  restartedMain] i.e.s.aspect.ServiceALoggingAspect       : --> In ServiceALoggingAspect from logPointcutServiceA
    2023-05-13 21:21:41.246  INFO 14986 --- [  restartedMain] i.e.springaop.servicea.ServiceAImpl      : doesStuff
    2023-05-13 21:21:41.246  INFO 14986 --- [  restartedMain] i.e.s.aspect.ServiceBLoggingAspect       : --> In ServiceBLoggingAspect from beforeLogPointcutServiceB
    2023-05-13 21:21:41.246  INFO 14986 --- [  restartedMain] i.e.s.aspect.ServiceBLoggingAspect       : --> arg 2
    2023-05-13 21:21:41.250  INFO 14986 --- [  restartedMain] i.e.springaop.serviceb.ServiceBImpl      : doesSomething:2
    2023-05-13 21:21:41.250  INFO 14986 --- [  restartedMain] i.e.springaop.serviceb.ServiceBImpl      : inner doALittleMore() which will not be aspect intercepted:2
    2023-05-13 21:21:41.250  INFO 14986 --- [  restartedMain] i.e.s.aspect.SubServiceBLoggingAspect    : --> In SubServiceBLoggingAspect from beforeLogPointcutServiceB
    2023-05-13 21:21:41.250  INFO 14986 --- [  restartedMain] i.e.s.aspect.SubServiceBLoggingAspect    : --> arg 2
    2023-05-13 21:21:41.254  INFO 14986 --- [  restartedMain] i.e.springaop.serviceb.SubServiceBImpl   : doALittleMore 2

### Reading

https://stackoverflow.com/questions/52621303/spring-aop-is-powerless-for-classes-with-interfaces
