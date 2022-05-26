package com.example.demo.springin10days.cdi;


import com.example.demo.springin10days.scope.JdbcConnection;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

// when we are trying to program we are trying to create as LESS NUMBERS of objects as POSSIBLE
// More objects More memory -> more pressure on Garbage Collectible Heap
// By not making this a prototype we get to create only one instance for all requests
@Repository
public class SomeCDIDAO {
    // Whenever you are trying to get a bean and one of its dependencies has a PROTOTYPE bean scope
    // then on the dependency
    @Inject
    JdbcConnection jdbcConnection;

    public JdbcConnection getJdbcConnection() {
        return jdbcConnection;
    }

    public void setJdbcConnection(JdbcConnection jdbcConnection) {
        this.jdbcConnection = jdbcConnection;
    }
    public int[] getData(){
        return new int[]{5, 89, 100};
    }

}


