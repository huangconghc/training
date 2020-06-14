package com.demo3;

public class UsbMouse  implements USB{
    public void open() {
        System.out.println("Mouse open");
    }

    public void close() {
        System.out.println("Mouse close");
    }
}
