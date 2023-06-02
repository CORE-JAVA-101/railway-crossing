package com.railway.config;

import org.flywaydb.core.Flyway;

public class FlywayRunner {

  public static void run()
  {
    Flyway flyway = Flyway.configure()
        .dataSource(DatabaseProvider.getDataSource())
        .locations("classpath:db/migration")
        .load();

    // Migrate the database
    flyway.clean(); // remove everyhting from db
    flyway.migrate(); // apply the script
  }
}
