package com.amalvadkar.jbms.adapter.in.web.common;

import org.junit.jupiter.api.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

@Tag("mvc")
public class AbstractMT {
    @Autowired
    protected MockMvcTester mockMvcTester;
}
