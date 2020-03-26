# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/en/1.0.0/)
and this project adheres to [Semantic Versioning](http://semver.org/spec/v2.0.0.html).

## [0.9.0] - 2020-03-26

### Added
- Support for MySQL

### Dependencies
- CUBA 7.2.x
- taggable 0.6.0
- entity-soft-reference 0.7.0
- declarative-controllers 0.10.0

## [0.8.0] - 2020-01-29

### Added
- Support for showing Attachments in Edit Screen (#23)

## [0.7.0] - 2019-10-19

### Dependencies
- CUBA 7.1.x
- taggable 0.5.3
- entity-soft-reference 0.6.5
- declarative-controllers 0.9.0

## [0.6.0] - 2019-10-19

### Added
- CUBA 7 screen API support (`WithAttachmentsSupport` interface)

### Dependencies
- CUBA 7.0.x
- taggable 0.4.0
- entity-soft-reference 0.5.1
- declarative-controllers 0.8.0

## [0.5.0] - 2019-05-21

### Dependencies
- CUBA 6.10.x
- taggable 0.3.0
- entity-soft-reference 0.4.0
- declarative-controllers 0.7.0

## [0.4.2] - 2018-07-21

### Dependencies
- taggable 0.2.3

## [0.4.1] - 2018-07-20

### Dependencies
- taggable 0.2.2
- entity-soft-reference 0.3.2
- declarative-controllers 0.6.0

## [0.4.0] - 2018-07-20

### Added

- PostgreSQL support
- Categories of attachments (#1)
- bugfix for NPE for entity names as attachables that are not valid anymore (#13)
- Administration screens for `Attachments` and `Attachment Categories` under `Administration > Attachments` (#1)

## [0.3.0] - 2018-07-15

### Added

- Possibility to add Tags to Attachments (#1)
- Multi Upload for attachments (#3)
- Drag & Drop while uploading files (#5)
- bugfix for erasing name after file upload (#2)

## [0.2.0] - 2018-07-14

### Dependencies
- CUBA 6.9.x

## [0.1.0] - 2018-02-11

### Added

- ability to add attachments to any Entity (`@WithAttachments`)


### Dependencies
- CUBA 6.8.x
