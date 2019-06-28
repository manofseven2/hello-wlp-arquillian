# Hello Websphere Liberty Profile With Arquillian
This is an example that shows how to integrate arquillian with WLP (websphere liberty profile) 8.5.

#How to run this example
To run this example you should have WLP version 8.5 or higher and maven.
Follow these steps:

1.  Install maven;
2.  Install WLP;
3.  Set WLP home directory into a environment variable named WLP_HOME 
4.  Create a server in WLP (for example testserver);
-   ${WLP_HOME}/bin/server create testserver
-   You can set the chosen server name into arquillian.xml file
5.  Add four feature in server.xml named:
-   jsp-2.2
-   cdi-1.0
-   concurrent-1.0
-   localConnector-1.0
6.  Execute this command:
-   mvn clean package
#Description
As you can see in this example, **CDI injection** is tested. 
if you want to use intellij idea to run test you can use debug-websphere container qualifier to debug your code. 