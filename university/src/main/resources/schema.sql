create table if not exists public.department
(
  id integer generated always as identity,
  name varchar(255) not null,
  primary key(id)
);


create table if not exists public.professor
(
  id integer generated always as identity,
  name varchar(255) not null,
  department_id integer not null,
  primary key(id)
);


create table if not exists public.course
(
  id integer generated always as identity,
  name varchar(255) not null,
  department_id integer not null,
  credits integer not null,
  primary key (id)
);


create table if not exists public.schedule
(
  id integer generated always as identity,
  professor_id integer not null,
  course_id integer not null,
  semester integer not null,
  year integer not null
  primary key (id)
);

