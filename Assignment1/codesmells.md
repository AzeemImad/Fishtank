# Markdown

Markdown is a plain-text file format. There are lots of programming tools that use Markdown, and it's useful and
easy to learn. Hash marks (the number sign) indicate headers. Asterisks indicate lists.

# List of code smells

## Code Smell 1: 
Improper Intimacy
### Code Smell Category: 
Coupler
### List of classes and line numbers involved:

* FishFrame, line no.All
* FishTank, line no. 15, 16
* Fish, line no. 123
* HungryFish, line no. 123
* Seaweed, line no. 43 ~ 66
* Bubble, line no. 73 ~ 75

### Description:

Method Paint in FishFrame (which is the only method in FishFrame) relies heavily on the field 
myLittleFishes[][] and myBubbles[][] (Object[][]) in the FishTank class, and it also relies on the draw methods from
various classes such as the Fish, HungryFish, Seaweed and Bubble Classes. Since Paint in FishFrame just uses internal 
Feilds and methods of another class, it is an improper intimacy. 

### Solution:

We can move the paint method into the FishTank class and delete the FishFrame class altogether. Then we can make
FishTank extend the JFrame method and import all the necessary items into FishTank.

### Explanation

By getting rid of the FishFrame and transferring all the JFrame functions from FishFrame to FishTank, and also by
moving the paint method into FishTank, we simplify the code so it looks better organized now, and it also effectively
increases code re-useability and management of the program, as the code will now not depend on another class as much as 
FishFrame depended on FishTank and other classes, thus effectively getting rid of the code smell.

============================================================

## Code Smell 2:
Speculative Generality
### Code Smell Category:
Dispensables
### List of classes and line numbers involved:

* FishTank line no's: 10, 12
### Description:

there are 2 variables created charHeight and charWidth. These variables are never used in the code anywhere. They were
created in the hopes of being used in the future, however since that is not the case here, we can say that they are a
code smell of the speculative Generality type.

### Solution:

Since there is no use for the fields that were created, we can just delete them.

### Explanation

By deleting the unused code, we make the code slimmer and the developer wont have any trouble
reading the code. It also will make the code more efficient and easier to manage, thus effectively getting rid of the
code smell


============================================================

## Code Smell 3:
Large Class
### Code Smell Category:
Bloater
### List of classes and line numbers involved:

* Bubble, line no: 7 ~ 135

### Description:
Class Bubble has too many methods and over time, will grow much bigger as more code is added to the class, hence making
it into a bloater.

### Solution:

Some of the methods in the class have almost the similar functionality and we can merge those functions. For instance, 
the methods floatRightUp, and floatLeftUp and floatStraightUp perform almost the same functions, hence we can condense
these methods into one method. We can also get rid of draw method as it is a middle man and it can be disregarded

### Explanation

My solution helps get rid of the code smell as now, the devoloper will not have to worry about many different attributes
of the class as there are less methods then before and it also lowers the risk of code duplication, hence effectively
getting rid of the code smell.


============================================================

## Code Smell 4:
Duplicate Code
### Code Smell Category:
Dispensables
### List of classes and line numbers involved:

* Fish, line no's: 9 ~ 156
* HungryFish line no's: 9 ~ 161

### Description:

The code in Fish and HungryFish is identical. Both classes perform the same functions and also have the same methods.
This is a clear cut example of the duplicate code, code smell type as the two pieces of code are almost mirror images
of each other and it is much harder to read and understand the code.

### Solution:

Since the code is identical and the only additional thing in HungryFish is the appearance of the fish, we can merge
the HungryFish class and Fish class by deleting the HungryFish class and adding the appearance of the HungryFish as a 
field into the Fish class. 

### Explanation

By deleting the class HungryFish, we make the overall code shorter, thus simplifying it. This in turn makes the code 
more efficient and easier to maintain, effectively getting rid of the code smell. 
============================================================

## Code Smell 5:
Shotgun Surgery
### Code Smell Category:
Change Preventers
### List of classes and line numbers involved:

* FishTank, line no: 31 ~ 58
* Bubble, line no: All
* Fish, line no: All
* HungryFish, line no: All
* Seaweed, line no: All

### Description:

If we had to make a change in the class Fish, or any of the aforementioned classes, we would have to make changes in
the main function or in any other classes where Fish or any of the the aforementioned classes are used. For instance
if we were to add an extra parameter in setLocation in Fish class, we would have to go and add another parameter
wherever .setLocation command is used. This is a code smell as if we had to make changes to any of the aforementioned
classes, we would have to make small changes to many different classes as mentioned above.


### Solution:

We need to create a parent class called Items and make Bubble, Fish, HungryFish and Seaweed subclasses of this class.
Then we move the methods that all of these subclasses have in common into Items class (methods such as drawString etc)
and let the methods and fields that are unique to the subclasses remain in the subclasses. 

### Explanation

By implementing the above solution, we only need to make changes to the one class (subclass or the parent class) and
there is little to no need of making changes to other classes. This makes the code more organized and easier to manage
and effectively gets rid of the smell.

============================================================
