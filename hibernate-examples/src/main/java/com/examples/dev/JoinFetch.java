package com.examples.dev;

import com.examples.dev.sessionfactory.SingletonSessionFactory;

public class JoinFetch {

    public static void main(String[] args){

    	System.out.println("Join fetch"+SingletonSessionFactory.getSession());
    }

}
