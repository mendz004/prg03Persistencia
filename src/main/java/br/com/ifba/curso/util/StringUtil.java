/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.util;

/**
 *
 * @author ETM-00168
 */
public class StringUtil {
    
    
    // Verifica se uma String é nula ou vazia após remover espaços nas extremidades
public static boolean isNullOrEmpty(String value) {
    return value == null || value.trim().isEmpty();
}

// Verifica se a String possui um tamanho mínimo (desconsiderando espaços nas extremidades)
public static boolean hasMinLength(String value, int minLength) {
    return value != null && value.trim().length() >= minLength;
}

// Verifica se o texto contém apenas letras (incluindo acentuação e espaços)
public static boolean isAlphabetic(String value) {
    return value != null && value.matches("^[a-zA-ZáéíóúÁÉÍÓÚãõÃÕçÇ\\s]+$");
}

// Verifica se a String contém somente números
public static boolean isNumeric(String value) {
    return value != null && value.matches("\\d+");
}

// Remove espaços extras, mantendo apenas um entre palavras
public static String normalize(String value) {
    return value == null ? null : value.trim().replaceAll("\\s+", " ");
}

// Valida se um e-mail possui formato básico correto
public static boolean isValidEmail(String email) {
    return email != null && email.matches("^[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,}$");
}

// Verifica se há qualquer caractere especial na String, exceto letras, números e espaço
public static boolean containsSpecialCharacters(String value) {
    return value != null && value.matches(".[^a-zA-Z0-9 ].");
}

// Verifica se o CPF está no formato ###.###.###-## (somente formato, não validade real)
public static boolean isValidCPFFormat(String cpf) {
    return cpf != null && cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
}

}
