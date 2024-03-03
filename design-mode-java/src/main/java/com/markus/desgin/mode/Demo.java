package com.markus.desgin.mode;

/**
 * @author: markus
 * @date: 2024/3/3 11:15 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class Demo {

    Animal animal;

    public Demo(Animal animal) {
        this.animal = animal;
    }

    public void cry() {
        this.animal.cry();
    }

    public static void main(String[] args) {
        Demo demo = new Demo(new People());
        demo.cry();

        demo = new Demo(new Dog());
        demo.cry();

        demo = new Demo(new Cat());
        demo.cry();
    }

    interface Animal {
        void cry();
    }

    static class People implements Animal {

        @Override
        public void cry() {
            System.out.println("呜呜呜~");
        }
    }

    static class Dog implements Animal {

        @Override
        public void cry() {
            System.out.println("汪汪汪~");
        }
    }

    static class Cat implements Animal {

        @Override
        public void cry() {
            System.out.println("喵喵喵~");
        }
    }
}
