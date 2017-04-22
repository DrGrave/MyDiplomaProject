package com.genezis.service;

import com.genezis.model.Attorney;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

/**
 * Created by Vadim on 22.04.2017.
 */
@Transactional()
public class AttorneyServiceTest {
    @Autowired
    private AttorneyService attorneyService;

    @Test
    public void getAttorney() throws NoSuchAlgorithmException {
//        Attorney attorney = attorneyService.getAttorney(1);
//        System.out.print(attorney.getIdAttorney());
    }

}
