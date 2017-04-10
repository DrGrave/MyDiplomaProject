package com.genezis.service;

import com.genezis.model.InClass;

/**
 * Created by vadim on 03.04.17.
 */
public interface InClassService {
    void saveInClass(InClass inClass);
    InClass getInClass(int id);
    InClass editInClass(InClass inClass);
    void deleteInClass(InClass inClass);
    InClass ifExists(InClass inClass);
}
