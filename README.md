[ ![Download](https://api.bintray.com/packages/mariodavid/cuba-components/cuba-component-attachable/images/download.svg) ](https://bintray.com/mariodavid/cuba-components/cuba-component-attachable/_latestVersion)
[![license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0)
[![Build Status](https://travis-ci.org/mariodavid/cuba-component-attachable.svg?branch=master)](https://travis-ci.org/mariodavid/cuba-component-attachable)
[![Coverage Status](https://coveralls.io/repos/github/mariodavid/cuba-component-attachable/badge.svg)](https://coveralls.io/github/mariodavid/cuba-component-attachable)

# CUBA Platform Component - Attachable

This application component lets you easily add attachments to any entity in your application.


Just add `@WithAttachments` on the browse screen of your entity and the rest will be done by this app-component.

![1-browse-with-attachments](https://github.com/mariodavid/cuba-component-attachable/blob/master/img/1-browse-with-attachments.png)


## Installation

1. `attachable` is available in the [CUBA marketplace](https://www.cuba-platform.com/marketplace)
2. Select a version of the add-on which is compatible with the platform version used in your project:

| Platform Version | Add-on Version |
| ---------------- | -------------- |
| 6.10.x           | 0.4.x          |
| 6.9.x            | 0.2.x - 0.3.x  |
| 6.8.x            | 0.1.x          |


The latest version is: [ ![Download](https://api.bintray.com/packages/mariodavid/cuba-components/cuba-component-attachable/images/download.svg) ](https://bintray.com/mariodavid/cuba-components/cuba-component-attachable/_latestVersion)

Add custom application component to your project:

* Artifact group: `de.diedavids.cuba.attachable`
* Artifact name: `attachable-global`
* Version: *add-on version*


## Supported DBMS

The following databases are supported by this application component:

* HSQLDB
* PostgreSQL


## Usage

To add attachments to your entity, you have to add the following annotation to your browse / edit screen controller:

```
@WithAttachments(listComponent = "customersTable")
public class CustomerBrowse extends AnnotatableAbstractLookup {
}
```

For the `@WithAttachments` annotation you need to define the list component on which it should add the attachments button.
Normally this is the `id` of the table you defined in your browse screen.

This annotation will create a button in the buttonsPanel of the table and add the Attachments button after the default CUBA buttons.

The `@WithAttachments` annotations can be customized through the following attributes:

* `String listComponent` - the id of the list component / table where the button will be added - REQUIRED
* `String buttonId` - the id of the newly created button that will be created ("attachmentBtn" by default)
* `String buttonsPanel` - the id of the buttons panel where the new button will be added ("buttonsPanel" by default)


### Example usage
To see this application component in action, check out this example: [cuba-example-using-attachable](https://github.com/mariodavid/cuba-example-using-attachable).


### Attachment list

The attachment button will show all attachments that have been added to a particular selected entity.
It allows to add, edit & remove attachments to this entity.
![2-attachments-list](https://github.com/mariodavid/cuba-component-attachable/blob/master/img/2-attachments-list.png)

### Attachment preview
Furthermore it gives the user the option to preview the attachment directly in the browser or download the attachment.
 
![3-attachment-preview](https://github.com/mariodavid/cuba-component-attachable/blob/master/img/3-attachment-preview.png)

The ability to do the preview depends on the attachment type and the browser capabilities.

### Configuration options

The application components adds the following application properties, that can be changed in the corresponding screen (`Administration > Application Properties):

* `attachable.updateAttachmentCounterOnSelect` - whether or not a counter of attachments should be displayed after a particular entity is selected in the table
