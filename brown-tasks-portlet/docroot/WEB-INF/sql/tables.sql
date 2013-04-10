create table sb_TaskItem (
	id_ LONG not null primary key,
	list LONG,
	label VARCHAR(75) null,
	weight INTEGER,
	description VARCHAR(75) null,
	status INTEGER
);

create table sb_TaskList (
	id_ LONG not null primary key,
	portlet VARCHAR(75) null,
	description VARCHAR(75) null,
	weight INTEGER
);