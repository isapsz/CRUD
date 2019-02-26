create table Clinicas(
codClinica int primary key not null,
nome varchar(30) not null,
cep int not null,
numero int not null,
complemento varchar(30) null
)

insert into Clinicas values(1, 'São Fransisco', 13030730, 123, null)
insert into Clinicas values(2, 'Tancredo Neves', 12035274, 646, 'Apto 3')
insert into Clinicas values(3, 'Luis de Souza', 13030420, 634, 'BL 04 APTO 103')
insert into Clinicas values(4, 'Marco Antônio', 14029630, 666, null)
insert into Clinicas values(5, 'Maria Azevedo', 43123853, 012, 'Apto 18')


