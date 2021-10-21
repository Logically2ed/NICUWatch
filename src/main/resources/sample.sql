create table NICUWatchtest.reports
(
    ref int auto_increment,
    Doctor varchar(20) not null,
    Test varchar(40) null,
    Result varchar(100) null,
    Notes varchar(255) null,
    constraint test_results_ref_uindex
        unique (ref)
)
    comment 'Test results of tests taken of the patient.';

INSERT INTO NICUWatchtest.reports (docId, Test, Result, Notes) VALUES ('doctor', 'Leg SStuff', 'Its Fine', 'I said its fine!');
INSERT INTO NICUWatchtest.reports (docId, Test, Result, Notes) VALUES ('doctor', 'Leg SStuff', 'Its Fine', 'I said its fine!');
INSERT INTO NICUWatchtest.reports (docId, Test, Result, Notes) VALUES ('doctor', 'Leg SStuff', 'Its Fine', 'I said its fine!');

