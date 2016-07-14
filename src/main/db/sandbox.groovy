databaseChangeLog() {

    changeSet(author: "diogo.gallo", id: "sandbox-0.0-1") {
        createTable(tableName: "topic") {
            column(name: "id", type: "int8") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "topic_pk")
            }

            column(name: "name", type: "varchar(100)")
        }

        createTable(tableName: "question") {
            column(name: "id", type: "int8") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "question_pk")
            }

            column(name: "topic_id", type: "int8")

            column(name: "description", type: "varchar(500)")

            column(name: "score", type: "int8")

            column(name: "level", type: "varchar(10)")
        }

        addForeignKeyConstraint(constraintName: "question_fk",
                baseTableName: "question",
                baseColumnNames: "topic_id",
                referencedTableName: "topic",
                referencedColumnNames: "id",
                onUpdate: "NO ACTION",
                onDelete: "CASCADE"
        )


    }

}