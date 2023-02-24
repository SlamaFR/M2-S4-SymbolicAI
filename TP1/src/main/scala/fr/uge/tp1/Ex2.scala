package fr.uge.tp1

import org.apache.jena.rdf.model.ModelFactory


object Ex2 extends App {

  private val rdf = ModelFactory.createDefaultModel()

  private val subject = rdf.createResource("https://upem.fr/example/macarron")
  private val property = rdf.createProperty("https://upem.fr/example/loves")
  private val `object` = rdf.createResource("https://upem.fr/example/cookies")

  rdf.add(subject, property, `object`)

  println(rdf.listStatements().toList)
  println(rdf.size())
}
