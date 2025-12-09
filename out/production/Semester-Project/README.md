

# Project Overview
A comprehensive text analysis application that processes article across multiple topics, performing statistical analysis, word frequency ranking, and sentiment analysis. Users can also add their own topics and articles via the interactive menu. 

# Features
- Text Preprocessing: Removes punctuation and common stop words from text files
- Statistical Analysis: Calculates total word count, unique words, and word frequencies
- Frequency Ranking: Ranks words by frequency using bubble sort
- Sentiment Analysis: Calculates sentiment scores using a lexicon-based approach
- Topic Management: Add new topics and articles through menus
- Multiple Topics: Processes articles from various categories (headphones, movies, Roman history, and custom user-imported topics)

# Classes

## Class Diagram
![Class Diagram](semesterProjectUMLFinal.png)

## Main.java
- Purpose: Main driver class with menu system  
- Responsibilities:
  - Manages user interaction through console menus
  - Handles topic selection and creation
  - Manages files and articles
  - Integrates all analysis components

## TextProcessor.java
- Purpose: Central processing unit for text analysis
- Responsibilities:
  - Reads text files using Scanner class
  - Removes punctuation from articles
  - Coordinates text preprocessing
  - Creates TextAnalysis objects for statistical processing
  - Integrates sentiment analysis functionality

## RemoveStopWords.java
- Purpose: Filters common words from text
- Responsibilities:
  - Loads stop words from external file
  - Filters out common words during text cleaning
  - Maintains a list of stop words for text processing

## TextAnalysis.java
- Purpose: Performs statistical analysis and sentiment calculation
- Responsibilities:
  - Calculates word statistics (total words and unique words)
  - Counts word frequencies using ArrayList class
  - Ranks word by frequency using bubble sort
  - Calculates sentiment scores and classifies sentiment (Very Positive to Very Negative)
  - Displays formatted analysis results

## SentimentLexicon.java
- Purpose: Manages sentiment scoring system
- Responsibilities:
  - Loads sentiment scores from lexicon file
  - Stores word-sentiment score mappings in a HashMap
  - Provides sentiment score lookup for individual words
  - Supports sentiment analysis calculations

# Usage
```

```

# Authors
- Logan Ameres
- William Landon
- Michael Kobus