package com.kaede.chapter05;

public class Lambda {
    public static void main(String[] args) {
        Lambda lambda = new Lambda();

        Func func = s-> {
            return true;
        };

        lambda.lambda(func);

        lambda.lambda(s-> {
            return false;
        });
    }

    public void lambda(Func func) {
        return;
    }
}

interface Func {
    boolean func(String str);
}
