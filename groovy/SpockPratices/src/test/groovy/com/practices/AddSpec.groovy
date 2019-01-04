package com.practices
import com.practices.Add
import spock.lang.Specification;

class AddSpec extends Specification {

    def "Add_two_numbers" () {
        when: "Initializing Class"
        def add = new Add()
        then: "Sum of two numbers"
        add.add(1,2) == 3
    }
}
