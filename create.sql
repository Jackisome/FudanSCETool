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
	PREC varchar(20) default null,
	FLEX varchar(20) default null,
	RESL varchar(20) default null,
	TEAM varchar(20) default null,
	PMAT varchar(20) default null,
	realLoad double default null,
	projectStatus varchar(100),
	projectOwner varchar(100),
	primary key (projectID),
	foreign key (projectOwner) references `user`(userID));

create table stage1(
	projectID varchar(10) not null,
	size double not null,
	estimateLoad double default null,
	primary key (projectID),
	foreign key (projectID) references project(projectID));

create table stage2(
		projectID varchar(10) not null,
		size double not null,
		PCPX varchar(20) not null,
		RUSE varchar(20) not null,
		PDIF varchar(20) not null,
		PERS varchar(20) not null,
		PREX varchar(20) not null,
		FCIL varchar(20) not null,
		SCED varchar(20) not null,
		estimateLoad double default null,
		primary key (projectID),
		foreign key (projectID) references project(projectID));

create table stage3(
		projectID varchar(10) not null,
		size double not null,
		RELY varchar(20) not null,
    `DATA` varchar(20) not null,
    DOCU varchar(20) not null,
    CPLX varchar(20) not null,
    RUSE varchar(20) not null,
    ACAP varchar(20) not null,
    AEXP varchar(20) not null,
    PCAP varchar(20) not null,
    PEXP varchar(20) not null,
    LTEX varchar(20) not null,
    PCON varchar(20) not null,
    TIME varchar(20) not null,
    STOR varchar(20) not null,
    PVOL varchar(20) not null,
    TOOL varchar(20) not null,
    SCED varchar(20) not null,
    SITE varchar(20) not null,
		estimateLoad double default null,
		primary key (projectID),
		foreign key (projectID) references project(projectID));

create table historyProject(
	projectID varchar(10) not null,
	projectName varchar(100) not null,
	createTime timestamp not null,
	programType varchar(10) not null,
	codeLanguage varchar(100) not null,
	PREC varchar(20) default null,
	FLEX varchar(20) default null,
	RESL varchar(20) default null,
	TEAM varchar(20) default null,
	PMAT varchar(20) default null,
	realLoad double default null,
	primary key (projectID));

create table historyStage1(
	projectID varchar(10) not null,
	size double not null,
	primary key (projectID),
	foreign key (projectID) references historyProject(projectID));

create table historyStage2(
		projectID varchar(10) not null,
		size double not null,
		PCPX varchar(20) not null,
		RUSE varchar(20) not null,
		PDIF varchar(20) not null,
		PERS varchar(20) not null,
		PREX varchar(20) not null,
		FCIL varchar(20) not null,
		SCED varchar(20) not null,
		primary key (projectID),
		foreign key (projectID) references historyProject(projectID));

create table historyStage3(
		projectID varchar(10) not null,
		size double not null,
		RELY varchar(20) not null,
    `DATA` varchar(20) not null,
    DOCU varchar(20) not null,
    CPLX varchar(20) not null,
    RUSE varchar(20) not null,
    ACAP varchar(20) not null,
    AEXP varchar(20) not null,
    PCAP varchar(20) not null,
    PEXP varchar(20) not null,
    LTEX varchar(20) not null,
    PCON varchar(20) not null,
    TIME varchar(20) not null,
    STOR varchar(20) not null,
    PVOL varchar(20) not null,
    TOOL varchar(20) not null,
    SCED varchar(20) not null,
    SITE varchar(20) not null,
		primary key (projectID),
		foreign key (projectID) references historyProject(projectID));

create table feedback(
	feedbackTime timestamp not null,
	userID varchar(100) not null,
	feedbackContent varchar(1000),
	feedbackStatus varchar(100),
	foreign key (userID) references `user`(userID));
