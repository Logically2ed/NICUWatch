# NICUWatch Schema
## Users
    ID
    Username
    Firstname
    Lastname
    email

## Reports
    Ref#
    Doctor
    Patient
    Test
    Result
    Notes

## Doctors
    docid
    firstname
    lastname
    tenure

## Patient
    patientid
    firstname
    lastname
    dob

<hr>

# Maybe
    
## Vitals
    generated(
        RR(Resperatory rate)
        HR(Heart Rate)
        Sp02(oxygen level)
    )
    

# Things to think about
- Should there be a Table for doctors? YES
- Sould there be a table for the types of results? NO
    - On table for test results. This requires a standard type of result that has more data than a regular result (ie. physician visit.)