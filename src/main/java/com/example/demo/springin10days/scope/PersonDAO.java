package com.example.demo.springin10days.scope;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// when we are trying to program we are trying to create as LESS NUMBERS of objects as POSSIBLE
// More objects More memory -> more pressure on Garbage Collectible Heap
// By not making this a prototype we get to create only one instance for all requests
@Component
public class PersonDAO {
    // Whenever you are trying to get a bean and one of its dependencies has a PROTOTYPE bean scope
    // then on the dependency
    @Autowired
    JdbcConnection jdbcConnection;

    public JdbcConnection getJdbcConnection() {
        return jdbcConnection;
    }

    public void setJdbcConnection(JdbcConnection jdbcConnection) {
        this.jdbcConnection = jdbcConnection;
    }
}

