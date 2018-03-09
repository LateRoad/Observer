package com.lateroad.observer.validation;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TxtReaderValidatorTest {
    TxtReaderValidator validator = new TxtReaderValidator();
    String wrongLine = "2 8 73 3 3 8 7 8 8";
    String rightLine = "2 0 9 3 74 -5 6 3";

    @Test
    public void testValidateLineTrue() {
        Assert.assertTrue(validator.validateLine(rightLine));
    }

    @Test
    public void testValidateLineFalse() {
        Assert.assertFalse(validator.validateLine(wrongLine));
    }

}