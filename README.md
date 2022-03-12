# SecondAssignment


category {
Id:"",
Name:"",
Description:""
}

ADD 
UPDATE
SHOW ALL

------------------------------------------------------

Asset{
Name:"",
Purchase_Date:"",
Condition_Note:"",
Category:"",
Assignment_Status:""
}

ADD
SHOW ALL
UPDATE
ASSIGN
RECOVER
DELETE

------------------------------------------------

category you need to add is like :
{
    "id":6,
    "name":"Name",
    "description":"description"
}

Asset you need to add like this:

{
    "name":"name",
    "category":"category",
    "conditionNote":"good"
}
Auto generate :
on adding new asset the assignment staus is available.
purchase date is current date in which the user add the asset .
