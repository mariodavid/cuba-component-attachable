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
| 7.1.x            | 0.7.x          |
| 7.0.x            | 0.6.x          |
| 6.10.x           | 0.5.x          |
| 6.9.x            | 0.2.x - 0.4.x  |
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

All other DBMS systems are supported in the way, that CUBA studio automatically creates DDL scripts.
Therefore it is totally possible to use the application component even without dedicated SQL scripts directly from this application component.

## Using the application component

### Browse Screens

Annotate your browse screens with the `@WithAttachments` annotation or by implementing the `WithAttachmentsSupport` interface,
depending on which version of CUBA screen APIs is used in the target screen.

#### @WithAttachments annotation (CUBA 6 screens)

```groovy
@WithAttachments(listComponent = "productsTable")
class ProductBrowse extends AnnotatableAbstractLookup {
}
```


For the `@WithAttachments` annotation you need to define the list component on which it should add the attachments button.
Normally this is the `id` of the table you defined in your browse screen.

This annotation will create a button in the buttonsPanel of the table and add the Attachments button after the default CUBA buttons.

The `@WithAttachments` annotations can be customized through the following attributes:

* `String listComponent` - the id of the list component / table where the button will be added - REQUIRED
* `String buttonId` - the id of the newly created button that will be created ("attachmentBtn" by default)
* `String buttonsPanel` - the id of the buttons panel where the new button will be added ("buttonsPanel" by default)


#### WithAttachmentsSupport interface (CUBA 7 screens)

```java

public class CustomerBrowse extends StandardLookup<Customer> implements WithAttachmentsSupport {

    @Inject
    protected GroupTable<Customer> customersTable;

    @Inject
    protected ButtonsPanel buttonsPanel;

    @Override
    public ListComponent getListComponentForAttachments() {
        return customersTable;
    }

    @Override
    public ButtonsPanel getButtonsPanelForAttachments() {
        return buttonsPanel;
    }

    @Override
    public WindowManager.OpenType attachmentListOpenType() {
        return WindowManager.OpenType.NEW_TAB;
    }
}
```

In the Interface variant the following attributes have to be defined by implementing methods instead of annotation attributes:

* `getListComponentForAttachments` defines the list component to target for the attachable functionality
* `getButtonsPanelForAttachments` defines the button panel on which a button will be placed
* `attachmentListOpenType` optionally defines the open type for the attachment list



### Edit Screens (CUBA 7 screens)

Besides using Attachments in the Browse Screen of the Entity, it is also possible to show Attachments as part of an Edit Screen.

In order to do display attachments of a particular Entity there is a `fragment` which can be used in the Edit Screen:

```xml
<fragment screen="ddca_EntityAttachmentsFragment">
    <properties>
        <property name="attachableDc" ref="customerDc"/>
    </properties>
</fragment>
```

An example can be found in the [customer-edit.xml](https://github.com/mariodavid/cuba-example-using-attachable/blob/master/modules/web/src/com/company/ceua/web/customer/customer-edit.xml#L53).

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
