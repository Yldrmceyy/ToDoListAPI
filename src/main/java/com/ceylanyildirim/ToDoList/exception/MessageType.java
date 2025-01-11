package com.ceylanyildirim.ToDoList.exception;

import lombok.Getter;

/**
 * MessageType, uygulama genelinde kullanılan hata mesajlarının türlerini ve kodlarını tanımlar.
 * Her hata türü bir kod ve bir mesaj içerir.
 */

@Getter //dısarıdan erısebilmek için setter a gerek yok
public enum MessageType {

    NO_RECORD_EXIST("1001","Kayıt Bulunamadı"),
    GENERAL_EXCEPTION("9999", "Genel Bir Hata Oluştu");

    private  String code;
    private String message;


    MessageType(String code, String message){
        this.code = code;
        this.message = message;
    }

}
