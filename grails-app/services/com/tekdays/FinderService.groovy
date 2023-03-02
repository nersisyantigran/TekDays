package com.tekdays

import grails.transaction.Transactional
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Transactional
class FinderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskService.class)


    def serviceMethod() {

    }
    def findCompletedTasks(){
        LOGGER.info("Testing log 4j dfghj")

        Task.findAllByCompleted(true).each {it->println("${it.id} : ${it.title}")}
    }
    def findByTitleTasks(String param){
        Task.findAllByTitleLike("${param}").each {it->println("${it.id} : ${it.title}")}
    }
    def findUpdatedTasks(){
        Task.findAllByVersionGreaterThan(0).each { println it.id}
    }
    def findILike(){
        Task.findAllByTitleLike("ave").each {it->println("${it.id} : ${it.title}")}
    }
    def findMultiQuery(TekUser tekUser){
//        TekEvent.findAllByVolunteers('hayk')
//        println(TekEvent.findAllByVolunteers(tekUser))
         def f =TekEvent.findAll().findAll {
             it?.volunteers.contains(/*TekUser.get(10)*/ tekUser)
         }

        println f

    }
}
