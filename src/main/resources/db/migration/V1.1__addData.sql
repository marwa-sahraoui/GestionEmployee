insert into activities (id, days_of_work, days_off)
values (1, 80, 10);

insert into clients (id, name)
values (111, 'SG');

insert into consultants (id, date_of_birth, hiring_date, name, manager_id)
values (31, '1988-10-05', '20021-10-05', 'marwa', 11);

insert into missions (id, date, tgm)
values (145, '2022-10-10', 500);

insert into consultants_missions (consultant_id, mission_id)
values (31, 145);

insert into managers (id, date_of_birth, hiring_date, name)
values (11, '1990-10-05', '20021-05-05', 'toto');

insert into missions_clients (mission_id, client_id)
values (145, 111);

insert into payslips (id, date, salary)
values (1000, '2022-10-10', 3000);




