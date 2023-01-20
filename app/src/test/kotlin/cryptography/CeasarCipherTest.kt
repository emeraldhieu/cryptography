package cryptography

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class CeasarCipherTest {

    private var ceasarCipher = CeasarCipher()

    @Test
    fun encryptInvalidCharacter() {
        // GIVEN
        val str = "!@#"

        // WHEN and THEN
        assertThrows<IllegalArgumentException>("Invalid character") {
            ceasarCipher.encrypt(str)
        }
    }

    @Test
    fun encryptCase1() {
        // GIVEN
        val str = "ZOO"

        // WHEN
        val encryptedStr = ceasarCipher.encrypt(str)

        // THEN
        assertEquals("CRR", encryptedStr)
    }

    @Test
    fun encryptCase1Lowercase() {
        // GIVEN
        val str = "zoo"

        // WHEN
        val encryptedStr = ceasarCipher.encrypt(str)

        // THEN
        assertEquals("crr", encryptedStr)
    }

    @Test
    fun encryptCase2() {
        // GIVEN
        val str = "CEASAR"

        // WHEN
        val encryptedStr = ceasarCipher.encrypt(str)

        // THEN
        assertEquals("FHDVDU", encryptedStr)
    }

    @Test
    fun encryptCase2Lowercase() {
        // GIVEN
        val str = "ceasar"

        // WHEN
        val encryptedStr = ceasarCipher.encrypt(str)

        // THEN
        assertEquals("fhdvdu", encryptedStr)
    }

    @Test
    fun decryptInvalidCharacter() {
        // GIVEN
        val str = "!@#"

        // WHEN and THEN
        assertThrows<IllegalArgumentException>("Invalid character") {
            ceasarCipher.decrypt(str)
        }
    }

    @Test
    fun decryptCase1() {
        // GIVEN
        val str = "CRR"

        // WHEN
        val decryptedStr = ceasarCipher.decrypt(str)

        // THEN
        assertEquals("ZOO", decryptedStr)
    }

    @Test
    fun decryptCase1Lowercase() {
        // GIVEN
        val str = "crr"

        // WHEN
        val decryptedStr = ceasarCipher.decrypt(str)

        // THEN
        assertEquals("zoo", decryptedStr)
    }

    @Test
    fun decryptCase2() {
        // GIVEN
        val str = "FHDVDU"

        // WHEN
        val decryptedStr = ceasarCipher.decrypt(str)

        // THEN
        assertEquals("CEASAR", decryptedStr)
    }

    @Test
    fun decryptCase2Lowercase() {
        // GIVEN
        val str = "fhdvdu"

        // WHEN
        val decryptedStr = ceasarCipher.decrypt(str)

        // THEN
        assertEquals("ceasar", decryptedStr)
    }
}