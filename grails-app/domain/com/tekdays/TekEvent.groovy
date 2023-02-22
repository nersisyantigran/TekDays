package com.tekdays

class TekEvent {

    String city
    String name
    TekUser organizer
    String venue
    Date startDate
    Date endDate
    String description

    static hasMany = [volunteers : TekUser,
                      respondents: String,
                      sponsorship: Sponsorship,
                      tasks      : Task,
                      messages   : TekMessage]

    static constraints = {
        name()
        city()
        description maxSize: 5000
        organizer()
        venue()
        startDate()
        endDate()
        sponsorship nullable: true
        tasks nullable: true
        messages nullable: true
    }

    String toString() {
        "$name, $city"
    }
}
