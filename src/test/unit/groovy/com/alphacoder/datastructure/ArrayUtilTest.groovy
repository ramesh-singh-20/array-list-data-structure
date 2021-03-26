package com.alphacoder.datastructure

import spock.lang.Specification

import java.util.logging.Handler

class ArrayUtilTest extends Specification{

    def 'Test ArrayList | isEmpty() | empty list'(){
        given:
        def arr= new ArrayList();

        when:
        def result= arr.isEmpty();

        then:
        result== true
    }

    def 'Test ArrayList | size() | Size is 0'(){
        given:
        def arr= new ArrayList();

        when:
        def result= arr.size()

        then:
        result==0
    }

    def 'Test ArrayList | non empty list'(){
        given:
        def arr= new ArrayList();

        when:
        arr.insert(1, 0)

        then:
        arr.isEmpty()== false

        and:
        arr.size()== 1
        arr.get(0)== 1

    }


    def 'Test ArrayList | ArrayIndexOutOfBoundsException'(){
        given:
        def arr= new ArrayList();

        when:
        arr.insert(1, 2)

        then:
        thrown(ArrayIndexOutOfBoundsException)

    }

    def 'Test ArrayList | ArrayIndexOutOfBoundsException with -ve index'(){
        given:
        def arr= new ArrayList();

        when:
        arr.insert(1, -1)

        then:
        thrown(ArrayIndexOutOfBoundsException)

    }

    def 'Test ArrayList | multiple inserts'(){
        given:
        def arr= new ArrayList();

        when:
        arr.insert(5,0)
        arr.insert(3, 1)
        arr.insert(8, 2)
        arr.insert(4, 3)

        then:
        arr.isEmpty()== false

        and:
        arr.size()== 4
        arr.get(0)== 5
        arr.get(1)== 3
        arr.get(2)== 8
        arr.get(3)== 4

    }
}
