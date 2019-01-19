# Introduction
RSA is a public key cryptographic algorithm designed for encrypting and decrypting messages. 

The implementation in this project is designed for a user to input their own messages and send them to another entity holding a private key, see them in encrypted form then decrypted form (reverted to plaintext).

- Entity creates public and private keys.
- User retrieves the public key.
- User enters message, encrypts it with public key and sends to server
- Entity receives message and decrypts using private key.
