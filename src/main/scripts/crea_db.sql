--Create table
create table avatar(
	id serial primary key,
	name varchar(25),
	file_name varchar(25) not null,
	from_user boolean default false
);

create table chaine_resto(
	id serial primary key,
	name varchar(25),
	www varchar(25),
	description varchar(25),
		logo integer
);

create table commentaire(
	id serial primary key,
	note integer check(note >= 0 and note <= 10),
	text text not null,
	date date,
		resto integer not null,
		utilisateur integer not null
);

create table country(
	id serial primary key,
	name varchar(25) not null
);

create table droit(
	id serial primary key,
	name varchar(25) not null,
	description varchar(25)
);

create table groupe(
	id serial primary key,
	name varchar(25) not null,
	description varchar(25),
		avatar integer not null
);

create table logo(
	id serial primary key,
	name varchar(25) not null,
	file_name varchar(25) not null,
		chaine_resto integer
);

create table photo(
	id serial primary key,
	name varchar(25) not null,
	info varchar(50) not null,
	date date not null,
	file_name varchar(25) not null,
		utilisateur integer not null,
		resto integer not null
);

create table resto(
	id serial primary key,
	name varchar(25) not null,
	address varchar(50) not null,
	tel varchar(7),
	www varchar(100),
	description varchar(100),
	last_verif date not null,
		logo integer,
		town integer,
		chaine_resto integer
	
);

create table tag(
	id serial primary key,
	name varchar(25) not null
);

create table town(
	id serial primary key,
	name varchar(25) not null,
		country integer not null
);

create table utilisateurs(
	id serial primary key,
	first_name varchar(25),
	last_name varchar(25),
	username varchar(25) not null,
	inscription_date date not null,
	password text not null,
	valide boolean default false,
		avatar integer
);

--relation table
create table resto_tag(
	resto_id integer,
	tag_id integer,
	foreign key (resto_id) REFERENCES resto (id),
	foreign key (tag_id) REFERENCES tag (id)
);

create table chaine_town(
	town_id integer,
	chaine_resto_id integer,
	foreign key (town_id) REFERENCES town (id),
	foreign key (chaine_resto_id) REFERENCES chaine_resto (id)
);

create table user_resto(
	utilisateur_id integer,
	resto_id integer,
	foreign key (utilisateur_id) REFERENCES utilisateurs (id),
	foreign key (resto_id) REFERENCES resto (id)
);

create table user_groupe(
	utilisateur_id integer,
	groupe_id integer,
	foreign key (utilisateur_id) REFERENCES utilisateurs (id),
	foreign key (groupe_id) REFERENCES groupe (id)
);

create table groupe_droit(
	groupe_id integer,
	droit_id integer,
	foreign key (groupe_id) REFERENCES groupe (id),
	foreign key (droit_id) REFERENCES droit (id)
);


--Adding FK

alter table chaine_resto ADD CONSTRAINT fk_chaine_logo FOREIGN KEY (logo) REFERENCES logo (id);

alter table commentaire ADD CONSTRAINT fk_comm_resto FOREIGN KEY (resto) REFERENCES resto (id);
alter table commentaire ADD CONSTRAINT fk_comm_user FOREIGN KEY (utilisateur) REFERENCES utilisateurs (id);

alter table groupe ADD CONSTRAINT fk_groupe_avatar FOREIGN KEY (avatar) REFERENCES avatar (id);

alter table logo ADD CONSTRAINT fk_logo_chaine FOREIGN KEY (chaine_resto) REFERENCES logo (id);

alter table photo ADD CONSTRAINT fk_photo_user FOREIGN KEY (utilisateur) REFERENCES utilisateurs (id);
alter table photo ADD CONSTRAINT fk_photo_resto FOREIGN KEY (resto) REFERENCES resto (id);

alter table resto ADD CONSTRAINT fk_resto_logo FOREIGN KEY (logo) REFERENCES logo (id);
alter table resto ADD CONSTRAINT fk_resto_town FOREIGN KEY (town) REFERENCES town (id);
alter table resto ADD CONSTRAINT fk_resto_chaine FOREIGN KEY (chaine_resto) REFERENCES chaine_resto (id);

alter table town ADD CONSTRAINT fk_town_country FOREIGN KEY (country) REFERENCES country (id);

alter table utilisateurs ADD CONSTRAINT fk_user_avatar FOREIGN KEY (avatar) REFERENCES avatar (id);



