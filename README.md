# Semantic Web
## Exercise 1
1. Add a new data type (simpleType) for element "Day" to the XML schema, to accept only the following values: Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday.

2. Add a new data type (simpleType) for "Time" to the XML Schema to accept only string values of 11 characters and follow the pattern "2 digits, colon, 2 digits, dash, 2 digits, colon, 2 digits", such as: "15:30-18:00".

3. Make an appropriate change to the XML Schema so that each "Event" can contain more than one, but less than ten "Lecture" elements.

4. Set an attribute in the XML Schema under "Lecture", called "Classroom" with type: string with less than 8 characters. This feature should be mandatory on each "Lecture".

5. Convert the inline declaration of the type of the elements "Event", "Lecture", "day", "time", "classroom" to global. 

6. Create three new types that derive from the type "eventType":
  - The type "lessonType" is an extension of the type"eventType", adding the additional element "Professor".
  - The type "SeminarType" is a restriction of the type "eventType" so as to contain only one "Lecture" element.
  - The type "labType" is a restriction of the type "eventType" so that elements of this type do not contain the "classroom" attribute.

7. Define globally three elements "lesson", "Seminar" and "Lab" of type "lessonType", "seminarType" and "labType" respectively, in order to use (SubstituteGroup) where reference is made to an "Event" element.

8. Develop a GUI application in JAVA, in which you load the xml file, and if it is valid based on the corresponding xml schema, you will present the contents in a table. The user will also be able to import new data (lectures) into the xml file. Finally, it can filter the data displayed in the table by choosing a day of the week.
