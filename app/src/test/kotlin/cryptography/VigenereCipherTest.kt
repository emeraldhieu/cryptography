package cryptography

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class VigenereCipherTest {

    @Test
    fun encryptCase1() {
        // GIVEN
        var vigenereCipher = VigenereCipher("DUH")

        // WHEN
        val encryptedStr = vigenereCipher.encrypt("CRYPTO")

        // THEN
        assertEquals("FLFSNV", encryptedStr)
    }

    @Test
    fun encryptCase1Lowercase() {
        // GIVEN
        var vigenereCipher = VigenereCipher("duh")

        // WHEN
        val encryptedStr = vigenereCipher.encrypt("crypto")

        // THEN
        assertEquals("flfsnv", encryptedStr)
    }

    @Test
    fun encryptCase2() {
        // GIVEN
        var vigenereCipher = VigenereCipher("DUH")

        // WHEN
        val encryptedStr = vigenereCipher.encrypt("THEYDRINKTHETEA")

        // THEN
        assertEquals("WBLBXYLHRWBLWYH", encryptedStr)
    }

    @Test
    fun encryptCase2Lowercase() {
        // GIVEN
        var vigenereCipher = VigenereCipher("duh")

        // WHEN
        val encryptedStr = vigenereCipher.encrypt("theydrinkthetea")

        // THEN
        assertEquals("wblbxylhrwblwyh", encryptedStr)
    }

    @Test
    fun decryptCase1() {
        // GIVEN
        var vigenereCipher = VigenereCipher("DUH")

        // WHEN
        val decryptedStr = vigenereCipher.decrypt("FLFSNV")

        // THEN
        assertEquals("CRYPTO", decryptedStr)
    }

    @Test
    fun decryptCase1Lowercase() {
        // GIVEN
        var vigenereCipher = VigenereCipher("duh")

        // WHEN
        val decryptedStr = vigenereCipher.decrypt("flfsnv")

        // THEN
        assertEquals("crypto", decryptedStr)
    }

    @Test
    fun decryptCase2() {
        // GIVEN
        var vigenereCipher = VigenereCipher("DUH")

        // WHEN
        val encryptedStr = vigenereCipher.encrypt("THEYDRINKTHETEA")

        // THEN
        assertEquals("WBLBXYLHRWBLWYH", encryptedStr)
    }

    @Test
    fun decryptCase2Lowercase() {
        // GIVEN
        var vigenereCipher = VigenereCipher("duh")

        // WHEN
        val encryptedStr = vigenereCipher.encrypt("theydrinkthetea")

        // THEN
        assertEquals("wblbxylhrwblwyh", encryptedStr)
    }
}