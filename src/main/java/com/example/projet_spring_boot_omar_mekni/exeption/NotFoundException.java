package com.example.projet_spring_boot_omar_mekni.exeption;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
