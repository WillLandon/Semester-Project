![Class Diagram](/Users/willlandon/Desktop/ProgrammingWorkshop/Semester-Project/semesterProjectUML.png)


# Project Overview
This is a text analysis application using Java to process articles from different topic, performs text preprocessing, and calculates various statistic including word frequencies and rankings. This project demonstrates basic processing techniques for comparative text analysis.

# Features
Text Preprocessing: Removes punctuation and stop words from text files  
Statistical Analysis: Calculates total  
Frequency Ranking: Ranks words by frequency using bubble sort  
Multiple Topics: Processes articles from three different categories  
Stop Word Filtering: Uses a stop word list to filter out common words  

# Classes

## Main.java
Runs the text analysis process  
Manages file paths for different topics  
Displays the results for each article  

## TextProcessor.java
Reads text files using the Scanner class  
Removes punctuation from article  
Manages the text preprocessing  
Creates TextAnalysis objects  

## RemoveStopWords.java
Loads stop words from file  
Filters out common words from text  
Maintains a list of stop words for text cleaning  

## TextAnalysis.java
Calculates word statistics, total words and unique words  
Counts word frequencies using ArrayList class  
Ranks words by frequency using bubble sort  
Displays results  

## Authors
Logan Ameres  
William Landon  
Michael Kobus
