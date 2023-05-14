-- GLB region schema and data
-- see https://www.baeldung.com/hikaricp
create table region(
    id numeric,
    name  varchar(14),
    constraint pk_region primary key ( id )
);
insert into region values( 1, 'GLB');
select * from region;