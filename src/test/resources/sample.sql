delete from reports;
delete from Doctor;
delete from Patient;
ALTER TABLE Doctor AUTO_INCREMENT = 1;
ALTER TABLE Patient AUTO_INCREMENT = 1;
ALTER TABLE reports AUTO_INCREMENT = 1;
insert into NICUWatchtest.Doctor (first_name, last_name, tenure) values ('Brad', 'Wallis', 3), ('John', 'Madden', 7), ('Mary', 'Williams', 25);
insert into NICUWatchtest.Patient (first_name, last_name, birth_date) values  ('Jon', 'Doe', '2021-08-07');
insert into NICUWatchtest.reports (ref, patientId, docId, Test, Result, Notes) values  (1, 1, 1, 'Lung Infection', 'Positive', 'Not a problem to be worried about.'), (2, 1, 1, 'Memory', 'Its Fine', 'Further testing needs to be done next week.'), (3, 1, 3, 'Leg SStuff', 'Its Fine', 'I said its fine!');