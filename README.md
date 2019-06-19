# Olympiad tasks

## Minesweeper
Have you ever played Minesweeper? It’s a cute little game which comes within a certain Operating
System which name we can’t really remember. Well, the goal of the game is to find where are all the
mines within a M × N field. To help you, the game shows a number in a square which tells you how
many mines there are adjacent to that square. For instance, supose the following 4 × 4 field with 2
mines (which are represented by an ‘*’ character):

*...

....

.*..

....

If we would represent the same field placing the hint numbers described above, we would end up
with:

*100

2210

1*10

1110

As you may have already noticed, each square may have at most 8 adjacent squares.

### Input

The input will consist of an arbitrary number of fields. The first line of each field contains two integers
n and m (0 < n, m ≤ 100) which stands for the number of lines and columns of the field respectively.
The next n lines contains exactly m characters and represent the field.
Each safe square is represented by an ‘.’ character (without the quotes) and each mine square
is represented by an ‘*’ character (also without the quotes). The first field line where n = m = 0
represents the end of input and should not be processed.

### Output

For each field, you must print the following message in a line alone:

Field #x:

Where x stands for the number of the field (starting from 1). The next n lines should contain the
field with the ‘.’ characters replaced by the number of adjacent mines to that square. There must be
an empty line between field outputs.

## Numbers
### Input
The first line of the input contains the number of datasets in the input. A blank line follows. The first
line of each dataset specifies the number of telephone numbers in the directory (up to 100,000) as a
positive integer alone on the line. The remaining lines list the telephone numbers in the directory, with
each number alone on a line. Each telephone number consists of a string composed of decimal digits,
uppercase letters (excluding Q and Z) and hyphens. Exactly seven of the characters in the string will
be digits or letters.
There’s a blank line between datasets.
Output
Generate a line of output for each telephone number that appears more than once in any form. The
line should give the telephone number in standard form, followed by a space, followed by the number
of times the telephone number appears in the directory. Arrange the output lines by telephone number
in ascending lexicographical order. If there are no duplicates in the input print the line:
No duplicates.
Print a blank line between the output of consecutive datasets.
###Sample Input

1

12

4873279

ITS-EASY

888-4567

3-10-10-10

888-GLOP

TUT-GLOP

967-11-11

310-GINO

F101010

888-1200

-4-8-7-3-2-7-9-

487-3279
### Sample Output
310-1010 2

487-3279 4

888-4567 3

## Clock
The history of clocks is fascinating, but unrelated to this problem. In this problem, you are asked
to find the angle between the minute hand and the hour hand on a regular analog clock. Assume that
the second hand, if there were one, would be pointing straight up at the 12. Give all angles as the
smallest positive angles. For example 9:00 is 90 degrees; not -90 or 270 degrees.
### Input

The input is a list of times in the form ‘H:M’, each on their own line, with 1 ≤ H ≤ 12 and
00 ≤ M ≤ 59. The input is terminated with the time ‘0:00’. Note that H may be represented with 1
or 2 digits (for 1–9 or 10–12, respectively); M is always represented with 2 digits (the input times are
what you typically see on a digital clock).
### Output

The output displays the smallest positive angle in degrees between the hands for each time. The answer
should between 0 degrees and 180 degrees for all input times. Display each angle on a line by itself in
the same order as the input. The output should be rounded to the nearest 1/1000, i.e., three places
after the decimal point should be printed.
### Sample Input

12:00

9:00

8:10

0:00
### Sample Output

0.000

90.000

175.000
