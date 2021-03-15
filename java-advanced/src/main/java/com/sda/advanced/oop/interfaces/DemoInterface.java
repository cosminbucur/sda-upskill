package com.sda.advanced.oop.interfaces;

public class DemoInterface {

    public static void main(String[] args) {
        Rectangle myRectangle = new Rectangle(4, 5);
        System.out.println(myRectangle.getArea());

        // rectangle is a shape (implements)
        Shape myShape = myRectangle;
        System.out.println(myShape.getPerimeter());

        // shape method
        myShape.getArea();

        // call default method
        myShape.getColor();
    }

    public static void inlineInterface() {
        Shape myShape = new Shape() {
            // anonymous (inline) class / interface

            // from shape
            @Override
            public double getArea() {
                return 0;
            }

            // from shape
            @Override
            public double getPerimeter() {
                return 0;
            }

            // from Drawable
            @Override
            public void draw() {

            }
        };
    }
}
