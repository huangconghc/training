package com.demo3;

public class UsbPan implements USB{
    public void open() {
        System.out.println("UsbPan open");
    }

    public void close() {
        System.out.println("UsbPan close");
    }
}
