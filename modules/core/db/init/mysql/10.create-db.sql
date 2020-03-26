-- begin DDCA_ATTACHEMENT
create table DDCA_ATTACHEMENT (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    ATTACHABLE varchar(255) not null,
    FILE_ID varchar(32),
    CATEGORY_ID varchar(32),
    --
    primary key (ID)
)^
-- end DDCA_ATTACHEMENT
-- begin DDCA_ATTACHMENT_CATEGORY
create table DDCA_ATTACHMENT_CATEGORY (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    CODE varchar(255),
    --
    primary key (ID)
)^
-- end DDCA_ATTACHMENT_CATEGORY
