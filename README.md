[ ![Download](https://api.bintray.com/packages/mariodavid/cuba-components/cuba-component-attachable/images/download.svg) ](https://bintray.com/mariodavid/cuba-components/cuba-component-attachable/_latestVersion)
[![license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0)
[![Build Status](https://travis-ci.org/mariodavid/cuba-component-attachable.svg?branch=master)](https://travis-ci.org/mariodavid/cuba-component-attachable)
[![Coverage Status](https://coveralls.io/repos/github/mariodavid/cuba-component-attachable/badge.svg)](https://coveralls.io/github/mariodavid/cuba-component-attachable)

# CUBA Platform Component - Attachable

This application component lets you easily add attachments to any entity in your application.


Just add `@WithAttachments` on the browse screen of your entity and the rest will be done by this app-component.

![1-browse-with-attachments](https://github.com/mariodavid/cuba-component-attachable/blob/master/img/1-browse-with-attachments.png)


## Attachments

To add attachments to your entity, you have to add the following annotation to your Browse / Edit screen controller:

```
@WithAttachments(listComponent = "customersTable")
public class CustomerBrowse extends AnnotatableAbstractLookup {
}
```

For the `@WithAttachments` annotation you need to define the list component on which it should add the attachments button.
Normally this is the `id` of the Table you defined in your browse screen.

NOTE: to make the Annotation work, you need to extend your screen from `AnnotatableAbstractLookup` instead of `AbstractLookup`.
This superclass is part of the app-component: [cuba-component-declarative-controllers](https://github.com/balvi/cuba-component-declarative-controllers),
which is a requirement for this app component.

Technically it is not required to directly add the dependency to this app component, since `attachable` already has a dependency on it.
However: since you directly depend on the app component (since you have to extend `AnnotatableAbstractLookup`), it is a best practice, to explicitly declare the dependency to it.


## Installation

1. Add the following maven repository `https://dl.bintray.com/mariodavid/cuba-components` to the build.gradle of your CUBA application:


    buildscript {
        
        //...
        
        repositories {
        
            // ...
        
            maven {
                url  "https://dl.bintray.com/mariodavid/cuba-components"
            }
        }
        
        // ...
    }

2. Select a version of the add-on which is compatible with the platform version used in your project:

| Platform Version | declarative-controllers | Add-on Version |
| ---------------- | -------------- | -------------- |
| 6.8.x            | 0.4.x          | 0.1.x          |


The latest version is: [ ![Download](https://api.bintray.com/packages/mariodavid/cuba-components/cuba-component-attachable/images/download.svg) ](https://bintray.com/mariodavid/cuba-components/cuba-component-attachable/_latestVersion)

Add custom application component to your project:

* Artifact group: `de.diedavids.cuba.attachable`
* Artifact name: `attachable-global`
* Version: *add-on version*

3. install the compatible version of [cuba-component-declarative-controllers](https://github.com/balvi/cuba-component-declarative-controllers) as another dependecy (see Table from 2. for version compatability).

![2-attachments-list](https://github.com/mariodavid/cuba-component-attachable/blob/master/img/2-attachments-list.png)


![3-attachment-preview](https://github.com/mariodavid/cuba-component-attachable/blob/master/img/3-attachment-preview.png)