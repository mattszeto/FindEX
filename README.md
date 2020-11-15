### Search Engine
Search Engine:
- Boolean Queries: Positional Inverted Index, K-gram Index, Porter2Stemmer Algorithm
  - K-Grams
  - Stemming
  - NEAR/k Queries
  - Wildcard Queries
- Ranked Queries: Disk Positional Index, K-gram Index on Disk
  - Spelling Check (Suggested Queries): Jaccard Coefficient, Levenshtein Edit Distance

Dependencies:
- SparkJava w/ Thymeleaf-Template: `com.sparkjava:spark-template-thymeleaf:2.7.1`
- Gson: `gson-2.8.6.jar`
- libstemmer (porter2stemmer): `tartarus snowball-stemmer`
- mapdb (b+tree for on-disk index): `org.mapdb`

###How to run search engine: (2 Ways)
#### CMD text:
You can run our search engine in the command line by running `indexer.java`
1. Open up your favorite text-editor or IDE (project developed on `intellij`)
2. download and load all dependencies (noted above)
3. run `indexer.java` for a fully functional cmd text application

#### Web UI: localhost
Another way is to run from your local machine at `http://localhost:4567/`
1. Open up text-editor or IDE (project developed on `intellij`)
2. download and load all dependencies (noted above)
3. run `WebUI.java` 
4. open a chrome window and go to `http://localhost:4567/`

#### Building Index:
To build an index, provide a path to your corpus folder.

(if you have already built your index before, and no files have changed within the corpus, then you do not need to build index again)
*you can check this by seeing if your corpus folder already has an index folder inside with `postings.bin` and `docWeights.bin` (there will be other files too, but these are the most important*

<b>You must bring your own corpus to index and search from (local file directory needed)</b>
