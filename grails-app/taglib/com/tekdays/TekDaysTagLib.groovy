package com.tekdays
class TekDaysTagLib {
//static encodeAsForTags = [tagName: 'raw']
    def pen = { attrs ->
        out << "<p> alo</p>"
    }
    def renderList = { attrs, body ->
        // reads the 'values' attribute from the attributes list
        def list = attrs.values
        // iterates and renders list values
        list.each {
            // uses the implicit 'out' variable to append content to the response
            out << "<span class=\"element\"> ${it} </span>"

        }
    }
    def messageThread = {attrs ->
        def messages = attrs.messages.findAll{msg -> !msg.parent}
        processMessages(messages, 0)
    }
    void processMessages(messages, indent){
        messages.each{ msg ->
            def body = "${msg?.author} - ${msg?.subject}"
            out << "<p style='height:35; margin-left:${indent * 20}px;'>"
            out << "${remoteLink(action:'showDetail', id:msg.id, update:'details', body)}"
            out << "</p>"
            def children = TekMessage.findAllByParent(msg)
            if (children){
                processMessages(children, indent + 1)
            }
        }
    }
}