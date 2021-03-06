package com.example.demodesignpattern.services.databaseManager;

import com.example.demodesignpattern.exceptions.ResourceNotFoundException;
import com.example.demodesignpattern.services.databaseManager.factories.DatabaseAbstractFactory;
import com.example.demodesignpattern.services.databaseManager.factories.MongoFactory;
import com.example.demodesignpattern.services.databaseManager.factories.PostgresFactory;
import com.example.demodesignpattern.services.databaseManager.factories.RedisFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * singleton and abstract factory
 */
@Service
public class DatabaseManager {

    @Autowired
    private RedisFactory redisFactory;

    @Autowired
    private MongoFactory mongoFactory;

    @Autowired
    private PostgresFactory postgresFactory;

    private DatabaseManager() {
    }

    public static DatabaseManager getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public DatabaseAbstractFactory getFactory(Type type) {
        switch (type) {
            case REDIS:
                return redisFactory;
            case MONGODB:
                return mongoFactory;
            case POSTGRES:
                return postgresFactory;
            default:
                throw new ResourceNotFoundException("Database not found");
        }
    }

    public enum Type {
        REDIS,
        MONGODB,
        POSTGRES
    }

    private static class SingletonHelper {
        private static final DatabaseManager INSTANCE = new DatabaseManager();
    }
}
