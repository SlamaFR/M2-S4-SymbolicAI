package fr.uge.tp3

import com.bigdata.journal.BufferMode
import com.bigdata.journal.Options
import com.bigdata.rdf.sail.BigdataSail
import com.bigdata.rdf.sail.BigdataSailRepository
import com.bigdata.rdf.sail.BigdataSailRepositoryConnection
import java.util.Properties

fun main() {
    val properties = Properties()
    properties[Options.BUFFER_MODE] = BufferMode.DiskRW
    properties[Options.FILE] = "../BlazeGraph/blazegraph.jnl"

    val sail = BigdataSail(properties)
    val repo = BigdataSailRepository(sail)

    try {
        repo.initialize()

        repo.transaction {

        }
    } finally {
        repo.shutDown()
    }
}

fun BigdataSailRepository.transaction(block: BigdataSailRepositoryConnection.() -> Unit) {
    val connection = this.connection
    try {
        connection.begin()
        connection.block()
        connection.commit()
    } catch (e: Exception) {
        connection.rollback()
    } finally {
        connection.close()
    }
}
