![Class Diagram](semesterProjectUMLFinal.png)


# Project Overview
This is a text analysis application using Java to process articles from different topic, performs text preprocessing, and calculates various statistic including word frequencies, rankings, and sentiment analysis. This project demonstrates basic processing techniques for comparative text analysis.

# Features
Text Preprocessing: Removes punctuation and stop words from text files  
Statistical Analysis: Calculates total  
Frequency Ranking: Ranks words by frequency using bubble sort  
Sentiment Analysis: Calculates sentiment scores using a lexicon-based approach  
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
Integrates sentiment analysis functionality  

## RemoveStopWords.java
Loads stop words from file  
Filters out common words from text  
Maintains a list of stop words for text cleaning  

## TextAnalysis.java
Calculates word statistics, total words and unique words  
Counts word frequencies using ArrayList class  
Ranks words by frequency using bubble sort  
Calculates sentiment scores and classifies sentiment  
Displays results  

## SentimentLexicon.java
Loads sentiment scores from a lexicon file  
Stores word-sentiment score mappings in a HashMap  
Provides sentiment score lookup for individual words  
Supports sentiment analysis calculations  

## Authors
Logan Ameres  
William Landon  
Michael Kobus
