package cryptography

import java.util.*
import java.util.stream.Collectors
import java.util.stream.Stream
import java.util.stream.StreamSupport

class CeasarCipher {
    private val alphabets: String = "abcdefghijklmnopqrstuvwxyz"
    private val shiftingCharacters = 3

    fun encrypt(str: String): String {
        val charStream: Stream<Char> = StreamSupport.stream(
            Spliterators.spliteratorUnknownSize(str.iterator(), Spliterator.ORDERED),
            false
        )
        return charStream.map { theChar -> getEncryptedCharacter((theChar)) }
            .map(Char::toString)
            .collect(Collectors.joining())
    }

    private fun getEncryptedCharacter(theChar: Char): Char {
        val index = getIndexForEncryptedCharacter(theChar)
        if (theChar.isLowerCase()) {
            return alphabets[index]
        }
        return alphabets[index].uppercaseChar()
    }

    private fun getIndexForEncryptedCharacter(theChar: Char): Int {
        val alphabetLength = alphabets.length
        for (i in alphabets.indices) {
            val alphabet = alphabets[i]
            if (theChar.lowercaseChar() == alphabet.lowercaseChar()) {
                if (i + shiftingCharacters <= alphabetLength) {
                    return i + shiftingCharacters
                }
                return (i + shiftingCharacters) % alphabetLength
            }
        }
        throw IllegalArgumentException("Invalid character")
    }

    fun decrypt(str: String): String {
        val charStream: Stream<Char> = StreamSupport.stream(
            Spliterators.spliteratorUnknownSize(str.iterator(), Spliterator.ORDERED),
            false
        )
        return charStream.map { theChar -> getDecryptedCharacter((theChar)) }
            .map(Char::toString)
            .collect(Collectors.joining())
    }

    private fun getDecryptedCharacter(theChar: Char): Char {
        val index = getIndexForDecryptedCharacter(theChar)
        if (theChar.isLowerCase()) {
            return alphabets[index]
        }
        return alphabets[index].uppercaseChar()
    }

    private fun getIndexForDecryptedCharacter(theChar: Char): Int {
        val alphabetLength = alphabets.length
        for (i in alphabets.indices.reversed()) {
            val alphabet = alphabets[i]
            if (theChar.lowercaseChar() == alphabet.lowercaseChar()) {
                if (i < shiftingCharacters) {
                    return i + alphabetLength - shiftingCharacters
                }
                return i - shiftingCharacters
            }
        }
        throw IllegalArgumentException("Invalid character")
    }
}
