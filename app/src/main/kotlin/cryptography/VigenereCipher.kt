package cryptography

import java.util.*
import java.util.stream.StreamSupport

class VigenereCipher {
    private val alphabets: String = "abcdefghijklmnopqrstuvwxyz"
    private val positionsByAlphabet: Map<Char, Int>
    private val key: String

    constructor(key: String) {
        this.key = key
        positionsByAlphabet = HashMap();
        for (i in alphabets.indices) {
            positionsByAlphabet[alphabets[i]] = i
        }
    }

    /**
     * Formula:
     * Ei = (Pi + Ki) mod 26
     * See https://www.geeksforgeeks.org/vigenere-cipher
     */
    fun encrypt(str: String): String {
        validate(str)

        val alphabetLength = alphabets.length
        val keyLength = key.length
        val encryptedCharacters: MutableList<Char> = ArrayList()
        for ((keyIndex, i) in str.indices.withIndex()) {
            val theChar = str[i].lowercaseChar()
            val position = positionsByAlphabet[theChar] ?: throw IllegalArgumentException("Should not happen")
            val keyCharacter = key[keyIndex % keyLength].lowercaseChar()
            val keyPosition = positionsByAlphabet[keyCharacter] ?: throw IllegalArgumentException("Should not happen")
            val encryptedPosition = (position + keyPosition) % alphabetLength
            val encryptedCharacter = alphabets[encryptedPosition]
            if (str[i].isLowerCase()) {
                encryptedCharacters.add(encryptedCharacter)
            } else {
                encryptedCharacters.add(encryptedCharacter.uppercaseChar())
            }
        }
        return encryptedCharacters.joinToString("")
    }

    private fun validate(str: String) {
        StreamSupport.stream(
            Spliterators.spliteratorUnknownSize(str.iterator(), Spliterator.ORDERED),
            false
        )
            .filter { theChar -> !alphabets.contains(theChar, true) }
            .findFirst()
            .ifPresent { theChar -> throw IllegalArgumentException("Invalid character: $theChar") }
    }

    /**
     * Formula:
     * Di = (Ei - Ki + 26) mod 26
     * See https://www.geeksforgeeks.org/vigenere-cipher
     */
    fun decrypt(str: String): String {
        validate(str)

        val alphabetLength = alphabets.length
        val keyLength = key.length
        val decryptedCharacters: MutableList<Char> = ArrayList()
        for ((keyIndex, i) in str.indices.withIndex()) {
            val theChar = str[i].lowercaseChar()
            val position = positionsByAlphabet[theChar] ?: throw IllegalArgumentException("Should not happen")
            val keyCharacter = key[keyIndex % keyLength].lowercaseChar()
            val keyPosition = positionsByAlphabet[keyCharacter] ?: throw IllegalArgumentException("Should not happen")
            val decryptedPosition = (position - keyPosition + alphabetLength) % alphabetLength
            val decryptedCharacter = alphabets[decryptedPosition]
            if (str[i].isLowerCase()) {
                decryptedCharacters.add(decryptedCharacter)
            } else {
                decryptedCharacters.add(decryptedCharacter.uppercaseChar())
            }
        }
        return decryptedCharacters.joinToString("")
    }
}
