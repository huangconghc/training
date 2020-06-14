package com.demo3;

public class BookPC {
    public static void main(String[] args) {
        useUSB(new UsbPan());
        useUSB(new UsbMouse());
    }
    //接口类型的引用，用于接收(指向)接口的子类对象
public static void useUSB(USB usb){
        usb.open();
        usb.close();
        }
        }
