package com.example.demo.springin10days.cdi;

import javax.inject.Inject;
import javax.inject.Named;
/* Container and Dependency Injection
 * Java EE Dependency Injection Standard (JSR)
 * Spring supports most annotations
 * @Inject (@Autowired)
 * @Named (@Component and @Qualifier)
 * @Singleton (Defines a scope of Singleton)
 */
@Named
public class SomeCDIBusiness {
    @Inject
    SomeCDIDAO someCDIDAO;

    public SomeCDIDAO getSomeCDIDAO() {
        return someCDIDAO;
    }

    public void setSomeCDIDAO(SomeCDIDAO someCDIDAO) {
        this.someCDIDAO = someCDIDAO;
    }
}
