package com.ceylanyildirim.ToDoList.exception.handler;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Exception<E> {

    private String hostName; // Hatanın meydana geldiği sunucu
    private  String path;  // İstek yolu
    private Date createTime; // Hata oluşum zamanı
    private E message;  // Hata mesajı

}
