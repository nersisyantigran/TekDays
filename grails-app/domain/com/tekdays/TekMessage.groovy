package com.tekdays

class TekMessage {

    String subject
    String content
    TekMessage parent
    TekEvent event
    TekUser author

    static belongsTo = TekEvent

    static constraints = {
        subject blank: false
        content blank: false, maxSize: 2000
        parent nullable: true
        author nullable: false
    }

    String toString() { author }
}
