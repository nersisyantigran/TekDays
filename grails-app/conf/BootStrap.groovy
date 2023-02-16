import com.tekdays.*

class BootStrap {

    def init = { servletContext ->
        /*def event1 = new TekEvent(name: 'Gateway Code Camp',
                city: 'Saint Louis, MO',
                organizer: 'John Doe',
                venue: 'TBD',
                startDate: new Date('11/21/2013'),
                endDate: new Date('11/21/2013'),
                description: '''This conference will bring coders fromCamp.''')
        if (!event1.save()) {
            event1.errors.allErrors.each { error ->
                println error.defaultMessage
            }
        }

        def event2 = new TekEvent(name: 'Perl Before Swine',
                city: 'Austin, MN',
                organizer: 'John Deere',
                venue: 'SPAM Museum',
                startDate: new Date('11/2/2013'),
                endDate: new Date('11/2/2013'),
                description: '''Join the Perl programmers of the Pork Producersthere!''')

        if (!event2.save()) {
            event2.errors.allErrors.each { error ->
                println "EVENT2 DOSE NOT SAVED"
            }
        }*/
    }
    def destroy = {
    }
}
