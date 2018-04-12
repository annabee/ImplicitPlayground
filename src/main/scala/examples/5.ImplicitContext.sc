
// Unlikely to change
class DatabaseConfiguration
class Connection

class Table(config: DatabaseConfiguration, connection: Connection) {
  def drop(tableName: String)(implicit config: DatabaseConfiguration, connection: Connection) { ??? }
}
