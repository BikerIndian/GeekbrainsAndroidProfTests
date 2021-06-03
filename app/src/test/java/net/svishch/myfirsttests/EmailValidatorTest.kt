package net.svishch.myfirsttests

import org.junit.Assert
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class EmailValidatorTest {

    @Test
    fun emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("name@email.com"))
    }

    @Test
    fun emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("name@email.co.uk"))
    }

    @Test
    fun emailValidator_InvalidEmailNoTld_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@email"))
    }

    @Test
    fun emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@email..com"))
    }

    @Test
    fun emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("@email.com"))
    }

    @Test
    fun emailValidator_EmptyString_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(""))
    }

    @Test
    fun emailValidator_NullEmail_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(null))
    }

    @Test
    fun emailValidator_InvalidEmailNoDomain_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@"))
    }

    @Test
    fun emailValidator_InvalidEmailNoAt_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("nameemail.com"))
    }

    @Test
    fun emailValidator_InvalidEmailDotAfterDomain_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@email.com."))
    }

    // a. assertEquals;
    @Test
    fun emailValidator_EqualsDomain_ReturnsDomain() {
        Assert.assertEquals("email.com", EmailValidator.getDomainForEmail("name@email.com"))
    }

    //b. assertNotEquals;
    @Test
    fun emailValidator_ReturnsNotDomain() {
        Assert.assertNotEquals("email.com", EmailValidator.getDomainForEmail("nameemail.com"))
    }

    //    c. assertArrayEquals;
    @Test
    fun emailValidator_ArrayEquals_ReturnsDomainArray() {
        var arr: Array<String> = arrayOf("e", "m", "a", "i", "l", ".", "c", "o", "m")
        Assert.assertArrayEquals(arr, EmailValidator.getArrDomainForEmail("name@email.com"))
    }

    //    d. assertNull;
    @Test
    fun emailValidator_ReturnsDomainNull() {
        Assert.assertNull(EmailValidator.getDomainForEmail("nameemail.com"))
    }

    //    e. assertNotNull;
    @Test
    fun emailValidator_ReturnsDomainNotNull() {
        Assert.assertNotNull(EmailValidator.getDomainForEmail("name@email.com"))
    }

}
