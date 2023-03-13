package com.tekdays


import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TekEventController {

    TaskService taskService
    EventService eventService
    RevisionsService revisionsService
    DatatablesSourceService datatablesSourceService
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]



    def dataTablesRenderer() {
        def propertiesToRender = ["name", "city", "description", "venue", "startDate", "endDate","id"]
        def entityName = 'TekEvent'
        render  datatablesSourceService.dataTablesSource(propertiesToRender, entityName, params)
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond TekEvent.list(params),
                model: [tekEventInstanceCount: TekEvent.count()]
    }

    def show(TekEvent tekEventInstance) {
        respond tekEventInstance
    }

    def create() {
        respond new TekEvent(params)
    }

    @Transactional
    def save(TekEvent tekEventInstance) {
        if (tekEventInstance == null) {
            notFound()
            return
        }

        if (tekEventInstance.hasErrors()) {
            respond tekEventInstance.errors, view: 'create'
            return
        }

        tekEventInstance.save flush: true
        eventService.addRespondents(tekEventInstance)

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message',
                        args: [message(code: 'tekEventInstance.label',
                                default: 'TekEvent'), tekEventInstance.id])
                redirect tekEventInstance
            }
            '*' { respond tekEventInstance, [status: CREATED] }
        }
    }

    def edit(TekEvent tekEventInstance) {
        respond tekEventInstance
    }

    @Transactional
    def update(TekEvent tekEventInstance) {
        if (tekEventInstance == null) {
            notFound()
            return
        }

        if (tekEventInstance.hasErrors()) {
            respond tekEventInstance.errors, view: 'edit'
            return
        }
        tekEventInstance.save flush: true
        eventService.addRespondents(tekEventInstance)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'TekEvent.label', default: 'TekEvent'), tekEventInstance.id])
                redirect tekEventInstance
            }
            '*' { respond tekEventInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(TekEvent tekEventInstance) {

        if (tekEventInstance == null) {
            notFound()
            return
        }

        tekEventInstance.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'TekEvent.label', default: 'TekEvent'), tekEventInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tekEvent.label', default: 'TekEvent'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
    @Transactional
    def volunteer (){
        def event = TekEvent.get(params.id)
        event.addToVolunteers(session.user)
        event.city = "amsterdam"
        event.save(flush : true)
        render "Thank you for Volunteering"
    }
    @Transactional
    def revision(){
        def v= revisionsService.revisions(TekEvent.class)
        render(v)

    }


}
