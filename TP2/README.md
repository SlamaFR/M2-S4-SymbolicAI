# Symbolic AI • TP 2

## Exercice 2

### Q1. Write a query to display all the triples in the dataset. How many triples are there?

```sparql
SELECT * WHERE {
  ?s ?p ?o
}
```

> There are 517,023 rows in the result.

### Q2. Write a query displaying the subjects and objects whose property is rdf:type. How many rows do you have in the result

```sparql
SELECT ?s ?o WHERE {
  ?s rdf:type ?o
}
```

> There are 24,465 rows in the result.

### Q3. Write a query showing the subjects of triples whose property is rdf:type and the subject is http://www4.wiwiss.fu-berlin.de/drugbank/resource/drugbank/drugs. How many lines do you get?

```sparql
SELECT ?s WHERE {
  ?s rdf:type <http://www4.wiwiss.fu-berlin.de/drugbank/resource/drugbank/drugs>
}
```

> There are 4,772 rows in the result.

### Q4. Take the request from question 3 and impose an ascending order on the subject.

```sparql
BASE <http://www4.wiwiss.fu-berlin.de/drugbank/resource/drugbank/>

SELECT ?s WHERE {
  ?s rdf:type <drugs>
} ORDER BY ?s
```

### Q5. Click on the subject whose URI ends with DB01146. 3 tables are displayed: outgoing, ingoing and attributes. After a visual search, provide the value of molecularWeightAverage.

> The value of molecularWeightAverage is 281.392.

### Q6. Write a request providing all drugs with a triple where the object contains the string ”Dextromethorphan”. How many distinct identifiers do you get?

```sparql
SELECT DISTINCT ?s WHERE {
  ?s ?p ?o
  FILTER regex(?o, "Dextromethorphan")
}
```

> There are 278 rows in the result.

### Q7. Provide the value of the ATC code (atcCode) for each of these drugs. How many lines do you get?

```sparql
BASE <http://www4.wiwiss.fu-berlin.de/drugbank/resource/drugbank/>

SELECT DISTINCT ?atcCode WHERE {
  ?s ?p ?o
  FILTER regex(?o, "Dextromethorphan")
  ?s rdf:type <drugs> .
  ?s <atcCode> ?atcCode
}
```

> There are 22 rows in the result.

### Q8. Write a Boolean SPARQL query to find out if there is a drug with the ATC code “R05DA09”.

```sparql
BASE <http://www4.wiwiss.fu-berlin.de/drugbank/resource/drugbank/>

ASK {
  ?s rdf:type <drugs> .
  ?s <atcCode> "R05DA09"
}
```

> The result is true.

### Q9. Write a DESCRIBE-type query to obtain all the information on the subject of the query 8. How many rows do you get in the result?

```sparql
BASE <http://www4.wiwiss.fu-berlin.de/drugbank/resource/drugbank/>

DESCRIBE ?s WHERE {
  ?s rdf:type <drugs> .
  ?s <atcCode> "R05DA09"
}
```

> There are 266 rows in the result.

### Q10. Write a query that only displays triples whose object is a literal. Write a query that displays only triples whose object has a data type of type integer.

```sparql
SELECT * WHERE {
  ?s ?p ?o
  FILTER isLiteral(?o)
}
```

> There are 332,428 rows in the result.

```sparql

```

### Q11.

### Q12. Write a request to obtain the number of ATC codes per drug. How many rows do you have in the result? How many ATC codes does the drug DB00759 have?

```sparql
BASE <http://www4.wiwiss.fu-berlin.de/drugbank/resource/drugbank/>

SELECT ?s (COUNT(?atcCode) AS ?atcCount) WHERE {
  ?s rdf:type <drugs> .
  ?s <atcCode> ?atcCode
} GROUP BY ?s
```

> There are 1,218 rows in the result.

> The drug DB00759 has 15 ATC codes.

### Q13. Write the request to obtain the number of drugs by ATC code. Number of lines?

```sparql
BASE <http://www4.wiwiss.fu-berlin.de/drugbank/resource/drugbank/>

SELECT ?atcCode (COUNT(?s) AS ?drugCount) WHERE {
  ?s rdf:type <drugs> .
  ?s <atcCode> ?atcCode
} GROUP BY ?atcCode
```

> There are 1,752 rows in the result.

### Q14. Modify query 13 to only have ATC codes starting with ”R05”. How many lines?

```sparql
BASE <http://www4.wiwiss.fu-berlin.de/drugbank/resource/drugbank/>

SELECT ?atcCode (COUNT(?s) AS ?drugCount) WHERE {
  ?s rdf:type <drugs> .
  ?s <atcCode> ?atcCode
  FILTER regex(?atcCode, "^R05")
} GROUP BY ?atcCode
```

> There are 13 rows in the result.

### Q15. Query 14 is not very relevant. You must change it to find out how many drug names exist by ATC code of the category starting with “R05”. How many lines? How many names for R05CA03?

```sparql
BASE <http://www4.wiwiss.fu-berlin.de/drugbank/resource/drugbank/>

SELECT ?atcCode (COUNT(?name) AS ?nameCount) WHERE {
  ?s rdf:type <drugs> .
  ?s <atcCode> ?atcCode
  FILTER regex(?atcCode, "^R05")
  ?s <name> ?name
} GROUP BY ?atcCode
```
