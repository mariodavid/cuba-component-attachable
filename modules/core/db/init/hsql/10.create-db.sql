-- begin DDCA_ATTACHEMENT
create table DDCA_ATTACHEMENT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    ATTACHABLE varchar(255) not null,
    FILE_ID varchar(36),
    CATEGORY_ID varchar(36),
    --
    primary key (ID)
)^
-- end DDCA_ATTACHEMENT
-- begin DDCA_ATTACHMENT_CATEGORY
create table DDCA_ATTACHMENT_CATEGORY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    CODE varchar(255),
    --
    primary key (ID)
)^
-- end DDCA_ATTACHMENT_CATEGORY
