# Assignment 2 - Calculation

## Note: The text below may change slightly until the start of module 2 based on feedback

## Learning outcomes
The student must show ability and skill in structuring their code so that it is clear and easy to follow for another programmer, to read in input from the user and convert to a suitable data type for further processing, to print formatted data to the user and to handle the String data type.

## Most typical mistakes that students make are:
* they do not validate input, as stated in the requirements.
* they do not use constants
* they do not read the coding rules
* they do the assignment without reading about the theory
* they have not seen the assignment two overview video on Canvas (it will be posted at the start of module 2, the week that follows the assignment one deadline)

## Prerequisites
The assignment shows that you have reviewed the material in Module 2 and brought your knowledge and feedback from Assignment 1.

## Task
You will write a program that calculates how much money your solar cells generate per day based on the hours of sunshine.

Begin the task by constructing a flow chart and program logic on paper. Then describe your structure in text form (pseudocode) in the comment header of the program so that an outsider can understand what the program does and how your logic/algorithm works.

You have installed solar cells on your roof and want to calculate how much you earn on a sunny summer day. You have bought 26 solar panels, each 1.7x1 m in size, and can produce a maximum of 290 W. 

## Assumptions
- You have installed your solar panels in a straight south position and have an ideal roof angle (35-45 degrees). In other words,
- On average, the solar radiation in Skellefteå on a sunny summer day (June / July) is 166 Wh / m<sup>2</sup> / hour.
- The efficiency of the solar cell ([Thermal efficiency](https://en.wikipedia.org/wiki/Thermal_efficiency)) is assumed to be 20% (of the solar radiation).
- The electricity price is assumed to be SEK 0.9 / kWh (including a 60 öre tax rebate).

Production (Wh) = Solar radiation (Wh / m<sup>2</sup> / hour) x efficiency x surface (m<sup>2</sup>) x hours of sunshine

The user enters what time the sun rises and what time it sets. Use Scanner for input. The time is entered in the form hh:mm.

The program must first calculate the number of hours of sunshine, then the production output, and finally, what profit the sale of the entire production gives.

You should present the results to two decimal place accuracy. You can use any print method of your choice. printf is suggested as it is easier to format the printout. (Not need to use round the value like in assignment one if you are using printf)

We assume in the program that all entered times are valid for the same day. You should check entered values so that the "date" is in June / July (month 6 or 7) and that the time of sunset is later than sunrise. The program should give an error message and quit for all other values. You should check for a valid hour, minute, and day. See the section on "How will you be graded."

## Example run 
### (Your output should be very close to what you see below, except the calculation may be slightly off based on how to calculate the values, it may be SEK 28.14 (some close value) instead of 28.66 for the exact dates and hours as inpit)
```
Enter today's date [mm-dd]> 06-22
Enter the time of sunrise [hh: mm]> 01:46
Enter the time of sunset [hh: mm]> 23:28
========================================== 
Sun hours: 21.70 hours 
The production on 22/6 is: 31.84 kWh to a value of: SEK 28.66
```
## Separator
You are supposed to use useDelimiter to specify the separator when reading user input according to program run above, read more about this in Practice Problem (IO and Strings - Time converter) and  Data Bank 3. . Please think about the best way to handle dates. You can also consider decimal places; see Data Bank 3.1 on Canvas

## Decision making
In your program, you need to handle decision-making (check if a condition is met). Your program logic should perform certain statements only if the condition is met. 

### Using if statements to make these decisions
The below pseudocode may help with your thinking process.
```
if month != JUNE
  wrong month
  System.exit(0)
if month != JULY
  wrong month
  System.exit(0)
if day < 1
  wrong date
  System.exit(0)
If month == JUNE
    if date > 30
      wrong date
      System.exit(0)
if month == JULY
    if date > 31
      wrong date
      System.exit(0)
```

## How will you be graded / What do you need to take care of
* You will be graded and checked for functional and non-functional requirements
* Functional requirements
  * Code output is according to the specification given below in the task description
  * Validation is important
    * Invalid hours need to be taken care of, meaning only hour value between 0 and 23 is allowed
    * Invalid minutes need to be taken care of, meaning only 0 - 59 are valid minutes
    * Number of days in the month needs to be checked, ex: if the month is June, you need to check if the days are between 1 and 30
* Non Functional requirements
  * Strictly follow the coding rules

## Note to those who have already done a programming course before
* There is no need to use for loop, if condition check, arrays. Yes, it makes it easy to write the program this way and probably more efficient. But that is not the goal of the assignment. Remember, the majority of the participants have yet to see these topics. So, solve the assignment as if you are yet to learn these topics in java programming.
  
## Submit the solution
Before you turn in the assignment, please check that your code follows the course's requirements for formatting and coding rules (see the "How will you be graded / What do you need to take care of" section above).

## Plagiarism 
Submissions may be checked for plagiarism, and the student will be reported to the university's Disciplinary Board in case of cheating.

## Correction
If you turn it in on time, the assignment will be corrected in three weeks. Any submission made after the deadline will have delays; we cannot say how long this takes.

NOTE! If you need help to complete the task, ask the primary teacher instead of submitting a half-finished solution. 

The grading teacher marks how well the code meets the assignment requirements. Any failed submissions must be reworked and resubmitted to achieve an approved level. On replit, the resubmit button is on the top-right. On Canvas, open the assignment page and click on the "New Attempt" button on the top-right to resubmit.  