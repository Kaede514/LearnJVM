package com.kaede.chapter05;

//˵�����ڰ󶨺����ڰ󶨵�����

public class AnimalTest {
    public static void main(String[] args) {
        
    }

    public void showAnimal(Animal animal) {
        animal.eat();   //����Ϊ�����ڰ�
    }

    public void showHunt(Huntable hunt) {
        hunt.hunt();    //����Ϊ�����ڰ�
    }
}

class Animal {
    public void eat() {
        System.out.println("�����ʳ");
    }
}

interface Huntable {
    void hunt();
}

class Dog extends Animal implements Huntable {
    public Dog() {
        super();    //����Ϊ�����ڰ󶨣������ھ���ȷ��������
    }

    public Dog(String name) {
        this();     //����Ϊ�����ڰ�
    }

    @Override
    public void eat() {
        System.out.println("���Թ�ͷ"); 
    }

    @Override
    public void hunt() {
        System.out.println("��ʳ���ӣ��������");
    }
}

class Cat extends Animal {
    @Override
    public void eat() {
        super.eat();    //����Ϊ�����ڰ�
        System.out.println("è����");
    }
}