package com.tekdays

import grails.transaction.Transactional
import org.hibernate.envers.query.AuditQuery

@Transactional
class RevisionsService {

    def serviceMethod() {

    }

    def revisions(Class aClass) {
        def auditQueryCreator = AuditReaderFactory.get(sessionFactory.currentSession).createQuery()

        def revisionList = []
        AuditQuery query = auditQueryCreator.forRevisionsOfEntity(aClass, false, true)
        query.resultList.each {
            if(it[0].id==params.getLong('id')) {
                revisionList.add(it)
            }
        }
        [revisionList: revisionList]
    }



}
