package com.practices

import spock.lang.Specification

class ListSpec extends Specification {
    def "test_list_java"() {
        given: "A empty List"
        List<Integer> list = new ArrayList<>();
        when:"adding one to list"
        list.add(1)
        then:"checking the output"
        list.get(0) == 1
    }
}
