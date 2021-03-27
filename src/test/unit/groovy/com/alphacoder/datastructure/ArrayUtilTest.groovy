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

    def 'Test ArrayList | isEmpty() | non empty list'(){
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


    def 'Test ArrayList | insert() | ArrayIndexOutOfBoundsException'(){
        given:
        def arr= new ArrayList();

        when:
        arr.insert(1, 2)

        then:
        thrown(ArrayIndexOutOfBoundsException)

    }

    def 'Test ArrayList | insert() | ArrayIndexOutOfBoundsException with -ve index'(){
        given:
        def arr= new ArrayList();

        when:
        arr.insert(1, -1)

        then:
        thrown(ArrayIndexOutOfBoundsException)

    }

    def 'Test ArrayList | insert() | multiple inserts at end'(){
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

    def 'Test ArrayList | insert() | insert at the start'(){
        given:
        def arr= new ArrayList();

        when:
        arr.insert(5,0)
        arr.insert(3, 1)
        arr.insert(8, 2)
        arr.insert(4, 3)
        arr.insert(9, 0)

        then:
        arr.isEmpty()== false

        and:
        arr.size()== 5
        arr.get(0)== 9
        arr.get(1)== 5
        arr.get(2)== 3
        arr.get(3)== 8
        arr.get(4)== 4
    }

    def 'Test ArrayList | insert() | multiple inserts in between'(){
        given:
        def arr= new ArrayList();

        when:
        arr.insert(5,0)
        arr.insert(3, 1)
        arr.insert(8, 2)
        arr.insert(4, 3)

        arr.insert(6, 2)
        arr.insert(9, 3)
        arr.insert(3, 6)

        then:
        arr.isEmpty()== false

        and:
        arr.size()== 7
        arr.get(0)== 5
        arr.get(1)== 3
        arr.get(2)== 6
        arr.get(3)== 9
        arr.get(4)== 8
        arr.get(5)== 4
        arr.get(6)== 3

    }

    def 'Test ArrayList | update() | success'(){
        given:
        def arr= new ArrayList();

        when:
        arr.insert(5,0)
        arr.insert(3, 1)
        arr.insert(8, 2)
        arr.insert(4, 3)
        arr.insert(9, 0)

        arr.update(6, 2)

        then:
        arr.isEmpty()== false

        and:
        arr.size()== 5
        arr.get(0)== 9
        arr.get(1)== 5
        arr.get(2)== 6
        arr.get(3)== 8
        arr.get(4)== 4
    }

    def 'Test ArrayList | update() | ArrayIndexOutOfBoundsException with -ve index'(){
        given:
        def arr= new ArrayList();

        when:
        arr.insert(5,0)
        arr.insert(3, 1)
        arr.insert(8, 2)
        arr.insert(4, 3)
        arr.insert(9, 0)

        arr.update(6, -1)

        then:
        thrown(ArrayIndexOutOfBoundsException)
    }

    def 'Test ArrayList | update() | ArrayIndexOutOfBoundsException'(){
        given:
        def arr= new ArrayList();

        when:
        arr.insert(5,0)
        arr.insert(3, 1)
        arr.insert(8, 2)
        arr.insert(4, 3)
        arr.insert(9, 0)

        arr.update(6, 5)

        then:
        thrown(ArrayIndexOutOfBoundsException)
    }

    def 'Test ArrayList | delete() | ArrayIndexOutOfBoundsException with -ve index'(){
        given:
        def arr= new ArrayList();

        when:
        arr.insert(5,0)
        arr.insert(3, 1)
        arr.insert(8, 2)
        arr.insert(4, 3)
        arr.insert(9, 0)

        arr.delete(-1)

        then:
        thrown(ArrayIndexOutOfBoundsException)
    }

    def 'Test ArrayList | delete() | ArrayIndexOutOfBoundsException'(){
        given:
        def arr= new ArrayList();

        when:
        arr.insert(5,0)
        arr.insert(3, 1)
        arr.insert(8, 2)
        arr.insert(4, 3)
        arr.insert(9, 0)

        arr.delete(5)

        then:
        thrown(ArrayIndexOutOfBoundsException)
    }

    def 'Test ArrayList | delete() | delete at start'(){
        given:
        def arr= new ArrayList();

        when:
        arr.insert(5,0)
        arr.insert(3, 1)
        arr.insert(8, 2)
        arr.insert(4, 3)

        arr.delete(0)

        then:
        arr.size()== 3

        and:
        arr.get(0)== 3
        arr.get(1)== 8
        arr.get(2)== 4
    }

    def 'Test ArrayList | delete() | delete at end'(){
        given:
        def arr= new ArrayList();

        when:
        arr.insert(5,0)
        arr.insert(3, 1)
        arr.insert(8, 2)
        arr.insert(4, 3)

        arr.delete(3)

        then:
        arr.size()== 3

        and:
        arr.get(0)== 5
        arr.get(1)== 3
        arr.get(2)== 8
    }

    def 'Test ArrayList | delete() | multiple deletes in between'(){
        given:
        def arr= new ArrayList();

        when:
        arr.insert(5,0)
        arr.insert(3, 1)
        arr.insert(8, 2)
        arr.insert(4, 3)

        arr.delete(1)
        arr.delete(1)
        arr.delete(1)

        then:
        arr.size()== 1

        and:
        arr.get(0)== 5
    }

    def 'Test ArrayList | check automatic increment of array'(){
        given:
        def arr= new ArrayList();

        when:
        for(int i=0; i<15;i++){
            arr.insert(i,i);
        }

        arr.insert(16, 15)

        then:
        arr.size()== 16
        and:
        arr.get(15)== 16

    }
}
