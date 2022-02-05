package com.epam.tests.collections_tests.listprocessor;


import com.epam.training.student_Uladzimir_Vinnik.collections.list_processor.IListProcessor;
import com.epam.training.student_Uladzimir_Vinnik.collections.list_processor.impl.ListProcessor;
import org.junit.jupiter.api.BeforeEach;

abstract class AbstractTest {

    IListProcessor testClass;

    @BeforeEach
    void setUp() {
        testClass = new ListProcessor();
    }
}
