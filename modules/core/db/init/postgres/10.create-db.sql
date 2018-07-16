-- begin DDCA_ATTACHEMENT
create table DDCA_ATTACHEMENT (
    ID uuid,
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
    FILE_ID uuid,
    --
    primary key (ID)
)^
-- end DDCA_ATTACHEMENT
