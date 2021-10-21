delete from reports;
ALTER TABLE reports AUTO_INCREMENT = 1;
INSERT INTO NICUWatchtest.reports (patientId, docId, Test, Result, Notes) VALUES ('jDoe', 'bWallis', 'Lung Infection', 'Positive', 'Not a problem to be worried about.');
INSERT INTO NICUWatchtest.reports (patientId, docId, Test, Result, Notes) VALUES ('jDoe', 'bWallis', 'Memory', 'Its Fine', 'Further testing needs to be done next week.');
INSERT INTO NICUWatchtest.reports (patientId, docId, Test, Result, Notes) VALUES ('jDoe', 'mWilliams', 'Leg SStuff', 'Its Fine', 'I said its fine!');