# Harpocrates Codec

According to Wikipedia, Harpocrates is the Greek god of silence, secrets, and confidentiality. [Wikipedia](https://en.wikipedia.org/wiki/Harpocrates)

Cryptography, specifically encryption, is the process of making text unintelligible, or "making it secret" [Fruhlinger](https://www.csoonline.com/article/569921/what-is-cryptography-how-algorithms-keep-information-secret-and-safe.html).

A codec is a device or program that encodes or decodes data.

`harpocrates-codec` is a Gradle library that provides a codec object that provides functions for encryption and decryption. It is configured to use the `AES` algorithm, specifically the `AES/CBC/PKCS5Padding` transformation.

The codec relies on two pieces of configuration:
* A secret key 
* An init vector

Both the secret key and the init vector must be 16 byte strings, otherwise `InvalidKeyException` or `InvalidAlgorithmParameterException` exceptions can be encountered.

## Example Usage

```kotlin
val message = "Hello, world!"

val encryptedMessage = AESCodec.encrypt(
    message = message,
    secretKey = secretKey,
    initVector = initVector
)

val decryptedMessage = AESCodec.decrypt(
    encryptedMessage = encryptedMessage,
    secretKey = secretKey,
    initVector = initVector
)

assertEquals(message, decryptedMessage) // "Hello, world!"
```

## References

Harpocrates. (n.d.). In Wikipedia. Retrieved August 6, 2023, from https://en.wikipedia.org/wiki/Harpocrates

Fruhlinger, J. (2022, May 22). What is cryptography? How algorithms keep information secret and safe. https://www.csoonline.com/article/569921/what-is-cryptography-how-algorithms-keep-information-secret-and-safe.html