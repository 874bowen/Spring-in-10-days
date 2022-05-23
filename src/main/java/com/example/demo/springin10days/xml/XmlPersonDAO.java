package com.example.demo.springin10days.xml;


/*
    *Here we are trying to create a xml ApplicationContext and wire it there.
*/
public class XmlPersonDAO {
    // Whenever you are trying to get a bean and one of its dependencies has a PROTOTYPE bean scope
    // then on the dependency
    XmlJdbcConnection xmlJdbcConnection;

    public XmlJdbcConnection getXmlJdbcConnection() {
        return xmlJdbcConnection;
    }

    public void setXmlJdbcConnection(XmlJdbcConnection xmlJdbcConnection) {
        this.xmlJdbcConnection = xmlJdbcConnection;
    }
}

