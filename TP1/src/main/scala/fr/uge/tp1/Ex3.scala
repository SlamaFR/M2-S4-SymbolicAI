package fr.uge.tp1

import org.apache.jena.rdf.model.{ModelFactory, Property}

object Ex3 extends App {

    private val rdf = ModelFactory.createDefaultModel()
    private val bank = getClass.getResourceAsStream("/drugbank_dump.nt")
    rdf.read(bank, null, "N-TRIPLE")

    println(s"Model size: ${rdf.size()}")
    private val typeProperty = rdf.createProperty("http://www.w3.org/1999/02/22-rdf-syntax-ns#type")

    private def countTypeTriples(): Int = {
        rdf.listSubjectsWithProperty(typeProperty).toList.size
    }

    println(s"Nodes with 'type' property: ${countTypeTriples()}")

    private def countDrugs(): Int = {
        val drugClass = rdf.createResource("http://www4.wiwiss.fu-berlin.de/drugbank/resource/drugbank/drugs")
        rdf.listSubjectsWithProperty(typeProperty, drugClass).toList.size
    }

    println(s"Number of drug: ${countDrugs()}")

    private def countDistinctProperties(): Int = {
        rdf.listStatements().mapWith(_.getPredicate).toSet.size
    }

    println(s"Distinct properties: ${countDistinctProperties()}")

    private def countDistinctNameSpaces(): Int = {
        rdf.listStatements().mapWith(_.getPredicate.getNameSpace).toSet.size
    }

    println(s"Distinct namespaces: ${countDistinctNameSpaces()}")

    private def listPropertiesOfNameSpace(nameSpace: String) = {
        rdf.listStatements().mapWith(_.getPredicate)
            .filterKeep(_.getNameSpace == nameSpace)
            .mapWith(_.getLocalName.split("/").last)
            .toSet
    }

    private val drugNameSpace = "http://www4.wiwiss.fu-berlin.de/drugbank/resource/drugbank/"
    println(s"Properties of namespace $drugNameSpace: ${listPropertiesOfNameSpace(drugNameSpace)}")



}
