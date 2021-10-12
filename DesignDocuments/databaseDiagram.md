# NICUWatch Schema
## Users
    ID
    Username
    Firstname
    Lastname
    AuthKey
    

## Account preferences
    Name
    email


## Reports
    Ref#
    Doctor
    Test
    Result
    Notes

## Vitals
    generated(
        RR(Resperatory rate)
        HR(Heart Rate)
        Sp02(oxygen level)
    )
    

# Things to think about
- Should there be a Table for doctors?
- Sould there be a table for the types of results? 
    - On table for test results. This requires a standard type of result that has more data than a regular result (ie. physician visit.)