/* Disable the module-info, running the tests causes errors due
   that mongodb-driver and mongodb-driver-core jar files
   contain same module names which is forbidden.
 */
module com.mydeveloperplanet.myspringwebfluxcrudplanet {
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires spring.context;
    requires reactor.core;
    requires spring.webflux;
    requires spring.core;
    requires spring.data.commons;
    requires org.reactivestreams;
    requires spring.web;
    requires spring.data.mongodb;
    requires spring.beans;
}