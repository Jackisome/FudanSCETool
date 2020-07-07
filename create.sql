create table `user`(
	userID varchar(100) not null,
	userPassword varchar(100) not null,
	isAdministrator tinyint default 0,
	registerTime timestamp,
	ownedProjectNumber int default 0,
	primary key (userID));

create table project (
	projectID varchar(10) not null,
	projectName varchar(100) not null,
	createTime timestamp not null,
	programType varchar(10) not null,
	codeLanguage varchar(100) not null,
	PREC float default null,
	FLEX float default null,
	RESL float default null,
	TEAM float default null,
	PMAT float default null,
	realLoad float default null,
	projectStatus varchar(100),
	projectOwner varchar(100),
	primary key (projectID),
	foreign key (projectOwner) references `user`(userID));

create table stage1(
	projectID varchar(10) not null,
	size float not null,
	estimateLoad float default null,
	primary key (projectID),
	foreign key (projectID) references project(projectID));

create table stage2(
		projectID varchar(10) not null,
		size float not null,
		PCPX float not null,
		RUSE float not null,
		PDIF float not null,
		PERS float not null,
		PREX float not null,
		FCIL float not null,
		SCED float not null,
		estimateLoad float default null,
		primary key (projectID),
		foreign key (projectID) references project(projectID));

create table stage3(
		projectID varchar(10) not null,
		size float not null,
		RELY float not null,
		`DATA` float not null,
		CPLX float not null,
		TIME float not null,
		STOR float not null,
		VIRT float not null,
		RURE float not null,
		ACAP float not null,
		AEXP float not null,
		PCAP float not null,
		VEXP float not null,
		LEXP float not null,
		MODP float not null,
		TOOL float not null,
		SCED float not null,
		estimateLoad float default null,
		primary key (projectID),
		foreign key (projectID) references project(projectID));

create table historyProject(
	projectID varchar(10) not null,
	projectName varchar(100) not null,
	createTime timestamp not null,
	programType varchar(10) not null,
	codeLanguage varchar(100) not null,
	PREC float default null,
	FLEX float default null,
	RESL float default null,
	TEAM float default null,
	PMAT float default null,
	realLoad float default null,
	primary key (projectID));

create table historyStage1(
	projectID varchar(10) not null,
	size float not null,
	primary key (projectID),
	foreign key (projectID) references historyProject(projectID));

create table historyStage2(
		projectID varchar(10) not null,
		size float not null,
		PCPX float not null,
		RUSE float not null,
		PDIF float not null,
		PERS float not null,
		PREX float not null,
		FCIL float not null,
		SCED float not null,
		primary key (projectID),
		foreign key (projectID) references historyProject(projectID));

create table historyStage3(
		projectID varchar(10) not null,
		size float not null,
		RELY float not null,
		`DATA` float not null,
		CPLX float not null,
		TIME float not null,
		STOR float not null,
		VIRT float not null,
		RURE float not null,
		ACAP float not null,
		AEXP float not null,
		PCAP float not null,
		VEXP float not null,
		LEXP float not null,
		MODP float not null,
		TOOL float not null,
		SCED float not null,
		primary key (projectID),
		foreign key (projectID) references historyProject(projectID));

create table feedback(
	feedbackTime timestamp not null,
	userID varchar(100) not null,
	feedbackContent varchar(1000),
	feedbackStatus varchar(100),
	foreign key (userID) references `user`(userID));