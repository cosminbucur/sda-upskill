## configure logging

- add maven dependencies
- configure in logback.xml
  - console appender
  - file appender

## read from properties file

- @Value
- AppConfig
- VersionService

## aop dependencies

- aspectjweaver
- aspectjrt

## method aspect

- BookServiceAspect
  - @Before
  - @After
  - @AfterReturning
  - @AfterThrowing
  - @Around

## count the method calls

- @Countable
- CountingAspect
- TimeService
- OutputService

## logging aspect

- @Loggable
- LoggingAspect
