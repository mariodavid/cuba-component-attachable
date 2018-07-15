package de.diedavids.cuba.attachable.web.attachment

import com.haulmont.cuba.core.entity.FileDescriptor
import com.haulmont.cuba.gui.data.Datasource
import de.diedavids.cuba.attachable.entity.Attachment
import spock.lang.Specification

class AttachmentNameExtractorSpec extends Specification {

    def "a file upload sets the name of the attachment from the filename"() {

        given:
        def sut = new AttachmentNameExtractor()

        and:
        def attachment = new Attachment()
        def fileDescriptor = Mock(FileDescriptor)
        fileDescriptor.getName() >> "hello"
        def event = new Datasource.ItemPropertyChangeEvent(Mock(Datasource), attachment,  "file", null, fileDescriptor)

        when:
        sut.itemPropertyChanged(event)

        then:
        attachment.name == "hello"

    }
    def "a file upload cuts off the file extension for the name"() {

        given:
        def sut = new AttachmentNameExtractor()

        and:
        def attachment = new Attachment()
        def fileDescriptor = Mock(FileDescriptor)
        fileDescriptor.getName() >> "hello.png"
        def event = new Datasource.ItemPropertyChangeEvent(Mock(Datasource), attachment,  "file", null, fileDescriptor)

        when:
        sut.itemPropertyChanged(event)

        then:
        attachment.name == "hello"

    }

    def "a file upload does not set the name of the attachment if there is already a name defined"() {

        given:
        def sut = new AttachmentNameExtractor()

        and:
        def attachment = new Attachment(name: "first name")
        def fileDescriptor = Mock(FileDescriptor)
        fileDescriptor.getName() >> "second name.png"
        def event = new Datasource.ItemPropertyChangeEvent(Mock(Datasource), attachment,  "file", null, fileDescriptor)

        when:
        sut.itemPropertyChanged(event)

        then:
        attachment.name == "first name"

    }
}
