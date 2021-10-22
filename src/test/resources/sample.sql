delete from doctors;
delete from patient;
delete from reports;
ALTER TABLE reports AUTO_INCREMENT = 1;
insert into NICUWatchtest.Doctors (docId, firstName, lastName, tenure) values ('bWallis', 'Brad', 'Wallis', 3), ('jMadden', 'John', 'Madden', 7), ('mWilliams', 'Mary', 'Williams', 25);
insert into NICUWatchtest.Patient (patientId, firstName, lastName, birthDate) values  ('jDoe', 'Jon', 'Doe', '2021-08-07');
insert into NICUWatchtest.reports (ref, patientId, docId, Test, Result, Notes) values  (1, 'jDoe', 'bWallis', 'Lung Infection', 'Positive', 'Not a problem to be worried about.'), (2, 'jDoe', 'bWallis', 'Memory', 'Its Fine', 'Further testing needs to be done next week.'), (3, 'jDoe', 'mWilliams', 'Leg SStuff', 'Its Fine', 'I said its fine!');
