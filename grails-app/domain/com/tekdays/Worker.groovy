package com.tekdays

class Worker {
    String name
    Integer age
    Date lastVisit
    static constraints = {
    }


    String toString() {
        "$name:$age"
    }
}
