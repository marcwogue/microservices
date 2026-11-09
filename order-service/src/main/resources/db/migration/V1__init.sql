
create table orders (
    quantity integer not null,
    create_at timestamp(6) with time zone not null,
    id uuid not null,
    status varchar(20) not null check ((status in ('CREATED','CONFIRMED','CANCELED'))),
    costumer varchar(100) not null,
    product varchar(100) not null,
    primary key (id)
)