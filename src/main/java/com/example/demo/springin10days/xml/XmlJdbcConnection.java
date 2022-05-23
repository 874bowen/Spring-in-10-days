package com.example.demo.springin10days.xml;

// Even though we are trying to have different instances of the JdbcConnection we still get the same Jdbc instance
// if we really need to have a different instance of JdbcConnection when we have a request for personDAO
// we have to configure something called a proxy -> Instead of directly giving it a JdbcConnection
// we give it a proxy
// A PROXY -> will make sure it gets a new intance of JdbcConnection each time.
public class XmlJdbcConnection {
    public XmlJdbcConnection(){
        System.out.println("JDBC Connection");
    }
}
