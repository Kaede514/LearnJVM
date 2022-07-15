package com.kaede.chapter05;

//说明早期绑定和晚期绑定的例子

public class AnimalTest {
    public static void main(String[] args) {
        
    }

    public void showAnimal(Animal animal) {
        animal.eat();   //表现为：晚期绑定
    }

    public void showHunt(Huntable hunt) {
        hunt.hunt();    //表现为：晚期绑定
    }
}

class Animal {
    public void eat() {
        System.out.println("动物进食");
    }
}

interface Huntable {
    void hunt();
}

class Dog extends Animal implements Huntable {
    public Dog() {
        super();    //表现为：早期绑定（编译期就能确定下来）
    }

    public Dog(String name) {
        this();     //表现为：早期绑定
    }

    @Override
    public void eat() {
        System.out.println("狗吃骨头"); 
    }

    @Override
    public void hunt() {
        System.out.println("捕食耗子，多管闲事");
    }
}

class Cat extends Animal {
    @Override
    public void eat() {
        super.eat();    //表现为：早期绑定
        System.out.println("猫吃鱼");
    }
}