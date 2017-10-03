package hu.uni.miskolc.iit.distributed.egov.ps.controller;

import hu.uni.miskolc.iit.distributed.egov.ps.service.PersonManagerService;

/**
 * Created by tothzs on 2017.10.03..
 */
public class PersonManagerController {
    private PersonManagerService managerService;

    public PersonManagerController(PersonManagerService managerService) {
        this.managerService = managerService;
    }


}
