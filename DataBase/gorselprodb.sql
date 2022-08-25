use gorselprodb;
create table work_tb(
work_id int not null auto_increment,
work_name varchar(255) not null,
work_price long not null,
primary key (work_id)
)