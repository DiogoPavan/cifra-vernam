/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vernam;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

/**
 *
 * @author Cliente
 */
public class MainVernam {
    
    private final static char encryptionArr[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String texto = "hello assdd";
        String chave = generateChave(texto.length());
        String encrypted = encrypt(texto, chave);
        String decrypted = decrypt(encrypted, chave);
        
        System.out.println(texto);
        System.out.println(chave);
        System.out.println(encrypted);
        System.out.println(decrypted);
    }
    
    public static String generateChave(int length) {
        
        if (length <= 0) {
            return null;
        }
        
        String key = "";
        Random random =  new Random();
        
        for (int i = 0; i < length; i++) {
            int randomValue = random.nextInt(26);
            key += encryptionArr[randomValue];
        }
        
        return key;
    }
    
    public static String encrypt(String texto, String key) {
        
        if (texto.length() != key.length()) {
            return "Tamanho do texto e da chave devem ser iguais";
        }
        
        byte[] textoBytes = texto.getBytes();
        byte[] keyBytes = key.getBytes();
        byte[] encryptedText = new byte[textoBytes.length];
        
        for (int i = 0; i < textoBytes.length; i++) {
            encryptedText[i] = (byte) (keyBytes[i] ^ textoBytes[i]);
        }
        
        return new String(encryptedText);
    }
    
    public static String decrypt(String cipherText, String key) {
        
        if (cipherText.length() != key.length()) {
            return null;
        }
        
        byte[] cipherTextBytes = cipherText.getBytes();
        byte[] keyBytes = key.getBytes();
        byte[] decryptedText = new byte[cipherTextBytes.length];
        
        for (int i = 0; i < cipherTextBytes.length; i++) {
            decryptedText[i] = (byte) (keyBytes[i] ^ cipherTextBytes[i]);
        }
        
        return new String(decryptedText).toUpperCase();
        
    }

}
